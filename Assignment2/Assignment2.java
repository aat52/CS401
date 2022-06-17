/*challenge a user to convert one string to another using as few edits as possible, 
then check to see if the user was able to achieve the minimum number
two random words will be selected from a dictionary, and the user will be tasked 
with converting the first word into the second word in the minimum number of edits 
and within a short amount of time
Scoring will be kept in two ways:
1) Out of all word pairs tried, how many words were transformed successfully within the time limit?
2) Of the words successfully transformed, how many edits were necessary vs. the minimum number
required? This score will be kept as a ratio: total_edits_necessary/optimal_edits. Clearly, 
for this metric, a score of 1.0 is optimal and the closer the score is to 1.0 the better
the performance.
each time he / she plays the game his / her results will be added to his / her previous result
they will be kept in a simple text file for each user */
import java.util.*;
import java.io.*;

public class Assignment2 
{
	private static final int MIN_LENGTH = 5, MAX_LENGTH = 9;
	private static final boolean PASSWORD_REQUIRED = false;
	
	public static void main(String[] args) throws IOException  
	{
		Scanner kbdInput = new Scanner(System.in);

		System.out.print("Dictionary file name? > ");
		String dictionaryFileName = kbdInput.nextLine();
		Dictionary dictionary = new Dictionary(dictionaryFileName);		
		Dictionary usedWords = new Dictionary();
		
		if (!new File(dictionaryFileName).exists()) 
		{
			System.out.println("Program stopped due to dictionary file not found.");
			System.exit(0);
		}
		
		printBanner();
		
		while (true) 
		{
			// Get player's name
			System.out.print("Please enter your name (or <Enter> to quit): ");
			String playerName = kbdInput.nextLine().toLowerCase();
			
			if (playerName.isEmpty()) 
			{
				System.out.println("Good-bye!");
				kbdInput.close();
				System.exit(0);
			}
			
			// Read player's statistics if player's file exist 
			File inFile = new File(playerName + ".txt");
			GamePlayer player;
			
			if (inFile.exists()) 
			{
				// Create a player with statistics from file
				Scanner fileInput = new Scanner(inFile);
				int rounds = fileInput.nextInt();	fileInput.nextLine();
				int success = fileInput.nextInt();	fileInput.nextLine();
				int optimal = fileInput.nextInt();	fileInput.nextLine();
				int tries = fileInput.nextInt();	fileInput.nextLine();
				fileInput.close();
				player = new GamePlayer(playerName, rounds, success, optimal, tries);
				System.out.printf("Welcome Back %s!\n", playerName);
			} 
			
			else 
			{
				// Create a new player
				player = new GamePlayer(playerName);
				System.out.println("Welcome New Player!");
			}
			
			// optional extra credit, toggle on or off in method below
			if (PASSWORD_REQUIRED) 
			{
				passwordProcessing(playerName);
			}
			
			System.out.print("Would you like to try? (y/n) ");
	
			while (kbdInput.next().toLowerCase().charAt(0) == 'y') 
			{
				// Check whether dictionary has enough length for two minimum length words
				if (dictionary.toString().length() < usedWords.toString().length() + MIN_LENGTH * 2) 
				{
					System.out.println("Out of dictionary words.");
					System.exit(0);
				}
				
				String word1 = "", word = "", word2 = "";
				
				// Check if the random word is in usedWord dictionary.
				do 
				{
					word1 = dictionary.randWord(MIN_LENGTH, MAX_LENGTH);	
				} while (usedWords.contains(word1));
				usedWords.addWord(word1);		// Add the new word1 into usedWord dictionary.
	
				word = word1;	// A backup version of the word1, need it for print statistics 
	
				// Check whether dictionary has enough length for one minimum length word
				if (dictionary.toString().length() < usedWords.toString().length() + MIN_LENGTH) 
				{
					System.out.println("Out of dictionary words.");
					System.exit(0);
				}
				
				do 
				{
					word2 = dictionary.randWord(MIN_LENGTH, MAX_LENGTH);
				} while (usedWords.contains(word2));
				usedWords.addWord(word2);		// Add the new word2 into usedWord dictionary
				
				// Find the Levenshtein distance
				int tries = 0, optimal = Dictionary.distance(word1, word2);	
				System.out.printf("\nYour goal is to convert \'%s\' to \'%s' in %d edits.\n", word1, word2, optimal);			
							
				MyTimer timer = new MyTimer(60 * 1000);		// 60 seconds
				//MyTimer timer = new MyTimer(1000);		// 1 second
				timer.start();
				
				do 
				{
					if (!timer.check()) 
					{
						System.out.println("Sorry but time has expired!");
						break;
					}
					
					System.out.println("Index\t\t0123456789");
					System.out.println("-----\t\t----------");
					System.out.println("Current Word:\t" + word1);
					System.out.println("Word 2:\t\t" + word2);
					System.out.println("Here are your options:");
					System.out.println("\tC k v -- Change char at location k to value v");
					System.out.println("\tI k v -- Insert char at location k with value v");
					System.out.println("\tD k   -- Delete char at location k");
					System.out.println("Option choice > ");
		
					char cid = kbdInput.next().toLowerCase().charAt(0);
					int k = kbdInput.nextInt();
					char v = ' ';
					
					if (cid == 'c' || cid == 'i')
						v = kbdInput.next().toLowerCase().charAt(0);
					
					// Prevent change/insert letter outside the word1
					if (cid == 'c' && k >= word1.length()) continue;	// can't change at index >= length
					if (cid == 'i' && k > word1.length()) continue;		// can't insert after index > length
					
					switch (cid) 
					{
						case 'c':	word1 = word1.substring(0, k) + v + word1.substring(k + 1);
									break;
						case 'i':	word1 = word1.substring(0, k) + v + word1.substring(k);
									break;
						case 'd':	word1 = word1.substring(0, k) + word1.substring(k + 1);
									break;
						default:	System.out.println("Invalid input");
					}
					
					tries++;
				} 
				while (!word1.equalsIgnoreCase(word2));
							
				// Update player's stats
				if (word1.equalsIgnoreCase(word2)) 
				{
					System.out.println("Congratulations!");
					player.success(tries, optimal);
				} 
				else 
				{
					player.failure();
				}
				
				// Display player's stats
				printStatistics(playerName, word, word2, tries, optimal);
				System.out.println(player);
	
				// Output player stats to file.
				PrintWriter fileOutput = new PrintWriter(playerName + ".txt");
				fileOutput.println(player.toStringFile());
				fileOutput.close();
				
				System.out.print("Would you like to try again? (y/n) ");
			}
		
			kbdInput.nextLine();	// Flush the kbdInput buffer for taking next input
			System.out.println("Thanks for playing " + playerName + "\n");
		}
	}
	
	private static void printBanner() 
	{
		String message = "	Welcome to the Word Changer Program\n";
		message += "Here is how to play\n";
		message += "For each round you will see two randomly selected words.\n";
		message += "You will have 1 minute to convert the first word to the second using only the following changes:\n";
		message += "  Insert a character at position k (with k starting at 0)\n";
		message += "  Delete a character at position k (with k starting at 0)\n";
		message += "  Change a character at position k (with k starting at 0)\n";
		message += "For example, to change the word 'WEASEL' to 'SEASHELL' you could do the following:\n";
		message += "  1) Change 'W' at position 0 to 'S': SEASEL\n";
		message += "  2) Insert 'H' at position 4: SEASHEL\n";
		message += "  3) Insert 'L' at position 7: SEASHELL\n";
		message += "Your goal is to make this conversion with the fewest changes.\n";
		message += "Note that there may be more than one way to achieve this goal.\n";
	
		System.out.println(message);
	}
	
 	private static void printStatistics(String playerName, String word1, String word2, int tries, int optimal) 
 	{
		System.out.printf("You have converted:\t%s\n", word1);
		System.out.printf("into:\t\t\t%s\n", word2);
		System.out.printf("in %d edits\n", tries);
		
		if (tries == optimal)
			System.out.printf("You used the minimal number of changes -- great job!\n");
		else
			System.out.printf("You used %d extra changes.  See if you can do the optimal number next time!\n", tries - optimal);
 	}

 	private static void passwordProcessing(String playerName) throws IOException 
 	{
 		// An extra password file will be created
		
 		// Read password file, and locate player's password
 		String name = "", password = "";
 		boolean hasPassword = false;
		File passwordFile = new File("password.txt");
		if (!passwordFile.canRead()) passwordFile.createNewFile();
		Scanner passwordInput = new Scanner(passwordFile);
		while (passwordInput.hasNext()) 
		{
			name = passwordInput.next();
			password = passwordInput.next();
			if (name.equals(playerName)) 
			{
				hasPassword = true;
				break;
			}
		}
		passwordInput.close();

		// If player has password in file, ask for input; otherwise create a password for player.
		if (hasPassword) 
		{
			// Asking password to play
			int attempts = 0;
			do 
			{
				System.out.print("Enter password: ");
				if (password.equals(new java.util.Scanner(System.in).next()))
					break;
				
				if (attempts++ >= 3) 
				{
					System.out.println("Incorrect password. Program ended.");
					System.out.println("Without password, a new player name (statistic file) may needed.");
					System.exit(0);
				}
			} while (true);
		} 
		else 
		{ 
			// Create a password
			System.out.print("Create a password: ");
			password = new java.util.Scanner(System.in).next();
			PrintWriter fileOutput = new PrintWriter(new FileOutputStream(new File("password.txt"), true));
			fileOutput.println(playerName + " " + password);
			fileOutput.close();
		}
 	}
}
