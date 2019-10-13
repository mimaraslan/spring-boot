# Build Your Docker Image 
docker build -f Dockerfile -t spring-boot-dockerize .

# Check Docker Images
docker image ls
docker images

# Run Docker Image 
# In the run command, we have specified that the port 8080 on the container should be mapped to the port 9090 on the Host OS.
docker run -p 9090:8080 spring-boot-dockerize