import java.util.*;

public class Lab3
{
	public static void main (String [] args)
	{
		Scanner inScan = new Scanner(System.in);
		
		int b;
		int X;
		int i = 0;
		
		
		do
			{
				//Asks the user to enter an integer base b > 1 (if the number is <= 1 you should quit the program)
				System.out.print("Enter an integer base greater than 1. \n > ");
				b = inScan.nextInt();
		
				if (b <= 1)
					{
						System.exit(0);
						
					}
				
				//Asks the user to enter a positive integer X.  Numbers <= 0 should be rejected and the user must re-enter.
				System.out.print("Enter a positive integer X. \n > ");
				X = inScan.nextInt();
				
				//reject numbers <= 0 and reenter
				while (X<=0)
					{
						System.out.print("Invalid input. Please enter a positive integer. \n > ");
						X = inScan.nextInt();
						
					}
				
				int calc = X;
				//calculate the floor of logbX and display
				do
					{
						calc = calc/b;
						i = i+1;
						
					}while(b<=calc);
					
				System.out.println("The log" + b + "(" + X + ")"+ " is " + i + "\n");
				
				i = 0;
				calc = 0;
			
			}while(b>1);
			
	}
} 
	
			
				
		
