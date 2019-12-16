CREATE DATABASE IF NOT EXISTS mycompanydb;

USE mycompanydb;

CREATE TABLE employee (
	id INT(50) NOT NULL AUTO_INCREMENT, 
	name VARCHAR(200) DEFAULT NULL, 
	position VARCHAR(200) DEFAULT NULL,
	department VARCHAR(100) DEFAULT NULL,
	salary INT(100) DEFAULT NULL,
	PRIMARY KEY (id)
);

INSERT INTO employee (id, name, position, department, salary) VALUES (1, 'Katerina Lena', 'Lead', 'Administration', 13000);

INSERT INTO employee (id, name, position, department, salary) VALUES (2, 'Olga Raya', 'Associate', 'Human Resource', 11000);

INSERT INTO employee (id, name, position, department, salary) VALUES (3, 'Yulya Natalia', 'Associate', 'Software', 9000);

INSERT INTO employee (id, name, position, department, salary) VALUES (4, 'Ksenie Tanya', 'Manager', 'Software', 12000);

INSERT INTO employee (id, name, position, department, salary) VALUES (5, 'Svetlana Larissa', 'Senior Manager', 'Human Resource', 16000);

INSERT INTO employee (id, name, position, department, salary) VALUES (6, 'Dasha Masha', 'Lead', 'Software', 14000);

SELECT * FROM employee;