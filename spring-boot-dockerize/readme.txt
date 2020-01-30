http://localhost:8085/api/v1/message

http://localhost:8085/test

TERMINAL
cd /Users/mimaraslan/Documents/workspace/spring-boot/spring-boot-dockerize/

mvn install dockerfile:build

docker run -p 8085:8085 -t mimaraslan/spring-boot-dockerize