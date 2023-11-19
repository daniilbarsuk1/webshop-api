# WebshopAPI Application
WebshopAPI implements part of web shop API:

* It can create, get, delete, update items/baskets with URI queries (you can make URI queries with Postman).

### Technology stack

* Java 17
* Spring Boot 6
* Hibernate
* Rest Assured
* PostgreSQL Database

### How to run

Run application
```sh
./gradlew bootRun
```

### Details
* It has multilayer architecture with service, facade, controller layers.
* WebshopAPI persists data in PostgreSQL database.
