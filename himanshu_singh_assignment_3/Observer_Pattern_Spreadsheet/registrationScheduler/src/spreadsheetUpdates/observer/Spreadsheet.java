package spreadsheetUpdates.observer;
import spreadsheetUpdates.observer.Cells;
import spreadsheetUpdates.util.FileProcessor;
import spreadsheetUpdates.util.Logger;

/**
 * 
 * @author Himanshu Singh
 * holds array of all 26*26 cells
 */
public class Spreadsheet {
	public static Cells[][] spreadsheet = new Cells[26][26];
	private FileProcessor FileProcessor_input;
	private FileProcessor FileProcessor_output;
	public Spreadsheet()
	{
		Logger.writeMessage("In spreadsheet constructor", Logger.DebugLevel.CONSTRUCTOR);
		int i=0,j=0;
	    for(i=0;i<26;i++)
		{
			for(j=0;j<26;j++)
			{
				spreadsheet[i][j] = new Cells(i,j);
			}
		}
	}
	/**
	 * constructor for spreadhseet 
	 * @param fileProcessor_preference
	 * @param fileProcessor_write
	 */

	public Spreadsheet(FileProcessor fileProcessor_preference, FileProcessor fileProcessor_write) {
		Logger.writeMessage("In spreadsheet constructor", Logger.DebugLevel.CONSTRUCTOR);
		int i=0,j=0;
		FileProcessor_input = fileProcessor_preference;
		FileProcessor_output = fileProcessor_write;
	    for(i=0;i<26;i++)
		{
			for(j=0;j<26;j++)
			{
				spreadsheet[i][j] = new Cells(i,j);
			}
		}
	}
	/**
	 * Reads the input file line by line and make changes to cells in current line
	 */
	public void Start()
	{
		Logger.writeMessage("In spreadsheet start", Logger.DebugLevel.IN_RUN);
		String line;
		String[] parts = new String[2];
		String[] parts2 = new String[2];
		while((line=FileProcessor_input.readLineFromFile())!=null)
		{
		    //System.out.println(line);
		    //char[] p = line.toCharArray();
			//DO ALL UPDATES HERE
		    
		    if(line.contains("="))
		    {
		    parts = line.split("=");
		    //System.out.println(parts[0]+"\n" + parts[1]);
		    if(parts[1].contains("+")){
		    	parts2 = parts[1].split("\\+");
		    }
		    else
		    	throw new IllegalArgumentException("String" +line + "does not contain +");
		    }
		    else
		    	throw new IllegalArgumentException("String" +line + "does not contain =");
		    	
		    int row,column;
		    row = (int)parts[0].charAt(0)-97;
		    //column = (int)parts[0].charAt(1)-48;
		    column  = Integer.parseInt(parts[0].substring(1,parts[0].length()))-1;
		    Cells new_cell = spreadsheet[row][column];
		    deregister(new_cell);
		    new_cell.rhs = parts2;
		    if(Getrhs(parts2)==1)   //not alphanumeric
		    new_cell.setValue(Integer.parseInt(parts2[0]) + Integer.parseInt(parts2[1]));
		    else
		    	makecellchanges(new_cell,parts2);
		    
		    //DO ALL UPDATES HERE
		    new_cell.notifyListener();
		    //this.print();
			//line = FileProcessor_input.readLineFromFile();
		}
	}
	
	/**
	 * 
	 * @param rhs second part of input line after "=" it is a string array with 2 elements
	 * @return 1 if rhs in alphanumeric, 0 is it is not 
	 */
	private int Getrhs(String[] rhs)
	{
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
		Logger.writeMessage("In spreadhseet alphanumreic", Logger.DebugLevel.IN_RUN);
		for(int i=0; i<str.length();i++)
		{
			int c = (int)str.charAt(i);
			if(c>=97&&c<=122)
				return 1;
		}
	return 0;
	}
	
	/**
	 * Deregisters the input cell from the listener list of all cells in spreadhseet as this cell is getting updated 
	 * @param c of type cell
	 */
	public void deregister(Cells c)
	{
		Logger.writeMessage("In spreadsheet de register cells", Logger.DebugLevel.IN_RUN);
		int i=0,j=0;
		for(i=0;i<26;i++)
		{
			for(j=0;j<26;j++)
			{
				spreadsheet[i][j].removeListener(c);
			}
		}
	}
	
	/**
	 * 
	 * @param cell current cell read from line, cell on lhs of line
	 * @param rhs process the values on rhs of line registers new listeners, updates cell values, notifys all listeners
	 */
	public void makecellchanges(Cells cell,String[] rhs)
	{
		Logger.writeMessage("In spreadhseet makechanges", Logger.DebugLevel.IN_RUN);
		if((alphanumeric(rhs[0]) ==0)&& (alphanumeric(rhs[1])==1))
		{
			//cell.setValue(Integer.parseInt(rhs[0]));
			int row,column;
		    row = (int)rhs[1].charAt(0)-97;
		    column  = Integer.parseInt(rhs[1].substring(1,rhs[1].length()))-1;
		    if(cell.checkcycle(spreadsheet[row][column])==1)
		    	return;
			spreadsheet[row][column].registerListener(cell);
			cell.setValue(Integer.parseInt(rhs[0])+spreadsheet[row][column].getValue());
		}
		else if(alphanumeric(rhs[1]) ==0 && alphanumeric(rhs[0])==1)
		{
			//cell.setValue(Integer.parseInt(rhs[1]));
			int row,column;
		    row = (int)rhs[0].charAt(0)-97;
		    column  = Integer.parseInt(rhs[0].substring(1,rhs[0].length()))-1;
		    if(cell.checkcycle(spreadsheet[row][column]) ==1)
		    	return;
			spreadsheet[row][column].registerListener(cell);
			cell.setValue(Integer.parseInt(rhs[1])+spreadsheet[row][column].getValue());
		}
		else
		{
			int row,column,val=0;
		    row = (int)rhs[0].charAt(0)-97;
		    //column = (int)rhs[0].charAt(1);
		    column  = Integer.parseInt(rhs[0].substring(1,rhs[0].length())) -1;
		    if(cell.checkcycle(spreadsheet[row][column]) ==1)
		    	return;
			spreadsheet[row][column].registerListener(cell);
			val = spreadsheet[row][column].getValue();
			row = (int)rhs[1].charAt(0)-97;
			column  = Integer.parseInt(rhs[1].substring(1,rhs[1].length())) -1;
			if(cell.checkcycle(spreadsheet[row][column]) ==1)
		    	return;
			spreadsheet[row][column].registerListener(cell);
			cell.setValue(spreadsheet[row][column].getValue() + val);
		}
	}
	
	/**
	 * Writes the sum of all cell values in outptut file
	 */
	public void print()
	{
		Logger.writeMessage("In spreadhseet print output ", Logger.DebugLevel.IN_RESULTS);
	 int i=0,j=0,value =0;
	 for(i=0;i<26;i++)
	 {
		 for(j=0;j<26;j++)
		 {
			 value =value+spreadsheet[i][j].getValue();
			 //System.out.println(spreadsheet[i][j].getValue()+"\n");
			 
		 }
	 }
	 //System.out.print("\n****"+value +"****\n");
	 FileProcessor_output.writeLineToFile("Sum of all cells:" + value + "\n");
	 FileProcessor_output.closefile();
	}
	
	/**
	 * Prints all the values of cell to screen 
	 */
	public void print_all()
	{
		int i=0,j=0;
		for(i=0;i<26;i++)
		{
			for(j=0;j<26;j++)
			{
				System.out.println(spreadsheet[i][j].getValue()+" ");
			}
			System.out.println("\n");
		}
	}
	
	
}
