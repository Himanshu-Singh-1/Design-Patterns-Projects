

#Compilation
From the folder: himanshu_singh_assignment2\registrationScheduler\src

ant all
ant prepare

TO RUN:
From the folder: john_doe\registrationScheduler\src

ant run -Darg0=<reg-preference-file-name> -Darg0=<add-drop-file-name> -Darg1=<outputfilename> -Darg2=<number-of-threads> -Darg3=<logger level>

Example:
ant run -Darg0=reg-input.txt -Darg1=add-drop.txt -Darg2=output.txt -Darg3=2 -Darg4=0

The files are read/written from/to here:
	himanshu_singh_assignment2/registrationScheduler/reg-input.txt
	himanshu_singh_assignment2/registrationScheduler/add-drop.txt
	himanshu_singh_assignment2/registrationScheduler/output.txt
will run 2 threads
will use Logger for debug level 0

CHOICE OF DATA STRUCTURE:
1. Hashtable to store courses in object pool. Key is the course name and value is the number of seats available. 
Hashtable is thread safe and has constant lookup time. 
2. LinkedHashmap to store students (object of Students class) in the Results class key is the student name and contains the student object.
this was used as students are required to be in sorted order, (Hashtable does not guarantee sorted order) so that while printing to output file
the students appear in order serially. Time complexity is O(1) same as Hashtable.
Citations:
1.
2.

