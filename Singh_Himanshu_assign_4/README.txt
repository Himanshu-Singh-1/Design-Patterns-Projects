-----------------------------------------------------------------------

## PROJECT DESCRIPTION:
Deserialization of objects from xml file using Java reflection and strategy pattern. The input file contains values of thousands of objects. Each of these objects can belong to any of the two classes : First and Second. The program reads this input file and creates all the objects specified in the input file.
-----------------------------------------------------------------------

## INPUT:
input.txt has the internal values of objects of each of the 2 classes First and Second. The internal values of each object is written dwon in this file in a specific format, the type of value os also given.
-----------------------------------------------------------------------

##OUTPUT:
output.txt the objects populated from input.txt are serialized in the same format written to file output.txt. The correctness of program can be tested by comparing the input.txt and output.txt file.
-----------------------------------------------------------------------

## DATA STRUCTRES USED AND SPECIAL FUNCTIONALITY:
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



