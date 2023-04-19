# spring-boot-security-data-mongodb

This project serves as a scaffold for building applications that utilize JWT authentication using Spring Security and
implement CRUD operations using Spring Data and MongoDB database.

It is based on this article https://www.bezkoder.com/spring-boot-mongodb-reactive/.

### Overview of registration, login and authorization process:

![spring-boot-mongodb-jwt-authentication-flow](spring-boot-mongodb-jwt-authentication-flow.png)

### Overview of Spring Boot Rest API Architecture:

![spring-boot-mongodb-jwt-authentication-spring-security-architecture](spring-boot-mongodb-jwt-authentication-spring-security-architecture.png)

### Available AUTH endpoints:
| Method | Url             | Action                   |
| ------ |-----------------|--------------------------|
| POST   | /api/auth/signup | register new user        |
```
{
  "username": "tester",
  "email": "test@test.com",
  "password": "12345678",
  "roles": ["user", "mod"]
}
```

| Method | Url             | Action                   |
| ------- |------------------|---------------------------|
| POST    | /api/auth/signin | log in with existing user |
```
{
  "username": "tester",
  "password": "12345678"
}
```

### Available REST endpoints:
| Methods | Urls                           | Actions                                   |
| ------- | ------------------------------| ----------------------------------------- |
| POST    | /api/tutorials                | create new Tutorial                       |
| GET     | /api/tutorials                | retrieve all Tutorials                    |
| GET     | /api/tutorials/:id            | retrieve a Tutorial by :id                |
| PUT     | /api/tutorials/:id            | update a Tutorial by :id                  |
| DELETE  | /api/tutorials/:id            | delete a Tutorial by :id                  |
| DELETE  | /api/tutorials                | delete all Tutorials                      |
| GET     | /api/tutorials/published      | find all published Tutorials              |
| GET     | /api/tutorials?title=[keyword]| find all Tutorials which title contains keyword |

## Configuration

### Database setup

Create collection named `roles` and run this query:
```
db.roles.insertMany([
{ "name": "ROLE_USER" },
{ "name": "ROLE_MODERATOR" },
{ "name": "ROLE_ADMIN" }
])
```
It will create roles that are required for the authorization process.

### Application setup

Before running application please set up your MongoDB database credentials in application.properties file using localhost or external 
uri:

```
#spring.data.mongodb.database=gride29_db
#spring.data.mongodb.host=localhost
#spring.data.mongodb.port=27017

#MongoDB configuration
spring.data.mongodb.uri=mongodb+srv://admin:${MONGODB_PASSWORD}@cluster0.awfhypf.mongodb.net/?retryWrites=true&w=majority
spring.data.mongodb.database=${MONGODB_SCHEMA:schema-name}
```


### Running the application
If you have trouble setting env variable during the build time, you can use this shell script:
```
#!/bin/bash

export MONGODB_PASSWORD=YOUR_PASSWORD
mvn install
unset YOUR_VAR
```

To build application use:
```
mvn install
```

To run application use: 
```
mvn spring-boot:run
```