FROM java:8
VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} spring-boot-dockerize.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/spring-boot-dockerize.jar"]