package Assignment.java;

import java.io.File;
import java.util.Scanner;

public class Cough extends Aches 
{

	//attributes
	File actualFile;
	Scanner myScanner;
	float ans;
	int times;//Used to count the amount of times the readFile method has been contacted
	
	//Constuctor
	public Cough(String fileName, String answer)
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
		float Cyes = 0;
		float Cyesno = 0;
		float Cnoyes = 0;
		float Cno = 0;
		
		//counter
		int i = 0;
		float j = 0;
		
		//array String
		String[] cough = new String[100];
		
		//Try and catch 
		try
		{
			//Scanning the file
			myScanner = new Scanner(actualFile);
			
			//Going through the File
			while(myScanner.hasNextLine())
			{
				cough[i] = myScanner.nextLine();
				i++;
			}
			
			//Length of file
			fileLength = i;
			
			//Loop for getting the values from the file
			for(i = 2; i < fileLength; i++)
			{
				//Array to split the old array
				String split[] = cough[i].split(",");
				
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
				
				//Yes in Cough and Yes in CoronaVirus columns
				if(split[2].contains("yes") && split[5].contains("yes"))
				{
					Cyes++;
				}
				
				//Yes in Cough and No in CoronaVirus columns
				if(split[2].contains("yes") && split[5].contains("no"))
				{
					Cyesno++;
				}
				
				//No in Cough and Yes in CoronaVirus columns
				if(split[2].contains("no") && split[5].contains("yes"))
				{
					Cnoyes++;
				}
				
				//No in Cough and No in CoronaVirus columns
				if(split[2].contains("no") && split[5].contains("no"))
				{
					Cno++;
				}
			}
			
			//Probability
			if(answer.contains("yes"))
			{
				j = Cyes + Cyesno;
				Cyes = Cyes/yes;
				Cyesno = Cyesno/no;
				if(times == 0)
				{
					ans = Cyes;
				}
				if(times == 1)
				{
					ans = Cyesno;
				}
				if(times == 2)
				{
					ans = j;
				}
				
				times++;
				
				if(times > 1)
				{
					times = 0;
				}
			}
			
			if(answer.contains("no"))
			{
				j = Cnoyes + Cno;
				Cnoyes = Cnoyes/yes;
				Cno = Cno/no;
				if(times == 0)
				{
					ans = Cnoyes;
				}
				if(times == 1)
				{
					ans = Cno;
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
