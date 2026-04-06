-- =========================
-- 1. USERS
-- =========================
INSERT INTO users_tbl (id, firstname, lastname, email, password, register_date, role) VALUES
(1, 'Pankaj', 'Sharma', 'pankaj1@gmail.com', 'pass123', '2024-01-10', 'ADMIN'),
(2, 'Amit', 'Patil', 'amit@gmail.com', 'pass123', '2024-02-12', 'CUSTOMER'),
(3, 'Neha', 'Joshi', 'neha@gmail.com', 'pass123', '2024-03-15', 'AUTHOR'),
(4, 'Rahul', 'Verma', 'rahul@gmail.com', 'pass123', '2024-01-20', 'AUTHOR'),
(5, 'Sneha', 'Kulkarni', 'sneha@gmail.com', 'pass123', '2024-04-01', 'CUSTOMER'),
(6, 'Vikas', 'Singh', 'vikas@gmail.com', 'pass123', '2024-02-18', 'AUTHOR'),
(7, 'Anjali', 'Mehta', 'anjali@gmail.com', 'pass123', '2024-03-05', 'CUSTOMER'),
(8, 'Rohit', 'Deshmukh', 'rohit@gmail.com', 'pass123', '2024-01-25', 'AUTHOR'),
(9, 'Kiran', 'Patel', 'kiran@gmail.com', 'pass123', '2024-02-28', 'CUSTOMER'),
(10, 'Meena', 'Iyer', 'meena@gmail.com', 'pass123', '2024-03-30', 'AUTHOR');

-- =========================
-- 2. TOPICS
-- =========================
INSERT INTO topic_tbl (id, topic_name, topic_desc) VALUES
(1, 'Java', 'Core and Advanced Java'),
(2, 'Spring', 'Spring Framework and Boot'),
(3, 'Hibernate', 'ORM Framework'),
(4, 'Database', 'SQL and NoSQL'),
(5, 'Web Development', 'Frontend and Backend');

-- =========================
-- 3. TUTORIALS
-- =========================
INSERT INTO tutorial_tbl (id, tutorial_name, publish_date, total_visits, content, topic_id, user_id) VALUES
(1, 'Java Basics', '2024-01-15', 120, 'Intro to Java', 1, 3),
(2, 'Spring Boot Intro', '2024-02-10', 200, 'Spring Boot Guide', 2, 4),
(3, 'Hibernate Mapping', '2024-03-05', 150, 'ORM Concepts', 3, 6),
(4, 'SQL Joins', '2024-01-22', 180, 'Join Queries', 4, 8),
(5, 'HTML Basics', '2024-02-01', 90, 'HTML Intro', 5, 10),
(6, 'Java Streams', '2024-03-18', 210, 'Streams API', 1, 3),
(7, 'Spring Security', '2024-04-02', 170, 'Security Concepts', 2, 4),
(8, 'Caching in Hibernate', '2024-03-25', 130, 'Cache Levels', 3, 6),
(9, 'Indexes in DB', '2024-02-14', 160, 'Indexing', 4, 8),
(10, 'React Basics', '2024-04-05', 140, 'Frontend Intro', 5, 10);

-- =========================
-- 4. ADDRESSES (@MapsId → user_id = PK)
-- =========================
INSERT INTO address_tbl (user_id, address_line1, address_line2, city, state, country, zip_code) VALUES
(1, 'Street 1', 'Apt 101', 'Pune', 'Maharashtra', 'India', '411001'),
(2, 'Street 2', 'Apt 102', 'Mumbai', 'Maharashtra', 'India', '400001'),
(3, 'Street 3', 'Apt 103', 'Nagpur', 'Maharashtra', 'India', '440001'),
(4, 'Street 4', 'Apt 104', 'Delhi', 'Delhi', 'India', '110001'),
(5, 'Street 5', 'Apt 105', 'Bangalore', 'Karnataka', 'India', '560001'),
(6, 'Street 6', 'Apt 106', 'Hyderabad', 'Telangana', 'India', '500001'),
(7, 'Street 7', 'Apt 107', 'Chennai', 'Tamil Nadu', 'India', '600001'),
(8, 'Street 8', 'Apt 108', 'Kolkata', 'West Bengal', 'India', '700001'),
(9, 'Street 9', 'Apt 109', 'Ahmedabad', 'Gujarat', 'India', '380001'),
(10, 'Street 10', 'Apt 110', 'Jaipur', 'Rajasthan', 'India', '302001');