package Assignment.java;

public class Controllor {

	public static void main(String[] answerArray)
	{
		//Variables
		int i = 0;
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

//--------------------------------------------------------------------------------------------------------------------------------------------------------------		
		
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
			s1.Conclusion(answer);
		}
		else
		{
			answer = "no";
			s1.Conclusion(answer);
		}
		
		
	}
}
