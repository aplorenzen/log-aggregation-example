# Example - Log Aggregration with ELK

### Introduction
This repository contains an example of how to get started with log aggregation with the ELK stack.

It contains basic configuration and a docker-compose definition for and ELK stack, including a filebeat container.
Also it contains two very simple spring boot containers, where one will be trying to reach a REST endpoint of the other service.

### Setting up

A few prerequisites:

1. You will need to have docker installed!
2. And you will need to have Java installed in order to build the Spring Boot applications
3. Make sure that your docker host (on Windows that means the Docker VM, configured through the Hyper-V Manager) has 2G+ memory available
4. You need to prepare two docker networks for the stacks to start:
   * elk (`docker network create elk`)
   * demo (`docker network create demo`)
   
### Development

#### Run the provider-service in dev mode
```bash
cd provider-service
mvnw spring-boot:run
```

#### Run the consumer-service in dev mode
```bash
cd consumer-service
mvnw spring-boot:run
```

### Buliding the Spring Boot applications
The following instructions should be initiated from the root of the project

#### Build the provider-service application and docker image
```bash
cd provider-service
mvnw clean package
docker build -t provider-service:0.1 .
```

#### Build the consumer service application and docker image
```
cd consumer-service
mvnw clean package
docker build -t consumer-service:0.1 .
```

#### Run the ELK stack
```
docker-compose up
```

Optionally use `docker-compose up -d`, to not attach the local terminal session to the stdout from the started containers. 

#### Run the two services (demo and consumer)
```
docker-compose -f app-stack.yml up
```

This will also build the demo and consumer docker images, but not the java applications. That needs to be done for each of them
