This project required us to assign courses to students according to their preference from a pool of 8 courses each of which has 20 seats. Courses were assigned
in preference of registration time. Hence two text files are used as input:
1. preference_input: has the course preference for each student.
2. regtime_input: has the time of registration request for each student.

Multi threading is used to process long registration input times parallelly. The project was implemented using OBJECT POOL PATTERN. Threads assign courses
parallely from the pool of courses.


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
	john_doe/registrationScheduler/reg-input.txt
	john_doe/registrationScheduler/add-drop.txt
	john_doe/registrationScheduler/output.txt
will run 2 threads
will use Logger for debug level 0




