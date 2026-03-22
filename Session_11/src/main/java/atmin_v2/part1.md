# 📘 Bài tập JDBC - Giải thích ResultSet và executeUpdate

## 1. Tại sao `if` không đủ để in danh sách?
---
Trong Java, câu lệnh `if` là một cấu trúc rẽ nhánh, nghĩa là nó chỉ kiểm tra điều kiện **một lần duy nhất**.

Khi sử dụng:
```java
if (rs.next())

