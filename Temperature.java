package Assignment.java;

import java.io.File;
import java.util.Scanner;

public class Temperature {
	
	//attributes
	String fileName;
	File actualFile;
	Scanner myScanner;
	int fileLength = 0;
	//amount yes and no
	int yes = 0;
	int no = 0;
	
	//Constructor
	public Temperature(String fileName)
	{
		this.fileName = fileName;
	}
	
	//Opening the file 
	public void openFile()
	{
		actualFile = new File(fileName);
	}
	
	//Starting to read the files
	String readFile()
	{		
		//amount of temperatures
		int hot = 0;
		int normal = 0;
		int cool = 0;
		int cold = 0;
		
		//amount temperatures with yes
		float hotyes = 0;
		float normalyes = 0;
		float coolyes = 0;
		float coldyes = 0;
		
		//amount temperatures with no
		float hotNo = 0;
		float normalNo = 0;
		float coolNo = 0;
		float coldNo = 0;
		
		//Counters for loops
		int i = 0;
		
		//Making a array
		String[] temp = new String[100];
		
		
		//Try and catch 
		try
		{
			//Scanning the file
			myScanner = new Scanner(actualFile);
			
			//loop to enter the file into an array
			while(myScanner.hasNextLine())
			{
				temp[i] = myScanner.nextLine();
				i++;
			}
			
			//Getting length of file
			fileLength = i;
			
			for (i=2; i < fileLength; i++)
			{
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
				
				if(temp[i].contains("cold"))
				{
					cold++;
				}
			}
			
			
			//Loop to count the amount of temperatures with CoronaVirus
			for(i=2; i < fileLength; i++)
			{
				//Array to split the old array
				String split[] = temp[i].split(",");
				
				//count the amount of "yes" in CoronaVirus column
				if(split[5].contains("yes"))
				{
					yes++;
				}
				
				//count the amount of "no" in CoronaVirus column
				if(split[5].contains("no"))
				{
					no++;
				}
				
				//Total number of "hot" temperatures that have CoronaVirus
				if(split[0].contains("hot") && split[5].contains("yes"))
				{
					hotyes++;	
				}
				
				//Total number of "normal" temperatures that have CoronaVirus
				if(split[0].contains("normal") && split[5].contains("yes"))
				{
					normalyes++;
				}
						
				//Total number of "cool" temperatures that have CoronaVirus
				if(split[0].contains("cool") && split[5].contains("yes"))
				{
					coolyes++;
				}
				
				//Total number of "cold" temperatures that have CoronaVirus
				if(split[0].contains("cold") && split[5].contains("yes"))
				{
					coldyes++;
				}
			}
			
			//Probability
			
			hotNo = (hot - hotyes)/no;
			hotyes = hotyes/yes;

			normalNo = (normal - normalyes)/no;
			normalyes = normalyes/yes;
			
			coolNo = (cool - coolyes)/no;
			coolyes = coolyes/yes;
			
			coldNo = (cold - coldyes)/no;
			coldyes = coldyes/yes;
			
			//System.out.println("Hot\nP(Yes): " + hotyes + "\nP(No): " + hotNo);
			//System.out.println("\n\nNormal\nP(Yes): " + normalyes + "\nP(No): " + normalNo);
			//System.out.println("\n\nCool\nP(Yes): " + coolyes + "\nP(No): " + coolNo);
			//System.out.println("\n\nCold\nP(Yes): " + coldyes + "\nP(No): " + coldNo);
		}
		
		//Catch if there is a error in finding the file
		catch(Exception e)
		{
			System.out.println("Couldn't find the file");
			e.printStackTrace();
		}
		
		return fileName;
	}
	
	//Closing the File
	void closeFile()
	{
		myScanner.close();
	}

}
