-- Ensure Database exists
CREATE DATABASE IF NOT EXISTS student_mgmt_db;
USE student_mgmt_db;

-- Table for Students
CREATE TABLE IF NOT EXISTS students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    course VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Seed Data
INSERT INTO students (name, email, course) VALUES ('Achintya', 'achin@example.com', 'Java Full Stack');
