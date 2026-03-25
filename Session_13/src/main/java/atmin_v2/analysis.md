## Phân tích lỗi Transaction

### Vấn đề

Trong `catch`, chỉ dùng:
System.out.println(...)
Chỉ **log lỗi**, không xử lý transaction

---

### Hậu quả

* Bước 1 (trừ tiền) 
* Bước 2 (update hóa đơn) 
* Không rollback

**Dữ liệu bị sai lệch (vi phạm ACID - Consistency)**

---

### Nguyên tắc bị vi phạm

> Transaction phải đảm bảo **All or Nothing**

---

### Thiếu hành động quan trọng

**`conn.rollback()`**

* Khi xảy ra `SQLException`
* Phải hoàn tác toàn bộ thay đổi trước đó

---

### Chuẩn đúng


catch (SQLException e) {
    conn.rollback();
}

