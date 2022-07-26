FROM openjdk:11
LABEL maintainer = "mimaraslan.com"
ADD target/spring-boot-backend-crud-1.0.1.jar spring-boot-backend-crud.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "spring-boot-backend-crud.jar"]