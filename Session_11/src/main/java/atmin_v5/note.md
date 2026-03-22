# Hệ thống Quản lý Bệnh viện Rikkei-Care

## Mô tả
Ứng dụng Console quản lý danh sách bác sĩ trực ca, kết nối trực tiếp database.

## Menu
1. Xem danh sách bác sĩ
2. Thêm bác sĩ mới
3. Thống kê chuyên khoa
4. Thoát

## Kiến trúc
- presentation
- business
- dao
- model
- db

## Kịch bản lỗi
- Nhập trùng mã bác sĩ (Primary Key)
- Nhập chuyên khoa quá dài
- Nhập họ tên rỗng
- Nhập menu không phải số
- Không kết nối được database
- SQL Exception khi insert

## Xử lý lỗi
- Sử dụng PreparedStatement
- Validate input
- try-catch SQLException
- Kiểm tra dữ liệu rỗng
