# Example - Log Aggregration with ELK

## Introduction
This repository contains an example of how to get started with log aggregation with the ELK stack.

It contains basic configuration and a docker-compose definition for and ELK stack, including a filebeat container.
Also it contains two very simple spring boot containers, where one will be trying to reach a REST endpoint of the other service.

## Setting up

A few prerequisites:

1. You will need to have docker installed!
2. And you will need to have Java installed in order to build the Spring Boot applications
3. Make sure that your docker host has 2G+ memory available (on Windows, right click on the Docker icon in the system tray -> "Settinga" -> "Advanced")
4. You need to prepare two docker networks for the stacks to start:
   * elk (`docker network create elk`)
   * demo (`docker network create demo`)
   
## Demo

In order to run the demo, you will need to build the Spring boot applications and then a docker image for each of them. Then you will be able to start the ELK and application stacks. 

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

### Starting the ELK and application stacks
These instructions should be initiated with the project root as working directory.

#### Run the ELK stack
```
docker-compose up
```

Optionally use `docker-compose up -d`, to not attach the local terminal session to the stdout from the started containers. (`docker-compose --help` and `docker-compose up --help` for more switches) 

#### Run the two services (provider and consumer)
```
docker-compose -f app-stack.yml up
```

This will also build the provider and consumer docker images if they were not built, but not the java applications. That needs to be done for each of them with maven as described above.

## Development

If you want to do some development on the services, you can run them with the maven wrapper.

### Run the provider-service in dev mode
```bash
cd provider-service
mvnw spring-boot:run
```

### Run the consumer-service in dev mode
```bash
cd consumer-service
mvnw spring-boot:run
```


