INSERT INTO `mydemodb`.`employees` (`first_name`, `last_name`,`email_id`,`birthday`)
VALUES ("Yulya", "Sveta", "test1@mail.com", sysdate());

INSERT INTO `mydemodb`.`employees` (`first_name`, `last_name`,`email_id`,`birthday`)
VALUES ("Katerina", "Lena", "test2@mail.com", sysdate());

INSERT INTO `mydemodb`.`employees` (`first_name`, `last_name`,`email_id`,`birthday`)
VALUES ("Anna", "Raya", "test3@mail.com", sysdate());

SELECT * FROM mydemodb.employees;


INSERT INTO `mydemodb`.`department` (`job`, `section_name`, `employee_id`) VALUES ('Java', 'Software', '1');
INSERT INTO `mydemodb`.`department` (`job`, `section_name`, `employee_id`) VALUES ('AWS', 'Cloud', '1');
INSERT INTO `mydemodb`.`department` (`job`, `section_name`, `employee_id`) VALUES ('IT', 'Cloud', '2');
INSERT INTO `mydemodb`.`department` (`job`, `section_name`, `employee_id`) VALUES ('Blockchain', 'Software', '3');


SELECT * FROM mydemodb.department;
