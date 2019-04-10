package com.javaassignment.test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PatientInfo extends JFrame 


{
	private JLabel intro;
	private JPanel panel1;
	private JPanel panel2;
	private JTextArea ptext;
	
	public PatientInfo(String name, String tempval, String acheval, String throatval)
	{
		
		File patientFile;
		Scanner patientScanner;
		
		patientFile= new File("\\Files\\Patients.csv");
		
		setLayout(new GridLayout());
		
		
		String allvals = name + "  " + tempval + "  " + acheval + "  " + throatval;
	
		String[] myPatient = new String[allvals.length()];
		
		panel1 = new JPanel();
		panel1.setBackground(Color.cyan);
		panel1.setPreferredSize(new Dimension(125,100));
		add(panel1);
		
		panel2 = new JPanel();
		panel2.setBackground(Color.cyan);
		panel2.setPreferredSize(new Dimension(125,100));
		add(panel2);
		
		intro = new JLabel("The following patient has been saved: \n");
		panel1.add(intro);
		
		ptext = new JTextArea();
		ptext.setBackground(Color.cyan);
		ptext.setPreferredSize(new Dimension(200,100));
		ptext.setText(allvals);
		ptext.setEditable(false);
		panel2.add(ptext);
		
		
		
		for ( int i = 0; i < myPatient.length; i++) 
		{
			myPatient[i]=new String();
		}
		System.out.println(allvals.length());
		System.out.println(myPatient.length);
		
		setLayout(new GridLayout(2,1));
		setSize(350,200);
		setVisible(true);
		
		File myPatientFile = new File(allvals);
		
		try 
		{
			patientScanner = new Scanner(myPatientFile);
			patientScanner.useDelimiter(",");
			
			while(patientScanner.hasNext())
			{
				System.out.print(patientScanner.next() + " | ");
				
			}
			
			patientScanner.close();
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			System.out.print("File not found");
			e.printStackTrace();
		}
		
		
		
		
		
	}
}
