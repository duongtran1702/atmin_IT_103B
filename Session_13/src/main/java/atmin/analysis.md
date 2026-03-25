## Lỗi: Thiếu Transaction trong JDBC

### Vấn đề

* Update kho **thành công**
* Nhưng bị lỗi runtime (`10 / 0`)
* Insert lịch sử **không chạy**

Dẫn đến **dữ liệu không nhất quán**

---

### Nguyên nhân

* `autoCommit = true` (mặc định JDBC)
* Mỗi câu SQL commit ngay, không rollback được

---

### Hậu quả

* Trừ thuốc
* Không có lịch sử 

---

### Cách sửa


conn.setAutoCommit(false);

try {
    // xử lý
    conn.commit();
} catch (Exception e) {
    conn.rollback();
}

**Nguyên tắc: All or Nothing**
