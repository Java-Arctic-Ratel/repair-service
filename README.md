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
- Database for development environment:
  - H2 (in memory)
- Database for local development:
  - MySQL 5
- Database for production environment:
  - PostgreSQL 10

## Installing
To clone and run this application, you'll need:
- Download project from github URL: 
            
      git clone https://github.com/Java-Arctic-Ratel/repair-service.git

- Go into the repository: 
        
      cd repair-service

- Build project

      gradle clean build
- Run applications with a database for development environment:
  - H2 (in memory): 
        
        gradle bootRun --args='--spring.profiles.active=dev'
        
- Run applications with a database for local development:      
  - [MySQL](docs/mysql.md):       
        
        gradle bootRun --args='--spring.profiles.active=local'
        
- Run applications with a database for production environment:
  - [PostgreSQL](docs/postresql.md): 

        gradle bootRun --args='--spring.profiles.active=prod'
  
- Generate fake data and save it to DataBase:
    - !!! All existing data will be deleted !!!
    - $numberOfOrders - - quantity of necessary fake orders
  
          http://localhost:8090/faker/$numberOfOrders
  
- Open http://localhost:8090/order

## Running test
    gradle test
