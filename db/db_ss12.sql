drop database if exists hospital_db;
CREATE DATABASE hospital_db;
USE hospital_db;

CREATE TABLE doctors (
    doctor_code VARCHAR(20) PRIMARY KEY,
    password VARCHAR(100),
    full_name VARCHAR(100),
    role VARCHAR(20)
);

INSERT INTO doctors (doctor_code, password, full_name, role) VALUES
('DOC001', '123456', 'Nguyen Van A', 'ADMIN'),
('DOC002', 'abc123', 'Tran Thi B', 'DOCTOR'),
('DOC003', 'password', 'Le Van C', 'DOCTOR');

CREATE TABLE medicines (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    stock INT NOT NULL
);

CREATE TABLE prescriptions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    medicine_id INT,
    quantity_sold INT NOT NULL,
    sale_date DATE NOT NULL,
    FOREIGN KEY (medicine_id) REFERENCES medicines(id)
);