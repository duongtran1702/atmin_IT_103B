## Phần 1 - Phân tích: Nguy cơ rò rỉ kết nối trong hệ thống y tế 24/7

Trong môi trường y tế, việc khởi tạo kết nối liên tục mà không đóng (`Close`) hoặc thiếu quản lý tập trung sẽ gây ra các hệ lụy nghiêm trọng:

1.  **Cạn kiệt tài nguyên (Connection Pool Exhaustion):**
    * Mỗi hệ quản trị CSDL (MySQL, SQL Server...) đều có giới hạn kết nối đồng thời ($max\_connections$).
    * Việc mở kết nối mới cho mỗi truy vấn mà không đóng sẽ khiến hệ thống nhanh chóng chạm ngưỡng giới hạn, dẫn đến lỗi "Too many connections". Bác sĩ và nhân viên y tế sẽ bị từ chối truy cập dữ liệu khẩn cấp.

2.  **Lãng phí tài nguyên hệ thống (Memory & CPU Leak):**
    * Mỗi kết nối "mồ côi" (orphan connection) vẫn chiếm dụng RAM và CPU cycle trên cả Web Server và Database Server.
    * Hàng nghìn kết nối treo sẽ làm tăng độ trễ (latency), khiến máy chủ chậm dần và cuối cùng là sập hệ thống (crash).

3.  **Rủi ro đến tính mạng (System Downtime):**
    * Hệ thống y tế đòi hỏi sự tức thời. Nếu DB bị treo, các tác vụ như tra cứu bệnh án, kê đơn thuốc hoặc chỉ định cấp cứu bị gián đoạn, gây nguy hiểm trực tiếp đến bệnh nhân.

#### Kết luận: Việc không quản lý kết nối đúng cách trong hệ thống y tế 24/7 không chỉ gây ra các vấn đề kỹ thuật mà còn có thể dẫn đến hậu quả nghiêm trọng về sức khỏe và tính mạng của bệnh nhân. Do đó, việc thiết kế và triển khai một giải pháp quản lý kết nối hiệu quả là vô cùng cần thiết để đảm bảo sự ổn định và an toàn của hệ thống y tế.