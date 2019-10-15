# Dockerizing a Spring Boot Application

## Build Your Docker Image 
docker build -f Dockerfile -t spring-boot-dockerize .

## Check Docker Images
docker images

## Run Docker Image 
## In the run command, we have specified that the port 8080 on the container should be mapped to the port 9090 on the Host OS.
docker run -p 9090:8080 spring-boot-dockerize

## In the run command, we have specified that the port 8080 on the container should be mapped to the port 8082 on the Host OS.
docker run -p 8082:8080 -t spring-boot-dockerize