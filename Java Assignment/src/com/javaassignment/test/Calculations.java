 /*
 *Java Machine Learning Assignment
 *Author: Adrian Borkowski C17384436
 *Description: The class below is the Calculation class for the assignment. Although not completed in the way that
 *				I'd like it to be, it's purpose is to provide the Naive Bayes algorithm for the program.
 *				It takes in the base calculations given to us in the question, which is passed by the
 *				class Base. It also takes in user inputs from the GUI_Patient class which should ultimately
 *				sent the calculations back to the user, showing them how likely they are to have Tonsilitis in
 *				percentage form.
 */				

package com.javaassignment.test;

//imports

import java.util.ArrayList;
import java.util.Scanner;

public class Calculations
{
	//Attributes
	
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
	
	private float seventy;
	private float thirty;
	private float accYcount;
	private float accNcount;
	
	private String accY;
	private String accN;
	
	private float bothY;
	private float bothN;
	private float finalpercentage;
	
	//Making a scanner variable to call it later in the class
	//private Scanner scan;
	
	//Making a second list of Arrays called newlist
	ArrayList<Patient> newlist = new ArrayList<Patient>();
	ArrayList<Patient> seventylist = new ArrayList<Patient>();
	ArrayList<Patient> thirtylist = new ArrayList<Patient>();
 	
	
	/*
	 *Constructor of Calculations, it should take in the Base class along with 
	  the file it contains and the methods called within the class
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
	
	public Calculations()
	{
		Base newBase = new Base("C:\\Users\\CalculationBase.csv");
		
		newBase.OpenFile();
		seventylist = newBase.readfile();
		newBase.closeReadFile();
		
		
	}
	
	
	
	
	
	
	/*
	 * In the method below, the main calculations for the algorithm are being made.
	 * Every for loop increments by one each time it runs through the loop and finds that
	 * the value of i is bigger than the length of the array listARRAY. Each time it increments,
	 * it checks the file provided and the user input whether they match the criteria found below.
	 * If it doesn't, it goes to a different for loop. If it does, a counter becomes incremented by 1.
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
		
			
		overallY = (tempcountY/tonsilitiscountY)*(achecountY/tonsilitiscountY)*(throatcountY/tonsilitiscountY)*(tonsilitiscountY/18);
		overallN = (tempcountN/tonsilitiscountN)*(achecountN/tonsilitiscountN)*(throatcountN/tonsilitiscountN)*(tonsilitiscountN/18);	
			
		normaliser = (overallY) + (overallN);
		
		
		totalY = (overallY) / (normaliser);
		totalN = (overallN) / (normaliser);
		
		
		return(totalY);	
		
		
	}//end of calc method
	
	
	public float acc()
	{
		seventy = (float)(13 * 0.7);
		Math.round(seventy);
		System.out.println(seventy);
		
		
		thirty = (float)(newlist.size() - seventy);
		Math.round(thirty);
		
		
		
		bothY = 0;
		bothN = 0;
		accYcount = 0;
		accNcount = 0;
		totalY = 0;
		totalN = 0;
		normaliser = 0;
		finalpercentage = 0;
		
		for(int j = 0; j < seventy; j++)
		{
			seventylist.add(newlist.get(j));
		}//end of for loop
		
		for(int j = (int)(seventy) ; j < newlist.size(); j++)
		{
			thirtylist.add(newlist.get(j));
		}//end of for loop
		
		
		newlist.clear();

		
		for(int j = 0; j < seventy; j++)
		{
			newlist.add(seventylist.get(j));
		}//end of for loop
		
		System.out.println();
		
		for(int j = 0; j < thirtylist.size(); j++)
		{
			calc();
			
			
			if(totalY >= 0.5)
			{
				accYcount++;
				accY = "Yes";
				if(accY.equals("Yes") && thirtylist.get(j).getTonsilitis().equals("Yes"))
				{
					bothY++;
					System.out.println(bothY);
				}//end of nested if()
				
			}//end of if()
			
			if(totalN >= 0.5)
			{
				accNcount++;
				accN = "No";
				if(accN.equals("No") && thirtylist.get(j).getTonsilitis().equals("No"))
				{
					bothN++;
					System.out.println(bothN);
				}//end of nested if()
				
				
			}//end of if()
			
			
		}//end of for loop
		
		normaliser = bothY + bothN;
		
		finalpercentage = (bothY) / (normaliser);
		
		return bothY;
		
		
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



	
	

