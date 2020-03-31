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
	int length = 0;
	
	public Temperature(String fileName)
	{
		this.fileName = fileName;
	}
	
	public void openFile()
	{
		actualFile = new File(fileName);
	}
	
	String[][] readFile()
	{		
		int i = 0;
		int j = 0;
		String[][] temp = new String[100][1];
		
		try
		{
			myScanner = new Scanner(actualFile);
			
			while(myScanner.hasNextLine())
			{
				temp[i][j] = myScanner.nextLine();
				System.out.println(temp[i][j]);
				i++;
			}
		}
		catch(Exception e)
		{
			System.out.println("Couldn't find the file");
			e.printStackTrace();
		}
		
		return temp;
	}
	
	void closeFile()
	{
		myScanner.close();
	}

}
