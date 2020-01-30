http://localhost:8085/api/v1/message

http://localhost:8085/test


mvn install dockerfile:build

docker run -p 8085:8085 -t spring-boot-dockerize/spring-boot-dockerize