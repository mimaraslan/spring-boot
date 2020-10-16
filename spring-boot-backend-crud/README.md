# spring-boot-dockerize

Spring Boot to Docker
![Spring Boot to Docker](src/main/resources/images/01.jpg)

Running Spring Boot Project on Docker
![Running Spring Boot Project on Docker](src/main/resources/images/02.jpg)

Running Spring Boot Project on Docker
![Running Spring Boot Project on Docker](src/main/resources/images/03.jpg)

<hr>
HTTP request method type: GET <br>
http://localhost:8082/api/v1//api/v1/employees

<hr>
OPEN A TERMINAL <br>
cd /Users/mimaraslan/Documents/workspace/spring-boot/spring-boot-backend-crud/


mvn install dockerfile:build


docker run -p 8082:8082 -t mimaraslan/spring-boot-backend-crud