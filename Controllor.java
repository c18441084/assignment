package Assignment.java;

public class Controllor {

	public static void main(String[] args)
	{
		//GUI Class
		GUI s1 = new GUI("First Screen"); 
		
		//Temperature Class
		Temperature myFileStuff = new Temperature("CoronaVirus.csv");
		myFileStuff.openFile();
		myFileStuff.readFile();
		myFileStuff.closeFile();
	}
}
