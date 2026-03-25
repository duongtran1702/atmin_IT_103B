# 1. Phân tích rủi ro & bẫy lỗi

* Nhập sai kiểu dữ liệu (vd: nhập "năm trăm" cho tiền) → crash `NumberFormatException`
* Chọn giường không tồn tại → update = 0 → dữ liệu sai
* Giường đã có người nhưng vẫn chọn → ghi đè sai dữ liệu
* Lỗi giữa transaction (thêm bệnh nhân ok nhưng update giường fail) → dữ liệu không nhất quán nếu không rollback
* Mất kết nối DB giữa chừng → transaction dang dở

---

# 2. Luồng xử lý (Tiếp nhận bệnh nhân)

1. Nhập tên, tuổi, mã giường, tiền
2. Validate input
3. Mở connection
4. setAutoCommit(false)
5. Check giường còn trống
6. Insert bệnh nhân
7. Update trạng thái giường
8. Insert tài chính
9. Commit nếu ok
10. Rollback nếu lỗi
11. Đóng connection

---

# 3. Thiết kế bảng

## Patient

* patient_id (PK)
* name
* age
* bed_id

## Bed

* bed_id (PK)
* status (AVAILABLE / OCCUPIED)

## Finance

* id (PK)
* patient_id
* balance

---

