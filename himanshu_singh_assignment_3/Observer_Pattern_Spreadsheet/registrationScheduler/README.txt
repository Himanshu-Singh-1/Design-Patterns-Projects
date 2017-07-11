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

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.â€

[Date: ] -- 4/17/2017

-----------------------------------------------------------------------

Array of cells is used to for 2d array of cells in spreadhsheet. Since the
size of spreadsheet is 26*26 known and arraylist adds more elements for future use
hence using array is space efficient.

ArrayList is used in cells class to store the list of listeners subscribed to this cell.
The number of listeners added to list changes with the lines of input read, hence an arrayList is used as the size
of listener lists is not known. Hashtable is not used as in all functions that access this dependents arraylist 
access all the elements not any specific one, hence it is better to use array list not hashtable as no logical index 
values can be used.

Checkcylces logic checks if cycle is bieng formed by looking into the dependents list of the cells to which we are subscribing the current cell.

-----------------------------------------------------------------------

Provide list of citations (urls, etc.) from where you have taken code
(if any).



