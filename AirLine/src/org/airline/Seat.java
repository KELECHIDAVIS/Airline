package org.airline;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Seat extends JPanel
{
	public int number; 
	public boolean taken=false; 
	public int clss; 

	public Seat(int number)
	{
		this.setPreferredSize(new Dimension(150, 150));
		this.setBorder(BorderFactory.createBevelBorder(0));
		JLabel label = new JLabel(String.valueOf(number+1)); 
		label.setFont(new Font("MV Boli", Font.BOLD,55 )); 
		this.add(label); 
		this.setBackground(Color.gray);
		this.number = number; 
		if(this.number>4)
		{
			this.clss = 2 ;
		}else
		{
			this.clss=1; 
		}
	}
	
	public void reserve()
	{
		System.out.println("SEAT NUMBER: "+(this.number+1));
		this.setBackground(Color.red);
		if(this.clss==1)
		{
			System.out.println("CLASS: ECONOMY");
		}else
		{
			System.out.println("CLASS: FIRST-CLASS");
		}
		
		this.taken=true; 
	}

	public int getNumber()
	{
		return number;
	}

	public void setNumber(int number)
	{
		this.number = number;
	}

	public boolean isTaken()
	{
		return taken;
	}

	public void setTaken(boolean taken)
	{
		this.taken = taken;
	}

	public int getClss()
	{
		return clss;
	}

	public void setClss(int clss)
	{
		this.clss = clss;
	}
	
	
}
