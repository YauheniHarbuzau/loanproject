# Loan Project

**Multi-module RESTful project on Spring Framework**

**Author Yauheni Harbuzau**

***

Project structure:

- DAO module
    - Entity
    - Repository
- Service module
    - DTO
    - Mapper
    - Service
    - AOP
- Controller module

***

Java version 11.</br>
Build tool Maven.</br>
Application entry point - ***TestApplication*** class in ***APP*** module.

Implemented saving, receiving, deleting customers and loans, drawing up loan agreements,</br>
calculating the amount of the monthly payment, the full amount of payment,</br>
the amount of the remaining payment,</br>
prohibiting the issuance of a loan with a low annual income of the customer.

The project implements entities for customers ***Person***, loans ***Loan***,</br>
as well as the entity ***Extradition*** that stores information about issued loans.</br>
Thus, issued loans information and customer lists are stored separately.</br>
Business logic is implemented in the ***Service*** module.</br>
Implemented ***AOP*** for exception handling and logging.

![loanproject database schema](images/loanproject_database_schema.png "loanproject database schema")</br>
Loan Project database schema from MySQL Workbench

***

Dependencies and libraries used in the project:

- ***Spring Boot Web***, ***Data JPA***, ***AOP***
- ***MySQL Connector*** for working with the database
- ***Project Lombok*** for automatic generation of getters, setters, constructors
- ***MapStruct*** for mapping between Entity and DTO
- ***SpringDoc OpenAPI UI*** for automating the generation of API documentation
- ***Log4j2*** for logging
- ***JUnit Jupiter*** for testing
- ***Decimal4j*** for number rounding