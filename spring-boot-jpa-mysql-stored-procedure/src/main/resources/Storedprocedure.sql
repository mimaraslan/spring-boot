----- STORED PROCEDURE QUERY #1 -----
DELIMITER $$
CREATE PROCEDURE `findAllEmployees` ()
    BEGIN
		SELECT * FROM employee;
    END $$
DELIMITER ;


----- STORED PROCEDURE QUERY #2 -----
DELIMITER $$
CREATE PROCEDURE findEmployeeByDepartment (IN emp_department VARCHAR(200))
	BEGIN
		SELECT * FROM employee emp WHERE emp.department = emp_department;
	END $$
DELIMITER ;


----- STORED PROCEDURE QUERY #3 -----
DELIMITER $$
CREATE PROCEDURE findEmployeeCountByPosition (IN emp_position VARCHAR(200), OUT position_count INT(50))
	BEGIN
		SELECT COUNT(*) INTO position_count FROM employee emp WHERE emp.position = emp_position;
	END $$
DELIMITER ;