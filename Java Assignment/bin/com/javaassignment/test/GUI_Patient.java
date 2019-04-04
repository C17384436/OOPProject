/* Java Machine Learning Assignment
 * Author: Adrian Borkowski C17384436
 *Description: The GUI_Patient Class of the Java Assignment. It provides code for interactive options such as text boxes,
 *				Choice Boxes and buttons which are used to input a Patient's data and to apply it to the code. A seperate
 *				button can also be found which takes the user back to the main menu of the code.
 */

package com.javaassignment.test;

//imports

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI_Patient extends JFrame implements ActionListener
{
	//attributes
	
	private JPanel panelIntro;
	private JPanel panelName;
	private JPanel panelTemp;
	private JPanel panelAches;
	private JPanel panelThroat;
	private JPanel panelButtons;
	private JLabel labelIntro;
	private JLabel labelName;
	private JLabel labelTemp;
	private JLabel labelAches;
	private JLabel labelThroat;
	private JTextField name;
	private JButton apply;
	private JButton home;
	
	//string lists containing variables
	
	String[] temp = { "Hot", "Cool", "Normal"};
	String[] aches = {"Yes", "No"};
	String[] throat = {"Yes", "No"};
	
	public GUI_Patient()
	{
		//Displays the name of the GUI on the top tab
		super("Patient Menu");
		
		//Selecting the layout of panels into a grid layout
		setLayout(new GridLayout());
		
		
		//panel constructors
		
		panelIntro = new JPanel();
		panelIntro.setBackground(Color.cyan);
		panelIntro.setPreferredSize(new Dimension(400,60));
		add(panelIntro);
		
		panelName = new JPanel();
		panelName.setBackground(Color.cyan);
		panelName.setPreferredSize(new Dimension(400,60));
		add(panelName);
		
		panelTemp = new JPanel();
		panelTemp.setBackground(Color.cyan);
		panelTemp.setPreferredSize(new Dimension(400,60));
		add(panelTemp);
		
		panelAches = new JPanel();
		panelAches.setBackground(Color.cyan);
		panelAches.setPreferredSize(new Dimension(400,60));
		add(panelAches);
		
		panelThroat = new JPanel();
		panelThroat.setBackground(Color.cyan);
		panelThroat.setPreferredSize(new Dimension(400,60));
		add(panelThroat);
		
		panelButtons = new JPanel();
		panelButtons.setBackground(Color.cyan);
		panelButtons.setPreferredSize(new Dimension(400,60));
		add(panelButtons);
		
		
		
		//label constructors
		
		//introductory text
		labelIntro = new JLabel("Welcome to the Patient Menu");
		panelIntro.add(labelIntro);
		
		//tells the user to input the full name of the patient
		labelName = new JLabel("Enter patient's full name: ");
		panelName.add(labelName);
		
		//tells the user to select a temperature from the choice box provided
		labelTemp = new JLabel("Temperature: ");
		panelTemp.add(labelTemp);
		
		//tells the user to select whether they have aches or not from the choice box provided
		labelAches = new JLabel("Aches: ");
		panelAches.add(labelAches);
		
		//tells the user to select whether they have a sore throat or not from the choice box provided
		labelThroat = new JLabel("Sore Throat: ");
		panelThroat.add(labelThroat);
		
		
		//text field constructor
		
		//allows the user to input text into a text box for the patient's name
		name = new JTextField();
		name.setPreferredSize(new Dimension(85,25));
		panelName.add(name);
		
		
		
		//choice box assignment
		
		//allows for the selection of the variables from the temp String list in a box
		JComboBox<String> tempList = new JComboBox<String>(temp);
		panelTemp.add(tempList);
		 
		//allows for the selection of the variables from the ache String list in a box
		JComboBox<String> acheList = new JComboBox<String>(aches);
		panelAches.add(acheList);
		
		//allows for the selection of the variables from the throat String list in a box 
		JComboBox<String> throatList = new JComboBox<String>(throat);
		panelThroat.add(throatList);
		
		
		
		//button assignment
		
		apply = new JButton("Apply");
		apply.addActionListener(this);
		apply.setPreferredSize(new Dimension(150,25));
		panelButtons.add(apply);
		
		home = new JButton("Back to Main Menu");
		home.addActionListener(this);
		home.setPreferredSize(new Dimension(150,25));
		panelButtons.add(home);
		
		
		setLayout(new GridLayout(6,1));
		setSize(400,500);
		setVisible(true);
		
	}
	
	
	    public void actionPerformed(ActionEvent anything) 
	    {
	    	if(anything.getSource() == apply)
	    	{
	    		System.out.println("Patient data has been saved");
	    	}
	    	else if(anything.getSource() == home)
	    	{
	    		GUI_Menu MyGUI = new GUI_Menu();
	    	}
	        
	    }
	
				
}