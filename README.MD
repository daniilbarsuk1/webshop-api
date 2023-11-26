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
### Usage
After application is launched, start from sign up, for that make POST request to endpoint
http://localhost:8080/auth/signup with request body of next form:
```json
{
    "username": "<your username>",
    "password": "<your password>"
}
```
As alternative, you can use default user with password 'admin' and username 'admin'. 
Next, you can use all functions of this application.
### Details
* It has multilayer architecture with service, facade, controller layers.
* WebshopAPI persists data in PostgreSQL database.
