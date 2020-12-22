# Simple Calculator
This project is written in Java 11 with Spring Boot and Angular 9
## Preparation
Make sure Node version 12 or higher, Angular 9 and Java 11 are installed

Set up a MySQL database with the name calculator on the default port (3306).

The default username will be "root" and the default password will be "password". 
Make sure to change this in the backend/src/main/resources/application.properties file if you want a secure application.

## Installation
* Clone this project
* Run mvn install in the backend directory and npm install in  the frontend directory.

## Start up
* Run mvn spring-boot:run in the backend directory and npm start in the frontend directory.

## Testing
* Run mvn test in the backend directory and npm test in the frontend directory.