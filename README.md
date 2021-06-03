QHALALIBRARY API

These is the qhala library backend services for users to register & login and view their videos and books.
The Restful services are well protected and routed to the specific JPA modules.

SCREENS
<<POSTMAN REQUESTS TO BE INCLUDED LATER || ALTERNATIVELY SWAGGER DOCUMENTATION URL>>


SWAGGER DOCS
http://localhost:8080/swagger-ui.html



MAVEN LIBRARIES
-Spring Boot 1.5.1.RELEASE
-Custom: Exceptions, File IO, Rest Authentication
-Spring Boot Test
-JSON Library(javax.json)
-Swagger API
-Hibernate Validation API (org.hibernate)
-Random Numbers and String Generators(smt-random-strings and smt-random-numbers)

FEATURES
These services can perform,
1. Users login
2. CRUD users
3. CRUD Operations for books and videos
3. View users assigned books and videos


DEPLOYMENT
Both MySQL database and war file to be deployed in the docker container


DEVELOPERS
evans kiptarus kibet(evanskibet114@gmail.com)