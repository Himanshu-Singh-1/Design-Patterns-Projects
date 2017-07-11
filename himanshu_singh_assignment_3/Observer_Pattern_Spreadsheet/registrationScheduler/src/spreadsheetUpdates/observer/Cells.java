package spreadsheetUpdates.observer;

import java.util.*;

import spreadsheetUpdates.util.FileProcessor;
import spreadsheetUpdates.util.Logger;
import spreadsheetUpdates.observer.Spreadsheet;;
/**
 * 
 * @author Himanshu Singh
 *  Cells of spreadsheet implements both Listener and Subject each cell is lietnere to some other cell observed by some other cell
 */
public class Cells implements Listener,Subject{
	private int value,rowno,columnno;
	//public FileProcessor FileProcessor_output;
	public ArrayList<Listener> dependents = new ArrayList<Listener>();
	public String[] rhs;
	public Cells(int i, int j) {
		Logger.writeMessage("In cells constructor", Logger.DebugLevel.CONSTRUCTOR);
		value =0;
		rowno =i;
		columnno = j;
	}
	/*
	public Cells(int i, int j, FileProcessor fileProcessor_output2) {
		// TODO Auto-generated constructor stub
		Logger.writeMessage("In cells constructor", Logger.DebugLevel.CONSTRUCTOR);
		value =0;
		rowno =i;
		columnno = j;
		FileProcessor_output = fileProcessor_output2;
	}
	*/
	@Override
	public void registerListener(Listener o) {
		Logger.writeMessage("In cells register listener", Logger.DebugLevel.IN_RUN);
		dependents.add(o);
		
	}
	@Override
	public void removeListener(Listener o) {
		Logger.writeMessage("In cells remove listener", Logger.DebugLevel.IN_RUN);
		dependents.remove(o);
	}
	@Override
	public void notifyListener() {
		Logger.writeMessage("In cells notify listener", Logger.DebugLevel.IN_RUN);
		for(Listener l:dependents)
		{
			l.update();
		}
	}
	@Override
	public void update() {
		Logger.writeMessage("In cells update", Logger.DebugLevel.IN_RUN);
		calculate();
		notifyListener();
	}
	
	/**
	 * value of cell is set 
	 * @param val input value
	 */
	public void setValue(int val)
	{
		value = val;
	}
	/**
	 * getting the cell value 
	 * @return
	 */
	public int getValue()
	{
		return value;
	}
	
	/**
	 * checks if cycle is created from current line of input
	 * @param c current cell 
	 * @return 1 if cycle present, 0  if no cycle 
	 */
	public int checkcycle(Cells c)
	{
		Logger.writeMessage("In cells check for cycle", Logger.DebugLevel.IN_RUN);
		for(Listener l: dependents)
		{
			Cells tmp = (Cells)l;
			if(l.equals(c))
			{
				//FileProcessor_output.writeLineToFile("Cycle detected" + c.rowno + c.columnno +"in" + tmp.rowno +tmp.columnno +"\n");
				//System.out.println("Cycle detected" + c.rowno + c.columnno +"in" + tmp.rowno +tmp.columnno);
				return 1;
			}
			if(tmp.checkcycle(c)==1)
			{
			return 1;
			}
			else
				return 0;
		}
		return 0;
	}
	
	/**
	 * Based on the rhs of line read calculate the cells value using the rhs as a formula
	 */
	void calculate()
	{
		Logger.writeMessage("In cells calculate value", Logger.DebugLevel.IN_RUN);
		if(Getrhs(rhs)==1)   //not alphanumeric
		    setValue(Integer.parseInt(rhs[0]) + Integer.parseInt(rhs[1]));
		    else
		    	makecellchanges(rhs);
		
	}
	
	/**
	 * 
	 * @param cell current cell read from line, cell on lhs of line
	 * @param rhs process the values on rhs of line registers new listeners, updates cell values, notifys all listeners
	 */
	public void makecellchanges(String[] rhs)
	{
		Logger.writeMessage("In cells amekchanges for alphanumeric", Logger.DebugLevel.IN_RUN);
		if((alphanumeric(rhs[0]) ==0)&& (alphanumeric(rhs[1])==1))
		{
			//cell.setValue(Integer.parseInt(rhs[0]));
			int row,column;
		    row = (int)rhs[1].charAt(0)-97;
		    column  = Integer.parseInt(rhs[1].substring(1,rhs[1].length()))-1;
		    if(checkcycle(Spreadsheet.spreadsheet[row][column])==1)
		    	return;
			//spreadsheet[row][column].registerListener(cell);
			setValue(Integer.parseInt(rhs[0])+Spreadsheet.spreadsheet[row][column].getValue());
		}
		else if(alphanumeric(rhs[1]) ==0 && alphanumeric(rhs[0])==1)
		{
			//cell.setValue(Integer.parseInt(rhs[1]));
			int row,column;
		    row = (int)rhs[0].charAt(0)-97;
		    column  = Integer.parseInt(rhs[0].substring(1,rhs[0].length()))-1;
		    if(checkcycle(Spreadsheet.spreadsheet[row][column]) ==1)
		    	return;
		    //Spreadsheet.spreadsheet[row][column].registerListener(cell);
			setValue(Integer.parseInt(rhs[1])+Spreadsheet.spreadsheet[row][column].getValue());
		}
		else
		{
			int row,column,val=0;
		    row = (int)rhs[0].charAt(0)-97;
		    //column = (int)rhs[0].charAt(1);
		    column  = Integer.parseInt(rhs[0].substring(1,rhs[0].length())) -1;
		    if(checkcycle(Spreadsheet.spreadsheet[row][column]) ==1)
		    	return;
			//spreadsheet[row][column].registerListener(cell);
			val = Spreadsheet.spreadsheet[row][column].getValue();
			row = (int)rhs[1].charAt(0)-97;
			column  = Integer.parseInt(rhs[1].substring(1,rhs[1].length())) -1;
			if(checkcycle(Spreadsheet.spreadsheet[row][column]) ==1)
		    	return;
			//spreadsheet[row][column].registerListener(cell);
			setValue(Spreadsheet.spreadsheet[row][column].getValue() + val);
		}
	}
	
	/**
	 * 
	 * @param rhs second part of input line after "=" it is a string array with 2 elements
	 * @return 1 if rhs in alphanumeric, 0 is it is not 
	 */
	private int Getrhs(String[] rhs)
	{
		Logger.writeMessage("In cells get rhs", Logger.DebugLevel.IN_RUN);
		if(alphanumeric(rhs[0])==0&&alphanumeric(rhs[1])==0)
			return 1;
		else
			return 0;
	}
	
	/**
	 * 
	 * @param str  any string
	 * @return 1 if alphanumeric, 0 if not 
	 */
	private int alphanumeric(String str)
	{
		Logger.writeMessage("In cells alphanumeric", Logger.DebugLevel.IN_RUN);
		for(int i=0; i<str.length();i++)
		{
			int c = (int)str.charAt(i);
			if(c>=97&&c<=122)
				return 1;
		}
	return 0;
	}
		
}
