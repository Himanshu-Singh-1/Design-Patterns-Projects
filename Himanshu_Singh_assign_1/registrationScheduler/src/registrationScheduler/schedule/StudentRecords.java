package registrationScheduler.schedule;

import java.util.Hashtable;
import java.util.Set;
import registrationScheduler.schedule.Students;
import java.util.Iterator;


/**
 * @author Himanshu Singh
 *
 */
public class StudentRecords {
	private static StudentRecords instance = null;
	private Hashtable<String, Integer> courses = new Hashtable<String, Integer>();
	//public LinkedHashMap<String, Students> studentlist = new LinkedHashMap<String, Students>();

	protected StudentRecords() {
	}

	/**
	 * Singleton Class
	 * @return returns a single instance of the objectpool class
	 */
	public static StudentRecords getInstance() {
		if (instance == null) {
			instance = new StudentRecords();
			instance.setcourses();
		}
		return instance;
	}
	
	/**
	 * sets the no of seats for each course to max initially.
	 */
	public void setcourses() {
		courses.put("A", 20);
		courses.put("B", 20);
		courses.put("C", 20);
		courses.put("D", 20);
		courses.put("E", 20);
		courses.put("F", 20);
		courses.put("G", 20);
		courses.put("H", 20);
	}

	/**
	 * returns the number of seats available for key course
	 * @param key string to get course by name of key
	 * @return returns the number of available seats for the key course
	 */
	public int getcourses(String key) {
		return (courses.get(key));
	}

	/**decrements the seats for the given coursename by one every time it is allocated
	 * @param coursename of type string used as key to get seats from courses list
	 */
	public void setcourses(String coursename) {
		courses.put(coursename, courses.get(coursename) - 1);
	}
	/**
	 * returns the next available course with maximum seats available 
	 * @param newstudent  object of class Students
	 * @return type string the next available course with maximum seats
	 */
	public void getFResources1(Students newstudent) {
		int i = newstudent.preferences.size();
		String ret = "";
		i--;
		while(i>=0)
		{
			if(courses.get(newstudent.preferences.get(i))>0)
			{
				newstudent.courses.add(newstudent.preferences.get(i));
				newstudent.preference = (6-i);
				ret = newstudent.preferences.get(i);
				courses.put(ret, courses.get(ret) - 1);
			}
			i--;
		}
	
			while(newstudent.courses.size()<4)
			{
			String str = getnextfree();
			newstudent.courses.add(str);
		}
		
	}
	
	public String getnextfree()
	{
		String ret = new String();
		Set<String> set = courses.keySet();
		String str = null;
		int max = 0;
		Iterator<String> itr = set.iterator();
		while (itr.hasNext()) {
			str = itr.next();
			if (courses.get(str) > max)
			{
				ret = str;
				max = courses.get(str);
			}
		}
		if(max>0)
		courses.put(ret, courses.get(ret) - 1);
		else 
			ret = "";
		return ret;
	}

}
