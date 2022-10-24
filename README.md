# Loan Project

**Multi-module RESTful project on Spring Framework**

**Author Yauheni Harbuzau**

***

Project structure:

- DAO module
    - Entity
    - JPA Repository
- Service module
    - DTO
    - Mapper
    - Service
    - AOP
- Controller
- APP (application entry point)

***

Java version 11.</br>
Build tool Maven.</br>
Application entry point - ***TestApplication*** class in ***APP*** module.

The project implements entities for clients ***Person***, loans ***Loan***,</br>
as well as the entity ***Extradition*** that stores information about issued loans.</br>
Thus, issued loans information and customer lists are stored separately.</br>
Business logic is implemented in the ***Service*** module.</br>
Implemented ***AOP*** for exception handling and logging.

***

Dependencies and libraries are used in the project:

- ***Spring Boot Web***, ***Data JPA***, ***AOP***
- ***MySQL Connector*** for working with the database
- ***Project Lombok*** for automatic generation of getters, setters, constructors
- ***MapStruct*** for mapping between Entity and DTO
- ***SpringDoc OpenAPI UI*** for working with Swagger UI
- ***Log4j2*** for logging
- ***JUnit Jupiter*** for test
- ***Decimal4j*** for round numbers