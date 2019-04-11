package com.javaassignment.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Base 
{
	private String fileName;
	private Scanner fileScanner;
	private File Base;
	
	public Base(String fileName)
	{
		this.setFileName(fileName);
	}
	
	
	public void OpenFile()
	{
		setBase(new File("Files\\CalculationBase.csv"));
	}
	
	String[] readfile()
	{
	
		
		ArrayList<String[]> list = new ArrayList<String[]>();
		
		
		
		//put lines into a string and Strings into an array
		try 
		{
			setFileScanner(new Scanner(getBase()));
			
			while(getFileScanner().hasNext())
			{
				
				
				String line = getFileScanner().nextLine();
				String[] lineARRAY;
				lineARRAY = line.split(",");
				list.add(lineARRAY);
				
				
				
				System.out.print(getFileScanner().next() + " | ");
				
			}
			
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			System.out.print("File not found");
			e.printStackTrace();
		}
		return null;
		
		
	}
	
	public void closeReadFile()
	{
		getFileScanner().close();
	}


	private String getFileName() 
	{
		return fileName;
	}


	private void setFileName(String fileName) 
	{
		this.fileName = fileName;
	}


	private Scanner getFileScanner() 
	{
		return fileScanner;
	}


	private void setFileScanner(Scanner fileScanner)
	{
		this.fileScanner = fileScanner;
	}


	private File getBase() 
	{
		return Base;
	}


	private void setBase(File base)
	{
		Base = base;
	}
	
	
}
