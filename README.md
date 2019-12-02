[![Build Status](https://travis-ci.com/Java-Arctic-Ratel/repair-service.svg?branch=master)](https://travis-ci.com/Java-Arctic-Ratel/repair-service) [![codecov](https://codecov.io/gh/Java-Arctic-Ratel/repair-service/branch/master/graph/badge.svg)](https://codecov.io/gh/Java-Arctic-Ratel/repair-service)
# Repair service
* [General info](#general-info)
* [Technologies](#technologies)
* [Installing](#installing)
* [Running test](#running-test)

## General info
Application for accounting and business automation in the field of electronic equipment repair services: a single database of orders and customers.

## Technologies
- JDK11
- Spring Boot 2
- Gradle 5
- Database:
  - H2 (in memory)
  - PostgreSQL
  - MySQL

## Installing
To clone and run this application, you'll need:
- Download project from github URL: 
            
      git clone https://github.com/Java-Arctic-Ratel/repair-service.git

- Go into the repository: 
        
      cd repair-service

- Install dependencies - gradle clean build
- Run applications with a database:
  - H2 (in memory): 
        
        java -jar -Dspring.profiles.active=h2 ./rest-app/build/libs/rest-app-1.0-SNAPSHOT.jar
  - [PostgreSQL](docs/postgresql.md): 
  
        java -jar -Dspring.profiles.active=postgresql ./rest-app/build/libs/rest-app-1.0-SNAPSHOT.jar
  - [MySQL](docs/mysql.md): 
        
        java -jar -Dspring.profiles.active=mysql ./rest-app/build/libs/rest-app-1.0-SNAPSHOT.jar
  - Open http://localhost:8090

## Running tests
./gradlew test