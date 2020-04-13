package Assignment.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Controllor {

	public static void main(String[] answerArray)
	{
		//Variables
		int i = 0;
		int right = 0;
		int wrong = 0;
		int length = 0;
	    double fileLength = 0;
		float yes = 0;
		float no = 0;
		float Amount = 0;
		String answer; 
		
		//GUI Class
		GUI s1 = new GUI("First Screen"); 
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
		yes = visitFileStuff.readFile();
		no = visitFileStuff.readFile();
		vAmount = visitFileStuff.readFile();
		visitFileStuff.closeFile();	
		
		//Calculations
		yes = tyes*ayes*cyes*styes*vyes*yes;
		no = tno*ano*cno*stno*vno*no;
		
		Amount = tAmount*aAmount*cAmount*stAmount*vAmount;
		
		yes = yes/Amount;
		no = no/Amount;
		
		yes = yes*100;
		no = no*100;
		
		//If statement to send the answer variable to the conclusion method in GUI.java
		if(yes > no)
		{
			answer = "yes";
			s1.Conclusion(answer);
		}
		else
		{
			answer = "no";
			s1.Conclusion(answer);
		}
//----------------------------------------------------------------------------------------------------------------------------------------------------------------
		//Anaylsising the last 30% of data
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
						
						//If statement to send the answer variable to the conclusion method in GUI.java
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
					System.out.println("Right: " + right);
					System.out.println("Wrong: " + wrong);
					float percentage = right + wrong;
					percentage = right/percentage;
					percentage = percentage * 100;
					System.out.println("Machine Accuracy: " + percentage + "%");
				} 
				catch (FileNotFoundException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	
}
