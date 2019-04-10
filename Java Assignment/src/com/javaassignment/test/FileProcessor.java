package com.javaassignment.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileProcessor
{
	
  

	public static void main(String[] args) 
	{
		

		try (PrintWriter writer = new PrintWriter(new File("test.csv")))
		{
    	
			StringBuilder sb = new StringBuilder();
			sb.append("Patient Number,");
			sb.append("Patient Name");
			sb.append("Patient ");
			sb.append('\n');

			sb.append("1");
			sb.append(',');
			sb.append("Ol");
			sb.append('\n');

			writer.write(sb.toString());

      		System.out.println("done!");
    	}
     
    	catch (FileNotFoundException e) 
    	{
    		System.out.println(e.getMessage());
    	}

	}

}
