package registrationScheduler.schedule;

import java.util.ArrayList;
import java.util.List;

public class Students {
	public List<String> preferences = new ArrayList<String>();
	public List<String> courses = new ArrayList<String>();
	public String name = new String();
	public int preference =0;
	public int time;
	public Students() {
	}
	/**
	 * changes the preference value of student
	 * @param i integer
	 */
	public void preference(int i) {
		preference = preference+i;
	}
}
