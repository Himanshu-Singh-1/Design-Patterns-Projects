package registrationScheduler.store;

import registrationScheduler.util.StdoutDisplayInterface;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import registrationScheduler.schedule.Students;
import registrationScheduler.util.FileDisplayInterface;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Logger;

public class Results implements StdoutDisplayInterface, FileDisplayInterface {
	 private FileProcessor output;
	 private LinkedHashMap<String,Students> data = new LinkedHashMap<String,Students>(); //= ObjectPool.getInstance().studentlist;
    
    /**
     * constructor for Results with output file given 
     * @param fileProcesor_outputfile of type FileProcessor 
     */
	public Results(FileProcessor fileProcesor_outputfile) {
		output = fileProcesor_outputfile;
		Logger.writeMessage("In result constructor", Logger.DebugLevel.CONSTRUCTOR);
	}

	/**
	 * writes the courses of students and preference score and average preference score to console
	 */
	public void writeScheduleToStdout() {
		Set<String> set = data.keySet();
		String str = null;
		Iterator<String> itr = set.iterator();
		while(itr.hasNext()){
			str = itr.next();
			Students printstudent = data.get(str);
			System.out.println(printstudent.name + " "+ printstudent.courses +"   "+ printstudent.preference + "\n");
		}
		int average = averageScore();
		String avg = "Average Preference Score is: " + average;
		System.out.println(avg);
		Logger.writeMessage(avg, Logger.DebugLevel.RELEASE);
    }
	
    /**
     * writes the courses of students and preference score and average preference score to output file
     */
    @Override
    public void writeSchedulesToFile(){
    	String text;
    	//Set<String> set = ObjectPool.getInstance().studentlist.keySet();
    	Set<String> set = data.keySet();
		String str = null;
		Iterator<String> itr = set.iterator();
		while(itr.hasNext()){
			str = itr.next();
			Students printstudent = data.get(str);
			text = printstudent.name +" "+ printstudent.courses+" " + printstudent.preference+ "\n";
			output.writeLineToFile(text);
			Logger.writeMessage(text, Logger.DebugLevel.IN_RESULTS);
		}
		int average = averageScore();
		String avg = "Average Preference Score is: " + average;
		
		output.writeLineToFile(avg);
		output.closefile();
    }
    
    /**
     * Inserts newly created student to data (private data strcuture for list of students) in results
     * @param key of type string the student name 
     * @param newstudent of type Students
     */
    public void insertData(String key,Students newstudent){
    	data.put(key, newstudent);    	
    }
    
    /**
     * returns the student from data corresponding to the string key
     * @param string of type string is the name of student 
     * @return of type Students
     */

	public Students getData(String string) {
		return(data.get(string));
	}
	
	/**
	 * computes and returns the average preference score for all students
	 * @return of type int
	 */
	public int averageScore(){
		Set<String> set = data.keySet();
		String str = null;
		int avg=0;
		Iterator<String> itr = set.iterator();
		while(itr.hasNext()){
			str = itr.next();
			Students printstudent = data.get(str);
			avg = avg+ printstudent.preference;
		}
		avg = avg/data.size();
		return(avg);
	}
}
