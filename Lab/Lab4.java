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
		Random rand = new Random();
		
		//create the Random object, then enter a conditional loop.  
		//At each iteration of the loop ask the user to enter the 
		//number of rolls desired and call RollDice with the appropriate parameters.  
		//Then ask the user if he/she wants to continue.  If so, 
		//repeat the process; if not terminate the program.
		
		//int random = rand.nextInt(12);
		
		//int random = 0; 
		
		int rolls;
		int cont;
		
		do {
			System.out.println("Enter the number of rolls desired: ");
			rolls = inScan.nextInt();
			RollDice(rolls, rand);
			
			System.out.println("\nContinue? Y = yes, N = no)");
			cont = inScan.next().toUpperCase().charAt(0);	
		} while (cont == 'Y');
	}
	
	
	public static void RollDice(int rolls, Random rand)
	{
		//do the "rolls" and count how many times each number comes up.
		//Then print out the number of times each number comes up and 
		//its fraction out of all of the rolls.
		int [] sumCounter = new int[13];

		for (int index = rolls; index > 0; index--) {
			//int die1 = (int)(Math.random() * 6) + 1;
			//int die2 = (int)(Math.random() * 6) + 1;
			int random = rand.nextInt(6) + 1 + rand.nextInt(6) + 1;
		    sumCounter[random]++;
		}
		
		System.out.println("The number ");
		
		for (int i = 2; i <= 12; i++) 
			System.out.println(i + " occurs " + sumCounter[i] + " times." );
		
		System.out.print("out of " + rolls);
	}
}
