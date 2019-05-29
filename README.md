# Java Optional
A small command line application in Java and fully tested, written for a small presentation I gave about Java 8 Optional and with the side purpose of familiarising with database connectivity using jdbc, MySQL and Docker. 

The application simply connects to a database and prints to the user the full name of the member whose ID is passed as argument in the command line, if that member exists. 
Otherwise, it prints an unsuccessful message.

## Prerequisites
* Docker
* a Java version from 8

### To create the local database with docker-compose 
Run `docker-compose -f src/test-mysql/docker-compose.yml up -d` from the project root to create and start a MySQL database container.
`docker-compose.yml` will create a table `members` inside the database and load some data in the table.
You can access the MySQL docker container's Adminer UI in a web browser at http://0.0.0.0:8080 for local testing (username and password are defined in `docker-compose.yml`.) 

To stop the database server run `docker-compose -f src/test-mysql/docker-compose.yml down` in the command line.

### To run the application from the project root
Make sure you have run `docker-compose` as indicated above, first, to start your database.

In the command line, run the following from the project root: 
```$xslt
gradle install
./build/install/OptionalTest/bin/OptionalTest <arg>

```
, where `<arg>` should be any number representing a member ID (please note currently no checking is made when the argument passed is not a number. In that case, the application will throw an unchecked exception).

### To run the tests
Make sure you have run `docker-compose` as indicated above, first. `docker-compose.yml` will also create a test MySQL database in a different port which is only used for the tests. 

Then run:
`./gradlew test`

