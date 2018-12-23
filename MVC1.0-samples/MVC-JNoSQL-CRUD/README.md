# Example of CRUD with JSR-371 and MongoDB

Simple example of using JSR-371 together with MongoDB to do CRUD operations.

#Resources Used
- Java 8
- Payara-Micro
- Apache Maven 3.3.9
- MongoDB 3.6
- JNoSQL

Docker = https://hub.docker.com/r/danieldiasjava/mvc-jnosql-crud/

# Run

- Start **MongoDB** default port=27017 with the command in the Prompt / Shell: `mongod` 
- mvn clean package payara-micro:bundle && mvn payara-micro:start
- Test by accessing the address : http://localhost:yourdoor/MVC1.0.Krazo/
