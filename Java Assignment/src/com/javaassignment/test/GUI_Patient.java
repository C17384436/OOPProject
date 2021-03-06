/* Java Machine Learning Assignment
 * Author: Adrian Borkowski C17384436
 *Description: The GUI_Patient Class of the Java Assignment. It provides code for interactive options such as text boxes,
 *				Choice Boxes and buttons which are used to input a Patient's data and to apply it to the algorithm.The algorithm itself is being
 *				called by calling the class Calculations (using the method calc). This class sends the user input over to the calc algorithm and gives back
 *				a percentage when the apply button is pressed. There is also a button that can also be found at the end which takes the user back to the main menu of the code.
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI_Patient extends JFrame implements ActionListener
{
	//Setting Attributes - Panels, Labels, Buttons and Text Fields
	
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
	private float percentage;
	
	//string lists containing variables for the user choices
	
	private JComboBox tempval;
	private JComboBox acheval;
	private JComboBox throatval;
	
	String[] tempString = {"Hot","Cool","Normal"};
	
	String[] acheString = {"Yes","No"};
	
	String[] throatString = {"Yes", "No"};
	
	
	//constructor
	public GUI_Patient()
	{
		//Displays the name of the GUI on the top tab
		super("Patient Menu");
		
		//Selecting the layout of panels into a grid layout
		setLayout(new GridLayout());
		
		
		//panel creation
		
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
		
		
		
		//label creation
		
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
		
		
		//text field creation
		
		//allows the user to input text into a text box for the patient's name
		name = new JTextField();
		name.setPreferredSize(new Dimension(85,25));
		panelName.add(name);
		
		
		
		
		//choice box assignment
		
		//allows for the selection of the variables from the tempval String into a choice box
		tempval = new JComboBox(tempString);
		panelTemp.add(tempval);
		
		
		//allows for the selection of the variables from the acheval String into a choice box
		acheval = new JComboBox(acheString);
		panelAches.add(acheval);
		
		//allows for the selection of the variables from the throatval String into a choice box
		throatval = new JComboBox(throatString);
		panelThroat.add(throatval);
		
		
		
		//button creation and assignment
		
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
	
	/*The code below provides actions for an event where one of the possible buttons is being
	 * pressed on the GUI. An example is that if the user presses the Apply button, the user
	 * info (the variables they picked from the choice box and name) are being passed to other
	 * classes.
	 */
	
	
	    public void actionPerformed(ActionEvent anything) 
	    {
	    	
	    	
	    	
	    	//the the button pressed is apply, the following happens
	    	if(anything.getSource() == apply)
	    	{
	    		//if name is blank, give an error message
	    		if(name.getText().equals(""))
	    		{
	    			System.out.println("Please input a name into the text box");
	    		}
	    		
	    		
	    		System.out.println("Patient data has been saved");
	    		
	    		//when the apply button is pressed, the user info is passed into the Calculations class and into the calc method.
	    		
	    		Calculations myCalc = new Calculations((String) tempval.getSelectedItem(),(String) acheval.getSelectedItem(), (String) throatval.getSelectedItem());
	    		//a new variable called percentage stores the float return of calc
	    		percentage = myCalc.calc();
	    		//a pop-up menu comes up and shows the following message with the percentage of tonsilitis depending on the user input
	    		JOptionPane.showMessageDialog(this, "The chance of you having tonsilitis is: " + (percentage * 100) + "%");
	    		
	    	}
	    	//else if the button pressed is the home button, it takes the user back to the main menu
	    	else if(anything.getSource() == home)
	    	{
	    		GUI_Menu MyGUI = new GUI_Menu();
	    		setVisible(false); 
	    	}
	    	
	        
	    }
	
				
}