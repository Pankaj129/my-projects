-- ==============================
-- USERS TABLE (20 RECORDS)
-- ==============================

INSERT INTO users_tbl (firstname, lastname, email, password, registerDate, role) VALUES
('John','Doe','john1@gmail.com','pass123','2024-01-01','CUSTOMER'),
('Jane','Smith','jane2@gmail.com','pass123','2024-01-02','AUTHOR'),
('Mike','Johnson','mike3@gmail.com','pass123','2024-01-03','ADMIN'),
('Emily','Davis','emily4@gmail.com','pass123','2024-01-04','CUSTOMER'),
('David','Wilson','david5@gmail.com','pass123','2024-01-05','AUTHOR'),
('Sarah','Taylor','sarah6@gmail.com','pass123','2024-01-06','CUSTOMER'),
('Chris','Brown','chris7@gmail.com','pass123','2024-01-07','AUTHOR'),
('Emma','Anderson','emma8@gmail.com','pass123','2024-01-08','CUSTOMER'),
('Daniel','Thomas','daniel9@gmail.com','pass123','2024-01-09','ADMIN'),
('Sophia','Jackson','sophia10@gmail.com','pass123','2024-01-10','CUSTOMER'),
('James','White','james11@gmail.com','pass123','2024-01-11','AUTHOR'),
('Olivia','Harris','olivia12@gmail.com','pass123','2024-01-12','CUSTOMER'),
('Liam','Martin','liam13@gmail.com','pass123','2024-01-13','CUSTOMER'),
('Ava','Thompson','ava14@gmail.com','pass123','2024-01-14','AUTHOR'),
('Noah','Garcia','noah15@gmail.com','pass123','2024-01-15','CUSTOMER'),
('Isabella','Martinez','isabella16@gmail.com','pass123','2024-01-16','ADMIN'),
('Ethan','Robinson','ethan17@gmail.com','pass123','2024-01-17','CUSTOMER'),
('Mia','Clark','mia18@gmail.com','pass123','2024-01-18','AUTHOR'),
('Lucas','Rodriguez','lucas19@gmail.com','pass123','2024-01-19','CUSTOMER'),
('Charlotte','Lewis','charlotte20@gmail.com','pass123','2024-01-20','CUSTOMER');


-- ==============================
-- TOPIC TABLE (20 RECORDS)
-- ==============================

INSERT INTO topic_tbl (topic_name, topic_desc) VALUES
('Java','Core Java concepts'),
('Spring','Spring Framework basics'),
('Hibernate','ORM with Hibernate'),
('MySQL','Database concepts'),
('REST API','Building REST services'),
('Microservices','Distributed architecture'),
('Docker','Containerization basics'),
('Kubernetes','Container orchestration'),
('AWS','Cloud fundamentals'),
('React','Frontend library'),
('Angular','Frontend framework'),
('Python','Programming basics'),
('Machine Learning','ML concepts'),
('Data Science','Data analysis'),
('DevOps','CI/CD pipelines'),
('Git','Version control'),
('Linux','OS fundamentals'),
('Networking','Network basics'),
('Security','Application security'),
('Testing','Unit & integration testing');


-- ==============================
-- ADDRESS TABLE (20 RECORDS)
-- ==============================

INSERT INTO address_tbl (id, address_line1, address_line2, city, state, country, zipCode, user_id) VALUES
(1,'Street 1','Near Park','Pune','MH','India','411001',1),
(2,'Street 2','Near Mall','Mumbai','MH','India','400001',2),
(3,'Street 3','Near School','Delhi','DL','India','110001',3),
(4,'Street 4','Near Office','Bangalore','KA','India','560001',4),
(5,'Street 5','Near Temple','Chennai','TN','India','600001',5),
(6,'Street 6','Near Hospital','Hyderabad','TS','India','500001',6),
(7,'Street 7','Near Market','Kolkata','WB','India','700001',7),
(8,'Street 8','Near Station','Ahmedabad','GJ','India','380001',8),
(9,'Street 9','Near Lake','Jaipur','RJ','India','302001',9),
(10,'Street 10','Near Garden','Lucknow','UP','India','226001',10),
(11,'Street 11','Near School','Nagpur','MH','India','440001',11),
(12,'Street 12','Near Mall','Indore','MP','India','452001',12),
(13,'Street 13','Near Park','Bhopal','MP','India','462001',13),
(14,'Street 14','Near Temple','Patna','BR','India','800001',14),
(15,'Street 15','Near Hospital','Surat','GJ','India','395001',15),
(16,'Street 16','Near Office','Kanpur','UP','India','208001',16),
(17,'Street 17','Near Market','Agra','UP','India','282001',17),
(18,'Street 18','Near Station','Nashik','MH','India','422001',18),
(19,'Street 19','Near Lake','Amritsar','PB','India','143001',19),
(20,'Street 20','Near Garden','Goa','GA','India','403001',20);



-- ==============================
-- TUTORIAL TABLE (20 RECORDS)
-- ==============================

INSERT INTO tutorial_tbl (tutorial_name, publish_date, total_visits, content, topic_id, user_id) VALUES
('Java Basics','2024-02-01',120,'Introduction to Java programming concepts',1,2),
('Spring Core','2024-02-02',150,'Understanding Spring IoC and DI',2,5),
('Hibernate Intro','2024-02-03',180,'Basics of Hibernate ORM framework',3,7),
('MySQL Queries','2024-02-04',200,'Learn CRUD operations in MySQL',4,11),
('REST API Design','2024-02-05',220,'Best practices for REST API development',5,2),

('Microservices Arch','2024-02-06',250,'Introduction to microservices architecture',6,5),
('Docker Setup','2024-02-07',300,'Getting started with Docker containers',7,7),
('Kubernetes Basics','2024-02-08',275,'Intro to Kubernetes orchestration',8,11),
('AWS EC2 Guide','2024-02-09',310,'Deploy apps using AWS EC2',9,14),
('React Components','2024-02-10',290,'Understanding React components and props',10,2),

('Angular Directives','2024-02-11',260,'Working with Angular directives',11,5),
('Python Basics','2024-02-12',330,'Learn Python programming from scratch',12,7),
('ML Intro','2024-02-13',350,'Basics of Machine Learning concepts',13,11),
('Data Science Guide','2024-02-14',370,'Data analysis and visualization',14,14),
('DevOps CI/CD','2024-02-15',400,'Building CI/CD pipelines',15,18),

('Git Commands','2024-02-16',210,'Common Git commands explained',16,2),
('Linux Commands','2024-02-17',230,'Essential Linux commands for developers',17,5),
('Networking Basics','2024-02-18',240,'Understanding networking concepts',18,7),
('App Security','2024-02-19',260,'Security best practices for applications',19,11),
('Unit Testing','2024-02-20',280,'JUnit and integration testing basics',20,18);