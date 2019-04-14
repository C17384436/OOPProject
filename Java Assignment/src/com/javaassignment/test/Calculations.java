 /*
 *Java Machine Learning Assignment
 *Author: Adrian Borkowski C17384436
 *Description: The class below is the Calculation class for the assignment. The purpose of the first part is to provide the Naive Bayes algorithm for the program.
 *				It takes in the base calculations given to us in the question, which is passed by the
 *				class Base. It also takes in user inputs from the GUI_Patient class which should ultimately
 *				sent back to the user, showing them how likely they are to have Tonsilitis in
 *				percentage form. 
 *				The second part of this class is to provide the overall program to check accuracy testing of the code itself. It
 *				splits the test data into two sections (70% and 30%), using the 70% as the new test data and comparing the 30% against the algorithm from the 
 *				previous method in this class. The method shows how accurate the algorithm is compared to the the test data given.
 *				
 *				
 */				

package com.javaassignment.test;

//imports

import java.util.ArrayList;
import java.util.Scanner;

public class Calculations
{
	//Attributes
	//attributes used in the calc method
	private float tempcountY;
	private float tempcountN;
	private float achecountY;
	private float achecountN;
	private float throatcountY;
	private float throatcountN;
	private float tonsilitiscountY;
	private float tonsilitiscountN;
	private float overallY;
	private float overallN;
	private float normaliser;
	private float totalY;
	private float totalN;
	
	private String tempval;
	private String acheval;
	private String throatval;
	
	//attributes used in the acc method
	private float seventy;
	private float thirty;
	
	private float importcalc;
	
	private float bothY;
	private float bothN;
	private float correctguess;
	private float incorrectguess;
	private float finalpercentage;
	
	//array lists
	//array list used in calc method
	ArrayList<Patient> newlist = new ArrayList<Patient>();
	
	//array list used in acc method
	ArrayList<Patient> seventylist = new ArrayList<Patient>();
	ArrayList<Patient> thirtylist = new ArrayList<Patient>();
 	
	
	/*
	 *Constructor for calc method, it should take in the Base class along with 
	  the file it contains and the methods called within the class as well as
	  taking in variables from GUI_Patient 
	 */ 
	public Calculations(String tempval, String acheval, String throatval)
	{
		Base myBase = new Base("C:\\Users\\CalculationBase.csv");
		
		myBase.OpenFile();
		newlist = myBase.readfile();
		myBase.closeReadFile();
		
		this.tempval = tempval;
		this.acheval = acheval;
		this.throatval = throatval;
		
		
	}
	
	/*
	 * Constructor for acc method, like before it opens up the CSV file, read it's contents
	 * , and closes it at the end.
	 */
	public Calculations()
	{
		Base newBase = new Base("C:\\Users\\CalculationBase.csv");
		
		newBase.OpenFile();
		newlist = newBase.readfile();
		newBase.closeReadFile();
		
		
	}
	
	
	
	
	
	
	/*
	 * In the method below, the main calculations for the algorithm are being made.
	 * The for loop increments by one until it reaches the size of the newlist array list. Each time that it loops around, it uses
	 * if statements to check whether the values input by the user through the GUI_Patient class are equivalent to the inputs in the file.
	 * Example: if the temperature that the user selected is Hot, if the user has aches and has a sore throat, the algorithm checks 
	 * if all of those variables are in the file and increments the three variable counters by 1 depending on whether or not they have certain symptoms.
	 */
	public float calc()
	{
		tempcountY = 0;
		tempcountN = 0;
		achecountY = 0;
		achecountN = 0;
		throatcountY = 0;
		throatcountN = 0;
		tonsilitiscountY = 0;
		tonsilitiscountN = 0;
		overallY = 0;
		overallN = 0;
		normaliser = 0;
		totalY = 0;
		totalN = 0;
		
		
		
		for(int i = 0; i < newlist.size(); i++)
		{
			if(newlist.get(i).getTemperature().equals(tempval) && newlist.get(i).getTonsilitis().equals("Yes"))
			{
				tempcountY++;
				
			}//end of if()
			
			if(newlist.get(i).getTemperature().equals(tempval) && newlist.get(i).getTonsilitis().equals("No"))
			{
				tempcountN++;
				
			}//end of if()
			
			if(newlist.get(i).getAches().equals(acheval) && newlist.get(i).getTonsilitis().equals("Yes"))
			{
				achecountY++;
				
			}//end of if()
			
			if(newlist.get(i).getAches().equals(acheval) && newlist.get(i).getTonsilitis().equals("No"))
			{
				achecountN++;
				
			}//end of if()
			
			if(newlist.get(i).getSorethroat().equals(throatval) && newlist.get(i).getTonsilitis().equals("Yes"))
			{
				throatcountY++;
				
			}//end of if()
			
			if(newlist.get(i).getSorethroat().equals(throatval) && newlist.get(i).getTonsilitis().equals("No"))
			{
				throatcountN++;
				
			}//end of if()
			
			if(newlist.get(i).getTonsilitis().equals("Yes"))
			{
				tonsilitiscountY++;
				
			}//end of if()
			
			if(newlist.get(i).getTonsilitis().equals("No"))
			{
				tonsilitiscountN++;
				
			}//end of if()
			
		}//end of for loop
		
		
		//the Probablitiy of the overall No count for user input variables is found below
		overallY = (tempcountY/tonsilitiscountY)*(achecountY/tonsilitiscountY)*(throatcountY/tonsilitiscountY)*(tonsilitiscountY/18);
		//the probablitity of the overall No count for user input variables is found below
		overallN = (tempcountN/tonsilitiscountN)*(achecountN/tonsilitiscountN)*(throatcountN/tonsilitiscountN)*(tonsilitiscountN/18);	
		
		//the normaliser (used to help get a percentage)
		normaliser = (overallY) + (overallN);
		
		
		//the total probablity of variables being yes throughout the test case (gives the percentage)
		totalY = (overallY) / (normaliser);
		//the total probablity of variables being yes throughout the test case (gives the percentage)
		totalN = (overallN) / (normaliser);
		
		//returns the total probability of Yes values to the GUI_Patient, later to be printed out as a percentage to the user as it comes out as a decimal
		return(totalY);	
		
		
	}//end of calc method
	
	
	
	/*The method below (acc) presents us with a way to check the accuracy of the test case. It initially splits the list into two pieces (70% for the
	 * test model and 30% for checking the actual accuracy of the model against the algorithm.) It then clears the initial list of variables (newlist) and puts in the 70% to use as the
	 * new test model. 
	 * 
	 */
	public float acc()
	{
		//the variable seventy is equal to the size of the newlist(18) by 0.7 (to get 70% of the list) which equals to 13. 
		seventy = Math.round((float)(newlist.size() * 0.7));
		
		//the variable thirty is equal to the size of newlist when seventy is taken away from it (to get 30% of the list) which equals to 5.
		thirty = (newlist.size() - seventy);
		
		
		//attributes set to 0 so that they reset every time the program is being run
		bothY = 0;
		bothN = 0;
		totalY = 0;
		totalN = 0;
		normaliser = 0;
		correctguess = 0;
		finalpercentage = 0;
		
		//for loop that loops around 13 times 
		for(int j = 0; j < seventy; j++)
		{
			//70% of the contents of newlist are being put into seventylist 
			seventylist.add(newlist.get(j));
		}//end of for loop
		
		//for loop that loops around 5 times (from the 13th line of the newlist)
		for(int j = (int)(seventy) ; j < newlist.size(); j++)
		{
			//30% of the contents of newlist are being put into thirtylist
			thirtylist.add(newlist.get(j));
		}//end of for loop
		
		//the newlist is then cleared
		newlist.clear();

		/*this for loop goes around 13 times and inputs the values of the seventylist back into newlist to use as the new test model
		 * (also because newlist has important methods that we use throughout this method) 
		 */
		for(int j = 0; j < seventy; j++)
		{
			newlist.add(seventylist.get(j));
		}//end of for loop
		
		//this for loop goes around 5 times
		for(int j = 0; j < thirtylist.size(); j++)
		{
			//the three variables are then changed to the inputs within the thirtylist (last 5 patients info)
			tempval = thirtylist.get(j).getTemperature();
			acheval = thirtylist.get(j).getAches();
			throatval = thirtylist.get(j).getSorethroat();
			
			//store the contents of the calc method within a variable and call it to use in this method
			importcalc = calc();
			
			
			//if the return value of the calc method is more than 50%
			if(importcalc >= 0.5)
			{
				//nested for loop that checks whether the values of Tonsilitis being Yes in the algorithm are equal to the list
				if(thirtylist.get(j).getTonsilitis().equals("Yes"))
				{
					//increments the counter of both being Yes by 1
					bothY++;
				}//end of nested if()
				
			}//end of if()
			
			//if the return value of importcalc is equal to 50% when taken away from 100%
			if(1.0 - importcalc >= 0.5)
			{
				//nested for loop that checks whether the values of Tonsilitis being No in the algorithm are equal to the list
				if(thirtylist.get(j).getTonsilitis().equals("No"))
				{
					//increments the counter of both being No by 1
					bothN++;
				}//end of nested if()
				
				
			}//end of if()
			
			
		}//end of for loop
		
		
		//correctguess is the total chance of the algorithm being correct when it predicts tonsilitis in a patient
		correctguess = bothY + bothN;
		//incorrect guess is the total chance of the algorithm being incorrect when it predicts tonsilitis in a patient (takes away all correct guesses from the amount of total guesses)
		incorrectguess = thirtylist.size() - correctguess;
		
		//prints out total amount of correct and incorrect guesses
		System.out.println("Correct Guesses: " + correctguess);
		System.out.println("Incorrect Guesses: " + incorrectguess);
		
		//finalpercentage is the amount of correct guesses divided by the total amount of guesses made, which gives the accuracy of the model
		finalpercentage = (correctguess) / (thirtylist.size());
		
		
		//returns the final percentage
		return finalpercentage;
		
		
	}//end of acc method
	
}//end of class

		
		/*
		 
			P(Temperature = Hot | Toncilitis = Yes) = 1/9
			P(Aches = Yes | Toncilitis = Yes) = 7/9
			P(Sore Throat = Yes | Toncilitis = Yes) = 7/9
			P(Toncilitis = Yes) = 9/18

			P(Temperature = Hot | Toncilitis = No) = 4/9
			P(Aches = Yes | Toncilitis = No) = 3/9
			P(Sore Throat = Yes | Toncilitis = No) = 3/9
			P(Toncilitis = No) = 9/18

			P(X|C)P(C), or P(X|Tonsilitis = Yes)P(Tonsilitis = Yes)

			P(X | Tonsilitis = Yes)P(Tonsilitis = Yes) = (1/9) * (7/9) * (7/9) * (9/18) = 0.036
			P(X | Tonsilitis = No)P(Tonsilitis = No) = (4/9) * (3/9) * (3/9) * (9/18) = 0.025

			To normalise:

			0.036 + 0.025 =

			0.061

			0.036/0.061= 0.059 = OVERALL YES OF YOU HAVING TONSLITIS
			0.025/0.061=0.041 = OVERALL NO OF YOU HAVING TONSLITIS

		 */



	
	

