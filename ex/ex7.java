/* CS 0401 Fall 2019 Java Example 7
   This example demonstrates simple static method calls in Java, and
   shows how value parameters work.  It also shows local variables and
   their scope.
*/
import java.util.Scanner;
public class ex7
{
	public static void main (String [] args)
	{
		Scanner theInput = new Scanner(System.in);
		System.out.print("Enter the radius: ");
		double rad = theInput.nextDouble();
		double theArea = area(rad);  // double theArea = ex7.area(rad);
			// would also work, but the ex7 class name is not necessary
			// since area() is in the same class as main()
		System.out.println("The area is " + theArea);

		System.out.print("Enter the base: ");
		int base = theInput.nextInt();
		System.out.print("Enter the max exponent: ");
		int exp = theInput.nextInt();
		showPowers(base, exp);	// showPowers is called as a procedure
			// rather than a function.  Note that we are not using a
			// result (since the method is void)
		System.out.println("Base is " + base);
			// A paramater within showPowers, called "base", was changed
			// inside the method.  However, that change has no effect on
			// the argument.  Note also that the names of the parameters
			// in the methods do not have to match the names of the
			// arguments (and in fact the argument in many cases does not
			// even have to be a variable) 

		int first = 10; int second = 20;
		System.out.println("First: " + first + " Second: " + second);
		noOpSwap(first, second);
		System.out.println("First: " + first + " Second: " + second);
		//System.out.println("temp = " + temp);
			// The above line will produce an error, since the variable
			// temp is local to the noOpSwap method.  Remove the comments
			// above to see the error.
	}

	// Note: Math.PI is a constant that is defined in the Math class
	// This method is a function, since its purpose is to return a
	// value
	public static double area(double radius)
	{
		double ans = Math.PI * radius * radius;
		return ans;
	}

	// This method is a procedure, since its purpose is to perform
	// some task, rather than to return a value
	public static void showPowers(int base, int N)
	{
		int val = 1;
		int i;  // declare loop control variable i
		for (i = 0; i <= N; i++)
		{
			System.out.println(base + "^" + i + " = " + val);
			val *= base;
		}
		System.out.println("i = " + i); // Note value after loop
		
		// Let's do it again, but now by declaring the loop control
		// variable within the loop
		val = 1;
		for (int j = 0; j <= N; j++)
		{
			System.out.println(base + "^" + j + " = " + val);
			val *= base;
		}
		//System.out.println("j = " + j); // Error!  Variables declared within
					// a for loop are local to the loop (even those declared
					// in the loop header
		base = 1000;
		
	}

	// This method will swap the parameters as shown.  However, since
	// they were passed by value, the swap has no effect on the
	// arguments, as shown with the output in the main
	public static void noOpSwap(int one, int two)
	{
		System.out.println("One: " + one + " Two: " + two);
		int temp = one;
		one = two;
		two = temp;
		System.out.println("One: " + one + " Two: " + two);
	}
}
