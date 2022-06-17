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

public class Assignment3 {
	private static final int MIN_LENGTH = 5, MAX_LENGTH = 9;
	private static String playerName;
	private static GamePlayer player;
	private static PlayerList players;
	private static Scanner kbdInput = new Scanner(System.in);

	public static void main(String[] args) throws IOException  {
		// Initialization: Load players from file
		players = new PlayerList("players.txt");		

		// Create dictionary
		System.out.print("Dictionary file name? > ");
		String dictionaryFileName = kbdInput.nextLine();
		Dictionary dictionary = new Dictionary(dictionaryFileName);		
		Dictionary usedWords = new Dictionary();
		
		if (!new File(dictionaryFileName).exists()) {
			System.out.println("Program stopped due to dictionary file not found.");
			System.exit(0);
		}
			
		// Main program loop
		while (true) {		
			System.out.println("Welcome to the Word Changer Program\n");
		
			signIn();
			printHowToPlay();
			
			System.out.print(playerName + ", would you like to try? (y/n) ");
						
			while (kbdInput.next().toLowerCase().charAt(0) == 'y') {
				// Check whether dictionary has enough length for two minimum length words
				if (dictionary.toString().length() < usedWords.toString().length() + MIN_LENGTH * 2) {
					System.out.println("Out of dictionary words.");
					System.exit(0);
				}
				
				String word1 = "", word = "", word2 = "";
				
				// Check if the random word is in usedWord dictionary.
				do {
					word1 = dictionary.randWord(MIN_LENGTH, MAX_LENGTH);	
				} while (usedWords.contains(word1));
				usedWords.addWord(word1);		// Add the new word1 into usedWord dictionary.
	
				word = word1;	// A backup version of the word1, need it for print statistics 
	
				// Check whether dictionary has enough length for one minimum length word
				if (dictionary.toString().length() < usedWords.toString().length() + MIN_LENGTH) {
					System.out.println("Out of dictionary words.");
					System.exit(0);
				}
				
				do {
					word2 = dictionary.randWord(MIN_LENGTH, MAX_LENGTH);
				} while (usedWords.contains(word2));
				usedWords.addWord(word2);		// Add the new word2 into usedWord dictionary
				
				// Find the Levenshtein distance
				int tries = 0;
				int optimal = Dictionary.distance(word1, word2);	
				System.out.printf("Your goal is to convert \'%s\' to \'%s' in %d edits.\n", word1, word2, optimal);			
							
				MyTimer timer = new MyTimer(60 * 1000);		// 60 seconds
				timer.start();
				
				do {
					if (!timer.check()) {
						System.out.println("Sorry but time has expired!");
						break;
					}
					
					System.out.println("\nIndex\t\t0123456789");
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
					char v = (cid == 'c' || cid == 'i') ? kbdInput.next().toLowerCase().charAt(0) : ' ';
					
					// Prevent change/insert letter outside the word1
					if (cid == 'c' && k >= word1.length()) continue;	// can't change at index >= length
					if (cid == 'i' && k > word1.length()) continue;		// can't insert after index > length
					
					switch (cid) {
						case 'c':	word1 = word1.substring(0, k) + v + word1.substring(k + 1);
									break;
						case 'i':	word1 = word1.substring(0, k) + v + word1.substring(k);
									break;
						case 'd':	word1 = word1.substring(0, k) + word1.substring(k + 1);
									break;
						default:	System.out.println("Invalid input");
									kbdInput.next();	// clear incorrect input
									continue;
					}
					
					tries++;
				} while (!word1.equalsIgnoreCase(word2));
							
				// Update player's statistics
				if (word1.equalsIgnoreCase(word2)) {
					System.out.println("Congratulations!");
					player.success(tries, optimal);
				} else {
					player.failure();
				}
				
				// Display player's statistics
				printStatistics(playerName, word, word2, tries, optimal);
				System.out.println(player);
				
				System.out.print("Would you like to try again? (y/n) ");
			}
		
			kbdInput.nextLine();	// Flush the kbdInput buffer for taking next input
			System.out.println("\nThanks for playing " + playerName + "\n");
		}
	}
	
	private static void signIn() throws IOException {
		Scanner kbdInput = new Scanner(System.in);
		
		// Print sign-in messages
		String message = "Please sign in with your name and password\n";
		message += "If you are a new player, leave your name field blank\n";
		message += "and we will set you up with a new account\n";
		message += "If you would like to end the game, enter 'Quit'\n";
		System.out.println(message);
				
		// Get player's name
		System.out.print("\tName: ");
		playerName = kbdInput.nextLine();
		
		if (playerName.equalsIgnoreCase("Quit")) {	// Quit
			System.out.println("No more players to play!\n");
			System.out.println("Here are the current stats: ");
			System.out.println(players);
			System.out.println("Saving players back to the file...");
			players.saveList();
			kbdInput.close();
			System.exit(0);
		}
		
		if (playerName.equals("")) {				// New GamePlayer, we need name and password
			setNewPlayerName();						// Get a new player name
			setNewPassword();						// Get a new player password
			players.addPlayer(player);				// Add the new player into PlayerList array
			return;
		} 
		
		if (!players.containsName(playerName)) {	// New GamePlayer, but we just need password
			System.out.println("Your name does not exist, so your sign-in has been cancelled.");
			System.out.println("Please register as a new player.\n");
			System.out.println("Welcome new Player!");
			System.out.println("Before playing we must get some information from you");

			player = new GamePlayer(playerName);
			setNewPassword();
			players.addPlayer(player);
			return;
		}

		if (players.containsName(playerName)) { 	// Returning player login
			int passwordAttempts = 0;
			
			do {
				player = new GamePlayer(playerName);

				System.out.print("\tPlease enter your password: ");
				player.setPass(kbdInput.next());
				player = players.authenticate(player);
				
				if (player == null) {				// Returning player, but password incorrect.  Give the player another chances to enter password again.
					System.out.println("\tSorry, your password does not match. Please try again.");

					if (passwordAttempts++ > 1) { 	// Too many failed password attempts, i.e, 3 attempts; create a new player
						System.out.println("Your password still does not match, so your sign-in has been cancelled.");
						System.out.println("Please register as a new player.");
						setNewPlayerName();					
						setNewPassword();				
						players.addPlayer(player);	// Add the new GamePlayer into PlayerList array
						return;
					}
				} 
			} while (player == null);				// Player authentication failed, authenticate again
		}
	}
	
	private static void setNewPlayerName() {
		System.out.println("Welcome new Player!");
		System.out.println("Before playing we must get some information from you");
		System.out.print("\tPlease enter a name for your account (no spaces): ");
		playerName = kbdInput.next();
		
		while (players.containsName(playerName)) {
			System.out.println("\tSorry but name " + playerName + " is taken. Please try a different name.");
			System.out.print("\tName: ");
			playerName = kbdInput.next();
		}
		
		player = new GamePlayer(playerName);
	}
	
	//new player password
	private static void setNewPassword() {
		String password = "", confirm = "";
		
		do {
			System.out.print("\tPlease enter your password: ");
			password = kbdInput.next();
			
			System.out.print("\tConfirm password: ");
			confirm = kbdInput.next();
			
			if (!password.equals(confirm)) {
				System.out.println("\tSorry but your passwords don't match!");
			} 
		} while (!password.equals(confirm));
		
		player.setPass(password);
	}
	
	//display instructions
	private static void printHowToPlay() {
		String message = "Here is how to play\n";
		message += "\tFor each round you will see two randomly selected words.\n";
		message += "\tYou will have 1 minute to convert the first word to the second using only the following changes:\n";
		message += "\t  Insert a character at position k (with k starting at 0)\n";
		message += "\t  Delete a character at position k (with k starting at 0)\n";
		message += "\t  Change a character at position k (with k starting at 0)\n";
		message += "\tFor example, to change the word 'WEASEL' to 'SEASHELL' you could do the following:\n";
		message += "\t  1) Change 'W' at position 0 to 'S': SEASEL\n";
		message += "\t  2) Insert 'H' at position 4: SEASHEL\n";
		message += "\t  3) Insert 'L' at position 7: SEASHELL\n";
		message += "\tYour goal is to make this conversion with the fewest changes.\n";
		message += "\tNote that there may be more than one way to achieve this goal.\n";
	
		System.out.print(message);
	}
	
	//statistics
 	private static void printStatistics(String playerName, String word1, String word2, int tries, int optimal) {
		System.out.printf("You have converted:\t%s\n", word1);
		System.out.printf("into:\t\t\t%s\n", word2);
		System.out.printf("in %d edits\n", tries);
		
		if (tries == optimal)
			System.out.printf("You used the minimal number of changes -- great job!\n");
		else
			System.out.printf("You used %d extra changes.  See if you can do the optimal number next time!\n", tries - optimal);
 	}
}
