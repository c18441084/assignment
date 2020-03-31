package Assignment.java;

public class Controllor {

	public static void main(String[] args)
	{
		Temperature myFileStuff = new Temperature("coronavirus.txt");
		myFileStuff.openFile();
		//String tokenRead = myFileStuff.readFile();
		//System.out.println(tokenRead);
		myFileStuff.readFile();
		myFileStuff.closeFile();
	}
}
