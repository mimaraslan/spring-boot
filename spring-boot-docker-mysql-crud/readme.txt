## TERMINAL 1
docker run -d -p 3306:3306 -p 33060:33060  --name mysql-standalone -e MYSQL_ROOT_PASSWORD=123456789 -e MYSQL_DATABASE=mydemodb -e MYSQL_USER=katerina  -e MYSQL_PASSWORD=123456789 -d mysql:latest

mysql -u root -p
123456789

SHOW VARIABLES WHERE Variable_name = 'port';

SHOW VARIABLES WHERE Variable_name = 'hostname';
SHOW VARIABLES LIKE "%port%";

//If you want to get user, you need start query in your mysql:
SELECT user(); // output your user: root@localhost
SELECT system_user(); // --

//If you want to get port your "mysql://user:pass@hostname:port/db"
SELECT @@port; //3306 is default

//If you want hostname your db, you can execute query
SELECT @@hostname;

SELECT host, user FROM mysql.user;


CREATE USER 'root'@'%' IDENTIFIED BY 'root';
GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' WITH GRANT OPTION;
GRANT ALL PRIVILEGES ON *.* TO 'katerina'@'%' WITH GRANT OPTION;


CREATE USER 'aslan'@'%' IDENTIFIED BY 'aslan';
GRANT ALL PRIVILEGES ON mydemodb.* TO 'aslan'@'%' WITH GRANT OPTION;


SHOW DATABASES;

CREATE DATABASE `my-lolo-db`;

SHOW DATABASES;

DROP DATABASE `my-lolo-db`;


USE mydemodb;

SHOW TABLES; 

CREATE TABLE product (id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
name VARCHAR(20),
food VARCHAR(30),
confirmed CHAR(1), 
signup_date DATE);

SHOW TABLES;

DESCRIBE product;

INSERT INTO `product` (`id`,`name`,`food`,`confirmed`,`signup_date`) VALUES (NULL, "aaa", "ttt","Y", '2020-04-11');
INSERT INTO `product` (`id`,`name`,`food`,`confirmed`,`signup_date`) VALUES (NULL, "bbb", "yyy","N", '2020-04-14');
INSERT INTO `product` (`id`,`name`,`food`,`confirmed`,`signup_date`) VALUES (NULL, "ccc", "uuu","Y", '2020-04-18');
INSERT INTO `product` (`id`,`name`,`food`,`confirmed`,`signup_date`) VALUES (NULL, "ddd", "mmm","Y", '2020-04-10');

SELECT * FROM product;

UPDATE `product` 
SET 
`confirmed` = 'Y' 
WHERE `product`.`name` ='bbb';

ALTER TABLE product ADD email VARCHAR(40);
DESCRIBE product;

ALTER TABLE product DROP email;
DESCRIBE product;

ALTER TABLE product ADD email VARCHAR(40) AFTER name; 
DESCRIBE product;

ALTER TABLE product DROP email;
DESCRIBE product;

DELETE from product  where name='bbb';
SELECT * FROM product;


## TERMINAL 2
cd /Users/mimaraslan/Documents/workspace/spring-boot/spring-boot-docker-mysql-crud/
docker build -t spring-boot-docker-mysql-crud .

docker run -p 8085:8085 -t --name spring-boot-docker-mysql-crud --link mysql-standalone:mysql spring-boot-docker-mysql-crud