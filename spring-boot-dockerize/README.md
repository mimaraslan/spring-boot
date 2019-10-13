# https://spring.io/guides/gs/spring-boot-docker/

docker version

# spring-boot-dockerize
How to Dockerize Spring Boot Application 

# Build Your Docker Image 
docker build -t spring-boot-dockerize.jar .
docker build . -f Dockerfile


# Check Docker Images
docker image ls
docker images

# Run Docker Image 



docker run -p 9090:8080 spring-boot-dockerize.jar

In the run command, we have specified that the port 8080 on the container should be mapped to the port 9090 on the Host OS.