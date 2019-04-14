/*
 *Java Machine Learning Assignment
 *Author: Adrian Borkowski C17384436
 *Description: This class is used to store a patient and all of the patients data so that it is easier to call the values later on in other classes
 *
 */

package com.javaassignment.test;

public class Patient
{

	//Attributes - Strings
	private String temperature;
	private String aches;
	private String sorethroat;
	private String tonsilitis;
	
	//contructor which passes in the the four variables used for data storage for patients
	public Patient(String temperature, String aches, String sorethroat, String tonsilitis)
	{
		this.setTemperature(temperature);
		this.setAches(aches);
		this.setSorethroat(sorethroat);
		this.setTonsilitis(tonsilitis);
		
		
	}
	
	//a tostring which returns a list of strings to display when a Patient is called
	public String toString() 
	{	
		
		return "Temperature: " + getTemperature() + ", Aches: " + getAches() + ", Sore Throat: " + getSorethroat()
				+ ", Tonsilitis: " + getTonsilitis() + "";
	}


	
	//setters and getters
	
	public String getTemperature() {
		return temperature;
	}


	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}


	public String getAches() {
		return aches;
	}


	public void setAches(String aches) {
		this.aches = aches;
	}


	public String getSorethroat() {
		return sorethroat;
	}


	public void setSorethroat(String sorethroat) {
		this.sorethroat = sorethroat;
	}


	public String getTonsilitis() {
		return tonsilitis;
	}


	public void setTonsilitis(String tonsilitis) {
		this.tonsilitis = tonsilitis;
	}
	
	
}
