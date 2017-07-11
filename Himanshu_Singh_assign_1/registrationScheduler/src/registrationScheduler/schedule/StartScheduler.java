
package registrationScheduler.schedule;

import registrationScheduler.schedule.Scheduler;
import registrationScheduler.store.Results;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Logger;

public class StartScheduler {
	private FileProcessor fileProcRegTime;
	private FileProcessor fileProc_courses;
	private Results result;
	private Scheduler scheduler;

/**
 * constructor for worker thread sets all data members
 * @param fileProc_preferenceobj of type FileProcessor
 * @param fileProc_addropobj of type FileProcessor
 * @param resultobj of type Results 
 */
    
    public StartScheduler(FileProcessor fileProc_time, FileProcessor fileProc_preference, Results resultobj) {
    	fileProcRegTime = fileProc_time;
    	fileProc_courses = fileProc_preference;
    	result = resultobj;
    	scheduler = new Scheduler(resultobj);
    	Logger.writeMessage("In worker thread constructor", Logger.DebugLevel.CONSTRUCTOR);
	}

    /**
     * call scheduler for each line read from file, allocates resources based on preference file
     * then processes the add drop choices from add drop file.
     * outputs the result to console and writes to output file.
     */
	public void run() {
		int i=0;
		Logger.writeMessage("In worerthread run method", Logger.DebugLevel.IN_RUN);
		String line = fileProcRegTime.readLineFromFile();
		String line2 = fileProc_courses.readLineFromFile();
		while(line!=null)
		{
			scheduler.schedulefilltime(line);
			line = fileProcRegTime.readLineFromFile();
			i++;
		}
		i=0;
		while(line2!=null)
		{
			scheduler.schedulefillcourses(line2);
			line2 = fileProc_courses.readLineFromFile();
			i++;
		}
		System.out.println(i);
		scheduler.schedulemain();
		
		result.writeScheduleToStdout();
		result.writeSchedulesToFile();	
    }
	
}
