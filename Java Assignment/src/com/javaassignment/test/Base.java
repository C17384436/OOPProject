/* Java Machine Learning Assignment
 * Author: Adrian Borkowski C17384436
 *Description:The following class is the Base class where the file with basic calculations(given to us initially in the question)
 *				is saved, opened, read and closed. Within this class, I have assigned some key items which occur throughout other classes (e.g the ArrayList list and the
 *				file path itself.). This class is a file processor class, just renamed to Base. 
 */

package com.javaassignment.test;


//imports
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Base 
{
	//Attributes - String, Scanner and File
	
	private String fileName;
	private Scanner fileScanner;
	private File Base;
	
	//initialising a new list of Arrays called list
	ArrayList<Patient> list = new ArrayList<Patient>();
	
	//constructor
	public Base(String fileName)
	{
		//the file CalculatedBase.csv is being put into the Base File attribute
		this.setFileName(fileName);
	}
	
	
	public void OpenFile()
	{
		//the myBase file opens up the file that has been input into the File attribute
		setBase(new File(getFileName()));
	}
	
	public ArrayList<Patient> readfile()
	{
		
		//put lines into a string and Strings into an array
		try 
		{	
			/*the code below uses a scanner to go through the contents of the file that
			 * has been opened and goes through it line by line. Every line that has some
			 * elements within it is saved as a String Array, later on inputing them into a 
			 * list of Arrays
			 */
			
			
			setFileScanner(new Scanner(getBase()));
			
			//if the line in the file being scanned has elements after it, it keeps on reading further
			while(getFileScanner().hasNext())
			{
				
				
				String line = getFileScanner().nextLine();
				String[] lineARRAY = line.split(",");
				
				//Each line becomes split by using a comma as a splitting element
				
				list.add(new Patient(lineARRAY[0],lineARRAY[1], lineARRAY[2],lineARRAY[3]));
				
				
				//prints out a seperator for every line to make it look cleaner
				//System.out.print(getFileScanner().next() + " | ");
				
			}
			
		} 
		//the loop below catches out and prints out an error on the condition that a file isn't found
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			System.out.print("File not found");
		}
		//returning the list ArrayList
		return list;
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
