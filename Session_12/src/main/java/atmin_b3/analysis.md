## Phần 1 - Phân tích (Ngắn gọn)

### Vì sao phải gọi `registerOutParameter()` trước khi thực thi?

JDBC yêu cầu gọi `registerOutParameter()` vì:

* JDBC **không tự biết kiểu dữ liệu** của tham số `OUT`
* Cần đăng ký trước để JDBC **chuẩn bị bộ nhớ và chuyển đổi kiểu**
* Nếu không đăng ký → lỗi khi gọi `getXXX()`

Ví dụ:


CallableStatement cs = conn.prepareCall("{CALL get_avg(?)}");
cs.registerOutParameter(1, Types.DOUBLE);
cs.execute();
double result = cs.getDouble(1);


### Kiểu `DECIMAL` trong SQL đăng ký bằng gì?

SQL:

```
DECIMAL
```

Java JDBC:

```
Types.DECIMAL
```

Ví dụ:
cs.registerOutParameter(1, Types.DECIMAL);

