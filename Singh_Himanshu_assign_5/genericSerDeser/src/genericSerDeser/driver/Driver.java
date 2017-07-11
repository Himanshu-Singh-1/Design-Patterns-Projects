
package genericSerDeser.driver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.IllegalArgumentException;

import genericSerDeser.util.DPML;
import genericSerDeser.util.FileProcessor;
import genericSerDeser.util.Logger;
import genericSerDeser.util.PopulateObjects;
import genericSerDeser.strategy.SerStrategy;

/**
 * @author Himanshu Singh
 * 
 */
public class Driver {

	//private static Integer NUM_THREADS = new Integer(0);
	private static Integer debuglevel = new Integer(0);
	public static FileProcessor FileProcessor_input;
	public static FileProcessor FileProcessor_addrop;
	public static FileProcessor FileProcessor_outputfile;

	/**
	 * @param args command line arguments
	 */
	public static void main(String args[]) {
		Driver dr = new Driver();
		dr.validateArgs(args);
		Logger.setDebugValue(debuglevel);
		//System.out.println("\n Geting Started\n");
		PopulateObjects populate = new PopulateObjects(FileProcessor_input, FileProcessor_outputfile);
		populate.start();
		SerStrategy serializing = new DPML(FileProcessor_outputfile);
		for(Object obj: populate.list_objects)
		{
			serializing.serialize(obj);
		}
		FileProcessor_outputfile.closefile();
		//spreadsheet.print_all();
		//spreadsheet.print();
		//FileProcessor_outputfile.closefile();
	} 
	
	
	/**
	 * validates the command line arguments
	 * @param args command line arguments
	 */
	private void validateArgs(String args[]) {
		if (args.length == 3) {
			String str;
			str = args[0];
			String newstr = args[1];
			File input = new File(str);
			FileProcessor_outputfile = new FileProcessor(newstr);
			try {
				BufferedReader brpref = new BufferedReader(new FileReader(input));
				FileProcessor_input = new FileProcessor(brpref);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			try {
				Driver.debuglevel = Integer.parseInt(args[2]);
				if (debuglevel > 4 || debuglevel < 0)
					System.err.println("Debuglevel and out of bounds");
			} catch (IllegalArgumentException ex) {
				System.err.println("NumberFormatException-Cannot parse to integer.");
				ex.printStackTrace();
				System.exit(1);
			}
			
		} else {
			System.err.println("Invalid number of arguments. Expected [FIXME: provide details here]");
			System.exit(1);
		}
	}

} 
