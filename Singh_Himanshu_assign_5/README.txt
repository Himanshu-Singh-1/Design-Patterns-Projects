Assuming you are in the directory containing this README:

## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code
ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=output.txt -Darg2=2

-----------------------------------------------------------------------

## To create tarball for submission
ant -buildfile src/build.xml tarzip

-----------------------------------------------------------------------

ArrayList is used for both first and second objects. As threading is not required. Also hash code for populated objects is not required so hashtable is not used.
-----------------------------------------------------------------------

Project Description:
In this project we need to create objects of two kids types of classes: first & second and then Serialize them again into XML file using java reflection. Correctness of code is checked by comparing 
the input XML and created output XML file. Java reflections is used to read the values of all object from input XML file. 




