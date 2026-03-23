# Phần 1 - Phân tích (Ngắn gọn)

Khi Database Server nhận một câu lệnh SQL, nó phải thực hiện:

1. **Parse** → kiểm tra cú pháp
2. **Optimize** → tạo Execution Plan
3. **Execute** → thực thi

Nếu cùng một cấu trúc câu lệnh chạy **1.000 lần** bằng cách nối chuỗi, Database phải:

* Parse lại 1.000 lần
* Tạo Execution Plan 1.000 lần
* Tiêu tốn CPU không cần thiết
* Giảm hiệu năng hệ thống

Ví dụ (Statement):

```sql
SELECT * FROM patient WHERE id = 1;
SELECT * FROM patient WHERE id = 2;
SELECT * FROM patient WHERE id = 3;
```

👉 Dù cấu trúc giống nhau, DB vẫn coi là **câu lệnh khác nhau**.

Trong khi dùng PreparedStatement:

```sql
SELECT * FROM patient WHERE id = ?
```

Database:

* Parse **1 lần**
* Tạo Execution Plan **1 lần**
* Tái sử dụng cho 1.000 lần chạy

## Kết luận

Việc parse và lập kế hoạch 1.000 lần cho cùng cấu trúc SQL gây:

* Lãng phí CPU
* Tăng thời gian xử lý
* Giảm hiệu năng Database

PreparedStatement giúp **tái sử dụng Execution Plan**, tránh lãng phí tài nguyên.
