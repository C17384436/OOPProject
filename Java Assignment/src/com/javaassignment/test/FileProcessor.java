package com.javaassignment.test;

import java.awt.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileProcessor
{
	
  

	public static void fileprocessor(String name, String tempval, String acheval, String throatval) 
	{
		
		File file = new File("\\Files\\Patients"); 
		  
	    try 
	    { 
	        // create FileWriter object with file as parameter 
	        FileWriter outputfile = new FileWriter(file); 
	  
	        // create CSVWriter object filewriter object as parameter 
	        CSVWriter writer = new CSVWriter(outputfile); 
	  
	        // create a List which contains String array 
	        List<String[]> data = new ArrayList<String[]>(); 
	        data.add(new String[] { "Name", "Temperature", "Aches", "Sore Throat", "Tonsilitis" }); 
	        data.add(new String[] {});  
	        writer.writeAll(data); 
	  
	        // closing writer connection 
	        writer.close(); 
	    } 
	    catch (IOException e) 
	    { 
    		
    	

	    }
	}

}
