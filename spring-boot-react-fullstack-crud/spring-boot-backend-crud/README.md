# spring-boot-backend-crud 

Spring Boot
![Spring Boot](src/main/resources/static/images/01.png)
![Spring Boot](src/main/resources/static/images/02.png)


-- NEXT STEP Coming Soon with docker -------------------

Spring Boot to Docker
![Spring Boot to Docker](src/main/resources/static/images/01.jpg)

Running Spring Boot Project on Docker
![Running Spring Boot Project on Docker](src/main/resources/static/images/02.jpg)

Running Spring Boot Project on Docker
![Running Spring Boot Project on Docker](src/main/resources/static/images/03.jpg)

<hr>
HTTP request method type: GET <br>
http://localhost:8082/api/v1//api/v1/employees

<hr>
OPEN A TERMINAL <br>
cd /Users/mimaraslan/Documents/workspace/spring-boot/spring-boot-backend-crud/

<hr>
docker build -t spring-boot-backend-crud:latest . 

<hr>
docker images

<hr>
docker run -p 8082:8082 -t spring-boot-backend-crud --link mysql-standalone:mysql spring-boot-backend-crud 