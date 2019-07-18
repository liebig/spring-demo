# Spring Framework Demo App

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Handling Form Submission](https://spring.io/guides/gs/handling-form-submission/)
* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)


# Tutorial
`curl -v http://localhost:8080/greeting?name=Joe`

`curl -v -s -H 'Accept-Language: de' http://localhost:8080/greeting?name=Joe`

`curl -v -s -H 'Accept-Language: en' http://localhost:8080/greeting?name=Joe`

`curl -v -s -H 'Accept-Language: fr_FR' http://localhost:8080/greeting?name=Joe`

`curl -v -X DELETE http://localhost:8080/api/customers/1`

`http://localhost:8080/actuator`

`java -jar .\target\demo-0.0.1-SNAPSHOT.war`
