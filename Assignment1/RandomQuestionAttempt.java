
//import scanner class
import java.util.*;

//import random
import java.util.Random;

public class RandomQuestionAttempt
{
  public static void main (String [] args)
  {
	Scanner inScan = new Scanner(System.in);
	Random rand = new Random();
	
	// Obtain a number between [0 - 14].
	int n = rand.nextInt(15);

	// Add 1 to the result to get a number from the required range
	// (i.e., [1 - 15]).
	n += 1;
	
	String pass = "unknown";
	String pass1 = "unknown";
	String pass2 = "unknown";
	
	if (n == 1)
		{
			System.out.print("What kind of mythical creature is Fawkes?	\n > ");
			//phoenix
			pass = inScan.next();
			
			if (pass.equalsIgnoreCase("phoenix"))
				{
					pass = "correct";
				}
			else
				{
					pass = "incorrect";
				}
			
		}
	if (n == 2)
		{
			System.out.print("What is the last name of the man who created the Sorceror's Stone? \n > ");
			//flamel
			pass = inScan.next();
			
			if (pass.equalsIgnoreCase("flamel"))
				{
					pass = "correct";
				}
			else
				{
					pass = "incorrect";
				}
			
		}
	if (n == 3)
		{
			System.out.print("Monkshood and wolfsbane are the same plant, also known as what? \n > ");
			//aconite
			pass = inScan.next();
			
			if (pass.equalsIgnoreCase("aconite"))
				{
					pass = "correct";
				}
			else
				{
					pass = "incorrect";
				}
		}
	if (n == 4)
		{
			System.out.print("What did Hagrid name the three-headed dog guarding the Sorceror's Stone? \n > ");
			//fluffy
			pass = inScan.next();
			
			if (pass.equalsIgnoreCase("fluffy"))
				{
					pass = "correct";
				}
			else
				{
					pass = "incorrect";
				}
		}
	if (n == 5)
		{
			System.out.println("What is the term for a witch or wizard who has the ability to change their appearance at will? \n > ");
			//metamorphmagus
			pass = inScan.next();
			
			if (pass.equalsIgnoreCase("metamorphmagus"))
				{
					pass = "correct";
				}
			else
				{
					pass = "incorrect";
				}
		}
	if (n == 6)
		{
			System.out.print("What is the type of small golden bird used in early Quidditch as the Snitch? \n > ");
			//snidget
			pass = inScan.nextLine();
			
			if (pass.equalsIgnoreCase("snidget"))
				{
					pass = "correct";
				}
			else if (pass.equalsIgnoreCase("golden snidget"))
				{
					pass = "correct";
				}
			else
				{
					pass = "incorrect";
				}
		}
	if (n == 7)
		{
			System.out.print("What potion allows the drinker to assume the appearance of someone else? \n > ");
			//polyjuice
			pass = inScan.next();
			
			if (pass.equalsIgnoreCase("polyjuice"))
				{
					pass = "correct";
				}
			else if (pass.equalsIgnoreCase("polyjuice potion"))
				{
					pass = "correct";
				}
			else
				{
					pass = "incorrect";
				}
		}	
	if (n == 8)
		{
			System.out.print("What potion can be used as a truth serum? \n > ");
			//veritaserum
			pass = inScan.next();
			
			if (pass.equalsIgnoreCase("veritaserum"))
				{
					pass = "correct";
				}
			else
				{
					pass = "incorrect";
				}
		}	
	if (n == 9)
		{
			System.out.print("What is the term for a witch or wizard who can transform themselves into an animal and back again at will? \n > ");
			//animagus
			pass = inScan.next();
			
			if (pass.equalsIgnoreCase("animagus"))
				{
					pass = "correct";
				}
			else
				{
					pass = "incorrect";
				}
		}	
	if (n == 10)
		{
			System.out.print("What herb root can be used to cure petrification? \n > ");
			//mandrake
			pass = inScan.next();
			
			if (pass.equalsIgnoreCase("mandrake"))
				{
					pass = "correct";
				}
			else if (pass.equalsIgnoreCase("mandrake root"))
				{
					pass = "correct";
				}
			else
				{
					pass = "incorrect";
				}
		}		
	if (n == 11)
		{
			System.out.print("What magical creature's presence is indicative of a tree with wood of high enough quality for wandmaking?  \n > ");
			//bowtruckles
			pass = inScan.next();
			
			if (pass.equalsIgnoreCase("bowtruckes"))
				{
					pass = "correct";
				}
			else
				{
					pass = "incorrect";
				}
		}	
	if (n == 12)
		{
			System.out.print("What is Gubraithian Fire is also known as?  \n > ");
			//everlasting fire
			pass = inScan.next();
			
			if (pass.equalsIgnoreCase("everlasting fire"))
				{
					pass = "correct";
				}
			else
				{
					pass = "incorrect";
				}
		}	
	if (n == 13)
		{
			System.out.print("What year do Unicorns grow horns? (enter as a single number) \n > ");
			//4
			pass = inScan.next();
			
			if (pass.equalsIgnoreCase("4"))
				{
					pass = "correct";
				}
			else
				{
					pass = "incorrect";
				}
		}	
	if (n == 14)
		{
			System.out.print("How many staircases does Hogwarts Castle contain? \n > ");
			//142
			pass = inScan.next();
			
			if (pass.equalsIgnoreCase("142"))
				{
					pass = "correct";
				}
			else
				{
					pass = "incorrect";
				}
		}	
	if (n == 15)
		{
			System.out.print("Looks like someone drank some Felix Felicis or it's just your lucky day! \nYou will receive discounted prices without needing to answer a question. \nHappy shopping! ");
					pass = "correct";
		}		
		
		System.out.println(pass);
  }
}
