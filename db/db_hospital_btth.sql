drop database if exists db_hospital_btth;
create database db_hospital_btth;
use db_hospital_btth;

CREATE TABLE doctors (
    doctor_id INT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    specialty VARCHAR(50),
    experience_years INT,
    base_salary DOUBLE,
    password VARCHAR(255) NOT NULL
);

INSERT INTO Doctors (full_name, specialty, experience_years, base_salary, password) VALUES 
('BS. Nguyễn Văn An', 'Nội khoa', 10, 20000000, 'pass_an_123'),
('BS. Lê Thị Bình', 'Nhi khoa', 5, 15000000, 'pass_binh_456'),
('BS. Trần Quang Đạo', 'Ngoại khoa', 15, 30000000, 'pass_dao_789'),
('BS. Phạm Minh Anh', 'Nhi khoa', 3, 12000000, 'pass_anh_abc'),
('BS. Hoàng Đức Trung', 'Sản khoa', 8, 18000000, 'pass_trung_xyz');

delimiter ~~
CREATE PROCEDURE calculate_duty_fee(IN d_id INT, OUT duty_fee DOUBLE)
BEGIN
    SELECT base_salary * experience_years * 0.05 INTO duty_fee 
    FROM Doctors WHERE doctor_id = d_id;
END ~~
delimiter ;

