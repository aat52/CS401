/*Write a static void method called RollDice 
that has two parameters: an int and a random.  
The int parameter determines how many times to 
roll the dice and the Random is used to generate 
the actual values. 
 
*/

//import scanner class
import java.util.*;

//import random
import java.util.Random;

public class Lab4 
{
	public static void main (String [] args)
	{
		Scanner inScan = new Scanner(System.in);
		//Random rand = new Random();
		
		//create the Random object, then enter a conditional loop.  
		//At each iteration of the loop ask the user to enter the 
		//number of rolls desired and call RollDice with the appropriate parameters.  
		//Then ask the user if he/she wants to continue.  If so, 
		//repeat the process; if not terminate the program.
		
		//int random = rand.nextInt(12);
		
		int random = 0; 
		
		int rolls;
		int cont;
		
		do
		{
			System.out.println("Enter the number of rolls desired: ");
			rolls = inScan.nextInt();
			RollDice(rolls, random);
			
			System.out.println("\nContinue? (1 = yes, 2 = no)");
			cont = inScan.nextInt();
			
		}while(cont ==1);
		
	  
	}
	
	
	public static void RollDice(int rolls, int random)
	{
		//do the "rolls" and count how many times each number comes up.
		//Then print out the number of times each number comes up and 
		//its fraction out of all of the rolls.
		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;
		int e = 0;
		int f = 0;
		int g = 0;
		int h = 0;
		int i = 0;
		int j = 0;
		int k = 0;
		int rolls1 = rolls;
		
		int die1;
		int die2;
		
		do
		{
			die1 = (int)(Math.random()*6) + 1;
			die2 = (int)(Math.random()*6) + 1;
			random = die1+die2;
			
			while (random == 1)
				{
					random = random + 1;
				}
			
			if (random == 2)
				{
					a = a + 1;
				}
			if (random == 3)
				{
					b = b + 1;
				}
			if (random == 4)
				{
					c = c + 1;
				}
			if (random == 5)
				{
					d = d + 1;
				}
			if (random == 6)
				{
					e = e + 1;
				}
			if (random == 7)
				{
					f = f + 1;
				}
			if (random == 8)
				{
					g = g + 1;
				}
			if (random == 9)
				{
					h = h + 1;
				}
			if (random == 10)
				{
					i = i + 1;
				}
			if (random == 11)
				{
					j = j + 1;
				}
			if (random == 12)
				{
					k = k + 1;
				}
			
			rolls = rolls - 1;
			
		}while(rolls > 0);
		
			System.out.println("The number ");
		
			System.out.println(2 + " occurs " + a + " times" );
			System.out.println(3 + " occurs " + b + " times" );
			System.out.println(4 + " occurs " + c + " times" );
			System.out.println(5 + " occurs " + d + " times" );
			System.out.println(6 + " occurs " + e + " times" );
			System.out.println(7 + " occurs " + f + " times" );
			System.out.println(8 + " occurs " + g + " times" );
			System.out.println(9 + " occurs " + h + " times" );
			System.out.println(10 + " occurs " + i + " times" );
			System.out.println(11 + " occurs " + j + " times" );
			System.out.println(12 + " occurs " + k + " times" );
			System.out.print("out of " + rolls1);
		
		
	}
	  
	  
	  
  
}
