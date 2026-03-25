# Phân tích bài toán

## Input

* maBenhNhan (int)
* tienVienPhi (double)

## Output

* Thành công: Xuất viện & thanh toán thành công
* Thất bại: lỗi và rollback

## Giải pháp

* Sử dụng transaction với setAutoCommit(false)
* Gom 3 câu lệnh UPDATE vào cùng transaction
* Commit khi tất cả thành công
* Rollback khi có lỗi
* Chủ động kiểm tra thiếu tiền và row affected

## Các bước xử lý

1. Mở connection
2. Tắt auto-commit
3. Lấy số dư
4. Kiểm tra đủ tiền
5. Trừ tiền
6. Update giường
7. Update bệnh nhân
8. Kiểm tra row affected
9. Commit hoặc rollback
10. Đóng connection
