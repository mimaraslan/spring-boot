FROM openjdk:11
LABEL maintainer = "mimaraslan.com"
EXPOSE 8080
ADD target/spring-boot-backend-crud-1.0.0-SNAPSHOT.jar spring-boot-backend-crud.jar
ENTRYPOINT ["java","-jar","/spring-boot-backend-crud.jar"]