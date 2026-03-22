## Ý nghĩa giá trị trả về của executeUpdate()

- Phương thức `executeUpdate()` trả về một số nguyên (`int`)
- Giá trị này đại diện cho:
    - Số lượng hàng (rows) bị tác động bởi câu lệnh SQL
    - Bao gồm các thao tác:
        - Thêm (INSERT)
        - Sửa (UPDATE)
        - Xóa (DELETE)

---

## Cách phản hồi cho y tá

- Nếu giá trị trả về > 0:
    - Cập nhật thành công
    - Có ít nhất 1 hàng (ví dụ: giường bệnh) khớp với `inputId`

- Nếu giá trị trả về = 0:
    - Không có hàng nào bị tác động
    - `inputId` không tồn tại trong hệ thống
    - Có thể hiển thị thông báo lỗi phù hợp cho người dùng