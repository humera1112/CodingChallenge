# CodingChallenge
This a RESTful service written in SpringBoot. The intent of the service is to provide operations for adding, updating and deleting enrollers and their dependants

## Building
Use maven to build the application from command line by running the following command at the root directory
mvn clean package

## Running
### As a springboot jar
mvn spring-boot:run 

Once is service is running, you may access the swagger Ui Api http://localhost:8080/healthcare/swagger-ui.html page and interact  with service directly from that page.
Alternatively, you can submit request from Postman and even command line using curl

If you like to interact directly with the data the service is running over,
embedded H2 database can be accessed from this page http://localhost:8080/healthcare/h2-console/login.jsp
- JDBC URL: jdbc:h2:mem:test;DB_CLOSE_ON_EXIT=FALSE;DB_CLOSE_DELAY=-1
- User / Password: sa / sa
