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
	
	String[] readFile()
	{		
		int i = 0;
		String[] temp = new String[100];
		
		try
		{
			myScanner = new Scanner(actualFile);
			
			while(myScanner.hasNextLine())
			{
				temp[i] = myScanner.nextLine();
				if(temp[i].contains("hot"))
				{
					hot++;
				}
				if(temp[i].contains("normal"))
				{
					normal++;
				}
				if(temp[i].contains("cool"))
				{
					cool++;
				}
				//System.out.println(temp[i]);
				i++;
			}
			i=0;
			int j =0;
			while(i < 70)
			{
				for(j=0; j < 6; j++)
				{
					String split[] = temp[i].split(",");
					System.out.println(split[j]);
				}
				i++;
			}
			//System.out.println(hot);
			//System.out.println(normal);
			//System.out.println(cool);
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
