//Prompts the user to enter an integer and reads in the integer 
//(assume that the user will correctly input an integer)

import java.util.*; //access scanner class
import java.text.DecimalFormat;
	
public class Lab2
{

	public static void main (String [] args)
	{
		
		Scanner inScan = new Scanner(System.in);

		int userint;
		
		int usersecint;
		
		double user_doub;
		
		System.out.println("Please enter an integer: ");
		userint = inScan.nextInt(); 
		int last= (userint%10);
		System.out.println("The ones digit of " + userint + " is " + last);
		
		//second digit
		System.out.print("Please enter an integer: ");
		usersecint = inScan.nextInt(); 
		int sec_last= (usersecint%100)/10;
		System.out.println("The 2nd last digit of " + usersecint + " is " + sec_last);
		
		//round
		DecimalFormat df = new DecimalFormat("#.###");
		System.out.print("Please enter a double: ");
		user_doub = inScan.nextDouble(); 
		System.out.println("The number "+ user_doub + " rounded to 3 decimal places is " + df.format(user_doub));
		
	}
}
