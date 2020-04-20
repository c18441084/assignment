package Assignment.java;

import java.io.File;
import java.util.Scanner;

public class Aches extends Temperature
{
	//attributes
	File actualFile;//Used to store the file
	Scanner myScanner;//Opens the file
	float ans;//Variable used to return the calculations/odds of user's answer
	int times;//Used to count the amount of times the readFile method has been contacted
	
	//Constructor
	public Aches(String fileName, String answer) 
	{
		super(fileName, answer);
	}
	
	//Opening the file
	public void openFile()
	{
		actualFile = new File(fileName);
	}
	
	//Reading the File
	public float readFile()
	{
		//Variable for length of file
		int fileLength = 0;
		
		//Variables for the amount of yes's and no's
		int yes = 0;
		int no = 0;
		
		//variables used in method
		float ACyes = 0;
		float ACyesno = 0;
		float ACnoyes = 0;
		float ACno = 0;
		
		//counter
		int i = 0;
		float j = 0;
		
		//array String
		String[] ache = new String[100];
		
		//Try and catch 
		try
		{
			//Scanning the file
			myScanner = new Scanner(actualFile);
			
			//Going through File
			while(myScanner.hasNextLine())
			{
				ache[i] = myScanner.nextLine();
				i++;
			}
			
			//Length of file
			fileLength = i;
			
			//Loop for getting the values from the file
			for(i = 2; i < fileLength; i++)
			{
				//Splitting the old array by comas
				String split[] = ache[i].split(",");
				
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
				
				//Yes in Aches and Yes in CoronaVirus columns
				if(split[1].contains("yes") && split[5].contains("yes"))
				{
					ACyes++;
				}
				
				//Yes in Aches and No in CoronaVirus columns
				if(split[1].contains("yes") && split[5].contains("no"))
				{
					ACyesno++;
				}
				
				//No in Aches and Yes in CoronaVirus columns
				if(split[1].contains("no") && split[5].contains("yes"))
				{
					ACnoyes++;
				}
				
				//No in Aches and No in CoronaVirus columns
				if(split[1].contains("no") && split[5].contains("no"))
				{
					ACno++;
				}
			}
			
			//Probability
			//if the answer that the user entered is equal to yes
			if (answer.contains("yes"))
			{
				j = ACyes + ACyesno;
				ACyes = ACyes/yes;
				ACyesno = ACyesno/no;
				if(times == 0)
				{
					ans = ACyes;
				}
				if(times == 1)
				{
					ans = ACyesno;
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
			//if the answer that the user entered is equal to no
			if (answer.contains("no"))
			{
				j = ACnoyes + ACno;
				ACnoyes = ACnoyes/yes;
				ACno = ACno/no;
				if(times == 0)
				{
					ans = ACnoyes;
				}
				if(times ==  1)
				{
					ans = ACno;
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
