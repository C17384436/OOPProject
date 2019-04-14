package com.javaassignment.test;

public class Patient
{

	private String temperature;
	private String aches;
	private String sorethroat;
	private String tonsilitis;
	
	public Patient(String temperature, String aches, String sorethroat, String tonsilitis)
	{
		this.setTemperature(temperature);
		this.setAches(aches);
		this.setSorethroat(sorethroat);
		this.setTonsilitis(tonsilitis);
		
		
	}
	
	
	public String toString() 
	{	
		
		return "Temperature: " + getTemperature() + ", Aches: " + getAches() + ", Sore Throat: " + getSorethroat()
				+ ", tonsilitis=" + getTonsilitis() + "]";
	}


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
