package registrationScheduler.schedule;

import registrationScheduler.objectPool.ObjectPool;
import registrationScheduler.store.Results;
import registrationScheduler.util.Logger;
/**
 * 
 * @author Himanshu Singh
 *
 */
public class Scheduler {
	private Results threadresult;
	public Scheduler(Results resultobj) {
		threadresult = resultobj;
		Logger.writeMessage("In Scheduler constructor", Logger.DebugLevel.CONSTRUCTOR);
	}
/**
 * sets the courses for each student according to the preference from preference file
 * @param line String line read from preferences input file 
 */
	public void schedule(String line) {
		int i=1;
		Students newstudent = new Students();
		String[] array = line.split(" ");
		newstudent.name = array[0];
		while(i<array.length)
		{
		newstudent.preferences.add(array[i]);
		i++;
		}
		String newcourse=null;
		i=1;
		while(i<array.length){
			if(ObjectPool.getInstance().getcourses(array[i])>0){
				newstudent.courses.add(array[i]);
				ObjectPool.getInstance().setcourses(array[i]);
				newstudent.preference(6-i+1);
			}
			else{
				newcourse = ObjectPool.getInstance().getFResources(newstudent);
				if(newcourse!=null){
					newstudent.courses.add(newcourse);
					ObjectPool.getInstance().setcourses(newcourse);
					newstudent.preference(1);
				}
			}
			i++;
		}
		//ObjectPool.getInstance().studentlist.put(newstudent.name, newstudent);
		threadresult.insertData(newstudent.name, newstudent);
	}
	
/**
 * changes the courses of each student according to the add drop choice
 * @param line string type line read from the add drop file 
 */
	public void schedule_addrop(String line) {
		int i=1;
		String[] array = line.split(" ");
		//Students newstudent =  ObjectPool.getInstance().studentlist.get(array[0]);
		Students newstudent = threadresult.getData(array[0]);
		if(array[1].equals("0")){
			i=2;
			while(i<array.length){
				if(newstudent.courses.contains(array[i])){
					if(newstudent.preferences.contains(array[i]))
					newstudent.preference(-6+newstudent.preferences.indexOf(array[i])); //Subtract preference score corresponding to course dopped and add 1 for new added course
					else
						newstudent.preference(-1);
					newstudent.courses.remove(array[i]);
					ObjectPool.getInstance().setcourses(array[i]);
				}
				i++;
			}
		}
		else if(array[1].equals("1")){
			i=2;
			while(i<array.length){
				if(!newstudent.courses.contains(array[i])&& ObjectPool.getInstance().getcourses(array[i])>0){
					newstudent.courses.add(array[i]);
					newstudent.preference(1);   // increment preference by 1 for new added course 
					ObjectPool.getInstance().setcourses(array[i]);
				}
				i++;
			}	
		}
		String coursestmp = null;
		for(String course: newstudent.courses){
			coursestmp = coursestmp + " "+ course;
		}
		Logger.writeMessage(""+ newstudent.name+"  " + coursestmp +"  "+ newstudent.preference , Logger.DebugLevel.FROM_RESULTS);
	}
}
