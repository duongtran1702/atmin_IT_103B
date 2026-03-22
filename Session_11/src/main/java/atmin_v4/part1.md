## Phân tích SQL Injection trong câu lệnh WHERE

---

## 1. Giới thiệu

Trong các ứng dụng sử dụng cơ sở dữ liệu, việc truy vấn dữ liệu thường được thực hiện thông qua các câu lệnh SQL. Tuy nhiên, nếu câu lệnh SQL được xây dựng bằng cách nối chuỗi trực tiếp với dữ liệu đầu vào từ người dùng mà không có kiểm tra, hệ thống sẽ dễ bị tấn công bởi SQL Injection.

SQL Injection là một lỗ hổng bảo mật cho phép kẻ tấn công chèn các đoạn mã SQL vào câu lệnh truy vấn, từ đó thay đổi logic xử lý dữ liệu của chương trình.

---

## 2. Cách câu lệnh SQL được tạo ra

Xét đoạn mã Java sau:

```java
String sql = "SELECT * FROM Patients WHERE full_name = '" + patientName + "'";