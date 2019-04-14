/* Java Machine Learning Assignment
 * Author: Adrian Borkowski C17384436
 *Description: The GUI_Menu Class of the Java Assignment. It contains the code for the main menu to be displayed
 *				and for the transition to a different (Patient and Algorithm) menu through user selection.
 *				The GUI_Menu appears Cyan in colour, with two evenly spaced buttons.
 */				


package com.javaassignment.test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GUI_Menu extends JFrame implements ActionListener
{
	
	//Setting Attributes - Panels, Labels and Buttons
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JLabel label1;
	private JButton patient;
	private JButton accuracy;
	private float accper;
	
	
	//Constructor
	public GUI_Menu()
	{
		//GUI title shows "Main Menu"
		super("Main Menu");
		
		//setting a grid style layout to make it easier to organise items on screen
		setLayout(new GridLayout());
		
		
		//creating panels
		
		panel1 = new JPanel();
		panel1.setBackground(Color.cyan);
		panel1.setPreferredSize(new Dimension(400,40));
		add(panel1);
		
		panel2 = new JPanel();
		panel2.setBackground(Color.cyan);
		panel2.setPreferredSize(new Dimension(400,40));
		add(panel2);
		
		panel3 = new JPanel();
		panel3.setBackground(Color.cyan);
		panel3.setPreferredSize(new Dimension(400,40));
		add(panel3);
		
		//creating a label
		
		label1 = new JLabel("Welcome to the Main Menu");
		panel1.add(label1);
		
		//creating buttons
		
		patient = new JButton("Patient");
		patient.addActionListener(this);
		patient.setPreferredSize(new Dimension(150,50));
		panel2.add(patient);
		
		accuracy = new JButton("Accuracy");
		accuracy.addActionListener(this);
		accuracy.setPreferredSize(new Dimension(150,55));
		panel3.add(accuracy);
		
		//grid layout settings
		
		setLayout(new GridLayout(3,1));
		setSize(400,500);
		setVisible(true);
	}
		
	public void actionPerformed(ActionEvent anything)
	{
		//if the button pressed is patient, it brings the user to the Patient Menu and closes down the current GUI
		if(anything.getSource() == patient)
		{
			GUI_Patient myPatient = new GUI_Patient();
			setVisible(false); 
			
		}
		
		//if the button pressed is the accuracy button, it displays a pop-up window which displays the accuracy of the model
		if(anything.getSource() == accuracy)
		{
			//calls the class calculations and the method acc which displays the percentage of accuracy
			Calculations myCalc = new Calculations();
			accper = myCalc.acc();
    		JOptionPane.showMessageDialog(this, "The accuracy of the test model is: " + (accper * 100) + "%");
		}
		
			
	}
		
	



}