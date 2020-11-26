Spring Boot to Docker
![Spring Boot to Docker](src/main/resources/static/images/01.jpg)
![Running Spring Boot Project on Docker](src/main/resources/static/images/02.jpg)
![Running Spring Boot Project on Docker](src/main/resources/static/images/03.jpg)

Running Spring Boot Project on Docker
![Running Spring Boot Project on Docker](src/main/resources/static/images/04.jpg)
![Running Spring Boot Project on Docker](src/main/resources/static/images/05.jpg)
![Running Spring Boot Project on Docker](src/main/resources/static/images/06.jpg)
![Running Spring Boot Project on Docker](src/main/resources/static/images/07.jpg)
![Running Spring Boot Project on Docker](src/main/resources/static/images/08.jpg)
![Running Spring Boot Project on Docker](src/main/resources/static/images/09.jpg)
![Running Spring Boot Project on Docker](src/main/resources/static/images/10.jpg)
![Running Spring Boot Project on Docker](src/main/resources/static/images/11.jpg)
![Running Spring Boot Project on Docker](src/main/resources/static/images/12.jpg)
![Running Spring Boot Project on Docker](src/main/resources/static/images/13.jpg)
![Running Spring Boot Project on Docker](src/main/resources/static/images/14.jpg)
![Running Spring Boot Project on Docker](src/main/resources/static/images/15.jpg)
![Running Spring Boot Project on Docker](src/main/resources/static/images/16.jpg)
![Running Spring Boot Project on Docker](src/main/resources/static/images/17.jpg)


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

##### MySQL Practical Command Examples #######

SHOW DATABASES;

CREATE DATABASE `my-lolo-db`;
SHOW DATABASES;

DROP DATABASE `my-lolo-db`;
SHOW DATABASES;


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
SELECT * FROM product;

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

exit;
##### MySQL Practical Command Examples #######


## TERMINAL 2
cd /Users/mimaraslan/Documents/workspace/spring-boot/spring-boot-docker-mysql-crud
docker build -t spring-boot-docker-mysql-crud .

docker run -p 8085:8085 -t --name spring-boot-docker-mysql-crud --link mysql-standalone:mysql spring-boot-docker-mysql-crud


## Docker CLI - Cheat Sheet (Kopya Kağıdı) Komut ve	Açıklaması
docker images	
Lokal registry’de mevcut bulunan Image’ları listeler

docker ps	
Halihazırda çalışmakta olan Container’ları listeler

docker ps -a	
Docker Daemon üzerindeki bütün Container’ları listeler

docker ps -aq	
Docker Daemon üzerindeki bütün Container’ların ID’lerini listeler

docker pull <repository_name>/<image_name>:<image_tag>	
Belirtilen Image’ı lokal registry’ye indirir. Örnek: docker pull gsengun/jmeter3.0:1.7

docker top <container_id>	
İlgili Container’da top komutunu çalıştırarak çıktısını gösterir

docker run -it <image_id|image_name> CMD	
Verilen Image’dan terminal’i attach ederek bir Container oluşturur

docker pause <container_id>	
İlgili Container’ı duraklatır

docker unpause <container_id>	
İlgili Container pause ile duraklatılmış ise çalışmasına devam ettirilir

docker stop <container_id>	
İlgili Container’ı durdurur

docker start <container_id>	
İlgili Container’ı durdurulmuşsa tekrar başlatır

docker rm <container_id>	
İlgili Container’ı kaldırır fakat ilişkili Volume’lara dokunmaz

docker rm -v <container_id>	
İlgili Container’ı ilişkili Volume’lar ile birlikte kaldırır

docker rm -f <container_id>	
İlgili Container’ı zorlayarak kaldırır. Çalışan bir Container ancak -f ile kaldırılabilir

docker rmi <image_id|image_name>	
İlgili Image’ı siler

docker rmi -f <image_id|image_name>	
İlgili Image’ı zorlayarak kaldırır, başka isimlerle Tag’lenmiş Image’lar -f ile kaldırılabilir

docker info	
Docker Daemon’la ilgili özet bilgiler verir

docker inspect <container_id>	
İlgili Container’la ilgili detaylı bilgiler verir

docker inspect <image_id|image_name>	
İlgili Image’la ilgili detaylı bilgiler verir

docker rm $(docker ps -aq)	
Bütün Container’ları kaldırır

docker stop $(docker ps -aq)	
Çalışan bütün Container’ları durdurur

docker rmi $(docker images -aq)	
Bütün Image’ları kaldırır

docker images -q -f dangling=true	
Dangling (taglenmemiş ve bir Container ile ilişkilendirilmemiş) Image’ları listeler

docker rmi $(docker images -q -f dangling=true)	
Dangling Image’ları kaldırır

docker volume ls -f dangling=true	
Dangling Volume’ları listeler

docker volume rm $(docker volume ls -f dangling=true -q)	
Danling Volume’ları kaldırır

docker logs <container_id>	
İlgili Container’ın terminalinde o ana kadar oluşan çıktıyı gösterir

docker logs -f <container_id>	
İlgili Container’ın terminalinde o ana kadar oluşan çıktıyı gösterir ve -f follow parametresi ile o andan sonra oluşan logları da göstermeye devam eder

docker exec <container_id> <command>	
Çalışan bir Container içinde bir komut koşturmak için kullanılır

docker exec -it <container_id> /bin/bash	
Çalışan bir Container içinde terminal açmak için kullanılır. İlgili Image’da /bin/bash bulunduğu varsayımı ile

docker attach <container_id>	
Önceden detached modda -d başlatılan bir Container’a attach olmak için kullanılır
