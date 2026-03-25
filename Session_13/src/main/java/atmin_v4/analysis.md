## Input

* Không có tham số hoặc có thể có limit/offset (optional)

## Output

* List<BenhNhanDTO>

    * Thông tin bệnh nhân
    * List<DichVu> dsDichVu

---

## Giải pháp 1: N+1 Query

* Query 1: Lấy danh sách bệnh nhân
* Loop từng bệnh nhân → query dịch vụ theo `maBenhNhan`

### Ưu điểm

* Dễ code
* Dễ hiểu

### Nhược điểm

* Nhiều query (N+1)
* Tốn network I/O
* Không đạt yêu cầu hiệu năng

---

## Giải pháp 2: JOIN + Map (Khuyến nghị)

* Dùng `LEFT JOIN`
* Lấy toàn bộ dữ liệu trong 1 query
* Map lại thành DTO trong Java

### Ưu điểm

* ✔ 1 query duy nhất → nhanh
* ✔ Tránh quá tải DB
* ✔ Đảm bảo không mất dữ liệu (LEFT JOIN)

### Nhược điểm

* Code map phức tạp hơn

---

## So sánh

| Tiêu chí  | N+1 Query| JOIN         |
| --------- | --------- | ------------ |
| Query DB  | N+1     | 1          |
| Hiệu năng | Thấp    | Cao        |
| RAM Java  | Nhẹ     | Trung bình |
| Code      | Dễ      | Khó hơn    |

---

## Lựa chọn

Chọn **JOIN + Map** vì đáp ứng hiệu năng (<1s với 500 record)

---

## Thiết kế xử lý

### SQL


SELECT bn.maBenhNhan, bn.ten, dv.maDichVu, dv.tenDichVu
FROM BenhNhan bn
LEFT JOIN DichVuSuDung dv 
ON bn.maBenhNhan = dv.maBenhNhan


### Luồng xử lý

1. Query JOIN
2. Dùng `Map<maBenhNhan, BenhNhanDTO>`
3. Nếu chưa có → tạo mới DTO
4. Nếu có dịch vụ → add vào list
5. Trả về list
