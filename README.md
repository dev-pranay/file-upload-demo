# file-upload-demo

This project is developed using Spring Boot 2.2.2.RELEASE with dependencies 'spring-boot-starter-web',
'spring-boot-starter-data-jpa', 'spring-boot-starter-data-rest' and 'lombok'.
This is the <b>back-end</b> application. The images will be uploaded in the <b>images</b> folder in src/main/resources/images/ . The front-end is developed using Angular 8 and can be accessed here <a href="https://github.com/dev-pranay/file-upload-client">file-upload-client</a>.

## Exceptions

Exception handling is done in 'Global Exception Handler' class using '@ControllerAdvice'.

## Database

In memory database, <b>H2 in MySQL mode</b>, is used for storing the user details and images.

## Table Script

The <b>USERDETAIL</b> table need to be created when the server is up and before running the application from front-end.

CREATE TABLE USERDETAIL (
	USER_ID INTEGER(20) AUTO_INCREMENT PRIMARY KEY,
	EMAIL_ID VARCHAR(20),
	NAME VARCHAR(20),
	PROFILE_IMAGE VARCHAR(100)
);

## Application execution steps:

1. Run the back-end i.e. server application
2. Create the table as given in the script using H2 console. Access it here - http://localhost:APP_PORT/h2-console
3. Run the <a href="https://github.com/dev-pranay/file-upload-client">file-upload-client</a> application for UI

And you are ready to test it.