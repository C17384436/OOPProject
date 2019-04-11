package com.javaassignment.test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;

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
	private String temperature;
 	private String aches;
 	private String sorethroat;
 	private String tonsilitis;
	
	public PatientInfo(String name, String tempval, String acheval, String throatval)
	{
		
		
		
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
		
		intro = new JLabel("The following patient has been input: \n");
		panel1.add(intro);
		
		ptext = new JTextArea();
		ptext.setBackground(Color.cyan);
		ptext.setPreferredSize(new Dimension(200,100));
		ptext.setText(allvals);
		ptext.setEditable(false);
		panel2.add(ptext);
		
		
		
		
		
		
		
		setLayout(new GridLayout(2,1));
		setSize(350,200);
		setVisible(true);
		
		
		
		
		
		
	}
}
