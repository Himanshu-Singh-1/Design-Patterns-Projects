
-----------------------------------------------------------------------
PROJECT DESCRIPTION:
In this project we need to create objects of two kids types of classes: first & second and then Serialize them again into XML file using java reflection. Correctness of code is checked by comparing the input XML and created output XML file. Java reflections is used to read the values of all object from input XML file.
-----------------------------------------------------------------------

## INPUT:
input.txt has the internal values of objects of each of the 2 classes First and Second. The internal values of each object is written dwon in this file in a specific format, the type of value os also given.
-----------------------------------------------------------------------

##OUTPUT:
output.txt the objects populated from input.txt are serialized in the same format written to file output.txt. The correctness of program can be tested by comparing the input.txt and output.txt file.
-----------------------------------------------------------------------

## DATA STRUCTURES AND SPECIAL FUNCTIONALITITES:
ArrayList is used for both first and second objects. As threading is not required. Also hash code for populated objects is not required so hashtable is not used.
-----------------------------------------------------------------------

Assuming you are in the directory containing this README:

## TO CLEAN:
ant -buildfile src/build.xml clean
-----------------------------------------------------------------------

## TO COMPILE: 
ant -buildfile src/build.xml all
-----------------------------------------------------------------------

## TO RUN BY SPECIFYING ARGUMENTS FROM COMMAND LINE: 
ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=output.txt -Darg2=2
-----------------------------------------------------------------------



 




