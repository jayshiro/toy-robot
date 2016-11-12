==============
Toy Robot Tool
==============

Description
-----------

- This Toy Robot Tool is a simulation on how to control a toy robot inside a 5x5 surface. You can run the program by directly executing the main RobotTool class inside IntelliJ or Eclipse, or building a jar file and executing the output jar. To build the jar, clone the git repository and run "mvn package" inside the project folder. Afterwards, execute "java -jar target/toy-robot-1.0-SNAPSHOT.jar". You must have Java 8 installed to run the tool, Git to clone the repository, and Maven to build the project.

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


