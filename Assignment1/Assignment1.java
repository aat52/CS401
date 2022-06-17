/*Angela Tseng
1pm Ramirez
Assignment 1
The assignment is to write a Java program that will simulate transactions with customers at a WWW franchise.
Basic structure: 
	Large loop to accomodate multiple customers
	Ask for customer
	Display original prices 
	Ask participation for challenge -> 1 is yes, 2, is no, and anything else is assumed as a no
	Questions change randomly each transaction, answers are commented under the question in the code (extra credit)
	Send the customer to discounted prices or penalize them depending on answer
	Loop transaction and ask customer to choose between choices; add to order by typing in a positive integer, subtract
		by entering a negative integer
	Send to checkout, calculate penalty if needed
	Show original prices compared to discounted (extra credit)
	Loop until amount is paid in full
	Return the change in as few coins as possible
*/
 
//import scanner class
import java.util.*;

//import random
import java.util.Random;

public class Assignment1 
{
  public static void main (String [] args)
  {
    //display introduction
    System.out.println("Welcome to 'Weasleys' Wizard Wheezes'!");
    System.out.println("[Official Licensed Franchise of Honeydukes]");
	
	//variable
	int cust;
	
	//create scanner object
	Scanner inScan = new Scanner(System.in);
	
	Random rand = new Random();
	
	do
		{
			//ask if there is a customer 
			System.out.print("Is there a customer in line? (1 = yes, 2 = no) > ");
			cust = inScan.nextInt();
				
			//input validation
			while (cust != 1 && cust != 2)
				{
				System.out.print("Invalid value -- please try again \n > ");
				cust = inScan.nextInt();
				}
			if (cust == 2)
				{
				System.exit(0);
				}
				
				//display price list
				System.out.println("\nHere is our price list: ");
				System.out.println("\tPygmy Puffs (each)\t\t 10 Sickles (290 Knuts)");
				System.out.println("\tExtendable Ears\t\t\t\t      60 Knuts");
				System.out.println("\t\tbag of three\t\t\t     160 Knuts");
				System.out.println("\tTrick Wands (regular) \t\t3 Galleons (1479 Knuts)");
				System.out.println("\tTrick Wands (autograph) \t5 Galleons (2465 Knuts)");
				System.out.println("\nPlease remember: \n 29 Knuts == 1 Sickle \n 17 Sickles == 1 Galleon == 493 Knuts\n");
			
			//ask for participation
			int user_part;
			System.out.println("\nWould you like to participate in the challenge question?");
			System.out.println("\tThis gives you the chance to shop at a discounted price. \n\tHowever, if you answer incorrectly, a 10% penalty \n\t\twill be added to the final bill.");
			System.out.print("\tBeware, the questions vary in content and difficulty \n\t\teach time they are initiated. \n\tAre you up to the challenge? (1 = yes, 2 = no) > ");
			user_part = inScan.nextInt();
			
			//variables for choices
			int user_update;
			int PygPuffs = 0;
			int ExtEars = 0;
			int RegWands = 0;
			int AutWands = 0;
			
			//address password question
			if (user_part == 1)
				{
					System.out.println("\nYou have accepted the challenge! \nPlease enter your answer as a one word answer or number.");
					
					//ask for randomized password
					// Obtain a number between [0 - 14].
					int n = rand.nextInt(15);
					String pass = "unknown";
					
					// Add 1 to the result to get a number from the required range
					// (i.e., [1 - 15]).
					n += 1;
					
					if (n == 1)
						{
							System.out.print("\nWhat kind of mythical creature is Fawkes?	\n > ");
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
							System.out.print("\nWhat is the last name of the man who created the Sorceror's Stone? \n > ");
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
							System.out.print("\nMonkshood and wolfsbane are the same plant, also known as what? \n > ");
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
							System.out.print("\nWhat did Hagrid name the three-headed dog guarding the Sorceror's Stone? \n > ");
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
							System.out.print("\nWhat is the term for a witch or wizard who has the ability to change \n\ttheir appearance at will? \n > ");
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
							System.out.print("\nWhat is the type of small golden bird used in early Quidditch as the Snitch? \n > ");
							//snidget
							pass = inScan.next();
							
							if (pass.equalsIgnoreCase("snidget"))
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
							System.out.print("\nWhat potion allows the drinker to assume the appearance of someone else? \n > ");
							//polyjuice
							pass = inScan.next();
							
							if (pass.equalsIgnoreCase("polyjuice"))
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
							System.out.print("\nWhat potion can be used as a truth serum? \n > ");
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
							System.out.print("\nWhat is the term for a witch or wizard who can transform themselves \n\tinto an animal and back again at will? \n > ");
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
							System.out.print("\nWhat herb root can be used to cure petrification? \n > ");
							//mandrake
							pass = inScan.next();
							
							if (pass.equalsIgnoreCase("mandrake"))
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
							System.out.print("\nWhat magical creature's presence is indicative of a tree with wood of \n\thigh enough quality for wandmaking?  \n > ");
							//bowtruckles
							pass = inScan.next();
							
							if (pass.equalsIgnoreCase("bowtruckles"))
								{
									pass = "correct";
								}
							else if (pass.equalsIgnoreCase("bowtruckle"))
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
							System.out.print("\nWhat is Gubraithian Fire is also known as?  \n > ");
							//everlasting
							pass = inScan.next();
							
							if (pass.equalsIgnoreCase("everlasting"))
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
							System.out.print("\nWhat year do Unicorns grow horns? \n > ");
							//4
							pass = inScan.next();
							
							if (pass.equalsIgnoreCase("4"))
								{
									pass = "correct";
								}
							else if (pass.equalsIgnoreCase("four"))
								{
									pass = "correct";
								}
							else if (pass.equalsIgnoreCase("fourth"))
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
							System.out.print("\nHow many staircases does Hogwarts Castle contain? \n > ");
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
							System.out.print("\nLooks like someone drank some Felix Felicis or it's just your lucky day! \n\tYou will receive discounted prices without needing to answer a question. \nHappy shopping! ");
									pass = "correct";
						}		
				
				//check for answer
				if (pass.equalsIgnoreCase("correct"))
					{
						System.out.println("\nCongratulations! Enjoy our items at a discounted price.");
						System.out.println("----------------------------------------------------\n");
						
						//display prices
						System.out.println("Here is our discounted price list: ");
						System.out.println("\tPygmy Puffs (each)\t\t\t  9 Sickles (261 Knuts)");
						System.out.println("\tExtendable Ears\t\t\t\t\t      50 Knuts");
						System.out.println("\t\tbag of three\t\t\t 	     140 Knuts");
						System.out.println("\tTrick Wands (regular or autographed)\t3 Galleons (1479 Knuts)");
						System.out.println("\nPlease remember: \n 29 Knuts == 1 Sickle \n 17 Sickles == 1 Galleon == 493 Knuts");
						
						int user_choice;
						do
						{
							//ask for choice
							System.out.println("\n\nPlease choose an option: ");
							System.out.println("\t1) Update Pygmy Puffs Order");
							System.out.println("\t2) Update Extendable Ears Order");
							System.out.println("\t3) Update Trick Wands Order");
							System.out.println("\t4) Show Price List");
							System.out.print("\t5) Check Out \n > ");
							user_choice = inScan.nextInt();

							//begin choice
								if (user_choice == 1)
									{
										System.out.println("Here is your current Pygmy Puffs order:\n " + PygPuffs + " Pygmy Puffs ordered");
										System.out.println("\nYou may add to your order by entering a positive integer, or \n\tsubtract from it by entering a negative integer.");								
										System.out.print("\nHow many Pygmy Puffs would you like for: \n\t 9 Sickles each \n > ");
										user_update = inScan.nextInt();
										PygPuffs = PygPuffs + user_update;
									}
								else if (user_choice == 2)
									{
										System.out.println("Here is your current Extendable Ears order:\n " + ExtEars + " Extendable Ears ordered");
										System.out.println("\nYou may add to your order by entering a positive integer, or \n\tsubtract from it by entering a negative integer.");								
										System.out.println("\nHow many Extendable Ears would you like for: \n\t 50 Knuts each \n\t140 Knuts per bag of 3");
										System.out.print("(Please indicate the total number of Extendable Ears you would \n\tlike, the system will determine the amount of bags purchased.)\n > ");
										user_update = inScan.nextInt();
										ExtEars = ExtEars + user_update;
									}
								else if (user_choice == 3)
									{
										System.out.println("Here is your current Trick Wands order:\n " + RegWands + " Regular Wands ordered \n " + AutWands + " Autographed Trick Wands ordered");
										System.out.println("\nYou may add to your order by entering a positive integer, or \n\tsubtract from it by entering a negative integer.");								
										System.out.println("\nHow many regular Trick Wands would you like for: \n\t 3 Galleons");
										System.out.print("\tSince you correctly answered the challenge, the cost is \n\tthe same for regular wands and autographed wands. \n >");		
										user_update = inScan.nextInt();
										RegWands = RegWands + user_update;
										System.out.println("How many autographed Trick Wands would you like for: \n\t 3 Galleons");
										System.out.print("\tSince you correctly answered the challenge, the cost is \n\tthe same for regular wands and autographed wands. \n >");
										user_update = inScan.nextInt();
										AutWands = AutWands + user_update;
									}
								else if (user_choice == 4)
									{
										System.out.println("Here is our discounted price list: ");
										System.out.println("\tPygmy Puffs (each)\t\t\t  9 Sickles (261 Knuts)");
										System.out.println("\tExtendable Ears\t\t\t\t\t      50 Knuts");
										System.out.println("\t\tbag of three\t\t\t 	     140 Knuts");
										System.out.println("\tTrick Wands (regular or autographed)\t3 Galleons (1479 Knuts)");
										System.out.println("\nPlease remember: \n 29 Knuts == 1 Sickle \n 17 Sickles == 1 Galleon == 493 Knuts");
						
									}
						}while(user_choice != 5);
							
						if ((PygPuffs + ExtEars + RegWands + AutWands) > 0)
							{
								//checkout calculation
								int PygKnuts = PygPuffs*261;
								int PygPuffs1 = PygPuffs*1;
								int ExtEars1 = ExtEars*1;
								int ExtEarsEach = ExtEars%3;
								int ExtEarsEach1 = ExtEars%3;
								int ExtEarsEachKnuts = ExtEarsEach*50;
								int ExtEarsBag = ExtEars/3;
								int ExtEarsBag1 = ExtEars/3;
								int ExtEarsBagKnuts = ExtEarsBag*140;
								int RegKnuts = RegWands*1479;
								int RegWands1 = RegWands*1;
								int AutKnuts = AutWands*1479;
								int AutWands1 = AutWands*1;
								int TotKnuts = PygKnuts+ExtEarsEachKnuts+ExtEarsBagKnuts+RegKnuts+AutKnuts;
								int DiscKnuts = ((TotKnuts*10)/100);
								
								System.out.println("\n\nHere is your current overall order:");
								do
									{
										if (PygPuffs > 0)
											{
												System.out.println(PygPuffs + " Pygmy Puffs at 9 Sickles (261 Knuts) each: \t" + (PygPuffs*9) + " Sickles  (" + (PygKnuts) + " Knuts) ");
												TotKnuts = TotKnuts - PygKnuts;
												PygPuffs = 0;
											}
										else if (ExtEarsEach > 0)
											{
												System.out.println(ExtEarsEach + " Extendable Ears at 50 Knuts each: \t\t\t   (" + (ExtEarsEachKnuts) + " Knuts)");
												TotKnuts = TotKnuts - ExtEarsEachKnuts;
												ExtEarsEach = 0;
											}
										else if (ExtEarsBag > 0)
											{
												System.out.println(ExtEarsBag + " Extendable Ears bag at 140 Knuts per bag: \t\t   (" + (ExtEarsBagKnuts) + " Knuts)");
												TotKnuts = TotKnuts - ExtEarsBagKnuts;
												ExtEarsBag = 0;
											}
										else if (RegWands > 0)
											{
												System.out.println(RegWands + " Regular Trick Wands each: \t\t\t" + (RegWands*3) + " Galleons ("+ (RegKnuts) + " Knuts) ");
												TotKnuts = TotKnuts - RegKnuts;
												RegWands = 0;
											}
										else if (AutWands > 0)
											{	
												System.out.println(AutWands + " Autographed Trick Wands each: \t\t" + (AutWands*3) + " Galleons (" + (AutKnuts) + " Knuts) ");
												TotKnuts = TotKnuts - AutKnuts;
												AutWands = 0;
											}
											
									}while(TotKnuts > 0);
									
									TotKnuts = PygKnuts+ExtEarsEachKnuts+ExtEarsBagKnuts+RegKnuts+AutKnuts;
								
								System.out.println("-----------------------------------------------------------------------");
								System.out.println("Total:\t\t\t\t\t\t\t    "+(TotKnuts) + " Knuts");
								
								//view order without discount
								int PygKnuts2 = PygPuffs1*290;
								int ExtEarsEach2 = ExtEars1%3;
								int ExtEarsEachKnuts2 = ExtEarsEach1*60;
								int ExtEarsBag2 = ExtEars1/3;
								int ExtEarsBagKnuts2 = ExtEarsBag1*160;
								int RegKnuts2 = RegWands1*1479;
								int AutKnuts2 = AutWands1*2465;
								int TotKnuts2 = PygKnuts2+ExtEarsEachKnuts2+ExtEarsBagKnuts2+RegKnuts2+AutKnuts2;
								
								System.out.println("\n\nThis is what your order would have looked like without the discount:");
								
										if (PygPuffs1 > 0)
											{
												System.out.println(PygPuffs1 + " Pygmy Puffs at 10 Sickles (290 Knuts) each: \t " + (PygPuffs1*10) + " Sickles (" + (PygKnuts2) + " Knuts) ");
												TotKnuts2 = TotKnuts2 - PygKnuts2;	
											}
										if (ExtEarsEach1 > 0)
											{
												System.out.println(ExtEarsEach1 + " Extendable Ears at 60 Knuts each: \t\t\t   (" + (ExtEarsEachKnuts2) + " Knuts)");
												TotKnuts2 = TotKnuts2 - ExtEarsEachKnuts2;	
											}
										if (ExtEarsBag1 > 0)
											{
												System.out.println(ExtEarsBag1 + " Extendable Ears bag at 160 Knuts per bag: \t\t   (" + (ExtEarsBagKnuts2) + " Knuts)");
												TotKnuts2 = TotKnuts2 - ExtEarsBagKnuts2;	
											}
										if (RegWands1 > 0)
											{
												System.out.println(RegWands1 + " Regular Trick Wands each: \t\t\t" + (RegWands1*3) + " Galleons ("+ (RegKnuts2) + " Knuts) ");
												TotKnuts2 = TotKnuts2 - RegKnuts2;	
											}
										if (AutWands1 > 0)
											{	
												System.out.println(AutWands1 + " Autographed Trick Wands each: \t\t" + (AutWands1*5) + " Galleons (" + (AutKnuts2) + " Knuts) ");
												TotKnuts2 = TotKnuts2 - AutKnuts2;	
											}
											
									TotKnuts2 = PygKnuts2+ExtEarsEachKnuts2+ExtEarsBagKnuts2+RegKnuts2+AutKnuts2;
									
								//display savings
								int Saved = TotKnuts2-TotKnuts;
								int gall = Saved/493;
								int sickle = (Saved%493)/29;
								int knut = Saved%29;
								
								if (TotKnuts2 > TotKnuts)
									{
										System.out.println("\nYou have saved: ");
										if (PygKnuts2 > PygKnuts)
											{
												System.out.println((PygKnuts2-PygKnuts) + " Knuts on Pygmy Puffs");
											}
										if (ExtEarsEachKnuts2 > ExtEarsEachKnuts)
											{
												System.out.println((ExtEarsEachKnuts2-ExtEarsEachKnuts) + " Knuts on Extendable Ears");
											}
										if (ExtEarsBagKnuts2 > ExtEarsBagKnuts)
											{
												System.out.println((ExtEarsBagKnuts2-ExtEarsBagKnuts) + " Knuts on Extendable Ears");
											}
										if (RegKnuts2 > RegKnuts)
											{
												System.out.println(+ (RegKnuts2-RegKnuts) + " Knuts on Regular Trick Wands");
											}
										if (AutKnuts2 > AutKnuts) 
											{
												System.out.println(+ (AutKnuts2-AutKnuts) + " Knuts on Autographed Trick Wands");
											}
									}
								
								System.out.println("You have saved " + Saved + " Knuts in total!");
								System.out.print("That's");
								if (gall > 0)
									{
										System.out.print(" " + gall + " Galleons");
									}
								if (sickle > 0 )
									{
											System.out.print(" " + sickle + " Sickles");
									}
								if (knut > 0)
									{
										System.out.print(" " +knut + " Knuts");
									}
								System.out.print("!");
									
								//payment format
								System.out.println("\n\nPlease enter a payment amount in the following format:");
								System.out.println("\t<amount><space><currency>");
								System.out.println("\t\t<amount> = integer");
								System.out.println("\t\t<space> = blank space");
								System.out.println("\t\t<currency> = {Knuts, Sickles, Galleons}");
								System.out.println("\tYou may enter as many times as you like.  Each entry will be added \n\tto your total until sufficient funds have been obtained.");
								System.out.println("\tRecall the currency exchange: \n \t\t29 Knuts = 1 Sickle \n \t\t493 Knuts = 17 Sickles = 1 Galleon");
								
								//ask for payment
								int totpaid = 0;
								
								do
									{
										String user_type;
										int user_pay;
										int gallknuts = 0;
										int sickleknuts = 0;
										int payknuts = 0;
										
										System.out.print("Payment: > ");
										user_pay = inScan.nextInt();
										user_type = inScan.next();
										
										if (user_type.equalsIgnoreCase("galleons"))
										{
											gallknuts = (493*user_pay);
											System.out.println("You have added " + gallknuts + " Knuts to your total");
										
										}
										else if (user_type.equalsIgnoreCase("galleon"))
										{
											gallknuts = (493*user_pay);
											System.out.println("You have added " + gallknuts + " Knuts to your total");
										
										}
										else if (user_type.equalsIgnoreCase("sickles"))
										{
											sickleknuts = (29*user_pay);
											System.out.println("You have added " + sickleknuts + " Knuts to your total");
										
										}
										else if (user_type.equalsIgnoreCase("sickle"))
										{
											sickleknuts = (29*user_pay);
											System.out.println("You have added " + sickleknuts + " Knuts to your total");
										
										}
										else if (user_type.equalsIgnoreCase("knuts"))
										{
											payknuts = (1*user_pay);
											System.out.println("You have added " + payknuts + " Knuts to your total");
											
										}
										else if (user_type.equalsIgnoreCase("knut"))
										{
											payknuts = (1*user_pay);
											System.out.println("You have added " + payknuts + " Knuts to your total");
											
										}
										user_pay = 0;
										totpaid = totpaid + gallknuts + sickleknuts + payknuts;
										System.out.println("You have paid " + totpaid + " Knuts out of " + TotKnuts +" Knuts");
										
									}while(totpaid < TotKnuts);
								
								//return change
								int overpaid = totpaid- TotKnuts;
								int gallchange = overpaid/493;
								int sicklechange = (overpaid%493)/29;
								int knutchange = overpaid%29;
								if (totpaid > TotKnuts)
									{
											System.out.println("\tYou have overpaid by " + (overpaid) + " Knuts");
											System.out.println("\tYour change is:");
											if (gallchange > 0)
												{
													System.out.println("\t\t" + gallchange + " Galleons");
												}
											if 	(sicklechange > 0)
												{
													System.out.println("\t\t" + sicklechange + " Sickles");
												}
											if (knutchange > 0)
												{
													System.out.println("\t\t" + knutchange + " Knuts");
												}
									}	
							}
						else 
							{
								System.out.println("\nYou have not purchased anything.");
							}
				
					}
				else
					{
						//wrong answer 
						System.out.println("\nIncorrect. A 10% penalty will be added to your final bill.");
						System.out.println("----------------------------------------------------\n");
					
						//display prices
						System.out.println("Here is our regular price list: ");
						System.out.println("\tPygmy Puffs (each)\t\t  1 Sickles (290 Knuts)");
						System.out.println("\tExtendable Ears\t\t\t\t      60 Knuts");
						System.out.println("\t\tbag of three\t\t\t     160 Knuts");
						System.out.println("\tTrick Wands (regular)\t\t3 Galleons (1479 Knuts)");
						System.out.println("\tTrick Wands (autographed)\t5 Galleons (2465 Knuts)");
						System.out.println("\nPlease remember: \n 29 Knuts == 1 Sickle \n 17 Sickles == 1 Galleon == 493 Knuts");
						
						int user_choice;
						do
						{
							//ask for choice
							System.out.println("\nPlease choose an option: ");
							System.out.println("\t1) Update Pygmy Puffs Order");
							System.out.println("\t2) Update Extendable Ears Order");
							System.out.println("\t3) Update Trick Wands Order");
							System.out.println("\t4) Show Price List");
							System.out.print("\t5) Check Out \n > ");
							user_choice = inScan.nextInt();

							//begin choice
								if (user_choice == 1)
									{
										System.out.println("Here is your current Pygmy Puffs order:\n " + PygPuffs + " Pygmy Puffs ordered");
										System.out.println("\nYou may add to your order by entering a positive integer, or \n\tsubtract from it by entering a negative integer.");															
										System.out.print("\nHow many Pygmy Puffs would you like for: \n\t 10 Sickles each \n > ");
										user_update = inScan.nextInt();
										PygPuffs = PygPuffs + user_update;
									}
								else if (user_choice == 2)
									{
										System.out.println("Here is your current Extendable Ears order:\n " + ExtEars + " Extendable Ears ordered");
										System.out.println("\nYou may add to your order by entering a positive integer, or \n\tsubtract from it by entering a negative integer.");								
										System.out.println("\nHow many Extendable Ears would you like for: \n\t 60 Knuts each \n\t160 Knuts per bag of 3");
										System.out.print("(Please indicate the total number of Extendable Ears you would \nlike, the system will determine the amount of bags purchased.)\n > ");
										user_update = inScan.nextInt();
										ExtEars = ExtEars + user_update;
									}
								else if (user_choice == 3)
									{
										System.out.println("Here is your current Trick Wands order:\n " + RegWands + " Regular Wands ordered \n " + AutWands + " Autographed Trick Wands ordered");
										System.out.println("\nYou may add to your order by entering a positive integer, or \n\tsubtract from it by entering a negative integer.");													
										System.out.println("\nHow many regular Trick Wands would you like for: \n\t 3 Galleons \n > ");
										user_update = inScan.nextInt();
										RegWands = RegWands + user_update;
										System.out.println("How many autographed Trick Wands would you like for: \n\t 5 Galleons \n >");
										user_update = inScan.nextInt();
										AutWands = AutWands + user_update;
									}
								else if (user_choice == 4)
									{
										System.out.println("Here is our regular price list: ");
										System.out.println("\tPygmy Puffs (each)\t\t  1 Sickles (290 Knuts)");
										System.out.println("\tExtendable Ears\t\t\t\t      60 Knuts");
										System.out.println("\t\tbag of three\t\t\t     160 Knuts");
										System.out.println("\tTrick Wands (regular)\t\t3 Galleons (1479 Knuts)");
										System.out.println("\tTrick Wands (autographed)\t5 Galleons (2465 Knuts)");
										System.out.println("\nPlease remember: \n 29 Knuts == 1 Sickle \n 17 Sickles == 1 Galleon == 493 Knuts");
									}
						}while(user_choice != 5);
							
							if ((PygPuffs + ExtEars + RegWands + AutWands) > 0)
								{
								
								//checkout calculation
								int PygKnuts = PygPuffs*290;
								int ExtEarsEach = ExtEars%3;
								int ExtEarsEachKnuts = ExtEarsEach*60;
								int ExtEarsBag = ExtEars/3;
								int ExtEarsBagKnuts = ExtEarsBag*160;
								int RegKnuts = RegWands*1479;
								int AutKnuts = AutWands*2465;
								int TotKnuts = PygKnuts+ExtEarsEachKnuts+ExtEarsBagKnuts+RegKnuts+AutKnuts;
								int PenKnuts = ((TotKnuts*10)/100);
								int NetKnuts = TotKnuts + PenKnuts;
								
								System.out.println("\n\nHere is your current overall order:");
								if (PygPuffs > 0)
									{
										System.out.println(PygPuffs + " Pygmy Puffs at 10 Sickles (290 Knuts) each: \t " + (PygPuffs*10) + " Sickles (" + (PygKnuts) + " Knuts) ");
									}
								if (ExtEarsEach > 0)
									{
										System.out.println(ExtEarsEach + " Extendable Ears at 60 Knuts each: \t\t\t   (" + (ExtEarsEachKnuts) + " Knuts)");
									}
								if (ExtEarsBag > 0)
									{	
										System.out.println(ExtEarsBag + " Extendable Ears bag at 160 Knuts per bag: \t\t   (" + (ExtEarsBagKnuts) + " Knuts)");
									}
								if (RegWands > 0)
									{	
										System.out.println(RegWands + " Regular Trick Wands each: \t\t\t" + (RegWands*3) + " Galleons ("+ (RegKnuts) + " Knuts) ");
									}
								if (AutWands > 0)
									{	
										System.out.println(AutWands + " Autographed Trick Wands each: \t\t" + (AutWands*5) + " Galleons (" + (AutKnuts) + " Knuts) ");
									}
								System.out.println("-----------------------------------------------------------------------");
								System.out.println("Total:\t\t\t\t\t\t\t    "+(TotKnuts) + " Knuts");
								System.out.println("Penalty of 10%:\t\t\t\t\t\t    " + PenKnuts + " Knuts");
								System.out.println("New total: \t\t\t\t\t\t    " + NetKnuts + " Knuts");
								
								//payment format
								System.out.println("\nPlease enter a payment amount in the following format:");
								System.out.println("\t<amount><space><currency>");
								System.out.println("\t\t<amount> = integer");
								System.out.println("\t\t<space> = blank space");
								System.out.println("\t\t<currency> = {Knuts, Sickles, Galleons}");
								System.out.println("\tYou may enter as many times as you like.  Each entry will be added \n\tto your total until sufficient funds have been obtained.");
								System.out.println("\tRecall the currency exchange: \n \t\t29 Knuts = 1 Sickle \n \t\t493 Knuts = 17 Sickles = 1 Galleon");
								
								//ask for payment
								int totpaid = 0;
								
								do
									{
										String user_type;
										int user_pay;
										int gallknuts = 0;
										int sickleknuts = 0;
										int payknuts = 0;
										
										System.out.print("Payment: > ");
										user_pay = inScan.nextInt();
										user_type = inScan.next();
										
										if (user_type.equalsIgnoreCase("galleons"))
										{
											gallknuts = (493*user_pay);
											System.out.println("You have added " + gallknuts + " Knuts to your total");
										
										}
										else if (user_type.equalsIgnoreCase("galleon"))
										{
											gallknuts = (493*user_pay);
											System.out.println("You have added " + gallknuts + " Knuts to your total");
										
										}
										else if (user_type.equalsIgnoreCase("sickles"))
										{
											sickleknuts = (29*user_pay);
											System.out.println("You have added " + sickleknuts + " Knuts to your total");
										
										}
										else if (user_type.equalsIgnoreCase("sickle"))
										{
											sickleknuts = (29*user_pay);
											System.out.println("You have added " + sickleknuts + " Knuts to your total");
										
										}
										else if (user_type.equalsIgnoreCase("knuts"))
										{
											payknuts = (1*user_pay);
											System.out.println("You have added " + payknuts + " Knuts to your total");
											
										}
										else if (user_type.equalsIgnoreCase("knut"))
										{
											payknuts = (1*user_pay);
											System.out.println("You have added " + payknuts + " Knuts to your total");
											
										}
										user_pay = 0;
										totpaid = totpaid + gallknuts + sickleknuts + payknuts;
										System.out.println("You have paid " + totpaid + " Knuts out of " + NetKnuts +" Knuts");
										
									}while(totpaid < NetKnuts);
								
								//display change
								int overpaid = totpaid- NetKnuts;
								int gallchange = overpaid/493;
								int sicklechange = (overpaid%493)/29;
								int knutchange = overpaid%29;
								if (totpaid > NetKnuts)
									{
											System.out.println("\tYou have overpaid by " + (overpaid) + " Knuts");
											System.out.println("\tYour change is:");
											if (gallchange > 0)
												{
													System.out.println("\t\t" + gallchange + " Galleons");
												}
											if 	(sicklechange > 0)
												{
													System.out.println("\t\t" + sicklechange + " Sickles");
												}
											if (knutchange > 0)
												{
													System.out.println("\t\t" + knutchange + " Knuts");
												}
									}	
							}
						else 
							{
								System.out.println("\nYou have not purchased anything.");
							}
					}
				}
			else if (user_part == 2)
				{
					
				System.out.println("\n\nPlease enjoy our items at their regular prices.");
				System.out.println("----------------------------------------------------\n");
			
					//display prices
						System.out.println("Here is our regular price list: ");
						System.out.println("\tPygmy Puffs (each)\t\t  1 Sickles (290 Knuts)");
						System.out.println("\tExtendable Ears\t\t\t\t      60 Knuts");
						System.out.println("\t\tbag of three\t\t\t     160 Knuts");
						System.out.println("\tTrick Wands (regular)\t\t3 Galleons (1479 Knuts)");
						System.out.println("\tTrick Wands (autographed)\t5 Galleons (2465 Knuts)");
						System.out.println("\nPlease remember: \n 29 Knuts == 1 Sickle \n 17 Sickles == 1 Galleon == 493 Knuts");
						
						int user_choice;
						do
						{
							//ask for choice
							System.out.println("\nPlease choose an option: ");
							System.out.println("\t1) Update Pygmy Puffs Order");
							System.out.println("\t2) Update Extendable Ears Order");
							System.out.println("\t3) Update Trick Wands Order");
							System.out.println("\t4) Show Price List");
							System.out.print("\t5) Check Out \n > ");
							user_choice = inScan.nextInt();

							//begin choice
								if (user_choice == 1)
									{
										System.out.println("Here is your current Pygmy Puffs order:\n " + PygPuffs + " Pygmy Puffs ordered");
										System.out.println("\nYou may add to your order by entering a positive integer, or \n\tsubtract from it by entering a negative integer.");								
										System.out.print("\nHow many Pygmy Puffs would you like for: \n\t 10 Sickles each \n > ");
										user_update = inScan.nextInt();
										PygPuffs = PygPuffs + user_update;
									}
								else if (user_choice == 2)
									{
										System.out.println("Here is your current Extendable Ears order:\n " + ExtEars + " Extendable Ears ordered");
										System.out.println("\nYou may add to your order by entering a positive integer, or \n\tsubtract from it by entering a negative integer.");
										System.out.println("\nHow many Extendable Ears would you like for: \n\t 60 Knuts each \n\t160 Knuts per bag of 3");
										System.out.print("(Please indicate the total number of Extendable Ears you would \nlike, the system will determine the amount of bags purchased.)\n > ");
										user_update = inScan.nextInt();
										ExtEars = ExtEars + user_update;
									}
								else if (user_choice == 3)
									{
										System.out.println("Here is your current Trick Wands order:\n " + RegWands + " Regular Wands ordered \n " + AutWands + " Autographed Trick Wands ordered");
										System.out.println("\nYou may add to your order by entering a positive integer, or \n\tsubtract from it by entering a negative integer.");					
										System.out.print("\nHow many regular Trick Wands would you like for: \n\t 3 Galleons \n > ");
										user_update = inScan.nextInt();
										RegWands = RegWands + user_update;
										System.out.print("How many autographed Trick Wands would you like for: \n\t 5 Galleons\n > ");
										user_update = inScan.nextInt();
										AutWands = AutWands + user_update;
									}
								else if (user_choice == 4)
									{
										//display prices
										System.out.println("Here is our regular price list: ");
										System.out.println("\tPygmy Puffs (each)\t\t  1 Sickles (290 Knuts)");
										System.out.println("\tExtendable Ears\t\t\t\t      60 Knuts");
										System.out.println("\t\tbag of three\t\t\t     160 Knuts");
										System.out.println("\tTrick Wands (regular)\t\t3 Galleons (1479 Knuts)");
										System.out.println("\tTrick Wands (autographed)\t5 Galleons (2465 Knuts)");
										System.out.println("\nPlease remember: \n 29 Knuts == 1 Sickle \n 17 Sickles == 1 Galleon == 493 Knuts");
									}
						}while(user_choice != 5);
							
							if ((PygPuffs + ExtEars + RegWands + AutWands) > 0)
								{
									
								//checkout calculation
								int PygKnuts = PygPuffs*290;
								int ExtEarsEach = ExtEars%3;
								int ExtEarsEachKnuts = ExtEarsEach*60;
								int ExtEarsBag = ExtEars/3;
								int ExtEarsBagKnuts = ExtEarsBag*160;
								int RegKnuts = RegWands*1479;
								int AutKnuts = AutWands*2465;
								int TotKnuts = PygKnuts+ExtEarsEachKnuts+ExtEarsBagKnuts+RegKnuts+AutKnuts;
								int PenKnuts = 0;
								int NetKnuts = TotKnuts + PenKnuts;
								
								
								System.out.println("\n\nHere is your current overall order:");
								if (PygPuffs > 0)
									{
										System.out.println(PygPuffs + " Pygmy Puffs at 10 Sickles (290 Knuts) each: \t " + (PygPuffs*10) + " Sickles (" + (PygKnuts) + " Knuts) ");
									}
								if (ExtEarsEach > 0)
									{
										System.out.println(ExtEarsEach + " Extendable Ears at 60 Knuts each: \t\t\t   (" + (ExtEarsEachKnuts) + " Knuts)");
									}
								if (ExtEarsBag > 0)
									{	
										System.out.println(ExtEarsBag + " Extendable Ears bag at 160 Knuts per bag: \t\t   (" + (ExtEarsBagKnuts) + " Knuts)");
									}
								if (RegWands > 0)
									{	
										System.out.println(RegWands + " Regular Trick Wands each: \t\t\t" + (RegWands*3) + " Galleons ("+ (RegKnuts) + " Knuts) ");
									}
								if (AutWands > 0)
									{	
										System.out.println(AutWands + " Autographed Trick Wands each:\t\t" + (AutWands*5) + " Galleons (" + (AutKnuts) + " Knuts) ");
									}
								System.out.println("-----------------------------------------------------------------------");
								System.out.println("Total:\t\t\t\t\t\t\t\t"+(TotKnuts) + " Knuts");
							
								//payment format
								System.out.println("\nPlease enter a payment amount in the following format:");
								System.out.println("\t<amount><space><currency>");
								System.out.println("\t\t<amount> = integer");
								System.out.println("\t\t<space> = blank space");
								System.out.println("\t\t<currency> = {Knuts, Sickles, Galleons}");
								System.out.println("\tYou may enter as many times as you like.  Each entry will be added \n\tto your total until sufficient funds have been obtained.");
								System.out.println("\tRecall the currency exchange: \n \t\t29 Knuts = 1 Sickle \n \t\t493 Knuts = 17 Sickles = 1 Galleon");
								
								//ask for payment
								
								int totpaid = 0;
								
								do
									{
										String user_type;
										int user_pay;
										int gallknuts = 0;
										int sickleknuts = 0;
										int payknuts = 0;
										
										System.out.print("Payment: > ");
										user_pay = inScan.nextInt();
										user_type = inScan.next();
										
										if (user_type.equalsIgnoreCase("galleons"))
										{
											gallknuts = (493*user_pay);
											System.out.println("You have added " + gallknuts + " Knuts to your total");
										
										}
										else if (user_type.equalsIgnoreCase("galleon"))
										{
											gallknuts = (493*user_pay);
											System.out.println("You have added " + gallknuts + " Knuts to your total");
										
										}
										else if (user_type.equalsIgnoreCase("sickles"))
										{
											sickleknuts = (29*user_pay);
											System.out.println("You have added " + sickleknuts + " Knuts to your total");
										
										}
										else if (user_type.equalsIgnoreCase("sickle"))
										{
											sickleknuts = (29*user_pay);
											System.out.println("You have added " + sickleknuts + " Knuts to your total");
										
										}
										else if (user_type.equalsIgnoreCase("knuts"))
										{
											payknuts = (1*user_pay);
											System.out.println("You have added " + payknuts + " Knuts to your total");
											
										}
										else if (user_type.equalsIgnoreCase("knut"))
										{
											payknuts = (1*user_pay);
											System.out.println("You have added " + payknuts + " Knuts to your total");
											
										}
										user_pay = 0;
										totpaid = totpaid + gallknuts + sickleknuts + payknuts;
										System.out.println("You have paid " + totpaid + " Knuts out of " + NetKnuts +" Knuts");
										
									}while(totpaid < NetKnuts);
								
								int overpaid = totpaid- NetKnuts;
								int gallchange = overpaid/493;
								int sicklechange = (overpaid%493)/29;
								int knutchange = overpaid%29;
								if (totpaid > NetKnuts)
									{
											System.out.println("\tYou have overpaid by " + (overpaid) + " Knuts");
											System.out.println("\tYour change is:");
											if (gallchange > 0)
												{
													System.out.println("\t\t" + gallchange + " Galleons");
												}
											if 	(sicklechange > 0)
												{
													System.out.println("\t\t" + sicklechange + " Sickles");
												}
											if (knutchange > 0)
												{
													System.out.println("\t\t" + knutchange + " Knuts");
												}
									}	
								}
							else
								{
									System.out.println("\nYou have not purchased anything.");
								}
				}
			else
				{
				System.out.println("\n\nInvalid input. Please enjoy our items at their regular prices.");
				System.out.println("----------------------------------------------------\n");
				
					//display prices
						System.out.println("Here is our regular price list: ");
						System.out.println("\tPygmy Puffs (each)\t\t  1 Sickles (290 Knuts)");
						System.out.println("\tExtendable Ears\t\t\t\t      60 Knuts");
						System.out.println("\t\tbag of three\t\t\t     160 Knuts");
						System.out.println("\tTrick Wands (regular)\t\t3 Galleons (1479 Knuts)");
						System.out.println("\tTrick Wands (autographed)\t5 Galleons (2465 Knuts)");
						System.out.println("\nPlease remember: \n 29 Knuts == 1 Sickle \n 17 Sickles == 1 Galleon == 493 Knuts");
						
						int user_choice;
						do
						{
							//ask for choice
							System.out.println("\nPlease choose an option: ");
							System.out.println("\t1) Update Pygmy Puffs Order");
							System.out.println("\t2) Update Extendable Ears Order");
							System.out.println("\t3) Update Trick Wands Order");
							System.out.println("\t4) Show Price List");
							System.out.print("\t5) Check Out \n > ");
							user_choice = inScan.nextInt();

							//begin choice
								if (user_choice == 1)
									{
										System.out.println("Here is your current Pygmy Puffs order:\n " + PygPuffs + " Pygmy Puffs ordered");
										System.out.println("\nYou may add to your order by entering a positive integer, or \n\tsubtract from it by entering a negative integer.");								
										System.out.print("\nHow many Pygmy Puffs would you like for: \n\t 10 Sickles each \n > ");
										user_update = inScan.nextInt();
										PygPuffs = PygPuffs + user_update;
									}
								else if (user_choice == 2)
									{
										System.out.println("Here is your current Extendable Ears order:\n " + ExtEars + " Extendable Ears ordered");
										System.out.println("\nYou may add to your order by entering a positive integer, or \n\tsubtract from it by entering a negative integer.");
										System.out.println("\nHow many Extendable Ears would you like for: \n\t 60 Knuts each \n\t160 Knuts per bag of 3");
										System.out.print("(Please indicate the total number of Extendable Ears you would \nlike, the system will determine the amount of bags purchased.)\n > ");
										user_update = inScan.nextInt();
										ExtEars = ExtEars + user_update;
									}
								else if (user_choice == 3)
									{
										System.out.println("Here is your current Trick Wands order:\n " + RegWands + " Regular Wands ordered \n " + AutWands + " Autographed Trick Wands ordered");
										System.out.println("\nYou may add to your order by entering a positive integer, or \n\tsubtract from it by entering a negative integer.");					
										System.out.print("\nHow many regular Trick Wands would you like for: \n\t 3 Galleons \n > ");
										user_update = inScan.nextInt();
										RegWands = RegWands + user_update;
										System.out.print("How many autographed Trick Wands would you like for: \n\t 5 Galleons \n > ");
										user_update = inScan.nextInt();
										AutWands = AutWands + user_update;
									}
								else if (user_choice == 4)
									{
										//display prices
										System.out.println("Here is our regular price list: ");
										System.out.println("\tPygmy Puffs (each)\t\t  1 Sickles (290 Knuts)");
										System.out.println("\tExtendable Ears\t\t\t\t      60 Knuts");
										System.out.println("\t\tbag of three\t\t\t     160 Knuts");
										System.out.println("\tTrick Wands (regular)\t\t3 Galleons (1479 Knuts)");
										System.out.println("\tTrick Wands (autographed)\t5 Galleons (2465 Knuts)");
										System.out.println("\nPlease remember: \n 29 Knuts == 1 Sickle \n 17 Sickles == 1 Galleon == 493 Knuts");
									}
						}while(user_choice != 5);
							
							if ((PygPuffs + ExtEars + RegWands + AutWands) > 0)
								{
								//checkout calculation
								int PygKnuts = PygPuffs*290;
								int ExtEarsEach = ExtEars%3;
								int ExtEarsEachKnuts = ExtEarsEach*60;
								int ExtEarsBag = ExtEars/3;
								int ExtEarsBagKnuts = ExtEarsBag*160;
								int RegKnuts = RegWands*1479;
								int AutKnuts = AutWands*2465;
								int TotKnuts = PygKnuts+ExtEarsEachKnuts+ExtEarsBagKnuts+RegKnuts+AutKnuts;
								int PenKnuts = 0;
								int NetKnuts = TotKnuts + PenKnuts;
								
								
								System.out.println("\n\nHere is your current overall order:");
								if (PygPuffs > 0)
									{
										System.out.println(PygPuffs + " Pygmy Puffs at 10 Sickles (290 Knuts) each: \t " + (PygPuffs*10) + " Sickles (" + (PygKnuts) + " Knuts) ");
									}
								if (ExtEarsEach > 0)
									{
										System.out.println(ExtEarsEach + " Extendable Ears at 60 Knuts each: \t\t\t   (" + (ExtEarsEachKnuts) + " Knuts)");
									}
								if (ExtEarsBag > 0)
									{	
										System.out.println(ExtEarsBag + " Extendable Ears bag at 160 Knuts per bag: \t\t   (" + (ExtEarsBagKnuts) + " Knuts)");
									}
								if (RegWands > 0)
									{	
										System.out.println(RegWands + " Regular Trick Wands each: \t\t\t" + (RegWands*3) + " Galleons ("+ (RegKnuts) + " Knuts) ");
									}
								if (AutWands > 0)
									{	
										System.out.println(AutWands + " Autographed Trick Wands each: \t\t" + (AutWands*5) + " Galleons (" + (AutKnuts) + " Knuts) ");
									}
								System.out.println("-----------------------------------------------------------------------");
								System.out.println("Total:\t\t\t\t\t\t\t"+(TotKnuts) + " Knuts");
								
								//payment format
								System.out.println("\nPlease enter a payment amount in the following format:");
								System.out.println("\t<amount><space><currency>");
								System.out.println("\t\t<amount> = integer");
								System.out.println("\t\t<space> = blank space");
								System.out.println("\t\t<currency> = {Knuts, Sickles, Galleons}");
								System.out.println("\tYou may enter as many times as you like.  Each entry will be added \n\tto your total until sufficient funds have been obtained.");
								System.out.println("\tRecall the currency exchange: \n \t\t29 Knuts = 1 Sickle \n \t\t493 Knuts = 17 Sickles = 1 Galleon");
								
								//ask for payment
								int totpaid = 0;
								
								do
									{
										String user_type;
										int user_pay;
										int gallknuts = 0;
										int sickleknuts = 0;
										int payknuts = 0;
										
										System.out.print("Payment: > ");
										user_pay = inScan.nextInt();
										user_type = inScan.next();
										
										if (user_type.equalsIgnoreCase("galleons"))
										{
											gallknuts = (493*user_pay);
											System.out.println("You have added " + gallknuts + " Knuts to your total");
										
										}
										else if (user_type.equalsIgnoreCase("galleon"))
										{
											gallknuts = (493*user_pay);
											System.out.println("You have added " + gallknuts + " Knuts to your total");
										
										}
										else if (user_type.equalsIgnoreCase("sickles"))
										{
											sickleknuts = (29*user_pay);
											System.out.println("You have added " + sickleknuts + " Knuts to your total");
										
										}
										else if (user_type.equalsIgnoreCase("sickle"))
										{
											sickleknuts = (29*user_pay);
											System.out.println("You have added " + sickleknuts + " Knuts to your total");
										
										}
										else if (user_type.equalsIgnoreCase("knuts"))
										{
											payknuts = (1*user_pay);
											System.out.println("You have added " + payknuts + " Knuts to your total");
											
										}
										else if (user_type.equalsIgnoreCase("knut"))
										{
											payknuts = (1*user_pay);
											System.out.println("You have added " + payknuts + " Knuts to your total");
											
										}
										user_pay = 0;
										totpaid = totpaid + gallknuts + sickleknuts + payknuts;
										System.out.println("You have paid " + totpaid + " Knuts out of " + NetKnuts +" Knuts");
										
									}while(totpaid < NetKnuts);
								
								int overpaid = totpaid- NetKnuts;
								int gallchange = overpaid/493;
								int sicklechange = (overpaid%493)/29;
								int knutchange = overpaid%29;
								if (totpaid > NetKnuts)
									{
											System.out.println("\tYou have overpaid by " + (overpaid) + " Knuts");
											System.out.println("\tYour change is:");
											if (gallchange > 0)
												{
													System.out.println("\t\t" + gallchange + " Galleons");
												}
											if 	(sicklechange > 0)
												{
													System.out.println("\t\t" + sicklechange + " Sickles");
												}
											if (knutchange > 0)
												{
													System.out.println("\t\t" + knutchange + " Knuts");
												}
									}	
								}
							else
								{
									System.out.println("\nYou have not purchased anything.");
								}
				}
			
				
				System.out.println("\n\nThank you for shopping at 'Weasleys' Wizard Wheezes'! \n\tCome back again!");
				System.out.println("----------------------------------------------------\n\n");
				
		}while(cust != 2);
	}
}
