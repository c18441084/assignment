package Assignment.java;

import java.io.File;
import java.util.Scanner;

public class Temperature {
	
	//attributes
	String fileName;
	File actualFile;
	Scanner myScanner;
	int hot = 0;
	int normal = 0;
	int cool = 0;
	
	public Temperature(String fileName)
	{
		this.fileName = fileName;
	}
	
	public void openFile()
	{
		actualFile = new File(fileName);
	}
	
	String readFile()
	{
		String token="";
		
		try
		{
			myScanner = new Scanner(actualFile);
			System.out.println("File found");
			
		}
		catch(Exception e)
		{
			System.out.println("Couldn't find the file");
			e.printStackTrace();
		}
		
		return token;
	}
	
	void closeFile()
	{
		myScanner.close();
	}

}
