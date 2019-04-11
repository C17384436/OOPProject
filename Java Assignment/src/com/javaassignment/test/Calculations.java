package com.javaassignment.test;

public class Calculations
{
	private float ptempY;
	private float ptempN;
 	private float pachesY;
 	private float pachesN;
 	private float pthroatY;
 	private float pthroatN;
 	private float ptonsY;
 	private float ptonsN;
 	
 	private int hotcount;
 	private int coolcount;
 	private int normalcount;
 	private int acheYcount;
	private int acheNcount;
	private int throatYcount;
	private int throatNcount;
	private int tonsYcount;
	private int tonsNcount;
	
 	private String temperature;
 	private String aches;
 	private String sorethroat;
 	private String tonsilitis;
 	
	public Calculations(String tempval, String acheval, String throatval, String[] listARRAY)
	{
		
		for(int i = 0; i > listARRAY.length; i++)
		{
			if(list[0].equals(tempval) && list[4].equals("Yes")
			{
				hotcount++;
				tonsYcount++;
			}
		}
		
		if(achecheck == "Yes")
		{
			for(int i = 0; i > acheYcount; i++ )
			{
				acheYcount++;
			}
		}
		
		if(achecheck == "No")
		{
			for(int i = 0; i > acheNcount; i++ )
			{
				acheNcount++;
			}
		}
		
		if(throatcheck == "Yes")
		{
			for(int i = 0; i > throatYcount; i++ )
			{
				throatYcount++;
			}
		}
		
		if(throatcheck == "No")
		{
			for(int i = 0; i > throatNcount; i++ )
			{
				throatNcount++;
			}
			
		}
		
		if(tonscheck == "Yes")
		{
			for(int i = 0; i > tonsYcount; i++ )
			{
				tonsYcount++;
			}
			
		}
		
		if(tonscheck == "No")
		{
			for(int i = 0; i > tonsNcount; i++ )
			{
				tonsNcount++;
			}
		}
		
		
		
		
		ptempY = tempval/tonsYcount;
		ptempN = (hotcount / tonsNcount) | (coolcount / tonsNcount) | (normalcount / tonsNcount);
		
		pachesY = acheYcount / tonsYcount;
		pachesN = acheNcount / tonsNcount;
		
		pthroatY = throatYcount / tonsYcount;
		pthroatN = throatNcount / tonsNcount;
		
		if(tempval && acheval.equals("Yes") && throatval.equals("Yes"))
		{
			ptonsY = tempval * acheval * throatval;
			
		}
		else if( (tempcheck == "Hot" | tempcheck == "Cool" | tempcheck == "Normal" ) && achecheck !="Yes" && throatcheck != "Yes")
		{
			
			ptonsN =  (hotcount | coolcount | normalcount) + acheNcount + throatNcount;
		}
		
		
		System.out.println(ptonsY);
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

			Dividing both results by the evidence P(X) to normalise

			0.036 + 0.025 =

			0.061

			0.036/0.061= 0.059 = OVERALL YES OF YOU HAVING TONSLITIS
			0.025/0.061=0.041 = OVERALL NO OF YOU HAVING TONSLITIS

		 */

	}
}
