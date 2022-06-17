// CS 0401 Fall 2019
// This class contains two algorithms, binarySearch and sequentialSearch, for
// searching for an int within an array of int.  It is written in an object-oriented
// way, with the A and comps variables being instance variables.  The initData() 
// method is a mutator to put random data into the array.  The search methods themselves
// are both accessors to look for a key in the array.  Finally, the runTrials() method
// is an accessor / mutator that will test the search methods and output some results.
// See more details below. 

import java.util.*;
import java.util.Random;

public class Lab9
{
	private long comps;
	private int [] A;
	private Random R;  // Random variable to generate array data and test data
	private final int max = 1000000;  // maximum value for the data (to be used
						// with the random object)
	
	// Initialize the data in the Lab9 object.  Note that at this point the array
	// is all 0s.  We use a separate method to put the random data into the array.
	public Lab9(int size)
	{
		A = new int[size];
		comps = 0;
		R = new Random();
	}
	
	public void initData()
	{
		// Initialize array with pseudo-random data.  To
		// allow for a reasonable number of items to be found,
		// restrict the ints to be less than 100000
		for (int i = 0; i < A.length; i++)
		{
			A[i] = R.nextInt(max);
		}
		Arrays.sort(A);
	}
	
	// Text Author's version, but converted to an instance method
	// so that it can update the comps instance variable. 
	public int binarySearch(int value)
	{
		int first;       // First array element
		int last;        // Last array element
		int middle;      // Mid point of search
		int position;    // Position of search value
		boolean found;   // Flag

		int count = 0;
	  
		// Set the inital values.
		first = 0;
		last = A.length - 1;
		position = -1;
		found = false;
		// Search for the value.
		while (!found && first <= last)
		{
			// Calculate mid point
			middle = (first + last) / 2;
			// We always do at least one comparison in this loop
         	comps++;
			// If value is found at midpoint...
			if (A[middle] == value)
			{  // YAY!
				found = true;
				position = middle;
			}
			// else if value is in lower half...
			// ...we must do another comp
			else if (A[middle] > value)
			{
				comps++;
				last = middle - 1;
			}
			// else the value is in upper half....
			// Note that in the worst case we are doing 2 comps here, 
			// since the else does not require an explicit test of the data.
			else // if (array[middle] < value)
			{
				first = middle + 1;
			}
			count++;
		}
		return position;
	}

	// Simple sequential search as discussed in lecture.  It also updates the
	// comps variable.
	public int sequentialSearch(int value)
	{
		boolean found = false;
		int ctr = 0;
		int loc = -1;
		while (ctr < A.length && !found)
		{
			comps++;
			if (A[ctr] == value)
			{
				loc = ctr;
				found = true;
			}
			else
				ctr++;
		}
		return loc;
	}
	
 	// You must write this instance method.  It should do the following FOR
 	// EACH algorithm (binarySearch and sequentialSearch)
 	// 1) Initialize comps to 0
 	// 2) Execute a loop "tr" times, generating a random int in the range
 	//    0 to max and calling the search method on that int.  Record the
 	//    number of times the search was successful.
 	// 3) After the loop, output the following:
 	//       Algorithm Name
 	//       Number of trials done
 	//       Number of values that were found
 	//       Total comparisons done over all trials
 	//       Average comparisons done per trial
 	// See the sample output in file lab9out.txt
	public void runTrials(int tr)
	{
		//bin search
		int found = 0;
		comps = 0;
		for (int i = 0; i < tr; i++) {
			if (binarySearch(R.nextInt(max)) >= 0)
				found++;
		}
		
		System.out.println("Binary Search:");
		System.out.println("\tArray size: " + A.length);
		System.out.println("\t# of trials: " + tr);
		System.out.println("\tFound: " + found);
		System.out.println("\tTotal comps: " + comps);
		System.out.println("\tAve. comps: " + (double)comps / tr);
		
		// Sequential Search
		found = 0;
		comps = 0;
		for (int i = 0; i < tr; i++) {
			if (sequentialSearch(R.nextInt(max)) >= 0)
				found++;
		}
		
		System.out.println("Sequential Search:");
		System.out.println("\tArray size: " + A.length);
		System.out.println("\t# of trials: " + tr);
		System.out.println("\tFound: " + found);
		System.out.println("\tTotal comps: " + comps);
		System.out.println("\tAve. comps: " + (double)comps / tr);
	}
8
	public static void main(String[] args)
	{
 		Scanner S = new Scanner(System.in);
 		System.out.print("Array size: ");
 		int sz = S.nextInt();
 		Lab9 instance = new Lab9(sz);
 		instance.initData();
 		System.out.print("# of trials: " );
 		int trials = S.nextInt();
 		
 		// You must write the runTrials() method before this program will
 		// work. See details in the comments above.
 		instance.runTrials(trials);
 	}	
}
