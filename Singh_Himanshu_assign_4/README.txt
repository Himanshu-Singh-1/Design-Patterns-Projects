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

Deserialization of objects from xml file using Java reflection and strategy pattern.


