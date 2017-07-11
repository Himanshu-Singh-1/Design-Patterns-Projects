package registrationScheduler.objectPool;

import java.util.Hashtable;
import java.util.Set;
import registrationScheduler.schedule.Students;
import java.util.Iterator;


/**
 * @author Himanshu Singh
 *
 */
public class ObjectPool {
	private static ObjectPool instance = null;
	private Hashtable<String, Integer> courses = new Hashtable<String, Integer>();
	//public LinkedHashMap<String, Students> studentlist = new LinkedHashMap<String, Students>();

	protected ObjectPool() {
	}

	/**
	 * Singleton Class
	 * @return returns a single instance of the objectpool class
	 */
	public synchronized static ObjectPool getInstance() {
		if (instance == null) {
			instance = new ObjectPool();
			instance.setcourses();
		}
		return instance;
	}
	
	/**
	 * sets the no of seats for each course to max initially.
	 */
	public void setcourses() {
		courses.put("A", 60);
		courses.put("B", 60);
		courses.put("C", 60);
		courses.put("D", 60);
		courses.put("E", 60);
		courses.put("F", 60);
		courses.put("G", 60);
		courses.put("H", 60);
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

	public String getFResources(Students newstudent) {
		Set<String> set = courses.keySet();
		String str, str1 = null;
		int max = 0;
		Iterator<String> itr = set.iterator();
		while (itr.hasNext()) {
			str = itr.next();
			if (courses.get(str) > max && !newstudent.preferences.contains(str) && !newstudent.courses.contains(str)) {
				max = courses.get(str);
				str1 = str;
			}
		}
		return (str1);
	}

}
