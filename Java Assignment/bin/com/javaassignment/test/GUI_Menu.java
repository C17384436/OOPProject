/* Java Machine Learning Assignment
 * Author: Adrian Borkowski C17384436
 *Description: The GUI_Menu Class of the Java Assignment. It contains the code for the main menu to be displayed
 *				and for the transition to a different menu through user selection.
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

public class GUI_Menu extends JFrame implements ActionListener
{
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JLabel label1;
	private JButton patient;
	private JButton doctor;
	
	
	public GUI_Menu()
	{
		super("Main Menu");
		
		setLayout(new GridLayout());
		
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
		
		label1 = new JLabel("Welcome to the Main Menu");
		panel1.add(label1);
		
		
		patient = new JButton("Patient");
		patient.addActionListener(this);
		patient.setPreferredSize(new Dimension(150,50));
		panel2.add(patient);
		
		doctor = new JButton("Doctor");
		doctor.addActionListener(this);
		doctor.setPreferredSize(new Dimension(150,50));
		panel3.add(doctor);
		
		
		
		setLayout(new GridLayout(3,1));
		setSize(400,500);
		setVisible(true);
	}
		
	public void actionPerformed(ActionEvent anything)
	{
		if(anything.getSource() == patient)
		{
			GUI_Patient myPatient = new GUI_Patient();
			
		}
		else if(anything.getSource() == doctor)
		{
			GUI_Doctor myDoctor = new GUI_Doctor();
		}
			
	}
		
	



}