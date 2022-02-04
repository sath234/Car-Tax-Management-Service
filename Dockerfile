#### SHARED DOCKER STAGES ##############

# The OS setup
FROM ubuntu as developer-os
ENV DEBIAN_FRONTEND    noninteractive
RUN apt-get update --fix-missing && \
apt-get install -y software-properties-common && \
apt-get install -y --no-install-recommends apt-utils && \
apt-get install -y curl \
wget
RUN echo "export SERVER_IP_ADDRESS='0.0.0.0'" >> /etc/profile
RUN apt-get clean

#### THE WEB SERVICE ##############
FROM openjdk:8-jdk-alpine as webservice
Expose 8080
WORKDIR /var
ENTRYPOINT ["java", "-jar", "springwebservice.jar"]
