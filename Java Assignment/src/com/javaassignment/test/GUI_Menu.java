package com.javaassignment.test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI_Menu extends JFrame implements ActionListener
{
	private JPanel panel1;
	private JPanel panel2;
	private JButton patient;
	private JButton doctor;
	
	
	public GUI_Menu()
	{
		super("Main Menu");
		
		setLayout(new GridLayout());
		
		panel1 = new JPanel();
		panel1.setBackground(Color.cyan);
		panel1.setPreferredSize(new Dimension(400,60));
		add(panel1);
		
		panel2 = new JPanel();
		panel2.setBackground(Color.cyan);
		panel1.setPreferredSize(new Dimension(400,60));
		add(panel2);
		
		
		patient = new JButton("Patient");
		patient.addActionListener(this);
		patient.setPreferredSize(new Dimension(150,50));
		panel1.add(patient);
		
		doctor = new JButton("Doctor");
		doctor.addActionListener(this);
		doctor.setPreferredSize(new Dimension(150,50));
		panel2.add(doctor);
		
		
		
		setLayout(new GridLayout(2,1));
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