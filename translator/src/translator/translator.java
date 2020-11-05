package translator;

import java.util.HashMap;
import java.util.Scanner;
import java.io.*;


public class translator 
{
	String input;
	File file = new File("EnglishToArabicDictionary.txt");
	Scanner scanner = new Scanner(System.in);
	String key;
	String value;
	String x;
	
	HashMap<String, String> dictionary = new HashMap<String, String>();
	BufferedReader in = new BufferedReader(new FileReader(file));
	
	public translator() throws IOException 
	{
		int number = 0;
		for (String line = in.readLine(); line != null; line = in.readLine())
		{
				key = line;
				value = in.readLine();
				if (number == 0)
				{
					key = key.substring(1);
				}
				dictionary.put(key, value);
				number++;
		}
		
		in.close();
		run();
	}
	
	public void run()
	{
		System.out.println("Hello, welcome to our English-Arabic dictionary!");
		do
		{
			System.out.println("Type in a word in English or press q to quit.");
			x = scanner.nextLine();
			value = dictionary.get(x);
			if (value == null && x.equals("q") == false)
				{
					System.out.println("Sorry, we found nothing by your search. Try another word.\n");
				}
			else if (x.equals("q") == true)
			{
				System.out.println("Successfully quit!");
			}
			else
			{
				System.out.println(value + "\n");
			}
		}
		while (x.equals("q") == false);
	}
	
	public static void main(String[] args) throws IOException
	{
		new translator();
		
	}
	
	//check for null!!!!!!!!!!

}
