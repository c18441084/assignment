package Assignment.java;

import java.io.File;
import java.util.Scanner;

public class Temperature {
	
	//attributes
	public String fileName;//Stores file name
	File actualFile;//Used to store the file
	Scanner myScanner;//Opens the file
	public String answer;//The users answer that they have entered into temperature
	float ans;//Variable used to return the calculations/odds of user's answer
	int times;//Used to count the amount of times the readFile method has been contacted
	int fileLength = 0;//Length of the file
	//amount yes and no
	int yes = 0;
	int no = 0;
	
	//Constructor
	public Temperature(String fileName, String answer)
	{
		this.setFileName(fileName);
		this.setAnswer(answer);
	}
	
	//Getter for FileName
	public String getFileName() 
	{
		return fileName;
	}
	
	//Setter for FileName
	public void setFileName(String fileName) 
	{
		this.fileName = fileName;
	}
	
	//Getter for answer
	public String getAnswer() 
	{
		return answer;
	}
	
	//Setter for answer
	public void setAnswer(String answer) 
	{
		this.answer = answer;
	}

	//Opening the file 
	public void openFile()
	{
		actualFile = new File(getFileName());
	}
	
	//Starting to read the files
	public float readFile()
	{		
		//Variables used for yes's and no's in CoronaVirus column
		yes = 0;
		no = 0;
		
		//amount of temperatures
		int hot = 0;
		int normal = 0;
		int cool = 0;
		int cold = 0;
		
		//amount temperatures that have CoronaVirus
		float hotyes = 0;
		float normalyes = 0;
		float coolyes = 0;
		float coldyes = 0;
		
		//amount temperatures that don't have CoronaVirus
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
				//Counting the amount of "hot" in Temperature column 
				if(temp[i].contains("hot"))
				{
					hot++;
				}
				
				//Counting the amount of "normal" in Temperature column 
				if(temp[i].contains("normal"))
				{
					normal++;
				}
				
				//Counting the amount of "cool" in Temperature column 
				if(temp[i].contains("cool"))
				{
					cool++;
				}
				
				//Counting the amount of "cold" in Temperature column 
				if(temp[i].contains("cold"))
				{
					cold++;
				}
			}
			
			
			//Loop to count the amount of temperatures with CoronaVirus
			for(i=2; i < fileLength; i++)
			{
				//Splitting the old array by comas
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
			
			/* Probability */
			//if the answer that the user entered is equal to hot
			if(answer.contains("hot"))
			{
				hotNo = (hot - hotyes)/no;
				hotyes = hotyes/yes;
				if (times == 0)
				{
					ans = hotyes;
				}
				if(times == 1)
				{
					ans = hotNo;
				}
				if(times == 2)
				{
					ans = hot;
				}
				if(times == 3)
				{
					ans = fileLength;
				}
				times++;
				if(times > 3)
				{
					times = 0;
				}
			}
			//if the answer that the user entered is equal to normal
			if(answer.contains("normal"))
			{
				normalNo = (normal - normalyes)/no;
				normalyes = normalyes/yes;
				if (times == 0)
				{
					ans = normalyes;
				}
				if(times == 1)
				{
					ans = normalNo;
				}
				if(times == 2)
				{
					ans = normal;
				}
				if(times == 3)
				{
					ans = fileLength;
				}
				times++;
				if(times > 3)
				{
					times = 0;
				}
			}
			//if the answer that the user entered is equal to cool
			if(answer.contains("cool"))
			{
				coolNo = (cool - coolyes)/no;
				coolyes = coolyes/yes;
				
				if (times == 0)
				{
					ans = yes;
				}
				if(times == 1)
				{
					ans = coolNo;
				}
				if(times == 2)
				{
					ans = cool;
				}
				if(times == 3)
				{
					ans = fileLength;
				}
				times++;
				if(times > 3)
				{
					times = 0;
				}
			}
			//if the answer that the user entered is equal to cold
			if(answer.contains("cold"))
			{
				coldNo = (cold - coldyes)/no;
				coldyes = coldyes/yes;
				
				if (times == 0)
				{
					ans = coldyes;
				}
				if(times == 1)
				{
					ans = coldNo;
				}
				if(times == 2)
				{
					ans = cold;
				}
				if(times == 3)
				{
					ans = fileLength;
				}
				times++;
				if(times > 3)
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
