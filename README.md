# Design Patterns

1) Project 1

Goal: 
Assign courses to students according to their preference from a pool of 8 courses each of which has 20 seats. Courses were assigned in preference of registration time. Hence two text files are used as input reg-time.txt and preferences .txt.


2) Project 2

Goal:
Assign courses to students according to their course add drop history from a pool of 8 courses each of which has 20 seats. Two text files are used as input. The courses are reshuffled according to second input file add-drop.txt this file has all the drop and add commands given by students after they gave thier preferences. The final course assignment to students is done by giving the courses to students according to the preference and then processing the add-drop file to accomodate all course changes.

Special Functionalities Implemented:
Multi threading is used to process long registration input times parallelly. The project was implemented using OBJECT POOL PATTERN. Threads assign courses parallely from the pool of courses.

3) Project 3

Goal:
implement a 26*26 cells of spreadhseet cell numbers are alphanumeric eg A1,Z26. An input file is provided containing all the changes to made to cells. Each line in input file every cell is assigned a value as absolute numeric or sum of integer plus another cells value or as sum of multiple cell values. The project process each of the input line sequentially and ignores the lines if they create a cycle. The output is the value of all cells after the manipulations in input file are all executed. 

Special Functionalities Implemented:
The project required us to demonstrate and use Observer Pattern. Each cell is observer as well as subject.

4) Project 4

Goal:
Deserialization of objects from xml file using Java reflection and strategy pattern. The input file contains values of thousands of objects. Each of these objects can belong to any of the two classes : First and Second. The program reads this input file and creates all the objects specified in the input file.

Special Functionalities Implemented:
Strategy Pattern Java Reflections  

5) Project 5

Goal:
In this project we need to create objects of two kids types of classes: first & second and then Serialize them again into XML file using java reflection. Correctness of code is checked by comparing the input XML and created output XML file. Java reflections is used to read the values of all object from input XML file.

Special Functionalities Implemented:
Strategy Pattern Java Reflections.
