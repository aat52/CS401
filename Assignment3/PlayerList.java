// CS 0401 Fall 2019
// Shell of the PlayerList class.
// This class represents a collection of players -- a very simple database.  The
// collection can be represented in various ways.  However, for this assignment
// you are required to use an array of GamePlayer.

// Note the imports below.  java.util.* is necessary for ArrayList and java.io.* is
// necessary for the file reading and writing.
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PlayerList
{
	private GamePlayer [] players;  // array of GamePlayer
	private int size;				// logical size
	private String file;			// name of file associated with this PlayerList
	
	// Initialize the list from a file.  Note that the file name is a parameter.  You
	// must open the file, read the data, making a new GamePlayer object for each line
	// and putting them into the array.  Your initial size for the array MUST be 3 and
	// if you fill it should resize by doubling the array size.  
	
	// Note that this method throws IOException. Because of this, any method that CALLS
	// this method must also either catch IOException or throw IOException.  Note that 
	// the main() in PlayerListTest.java throws IOException.  Keep this in mind for your
	// main program (Assig3.java).  Note that your saveList() method will also need
	// throws IOException in its header, since it is also accessing a file.
	public PlayerList(String fName) throws IOException {
		// Initialize all attributes
		players = new GamePlayer[3];
		size = 0;
		file = fName;
		
		// Read all players from file, and store into players array
		Scanner fileInput = new Scanner(new File(fName));
		String [] playerData = null;
		
		while (fileInput.hasNextLine()) {
			String line = fileInput.nextLine();
			playerData = line.split(",");
		
			String name = playerData[0];
			String password = playerData[1];
			int rounds = Integer.parseInt(playerData[2]);
			int success = Integer.parseInt(playerData[3]);
			int optimal = Integer.parseInt(playerData[4]);
			int tries = Integer.parseInt(playerData[5]);

			addPlayer(new GamePlayer(name, password, rounds, success, optimal, tries));
		}
		
		fileInput.close();
	}

	// See program PlayerListTest.java to see the other methods that you will need for
	// your PlayerList class.  There are a lot of comments in that program explaining
	// the required effects of the methods.  Read that program very carefully before
	// completing the PlayerList class.  You will also need to complete the modified
	// GamePlayer class before the PlayerList class will work, since your array is an
	// array of GamePlayer objects.
	
	// You may also want to add some methods that are not tested in PlayerListTest.java.
	// Think about what you need to do to a PlayerList in your Assig3 program and write 
	// the methods to achieve those tasks.  However, make sure you are always thinking
	// about encapsulation and data abstraction.
	
	public int capacity() {
		return players.length;
	}
	
	public int size() {
		return size;
	}
	
	private void enlarge() {
		GamePlayer [] larger = new GamePlayer[players.length * 2];
		for (int index = 0; index < size; index++)
			larger[index] = players[index];
		
		players = larger;
	}
	
	public boolean containsName(String s) {
		for (int index = 0; index < size; index++) {
			if (players[index].getName().equalsIgnoreCase(s)) {
				return true;
			}
		}
		return false;
	}
		
	public boolean addPlayer(GamePlayer newPlayer) {
		if (containsName(newPlayer.getName())) { 		// Player's name exist
			return false;
		}	
		if (size == players.length) {					// Array is full.
			enlarge();
		}
		players[size++] = newPlayer;				// Ok to add new player
		
		return true;
	}
	
	public GamePlayer authenticate(GamePlayer temp) {
		for (int index = 0; index < size; index++) {
			if (players[index].getPass().equals(temp.getPass()) &&
				players[index].getName().equals(temp.getName())) {
				return players[index];
			}
		}
		return null;
	}

	public void saveList() throws FileNotFoundException {
//		PrintWriter outputStream = new PrintWriter(file);
//		
//		for (int index = 0; index < size; index++) {
//			String onePlayer = players[index].toStringFile();
//			outputStream.println(onePlayer);
//		}
//		outputStream.close();
	}
	
	public String toString() {
		String output = "Total Players: " + size + "\n";
		
		for (int index = 0; index < size; index++) {
			output += players[index] + "\n\n";
		}
		
		return output;
	}
}
