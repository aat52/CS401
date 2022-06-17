// CS 401 Fall 2019
// MyDeque class to implement a simple deque
// Complete the methods indicated.  Be careful about the
// special cases indicated.  See lab for details on how
// to implement the methods.

public class MyDeque implements SimpleDeque
{
	Object [] theData;
	int numItems;

	public MyDeque(int maxItems)
	{
		theData = new Object[maxItems];
		numItems = 0;
	}
	
	public boolean isEmpty()
	{
		return (numItems == 0);
	}
	
	public void addFront(Object X)
	{
		// Add new item at front of list (shifting old items
		// to right first).  If the list is full, do not add
		// the item (just do nothing).
		if (numItems == theData.length){
			return;
		}
		else{
			for (int i = numItems; i > 0; i--) {                
				theData[i] = theData[i-1];
			}	
		numItems++;
		theData[0] = X;
		}
	}

	public void addRear(Object X)
	{
		// Add new item at rear of list.  If the list is full,
		// do not add the item (just do nothing).
		if (numItems == theData.length){
			return;
		}
		else{
			//System.out.println(X);
			theData[numItems++] = X;
			//System.out.println(theData[numItems-1]);
		}
			
	}

	public Object removeFront()
	{
		// Remove and return front item from list, shifting remaining
		// items to the left to fill the spot.  If list is empty,
		// return null.
		
		if (isEmpty()){
			return null;
		}
		else{
			Object t = theData[0];
			
			for (int i = 0; i < numItems - 1; i++) {                
				theData[i] = theData[i+1];
			}	
			theData[--numItems] = null;
			return t;
		}
	}

	public Object removeRear()
	{
		// Remove and return rear item from list.  If list is empty,
		// return null.
		//boolean ans = theData.isEmpty();
		//if (ans == true){
		if (isEmpty()){
			return null;
		}
		else{
			return theData[--numItems];
		}
	}
	
	
	public String toString() {
		String output = "The data: ";
		
		for (int i = 0; i < theData.length; i++) {
			output += theData[i] + "\t";
		}
		return output + "\n";
	}
}
