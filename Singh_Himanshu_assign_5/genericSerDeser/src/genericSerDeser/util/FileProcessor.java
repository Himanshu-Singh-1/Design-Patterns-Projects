
package genericSerDeser.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.String;

/**
 * 
 * @author Himanshu Singh
 * helper class implements file writer and file reader functionality 
 */
public class FileProcessor {
	
    private BufferedReader in;
    private BufferedWriter out;
    private String outfilename;
    
    public FileProcessor(BufferedReader bufReaderIn){
	Logger.writeMessage("In FileProcessor, BufferedReader constructor", Logger.DebugLevel.CONSTRUCTOR);
	in = bufReaderIn;
    }
   
    public FileProcessor(String outFileNameIn){
    	outfilename = outFileNameIn;
	Logger.writeMessage("In FileProcessor, String Parameter constructor", Logger.DebugLevel.CONSTRUCTOR);
	try {
		File file = new File(outFileNameIn);
		if(!file.exists()){
			file.createNewFile();
		}
		FileWriter fw = new FileWriter(file);
		out = new BufferedWriter(fw);
	} catch (IOException e) {
		e.printStackTrace();
	}
    }
    
    /**
     * @return String  reads line from file and returns line 
     */
    public  String readLineFromFile(){
    	String line = null;
    	try {
			line = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	return line;
    }
     
    /**
     * writes to output file line by line 
     * @param text line to be written to file
     */
    public void writeLineToFile(String text){    	
    	try {
    		out.write(text);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    /**
     * closes the output file
     */
    public void closefile(){
    	try {
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
}
