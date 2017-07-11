
package registrationScheduler.threadMgmt;

import registrationScheduler.store.Results;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Logger;

public class CreateWorkers  {
	private FileProcessor fileProc_preference;
	private FileProcessor fileProc_addrop;
	private Results result;
	
/**
 * Constructor for CreateWorkers 
 * @param fileProcessor_preference object of Fileprocessor to process preference file 
 * @param fileProcessor_addrop object of Fileprocessor to process add drop file
 * @param resultobj object of Results to store results in data structure
 */
	public CreateWorkers(FileProcessor fileProcessor_preference, FileProcessor fileProcessor_addrop,
			Results resultobj) {
		fileProc_preference = fileProcessor_preference;
		fileProc_addrop = fileProcessor_addrop;
		result = resultobj;
		Logger.writeMessage("In CreateWorkers constructor", Logger.DebugLevel.CONSTRUCTOR);
	}
	
/**
 *  Function to create given number of threads
 * @param noOfThreads value taken from command line and passed to local variable noOfThreads
 */
	public void startWorkers(int noOfThreads){

		Thread[] threadarray = new Thread[noOfThreads];
		
		for(int i=0;i<noOfThreads;i++)
		{
			WorkerThread workerthread = new WorkerThread(fileProc_preference,fileProc_addrop,result);
			if(i == 0)
				threadarray[i] = new Thread(workerthread);
			else 
				threadarray[i] = new Thread();
			threadarray[i].start();
		}
		
		 for(int j=0;j<noOfThreads;++j){
		     try {
		    	 threadarray[j].join();
	      } catch (InterruptedException e) {
		 	e.printStackTrace();
		 	System.exit(1);
		     }
		 }


	}

	public void startWorkers() {
		WorkerThread workerthread = new WorkerThread(fileProc_preference,fileProc_addrop,result);
		workerthread.run();
	}
}
