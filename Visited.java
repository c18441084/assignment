package Assignment.java;

import java.io.File;
import java.util.Scanner;

public class Visited extends Temperature
{
	//Attributes
	File actualFile;
	Scanner myScanner;
	float ans;
	int times;//Used to count the amount of times the readFile method has been contacted
	
	//Constuctor
	public Visited(String fileName, String answer)
	{
		super(fileName, answer);
	}
	
	//Opening the File
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
		
		//Variables used in method
		float Vyes = 0;
		float Vyesno = 0;
		float Vnoyes = 0;
		float Vno = 0;
		
		//counter
		int i = 0;
		float j = 0;
		
		//array String
		String[] visited = new String[100];
		
		//Try and Catch
		try
		{
			//Scanning the file
			myScanner = new Scanner(actualFile);
			
			//Going through the File
			while(myScanner.hasNextLine())
			{
				visited[i] = myScanner.nextLine();
				i++;
			}
			
			//Length the file
			fileLength = i;
			
			//Loop for getting the values from the file
			for(i= 2; i < fileLength; i++)
			{
				//Splitting the old array by comas
				String split[] = visited[i].split(",");
				
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
				
				//Yes in Recently Visited and Yes in CoronaVirus columns
				if(split[3].contains("yes") && split[5].contains("yes"))
				{
					Vyes++;
				}
				
				//Yes in Recently Visited and No in CoronaVirus columns
				if(split[3].contains("yes") && split[5].contains("no"))
				{
					Vyesno++;
				}
				
				//No in Recently Visited and Yes in CoronaVirus columns
				if(split[3].contains("no") && split[5].contains("yes"))
				{
					Vnoyes++;
				}
				
				//No in Recently Visited and No in CoronaVirus columns
				if(split[3].contains("no") && split[5].contains("no"))
				{
					Vno++;
				}
			}
			
			//Probability
			if(answer.contains("yes"))
			{
				j = Vyes + Vyesno;
				Vyes = Vyes/yes;
				Vyesno = Vyesno/no;
				if(times == 0)
				{
					ans = Vyes;
				}
				if(times == 1)
				{
					ans = Vyesno;
				}
				if(times == 2)
				{
					ans = yes;
				}
				if(times == 3)
				{
					ans = no;
				}
				if(times == 4)
				{
					ans = j;
				}
				
				times++;
				
				if(times > 4)
				{
					times = 0;
				}
			}
			
			if(answer.contains("no"))
			{
				j = Vnoyes + Vno;
				Vnoyes = Vnoyes/yes;
				Vno = Vno/no;
				if(times == 0)
				{
					ans = Vnoyes;
				}
				if(times == 1)
				{
					ans = Vno;
				}
				if(times == 2)
				{
					ans = yes/fileLength;
				}
				if(times == 3)
				{
					ans = no/fileLength;
				}
				if(times == 4)
				{
					ans = j;
				}
				 times++;
				 
				if(times > 4)
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
