/* Java Machine Learning Assignment
 * Author: Adrian Borkowski C17384436
 *Description: The Doctor Class of the Java Assignment
 */


package com.javaassignment.test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GUI_Doctor extends JFrame implements ActionListener
{
	private JPanel panelIntro;
	private JPanel panelOptions;
	private JPanel panelButtons;
	private JPanel panelDisplay;
	private JLabel labelIntro;
	private JLabel labelOptions;
	private JButton viewButton;
	private JButton deleteButton;
	private JButton home;
	private JTextArea box;
	
	
	public GUI_Doctor()
	{
		
		super("Doctor Menu");
		
		setLayout(new GridLayout());
		
		panelIntro = new JPanel();
		panelIntro.setBackground(Color.cyan);
		panelIntro.setPreferredSize(new Dimension(400,60));
		add(panelIntro);
		
		panelButtons = new JPanel();
		panelButtons.setBackground(Color.cyan);
		panelButtons.setPreferredSize(new Dimension(400,60));
		add(panelButtons);
		
		
		labelIntro = new JLabel("Welcome to the Doctor Menu");
		panelIntro.add(labelIntro);
		
		
		//display box goes here
		
		box = new JTextArea();
		box.setBackground(Color.LIGHT_GRAY);
		box.setPreferredSize(new Dimension(350,150));
		box.setEditable(false);
		panelIntro.add(box);
		
		
		labelOptions = new JLabel("Please select one of the following options: ");
		panelButtons.add(labelOptions);
		
		viewButton = new JButton("Display Patient Results");
		viewButton.addActionListener(this);
		viewButton.setPreferredSize(new Dimension(180,25));
		panelButtons.add(viewButton);
		
		deleteButton = new JButton("Clear Patient Results");
		deleteButton.addActionListener(this);
		deleteButton.setPreferredSize(new Dimension(180,25));
		panelButtons.add(deleteButton);
		
		
		home = new JButton("Return to Main Menu");
		home.addActionListener(this);
		home.setPreferredSize(new Dimension(180,25));
		panelButtons.add(home);
		
		
		setLayout(new GridLayout(2,1));
		setSize(400,500);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent anything)
	{	
		if(anything.getSource() == home)
    	{
    		GUI_Menu MyGUI = new GUI_Menu();
    		setVisible(false); 
    	}
	}
	
	

}
