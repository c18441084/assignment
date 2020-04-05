package Assignment.java;

public class Controllor {

	public static void main(String[] answerArray)
	{
		int i = 0;
		int j = 0;
		//GUI Class
		//GUI s1 = new GUI("First Screen"); 
		//String temperature = answerArray[i];
	
		/*//Temperature Class
		Temperature myFileStuff = new Temperature("CoronaVirus.csv", temperature);
		float tyes = 0;
		float tno = 0;
		myFileStuff.openFile();
		tyes = myFileStuff.readFile();
		tno = myFileStuff.readFile();
		myFileStuff.closeFile();*/
		
		//Aches Class
		Aches achesFileStuff = new Aches("CoronaVirus.csv");
		float ayes = 0;
		float ano = 0;
		achesFileStuff.openFile();
		ayes = achesFileStuff.readFile();
		ano = achesFileStuff.readFile();
		//achesFileStuff.closeFile();
	}
}
