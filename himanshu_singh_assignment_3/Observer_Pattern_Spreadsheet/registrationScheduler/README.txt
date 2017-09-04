-----------------------------------------------------------------------

## PROJECT DESCIPTION:
The project required us to implement a 26*26 cells of spreadhseet cell numbers are alphanumeric eg A1,Z26. An input file is provided containing formulas for manipulation of cell. 
Each line in input file every cell is assigned a value as absolute numeric or sum of integer plus another cells value or as sum of multiple cell values. The project process each of the input line sequentially and ignores the lines if they create a cycle. The output is the value of all cells after the manipulations in input file are all executed. 
The project required us to demonstrate and use Observer Pattern. Each cell is observer as well as subject.
-----------------------------------------------------------------------

## INPUT:
input.txt contains all the expressions for cell manipulations e.g a11 = b21 +100, g21 = b18 + c17. The expressions result in the final value of the cells after the entire input file has been processes and changes made to the cells of spreadsheet. 
-----------------------------------------------------------------------

## OUTPUT:
The spreadsheet is printed to console as a 26*26 grid with final values of all the cells. an output file output.txt is also generated with the same content. 
-----------------------------------------------------------------------

## DATA STRUCTURES AND SPECIAL FUNCTIONALITITES:
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

## TO CREATE TARBALL FOR SUBMISSION:
ant -buildfile src/build.xml tarzip
-----------------------------------------------------------------------




