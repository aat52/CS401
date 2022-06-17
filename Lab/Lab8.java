// CS 0401 Fall 2019
// Lab8 Driver program.  Your modified SimpleLList class should work with
// this class as is and should produce the same output as shown in file
// lab8out.txt

public class Lab8
{
	static String [] data = {"This", "is", "Lab", "Eight"};
	
	public static void main(String [] args)
	{
		SimpleLList list1 = new SimpleLList();
		SimpleLList list2 = new SimpleLList();
		SimpleLList list3 = new SimpleLList();
		
		for (int i = 0; i < data.length; i++)
		{
			list1.add(data[i]);
			list2.add(data[i]);
		}
		System.out.println("List 1: " + list1.toString());
		System.out.println("List 2: " + list2.toString());
		
		if (list1.equals(list2))
			System.out.println("Lists are equal");
		else
			System.out.println("Lists are NOT equal");
		
		list1.set(2, "Exercise");
		
		System.out.println("List 1: " + list1.toString());
		System.out.println("List 2: " + list2.toString());
		
		if (list1.equals(list2))
			System.out.println("Lists are equal");
		else
			System.out.println("Lists are NOT equal");
		
		list1.set(2, "Lab");
		list2.add("Output");
		
		System.out.println("List 1: " + list1.toString());
		System.out.println("List 2: " + list2.toString());
		
		if (list1.equals(list2))
			System.out.println("Lists are equal");
		else
			System.out.println("Lists are NOT equal");
			
		//test null
		System.out.println("Should print null \n" + list3.toString());
		
	}
}
