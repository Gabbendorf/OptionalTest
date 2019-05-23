# Java Optional
A small command line application in Java and fully tested, written for a small presentation about Java 8 Optional and with the side purpose of familiarising with database connectivity using jdbc and MySql. 

The application simply connects to a database and prints the full name of the member whose id is passed as argument in the command line to the user, if the member exists. 
Otherwise, it prints an unsuccessful message.

## To run the tests
`./gradlew test`

## To run the application from project root
Pass any number representing a memberId as argument to the command line terminal below:
```$xslt
gradle install
./build/install/OptionalTest/bin/OptionalTest <arg>

```