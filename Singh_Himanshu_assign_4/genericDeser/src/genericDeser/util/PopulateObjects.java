package genericDeser.util;


import genericDeser.util.*;

import java.awt.List;
import java.lang.reflect.*;
import java.util.ArrayList;
public class PopulateObjects {

	public  FileProcessor FileProcessor_input;
	public  FileProcessor FileProcessor_outputfile;
	public  ArrayList<First> first_list= new ArrayList<First>();
	public ArrayList<Second> second_list = new ArrayList<Second>();
	public PopulateObjects()
	{
		
	}

	public PopulateObjects(FileProcessor fileProcessor_input2, FileProcessor fileProcessor_outputfile2) {
		// TODO Auto-generated constructor stub
		Logger.writeMessage("In populate objects constructor", Logger.DebugLevel.CONSTRUCTOR);
		FileProcessor_input = fileProcessor_input2;
		FileProcessor_outputfile = fileProcessor_outputfile2;
	}
	public void printFisrst()
	{
		int i=0;
		Logger.writeMessage("In print first objects count", Logger.DebugLevel.IN_RUN);
		for(First obj: first_list)
		{
			//System.out.println(obj.getByteValue()+" " +obj.getFloatValue()+" "+obj.getShortValue()+" "+obj.getStringValue()+" "+obj.getCharValue()+" "+obj.getDoubleValue()+" "+obj.getIntValue()+" "+obj.getLongValue());
			i++;
		}
		System.out.println("\nTotal Number of First Objects: " + i );
	}
	
	public void printSecond()
	{
		Logger.writeMessage("In print second objects count", Logger.DebugLevel.IN_RUN);
		int i=0;
		for(Second obj: second_list)
		{
			//System.out.println(obj.getDoubleValue()+" "+obj.getDoubleValue2()+" " +obj.getLongValue()+" " +obj.getLongValue2()+" " +obj.getShortValue()+" " +obj.getShortValue2()+" " +obj.getStringValue());
			i++;
		}
		System.out.println("\nTotal Number of Second Objects: " + i);
	}

	public void start() {
		// TODO Auto-generated method stub
		Logger.writeMessage("In start function of populate objects", Logger.DebugLevel.IN_RUN);
		String newline;
		String first = "<fqn:genericDeser.util.First>";
		String second = "<fqn:genericDeser.util.Second>";
		while((newline = FileProcessor_input.readLineFromFile()) != null)
		{
			if(newline.equals(first))
				populatefirst();
			if(newline.equals(second))
				populatesecond();
			
		}
		equalfirst();
		this.printFisrst();
		equalsecond();
		this.printSecond();
	}
	
	private void equalfirst()
	{
		Logger.writeMessage("In checking nuber of unique first objects", Logger.DebugLevel.IN_RUN);
		ArrayList<First> first_listtmp= new ArrayList<First>();
		for(First obj: first_list)
		{
			if(!first_listtmp.contains(obj))
				first_listtmp.add(obj);
		}
		System.out.println("\nNumber of unique first objects:" + first_listtmp.size());
	}
	
	private void equalsecond()
	{
		Logger.writeMessage("In checking nuber of unique second objects", Logger.DebugLevel.IN_RUN);
		ArrayList<Second> second_listtmp = new ArrayList<Second>();
		for(Second obj: second_list)
		{
			if(!second_listtmp.contains(obj))
				second_listtmp.add(obj);
		}
		System.out.println("\nNumber of unique second objects: "+ second_listtmp.size());
	}

	private void populatesecond() {
		try{
			Logger.writeMessage("In creatinf objects of second", Logger.DebugLevel.IN_RUN);
		// TODO Auto-generated method stub
		String newline = FileProcessor_input.readLineFromFile();
		newline = newline.replaceAll("<", "");
		newline = newline.replaceAll(">", "");
		Object obj;
		String second = "</fqn:genericDeser.util.Second>";
		String parts[] ;
		String parts2[] ;
		String value[];
		String[] var;
		String clsName = "genericDeser.util.Second";
		int i=0;
		Class cls = Class.forName(clsName); 
			obj = cls.newInstance();
			
	    Class[] signature = new Class[1];
	    String methdName = new String();
	    Object params = new Object();
	    //while(newline.equals(second)==false)
	    while(!newline.contains("/fqn"))
	    {
	    	newline = newline.replaceAll("<", "");
			newline = newline.replaceAll(">", "");
			parts = newline.split(", ");
			parts2 = parts[0].split("=");
			//System.out.println(parts[0]+parts[1]+parts[2]);
			value = parts[2].split("=");
			var = parts[1].split("=");
			//value[1] = null;
			if(parts2[1].equals("short") && var[1].equals("ShortValue"))
			{
				methdName = "set" + "ShortValue";
				signature[0] = Short.TYPE;
				params = new Short(Short.parseShort(value[1]));
			}
			else if (parts2[1].equals("short") && var[1].equals("ShortValue2"))
			{
				methdName = "set" + "ShortValue2";
				signature[0] = Short.TYPE;
				params = new Short(Short.parseShort(value[1]));
			}
			else if(parts2[1].equals("long") && var[1].equals("LongValue"))
			{
				methdName = "set" + "LongValue";
				signature[0] = Long.TYPE;
				params = new Long(Long.parseLong(value[1]));
			}
			else if(parts2[1].equals("long") && var[1].equals("LongValue2"))
			{
				methdName = "set" + "LongValue2";
				signature[0] = Long.TYPE;
				params = new Long(Long.parseLong(value[1]));
			}
			else if(parts2[1].equals("double") && var[1].equals("DoubleValue"))
			{
				methdName = "set" + "DoubleValue";
				signature[0] = Double.TYPE;
				params = new Double(Double.parseDouble(value[1]));
			}
			else if(parts2[1].equals("double") && var[1].equals("DoubleValue2"))
			{
				methdName = "set" + "DoubleValue2";
				signature[0] = Double.TYPE;
				params = new Double(Double.parseDouble(value[1]));
			}
			else if(parts2[1].equals("String"))
			{
				methdName = "set" + "StringValue";
				signature[0] = String.class;
				if(parts2.length==1)
					params = null;
				else
				params = new String(value[1]);
			}
			else
				return;
			Method meth = cls.getMethod(methdName, signature);
			meth.invoke(obj, params);
			newline = FileProcessor_input.readLineFromFile();
	    }
	    second_list.add((Second) obj);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private void populatefirst(){
		
		try{
			Logger.writeMessage("In creatinf objects of first", Logger.DebugLevel.IN_RUN);
		// TODO Auto-generated method stub
		String newline = FileProcessor_input.readLineFromFile();
		newline = newline.replaceAll("<", "");
		newline = newline.replaceAll(">", "");
		Object obj;
		String first = "</fqn:genericDeser.util.First>";
		String parts[]; 
		String parts2[]; 
		String value[];
		String clsName = "genericDeser.util.First";
		int i=0;
		Class cls = Class.forName(clsName); 
			obj = cls.newInstance();
			
	    Class[] signature = new Class[1];
	    String methdName = new String();
	    Object params = new Object();
		//while(newline.equals(first)==false)
	    while(!newline.contains("/fqn"))
		{
			
			newline = newline.replaceAll("<", "");
			newline = newline.replaceAll(">", "");
			parts = newline.split(", ");
			parts2 = parts[0].split("=");
			
			value = parts[2].split("=");
			if(parts2[1].equals("byte"))
			{
				methdName = "set" + "ByteValue";
				signature[0] = Byte.TYPE;
				params = new Byte(Byte.parseByte(value[1]));
			}
			else if(parts2[1].equals("short"))
			{
				methdName = "set" + "ShortValue";
				signature[0] = Short.TYPE;
				params = new Short(Short.parseShort(value[1]));
			}
			else if(parts2[1].equals("int"))
			{
					methdName = "set" + "IntValue";
					signature[0] = Integer.TYPE;
					params = new Integer(Integer.parseInt(value[1]));
			}
			else if(parts2[1].equals("long"))
			{
					methdName = "set" + "LongValue";
					signature[0] = Long.TYPE;
					params = new Long(Long.parseLong(value[1]));
			}
			else if(parts2[1].equals("float"))
			{
					methdName = "set" + "FloatValue";
					signature[0] = Float.TYPE;
					params = new Float(Float.parseFloat(value[1]));
			}
			else if(parts2[1].equals("double"))
			{
					methdName = "set" + "DoubleValue";
					signature[0] = Double.TYPE;
					params = new Double(Double.parseDouble(value[1]));
			}
			else if(parts2[1].equals("boolean"))
			{
					methdName = "set" + "BooleanValue";
					signature[0] = Boolean.TYPE;
					params = new Boolean(Boolean.parseBoolean(value[1]));
			}
			else if(parts2[1].equals("char"))
			{
					methdName = "set" + "CharValue";
					signature[0] = Character.TYPE;
					//value[1] ="abc";
					if(value.length==1)
						params = 'a';
					else
					params = new Character(value[1].charAt(0));
			}
			else if(parts2[1].equals("String"))
			{
					methdName = "set" + "StringValue";
					signature[0] = String.class;
					if(parts2.length==1||value.length==1)
						params = null;
					else
					params = new String(value[1]);
			}
			else
					return;
			
				Method meth = cls.getMethod(methdName, signature);
				meth.invoke(obj, params);
				newline = FileProcessor_input.readLineFromFile();
				if(newline.contains("/fqn"))
					break;
		}
		first_list.add((First) obj);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
