package com.javaassignment.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Base 
{
	public static void base()
	{
		File Base;
		Scanner fileScanner;

		Base = new File("Files\\CalculationBase.csv");
		
		try 
		{
			fileScanner = new Scanner(Base);
			fileScanner.useDelimiter(",");
			
			while(fileScanner.hasNext())
			{
				System.out.print(fileScanner.next() + " | ");
				
			}
			
			fileScanner.close();
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			System.out.print("File not found");
			e.printStackTrace();
		}
		
		
	}
}
