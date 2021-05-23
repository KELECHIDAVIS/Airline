package org.airline;

import java.awt.GridLayout;
import java.util.Scanner;

import javax.swing.JFrame;

public class Main
{
	public static void main(String[] args)
	{
		Seat[] seats = filler(); 
		boolean finish=false; 
		JFrame frame = new JFrame(); 
		frame.setLocationRelativeTo(null);
		frame.setLayout(new GridLayout(5, 2));
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fillFrame(frame, seats); 
		frame.pack(); 
				
				
				
		
		while(!finish)
		{
			boolean asking = true; 
			System.out.println("Which seating class would you like? \n(1:ECONOMY   2:FIRST-CLASS)");
			Scanner sc = new Scanner(System.in); 
			int choice = sc.nextInt(); 
			sc.nextLine(); 
			finder(seats, choice); 
			
			
			
			while(asking)
			{
				System.out.println("Would you like another seat?(yes/no)");
				String answer= sc.nextLine(); 
				if(answer.equals("yes"))
				{
					break; 
				}else if(answer.equals("no"))
				{
					finish = true; 
					break; 
				}
			}
		}
		
		System.out.println("Your seats are: ");
		for(int i=0;i<seats.length; i++)
		{
			if(seats[i].isTaken())
			{
				System.out.print((seats[i].getNumber()+1)+", ");
			}
		}
				
	}
	
	public static void fillFrame(JFrame frame, Seat[] seats)
	{
		for(int i = 0; i<seats.length; i++)
		{
			frame.add(seats[i]); 
		}
	}
	
	
	//fills the seats
	public static Seat[] filler()
	{
		Seat[] seats = new Seat[10]; 
		for(int i=0;i<seats.length; i++)
		{
			seats[i]=new Seat(i); 
		}
		
		return seats; 
	}
	public static void finder(Seat[] seats, int clss)
	{
		boolean found =false; 
		for(int i = 0; i<seats.length;i++)
		{
			if(seats[i].clss==clss&&seats[i].taken==false)
			{
				seats[i].reserve();
				found = true; 
				break; 
			}
		}
		if(!found)
		{
			System.out.println("There are no open seats that fit your criteria. Would you like to switch to a different seating class?(yes/no)");
			Scanner s = new Scanner(System.in);
			String choice = s.nextLine(); 
			if(choice.equals("yes"))
			{
				boolean secondFound =false; 
				for(int i = 0; i<seats.length;i++)
				{
					if(seats[i].taken==false)
					{
						seats[i].reserve();
						secondFound = true; 
						break; 
					}
				}
				if(secondFound==false)
				{
					System.out.println("Sorry but this plane is full. The next flight is in 3 hours.");
				}
			}else
			{
				System.out.println("Next Flight In 3 Hours");
			}
		}
	}
}
