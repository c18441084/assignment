package Assignment.java;

public class Controllor {

	public static void main(String[] args)
	{
		Temperature myFileStuff = new Temperature("MLdata.xlsx");
		myFileStuff.openFile();
		String tokenRead = myFileStuff.readFile();
		System.out.println(tokenRead);
		myFileStuff.closeFile();
	}
}
