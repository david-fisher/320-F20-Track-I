# 320-F20-Track-I
track 1's repo - Business in the frontend, Party in the backend
## Spring Boot Start up
* Clone the repository
* Import Maven dependencies
* Go to src\main\java\team8\partyinthebackend\EthicsApplication.java and run :rocket:
* Finally, check out http://localhost:8080/

## React Webpage Start up
You need node.js latest version: https://nodejs.org/en/

* Run springboot server
* Then navigate to project directory 'react/basic-app'
* `npm install` to download necessary libraries and files
* `npm start`
* Open http://localhost:3000/

## Database start up
* Download the PostgreSQL https://www.youtube.com/watch?v=BLH3s5eTL4Y
* For the initialization, you should have 
    * port: 5432
    * username: postgres
    * passward: \<anything>
    * database: postgres
    * table: students
    * student have name and major in different columns
* Change the password config to \<anything> in the file src\main\resources\mybatis-config.xml
* Run your react, you should be able to see the first student you put in database

## Troubleshooting
Port is already occupied solution: https://www.baeldung.com/tomcat-bind-exception
