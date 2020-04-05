
package Assignment.java;

import java.io.File;
import java.util.Scanner;

public class Temperature {
	
	//attributes
	private String fileName;
	File actualFile;
	Scanner myScanner;
	private String answer;
	float ans;
	int times;
	int fileLength = 0;
	//amount yes and no
	int yes = 0;
	int no = 0;
	
	//Constructor
	public Temperature(String fileName, String answer)
	{
		this.setFileName(fileName);
		this.setAnswer(answer);
	}
	
	public String getFileName() 
	{
		return fileName;
	}

	public void setFileName(String fileName) 
	{
		this.fileName = fileName;
	}
	
	public String getAnswer() 
	{
		return answer;
	}

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
		yes = 0;
		no = 0;
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
				times++;
				if(times == 2)
				{
					times = 0;
				}
			}
			
			if(answer.contains("normal"))
			{
				normalNo = (normal - normalyes)/no;
				normalyes = normalyes/yes;
				System.out.println(normalyes);
				//System.out.println(normalNo);
				if (times == 0)
				{
					ans = normalyes;
				}
				if(times == 1)
				{
					ans = normalNo;
				}
				times++;
				if(times == 2)
				{
					times = 0;
				}
			}
			
			if(answer.contains("cool"))
			{
				coolNo = (cool - coolyes)/no;
				coolyes = coolyes/yes;
				
				if (times == 0)
				{
					ans = coolyes;
				}
				if(times == 1)
				{
					ans = coolNo;
				}
				times++;
				if(times == 2)
				{
					times = 0;
				}
			}
			
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
				times++;
				if(times == 2)
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
		
		return ans;
	}
	
	//Closing the File
	void closeFile()
	{
		myScanner.close();
	}

}
