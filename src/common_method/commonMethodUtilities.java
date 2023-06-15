package common_method;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class commonMethodUtilities {

	public static void evidenceFileCreator(String fileName,String request, String response) throws IOException
	{
		File newTextFile = new File ("C:\\Users\\HP\\eclipse-workspace\\new_frame" + fileName + ".txt");
		if(newTextFile.createNewFile())
		{
		FileWriter dataWriter = new FileWriter(newTextFile);
		dataWriter.write("Requestbody is : \n " +request+ "\n\n");
		dataWriter.write("\nResponsebody is :\n" +response);
		dataWriter.close();
		System.out.println("requestbody and responsebody data store in:"+newTextFile.getName());
		}
		else
		{
			System.out.println(newTextFile.getName()+"Already exists take backup of it");
		}
}
}