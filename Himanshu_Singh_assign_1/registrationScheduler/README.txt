
Assuming you are in the directory containing this README:

## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
ant -buildfile src/build.xml run -Darg0=firstarg -Darg1=SECOND -Darg2=THIRD

-----------------------------------------------------------------------

## To create tarball for submission
ant -buildfile src/build.xml tarzip

-----------------------------------------------------------------------

##DESCRIPTION:
This project required us to assign courses to students according to their preference from a pool of 8 courses each of which has 20 seats. Courses were 
assigned in preference of registration time. Hence two text files are used as 

##INPUT:
1. preference_input: has the course preference for each student.
2. regtime_input: has the time of registration request for each student.



