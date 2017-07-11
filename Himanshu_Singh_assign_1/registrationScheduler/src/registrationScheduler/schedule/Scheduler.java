package registrationScheduler.schedule;

import java.util.HashMap;
import java.util.TreeMap;

import registrationScheduler.store.Results;
import registrationScheduler.util.Logger;
/**
 * 
 * @author Himanshu Singh
 *
 */
public class Scheduler {
	private Results finalresult;
	private TreeMap<Integer, Students> regtimerecords = new TreeMap<Integer, Students>();
	private HashMap<String,Students> coursepreference=new HashMap<String,Students>();  
	public Scheduler(Results resultobj) {
		finalresult = resultobj;
		Logger.writeMessage("In Scheduler constructor", Logger.DebugLevel.CONSTRUCTOR);
	}
/**
 * sets the courses for each student according to the preference from preference file
 * @param line String line read from preferences input file 
 */
	public void schedulefillcourses(String line) {
		int i=1;
		Students newstudent = new Students();
		String[] array = line.split(" ");
		newstudent.name = array[0];
		while(i<array.length)
		{
		newstudent.preferences.add(array[i]);
		coursepreference.put(newstudent.name, newstudent);
		i++;
		}
	}
	
	public void schedulefilltime(String line) {
		
		Students newstudent = new Students();
		String[] array = line.split(" ");
		newstudent.name = array[0];
		newstudent.time = Integer.parseInt(array[1]);
		this.regtimerecords.put(newstudent.time,newstudent);
		
	}
	
	public void schedulemain()
	{
		StudentRecords.getInstance().setcourses();
		for(Integer treekey: regtimerecords.keySet())
		{
			Students map_student;
			map_student = coursepreference.get(regtimerecords.get(treekey).name);
				StudentRecords.getInstance().getFResources1(map_student);
		finalresult.insertData(map_student.name, map_student);
		}
	}
	
	public void schedule(String line)
	{
		int i=1;
		Students newstudent = new Students();
		String[] array = line.split(" ");
		newstudent.name = array[0];
		while(i<array.length)
		{
		newstudent.preferences.add(array[i]);
		i++;
		}
		i=1;
		while(i<array.length){
				newstudent.courses.add(array[i]);
				StudentRecords.getInstance().setcourses(array[i]);
				newstudent.preference(6-i+1);			
			}
			i++;
		
		finalresult.insertData(newstudent.name, newstudent);
	}
	
}
