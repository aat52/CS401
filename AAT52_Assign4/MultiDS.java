// CS 0401 Fall 2019
// Shell of MultiDS<T> class to be used with Assignment 4.
// You must complete this class so that:
// 1) It works with test program Assig4A.java
// 2) You can use it in your War program

import java.io.*;
import java.util.*;
public class MultiDS<T> implements PrimQ<T>, Reorder
{
	private T [] theData;  // Note that the data is an array of T
	// You will also need one or more state variables to keep track of your
	// logical data.  The variables you need depend on how you will manage
	// your queue.
	
	private Random R;  // This is needed so that you can shuffle your data

	public MultiDS(int sz)
	{
		theData = (T []) new Object[sz];  // Note how this is created
		R = new Random();
		// You will also need to initialize your other state variable(s).
		// You will need to create a new array in a similar way in your
		// resize() method.
	}

	// Below you should implement all of the methods in the PrimQ<T> and Reorder
	// interfaces.  See the details for these methods in files PrimQ.java and
	// Reorder.java.  See how these are actually used in the test program Assig4A.java.
	// Once you have completed this class the program Assig4A.java should compile and
	// run and give output identical to that shown in file A4Out.txt (except for the
	// order of the data after shuffling, since that should be random).
	
private int size;
	
	public boolean addItem(T item) {
		if (full())
			resize();
		
		theData[size] = item;
		size++;
		
		return true;
	}
	
	private void resize() {
			T[] tempI = (T[]) new Object[theData.length*2];
			
			for (int i = 0; i < size; i++)
				tempI[i] = theData[i];
			
			theData = tempI;
	}
	
	public T removeItem() {
		if (empty())
			return null;
		
		T item = (T) theData[0];
		shiftLeft();
		size--;
		
		return item;
	}
	
	public boolean full() {
		if (size == theData.length)
			resize();
		
		return (size == theData.length);
	}
	
	public boolean empty() {
		return (size == 0);
	}
	
	public int size() {
		return size;
	}
	
	public void clear() {
		size = 0;
	}
	
	public void reverse() {
		T[] temp = (T[]) new Object[theData.length];
		
		for (int i = 0; i < size; i++)
			temp[size - 1 - i ] = theData[i];
		
		theData = temp;
	}

	public void shiftRight() {
		T temp = theData[size - 1];
		
		for (int i = size; i > 0; i--)
			theData[i] = theData[i - 1];
		
		theData[0] = temp;
		
	}
	
	public void shiftLeft() {
		T temp = theData[0];
		
		for (int i = 0; i < size - 1; i++)
			theData[i] = theData[i+1];
		
		theData[size - 1] = temp;
		
	}
	
	public void shuffle() {
		for (int i = 0; i < size; i++) {
			int random = R.nextInt(size);
			
			T temp = theData[i];
			theData[i] = theData[random];
			theData[random] = temp;
		}
	}
	
	public String toString() {
		String output = "Contents: \n";
		
		for (int i = 0; i < size; i++)
			output += theData[i] + " ";
		
		return output;
	}
}