
package registrationScheduler.threadMgmt;

import registrationScheduler.schedule.Scheduler;
import registrationScheduler.store.Results;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Logger;

public class WorkerThread implements Runnable  {
	private FileProcessor fileProcPreference;
	private FileProcessor fileProc_addrop;
	private Results result;
	private Scheduler scheduler;

/**
 * constructor for worker thread sets all data members
 * @param fileProc_preferenceobj of type FileProcessor
 * @param fileProc_addropobj of type FileProcessor
 * @param resultobj of type Results 
 */
    
    public WorkerThread(FileProcessor fileProc_preferenceobj, FileProcessor fileProc_addropobj, Results resultobj) {
    	fileProcPreference = fileProc_preferenceobj;
    	fileProc_addrop = fileProc_addropobj;
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
		Logger.writeMessage("In worerthread run method", Logger.DebugLevel.IN_RUN);
		String line = fileProcPreference.readLineFromFile();;
		while(line!=null)
		{
			scheduler.schedule(line);
			line = fileProcPreference.readLineFromFile();	
		}
		//result.writeScheduleToStdout();
		line = fileProc_addrop.readLineFromFile();
		while(line!=null){
			scheduler.schedule_addrop(line);
			line = fileProc_addrop.readLineFromFile();
		}
		//System.out.println("\n*******************\n");
		result.writeScheduleToStdout();
		result.writeSchedulesToFile();	
    }
    

}
