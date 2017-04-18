package comScore;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MediaMetrics {
	
	ArrayList<String[]> records;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MediaMetrics m = new MediaMetrics();
		m.records = new ArrayList<String[]>();
		
		Scanner sc = new Scanner(System.in);
		
		boolean run = true;
		
		while(run)
		{
			System.out.println("Welcome to the comScore programming challenge solution\n");
			System.out.println("Choose from the following menu options\n");
			System.out.println("1) import file\n");
			System.out.println("2) quit\n");
			

			if(sc.hasNextInt())
			{
				int choice = sc.nextInt();
				if(choice == 1)
				{
					System.out.println("Input the path to the file from which to read\n");
					
					m.importFile(sc.next());
				}
				else if(choice == 2)
				{
					System.out.println("Goodbye\n");
					run = false;
					break;
				}
			}
			else
			{
				System.out.println("Invalid option entered, choose again\n\n");
				sc.skip(".*");
			}
		}
		sc.close();
	}
	
	public void importFile(String fileName)
	{
		BufferedReader bReader;
		try
		{
			bReader = new BufferedReader(new FileReader(fileName));
		}
		catch (FileNotFoundException E)
		{
			System.out.println(E.toString());
			return;
		}
		
		String nextLine;
		
		do
		{
			try
			{
				nextLine = bReader.readLine();
			}
			catch(IOException E)
			{
				System.out.println(E.toString());
				break;
			}
			
			if(nextLine != null)
			{
				String[] fields = nextLine.split("|");
				
				records.add(fields);
			}
		}while(nextLine != null);
		try
		{
			bReader.close();
		}
		catch(IOException E)
		{
			System.out.println(E.toString());
		}
	}
		

}
