# Phần 1 - Phân tích: Tại sao PreparedStatement được coi là "tấm khiên" chống SQL Injection?

## 1. SQL Injection là gì?

SQL Injection là kỹ thuật tấn công khi kẻ xấu chèn các đoạn mã SQL độc hại vào dữ liệu đầu vào của người dùng.
Nếu ứng dụng nối chuỗi SQL trực tiếp từ input, câu lệnh SQL có thể bị thay đổi ý nghĩa ban đầu.

Ví dụ nguy hiểm khi cộng chuỗi:

```java
String username = "' OR '1'='1";
String sql = "SELECT * FROM users WHERE username = '" + username + "'";
```

Câu SQL thực tế sẽ trở thành:

```sql
SELECT * FROM users WHERE username = '' OR '1'='1'
```

Điều kiện luôn đúng → trả về toàn bộ dữ liệu.

---

## 2. PreparedStatement hoạt động như thế nào?

PreparedStatement sử dụng dấu `?` làm placeholder cho tham số:

String SQL = "SELECT * FROM users WHERE username = ?"; PreparedStatement stmt = conn.prepareStatement(sql); stmt.setString(1, username);

Ở đây câu SQL và dữ liệu đầu vào được tách riêng.

---

## 3. Cơ chế "Pre-compiled" (Biên dịch trước)

Quá trình thực thi gồm 2 bước:

### Bước 1: Database biên dịch câu SQL trước

```sql
SELECT * FROM users WHERE username = ?
```

Database chỉ hiểu đây là cấu trúc câu lệnh.

### Bước 2: Truyền tham số sau

```
username = ' OR '1'='1
```

Giá trị này được xem như dữ liệu thuần.

---

## 4. Vì sao điều này chống được SQL Injection?

Do SQL đã được biên dịch trước nên:

* Cấu trúc câu SQL không thể thay đổi
* Input chỉ được coi là dữ liệu
* Ký tự đặc biệt không còn ý nghĩa điều khiển SQL

Database sẽ xử lý như:

```sql
SELECT * FROM users WHERE username = "' OR '1'='1"
```

Database chỉ tìm chuỗi này thay vì thực thi logic OR.

---

## 5. Lợi ích của cơ chế Pre-compiled

* Ngăn chặn SQL Injection
* Tách biệt SQL và dữ liệu
* Tăng hiệu năng (biên dịch một lần)
* Tự động escape ký tự đặc biệt
* Giảm lỗi cú pháp SQL

---

## 6. Kết luận

PreparedStatement được coi là "tấm khiên" chống SQL Injection vì sử dụng cơ chế pre-compiled để tách riêng câu lệnh SQL và dữ liệu đầu vào. Nhờ đó dữ liệu người dùng không thể thay đổi cấu trúc SQL, giúp ứng dụng an toàn hơn.
