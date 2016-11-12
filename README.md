==============
Toy Robot Tool
==============

Description
-----------

This Toy Robot Tool is a simulation on how to control a toy robot inside a 5x5 surface. You can run the program by directly executing the main RobotTool class inside IntelliJ or Eclipse, or building a jar file and executing the output jar.  
To build the jar, clone the git repository and run the following inside the project folder.  
```sh
mvn package
```
To run the tests manually.
```sh
mvn test
```
Afterwards, execute the following command to start the program.
```sh
java -jar target/toy-robot-1.0-SNAPSHOT.jar
```
You must have [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) installed to run the tool, [Git](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git) to clone the repository, and [Maven](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html) to build the project.

Example input and corresponding results
---------------------------------------

### Example a

PLACE 5,5,EAST
REPORT

Expected output:

    Robot is not yet placed.

### Example b

MOVE
LEFT
RIGHT
MOVE
REPORT

Expected output:

    Robot is not yet placed.

### Example c

PLACE 3,3,NORTH
RIGHT
MOVE
LEFT
MOVE
REPORT

Expected output

    4,4,NORTH
	
### Example d

PLACE 1,2,EAST
MOVE
PLACE 4,2,WEST
REPORT

Expected output

    4,2,WEST	


