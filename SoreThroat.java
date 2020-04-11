package Assignment.java;

import java.io.File;
import java.util.Scanner;

public class SoreThroat extends Temperature 
{
	//Attributes
	File actualFile;
	Scanner myScanner;
	float ans;
	int times;//Used to count the amount of times the readFile method has been contacted
	
	//Constuctor
	public SoreThroat(String fileName, String answer)
	{
		super(fileName, answer);
	}
	
	//Opening the file 
	public void openFile()
	{
		actualFile = new File(fileName);
	}
	
	//Reading the file
	public float readFile()
	{
		//Variable for length of file
		int fileLength = 0;
		
		//Variables for the amount of yes's and no's
		int yes = 0;
		int no = 0;
		
		//Variables used in method
		float STyes = 0;
		float STyesno = 0;
		float STnoyes = 0;
		float STno = 0;
		
		//counter
		int i = 0;
		float j = 0;
		
		//array String
		String[] sorethroat = new String[100];
		
		//Try and Catch
		try
		{
			//Scanning the file
			myScanner = new Scanner(actualFile);
			
			//Going through the File
			while(myScanner.hasNextLine())
			{
				sorethroat[i] = myScanner.nextLine();
				i++;
			}
			
			//Length the file
			fileLength = i;
			
			//Loop for getting the values from the file
			for(i= 2; i < fileLength; i++)
			{
				//Array to split the old array
				String split[] = sorethroat[i].split(",");
				
				//Amount of yes's in CoronaVirus column
				if(split[5].contains("yes"))
				{
					yes++;
				}
				
				//Amount of no's in CoronaVirus column
				if(split[5].contains("no"))
				{
					no++;
				}
				
				//Yes in Sore Throat and Yes in CoronaVirus columns
				if(split[3].contains("yes") && split[5].contains("yes"))
				{
					STyes++;
				}
				
				//Yes in Sore Throat and No in CoronaVirus columns
				if(split[3].contains("yes") && split[5].contains("no"))
				{
					STyesno++;
				}
				
				//No in Sore Throat and Yes in CoronaVirus columns
				if(split[3].contains("no") && split[5].contains("yes"))
				{
					STnoyes++;
				}
				
				//No in Sore Throat and No in CoronaVirus columns
				if(split[3].contains("no") && split[5].contains("no"))
				{
					STno++;
				}
			}
			
			//Probability
			if(answer.contains("yes"))
			{
				j = STyes + STyesno;
				STyes = STyes/yes;
				STyesno = STyesno/no;
				if(times == 0)
				{
					ans = STyes;
				}
				if(times == 1)
				{
					ans = STyesno;
				}
				if(times == 2)
				{
					ans = j;
				}
				
				times++;
				
				if(times > 2)
				{
					times = 0;
				}
			}
			
			if(answer.contains("no"))
			{
				j = STnoyes + STno;
				STnoyes = STnoyes/yes;
				STno = STno/no;
				if(times == 0)
				{
					ans = STnoyes;
				}
				if(times == 1)
				{
					ans = STno;
				}
				if(times == 2)
				{
					ans = j;
				}
				 times++;
				 
				if(times > 2)
				{
					times = 0;
				}
			}
				
		}
		//Catch if there is a error in finding the file
		catch(Exception e)
		{
			System.out.println("Couldn't find the file");
			e.printStackTrace();
		}
		
		//Returning calculations to Controllor.java
		return ans;
	}
	
	//Closing the File
	void closeFile()
	{
		myScanner.close();
	}
}
