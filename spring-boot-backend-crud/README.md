# spring-boot-dockerize

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