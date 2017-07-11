package genericSerDeser.util;

import genericSerDeser.strategy.SerStrategy;
import java.lang.reflect.*;
import java.sql.Types;

import genericSerDeser.util.FileProcessor;
public class DPML implements SerStrategy{
	private FileProcessor outputfile;
	public DPML(FileProcessor out)
	{
	 outputfile = out;
	}

	@Override
	public void serialize(Object obj) {
		// TODO Auto-generated method stub
		Class cls = obj.getClass();
		Field  flds[] = cls.getDeclaredFields();
		String classname = cls.getName();
		String var = new String();
		outputfile.writeLineToFile("<fqn:"+classname+">\n");
		for(Field fld: flds)
		{
			try {
				String methdName ="get"+fld.getName(); 
				Method meth = cls.getMethod(methdName);
				if(fld.getType().getTypeName().contains("String"))
					var = "<type=String"+", var="+fld.getName()+", value="+meth.invoke(obj)+">\n";
				else
				var = "<type="+fld.getType().getTypeName()+", var="+fld.getName()+", value="+meth.invoke(obj)+">\n";
			} catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			outputfile.writeLineToFile(var);
		}
		//System.out.println(classname);
		outputfile.writeLineToFile("</fqn:"+classname+">\n");
	}
	
}


