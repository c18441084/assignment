/*********************************************************************************************
 * 
 * Author: Niall McNamara
 * Student Number: C18441084
 * Date:
 * Project: Machine Learning Assignment
 * Description: The following program is used to test users to calculate if they are likely to have 
 * 				Coronavirus or not. Classes such as; Temperature.java, Aches.java, Cough.java, SoreThroat.java 
 * 				and Visited.java, each read in a file called "CoronaVirus.csv" and disect it down to retrieve 
 * 				the information needed from each column. I used the algorithm Naives Bayes to calculate the 
 * 				whether the user had CoronaVirus judging by their answers. The user will enter their answers 
 * 				using the GUI I constructed in the class: GUI.java. In this class I took the user's answers
 * 				and transferred them into the Controllor.java class. The Controllor.java class sends the file 
 * 				to each class so it can be broken down. The class then sends the information back to to the 
 * 				Controllor.java class so it can be calculated and to find the answer for the user. The answer
 * 				is sent back to the GUI.java class where it is displayed to the user whether they have the 	
 * 				virus or not.
 *Refernces:(https://www.youtube.com/watch?v=CPqOCI0ahss&t=321s) = Video explaining and showing Naives Bayes,
 *			 Used previous labs to help with file processing and GUI set up, 
 * 
 ************************************************************************************************/
package Assignment.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Controllor {
	//The GUI kept printing twice because I went through the main twice. I added this static variable so that the GUI would only print once
	static int k = 0;
	public static void main(String[] answerArray)
	{
		
		//Variables
		int i = 0;//Counter
		int right = 0;//How many times my machine was right
		int wrong = 0;//Hoe many times my machine was wrong
		int length = 0;//Length of the file used to get the last 30% of the file
	    double fileLength = 0;//Length of the file used to get the last 30% of the file
		float yes = 0;//The percentage of yes's in the CoronaVirus column
		float no = 0;//The percentage of no's in the CoronaVirus column
		float Amount = 0;//The amount of times the user's answers were in the columns
		String answer;//String that tells the user whether they are positive or negative
		
		//GUI Class
		GUI s1 = new GUI("Answer Screen", k);
		k = 1;
		//Adding the user's answers into seperate strings
		String temperature = answerArray[i];
		i++;
		String ache = answerArray[i];
		i++;
		String cough = answerArray[i];
		i++;
		String sorethroat = answerArray[i];
		i++;
		String visited = answerArray[i];
	
		//Temperature Class
		Temperature myFileStuff = new Temperature("CoronaVirus.csv", temperature);
		float tyes = 0;
		float tno = 0;
		float tAmount = 0;
		myFileStuff.openFile();
		tyes = myFileStuff.readFile();
		tno = myFileStuff.readFile();
		tAmount = myFileStuff.readFile(); 
		fileLength = myFileStuff.readFile();
		myFileStuff.closeFile();
		
		//Aches Class
		Aches achesFileStuff = new Aches("CoronaVirus.csv", ache);
		float ayes = 0;
		float ano = 0;
		float aAmount = 0;
		achesFileStuff.openFile();
		ayes = achesFileStuff.readFile();
		ano = achesFileStuff.readFile();
		aAmount = achesFileStuff.readFile();
		achesFileStuff.closeFile();
		
		//Cough Class
		Cough coughFileStuff = new Cough("CoronaVirus.csv", cough);
		float cyes = 0;
		float cno = 0;
		float cAmount = 0;
		coughFileStuff.openFile();
		cyes = coughFileStuff.readFile();
		cno = coughFileStuff.readFile();
		cAmount = coughFileStuff.readFile();
		coughFileStuff.closeFile();
		
		//Sore Throat Class
		SoreThroat soreThroatFileStuff = new SoreThroat("CoronaVirus.csv", sorethroat);
		float styes = 0;
		float stno = 0;
		float stAmount = 0;
		soreThroatFileStuff.openFile();
		styes = soreThroatFileStuff.readFile();
		stno = soreThroatFileStuff.readFile();
		stAmount = soreThroatFileStuff.readFile();
		soreThroatFileStuff.closeFile();
		
		//Visited Class
		Visited visitFileStuff = new Visited("CoronaVirus.csv", visited);
		float vyes = 0;
		float vno = 0;
		float vAmount = 0;
		visitFileStuff.openFile();
		vyes = visitFileStuff.readFile();
		vno = visitFileStuff.readFile();
		yes = visitFileStuff.readFile();//getting the percentage of yes's in the CoronaVirus column
		no = visitFileStuff.readFile();//getting the percentage the of no's in the CoronaVirus column
		vAmount = visitFileStuff.readFile();
		visitFileStuff.closeFile();	
		
		//Calculations
		yes = tyes*ayes*cyes*styes*vyes*yes;
		no = tno*ano*cno*stno*vno*no;
		
		Amount = tAmount*aAmount*cAmount*stAmount*vAmount;
		
		yes = yes/Amount;
		no = no/Amount; 
		
		//If statement to send the answer variable to the conclusion method in GUI.java
		if(yes > no)
		{
			answer = "yes";
		}
		else
		{
			answer = "no";
		}
		
//----------------------------------------------------------------------------------------------------------------------------------------------------------------
		//Anaylsising the last 30% of data
		float percentage = 0;
		File actualFile = new File("CoronaVirus.csv");
		try 
		{
			Scanner myScanner = new Scanner(actualFile);
			length = (int)fileLength;
			int Length = length;
			int j = 0;
			String[] once = new String[length];
			i=0;
			while(myScanner.hasNextLine())
			{
				once[i] = myScanner.nextLine();
				i++;
			}
			fileLength = length - (length*0.3);
			length = (int)fileLength;
			for(i = length; i < Length; i++)
			{
				j = 0;
				String checks[] = once[i].split(",");
				
				if(j == 0)
				{
					//Temperature Class
					Temperature MyFileStuff = new Temperature("CoronaVirus.csv", checks[j]);
					MyFileStuff.openFile();
					tyes = MyFileStuff.readFile();
					tno = MyFileStuff.readFile();
					tAmount = MyFileStuff.readFile(); 
					fileLength = MyFileStuff.readFile();
					MyFileStuff.closeFile();
				}
				j++;
				if(j == 1)
				{
					//Aches Class
					Aches AchesFileStuff = new Aches("CoronaVirus.csv", checks[j]);
					AchesFileStuff.openFile();
					ayes = AchesFileStuff.readFile();
					ano = AchesFileStuff.readFile();
					aAmount = AchesFileStuff.readFile();
					AchesFileStuff.closeFile();
				}
				j++;
				if(j == 2)
				{
					//Cough Class
					Cough CoughFileStuff = new Cough("CoronaVirus.csv", checks[j]);
					CoughFileStuff.openFile();
					cyes = CoughFileStuff.readFile();
					cno = CoughFileStuff.readFile();
					cAmount = CoughFileStuff.readFile();
					CoughFileStuff.closeFile();
				}
				j++;
				if(j == 3)
				{
					//Sore Throat Class
					SoreThroat SoreThroatFileStuff = new SoreThroat("CoronaVirus.csv", checks[j]);
					SoreThroatFileStuff.openFile();
					styes = SoreThroatFileStuff.readFile();
					stno = SoreThroatFileStuff.readFile();
					stAmount = SoreThroatFileStuff.readFile();
					SoreThroatFileStuff.closeFile();
				}
				j++;
				if(j == 4)
				{
					//Visited Class
					Visited VisitFileStuff = new Visited("CoronaVirus.csv", checks[j]);
					VisitFileStuff.openFile();
					vyes = VisitFileStuff.readFile();
					vno = VisitFileStuff.readFile();
					yes = VisitFileStuff.readFile();
					no = VisitFileStuff.readFile();
					vAmount = VisitFileStuff.readFile();
					VisitFileStuff.closeFile();	
				}
				
				j++;
				//Calculations
				yes = tyes*ayes*cyes*styes*vyes*yes;
				no = tno*ano*cno*stno*vno*no;
				
				Amount = tAmount*aAmount*cAmount*stAmount*vAmount;
				
				yes = yes/Amount;
				no = no/Amount;
				
				yes = yes*100;
				no = no*100;
				
				//If statement to see how many are correct and how many are incorrect
				if(yes > no)
				{
					if(checks[j].contains("yes") || checks[j].contains("Yes"))
					{
						right++;
					}
					if(checks[j].contains("no") || checks[j].contains("No"))
					{
						wrong++;
					}
				}
				else
				{
					if(checks[j].contains("no") || checks[j].contains("No"))
					{
						right++;
					}
					if(checks[j].contains("yes") || checks[j].contains("Yes"))
					{
						wrong++;
					}
				}
				
			}
			//Calculating the percentage of my machine being correct 
			percentage = right + wrong;
			percentage = right/percentage;
			percentage = percentage * 100;
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		//Sending the answer variable and percentage variable over to the GUI
		s1.Conclusion(answer, percentage);
	}
}
