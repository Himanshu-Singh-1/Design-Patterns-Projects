
package registrationScheduler.driver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.IllegalArgumentException;

import registrationScheduler.schedule.StartScheduler;
import registrationScheduler.store.Results;

import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Logger;

/**
 * @author Himanshu Singh
 *
 */
public class Driver {

	private static Integer debuglevel = new Integer(0);
	public static FileProcessor FileProcessor_regtime;
	public static FileProcessor FileProcessor_preference;
	public static FileProcessor FileProcesor_outputfile;

	/**
	 * @param args command line arguments
	 */
	public static void main(String args[]) {
		Driver dr = new Driver();
		dr.validateArgs(args);
		Logger.setDebugValue(debuglevel);
		System.out.println("\n Geting Started\n");
		Results resultobj = new Results(FileProcesor_outputfile);
		StartScheduler start_work = new StartScheduler(FileProcessor_regtime,FileProcessor_preference,resultobj);
		start_work.run();
		
	} 
	
	
	/**
	 * validates the command line arguments
	 * @param args command line arguments
	 */
	private void validateArgs(String args[]) {
		if (args.length == 4) {
			String str;
			str = args[0];
			File preference = new File(str);
			str = args[1];
			File add_drop = new File(str);
			String outputfile = args[2];
			FileProcesor_outputfile = new FileProcessor(outputfile);
			try {
				BufferedReader brpref = new BufferedReader(new FileReader(preference));
				FileProcessor_regtime = new FileProcessor(brpref);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				BufferedReader br_addrop = new BufferedReader(new FileReader(add_drop));
				FileProcessor_preference = new FileProcessor(br_addrop);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			try {
				//Driver.NUM_THREADS = Integer.parseInt(args[3]);
				Driver.debuglevel = Integer.parseInt(args[3]);
				if (debuglevel > 4 || debuglevel < 0)
					System.err.println("Debuglevel out of bounds");
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
