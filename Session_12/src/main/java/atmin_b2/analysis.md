# Phần 1 - Phân tích

## Tại sao các phương thức `setDouble()`, `setInt()` của PreparedStatement giúp không cần lo lắng về dấu chấm hay dấu phẩy?

Khi làm việc với cơ sở dữ liệu, vấn đề định dạng số theo **locale (khu vực hệ điều hành)** có thể gây lỗi.
Ví dụ:

* Ở Mỹ: số thập phân dùng dấu **chấm** → `3.14`
* Ở một số nước châu Âu: dùng dấu **phẩy** → `3,14`

Nếu lập trình viên **nối chuỗi SQL thủ công**, dữ liệu số sẽ phụ thuộc vào định dạng hệ điều hành:

```java
double price = 3.14;
String sql = "INSERT INTO product(price) VALUES (" + price + ")";
```

Trong một số locale, `price` có thể thành `3,14`, dẫn đến câu SQL:

```sql
INSERT INTO product(price) VALUES (3,14)
```

Điều này làm SQL hiểu là **hai giá trị** thay vì một → gây lỗi cú pháp.

---

## PreparedStatement giải quyết như thế nào?

Khi sử dụng `PreparedStatement`, ta **không nối chuỗi** mà truyền giá trị qua các phương thức như:

* `setDouble()`
* `setInt()`
* `setFloat()`
* `setLong()`

Ví dụ:


String SQL = "INSERT INTO product(price) VALUES (?)";
PreparedStatement ps = conn.prepareStatement(sql);
ps.setDouble(1, 3.14);


### Điều gì xảy ra bên trong?

* JDBC **không chuyển số thành chuỗi theo locale**
* Nó gửi **giá trị số dạng nhị phân (binary)** trực tiếp xuống database
* Database hiểu đúng kiểu dữ liệu (`DOUBLE`, `INT`, …)
* Không phụ thuộc dấu `.` hay `,`

---

## Lợi ích

### Không phụ thuộc hệ điều hành

Chạy trên Windows, Linux hay máy khác locale vẫn đúng.

### Không lo lỗi dấu chấm/dấu phẩy

Không bị sai cú pháp SQL.

### Đảm bảo đúng kiểu dữ liệu

Database nhận đúng kiểu `INT`, `DOUBLE`, không phải chuỗi.

### Code an toàn hơn

Không bị lỗi khi format số.

---

## Kết luận

Các phương thức như `setDouble()` và `setInt()` giúp lập trình viên **không cần quan tâm đến định dạng dấu chấm hay dấu phẩy**, vì:

* JDBC truyền dữ liệu theo **kiểu số thật**
* Không chuyển sang chuỗi
* Không phụ thuộc locale của hệ điều hành
* Database luôn nhận đúng định dạng

Vì vậy, `PreparedStatement` giúp code **ổn định và portable hơn** khi làm việc với dữ liệu số.
