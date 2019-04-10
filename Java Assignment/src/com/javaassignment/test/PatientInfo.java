package com.javaassignment.test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

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
	
	public PatientInfo(String string, String string2, String string3, String string4)
	{
		
		
		setLayout(new GridLayout());
		
		String allvals = string + "  " + string2 + "  " + string3 + "  " + string4;
		
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
		ptext.setPreferredSize(new Dimension(125,100));
		ptext.setText(allvals);
		ptext.setEditable(false);
		panel2.add(ptext);
		
		
		setLayout(new GridLayout(2,1));
		setSize(350,200);
		setVisible(true);
		
	}
}
