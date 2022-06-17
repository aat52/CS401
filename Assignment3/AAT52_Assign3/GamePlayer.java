
/*
encapsulate the functionality of a player of your game
GamePlayer will represent each player of the game and should 
have data to represent the player's name, number of rounds played, and other information
include methods to update the values as needed and to represent the data in a form 
that can be saved into a file

*/
public class GamePlayer {
	private String playerName;
	private String password;
	private int rounds;
	private int success;
	private int failure;
	private int optimal;
	private int tries;
	
	public GamePlayer() {
	}
	
	public GamePlayer(String name) {
		this(name, 0, 0, 0, 0);			// Calling overloaded constructor
	}
	
	public GamePlayer(String name, int rounds, int success, int optimal, int tries) {
		this.playerName = name;
		this.rounds = rounds;
		this.success = success;
		this.optimal = optimal;
		this.tries = tries;
	}
	
	public GamePlayer(String name, String password, int rounds, int success, int optimal, int tries) {
		this(name, rounds, success, optimal, tries);
		setPass(password);
	}
	
	public void success(int tries, int optimal) {
		this.success++;
		this.tries += tries;
		this.optimal += optimal;
		this.rounds++;
	}
	
	public void failure() {
		this.failure++;
		this.rounds++;
	}
	
	public String getName() {
		return this.playerName;
	}
	
	public String toString() {
		double ratio = (optimal == 0) ? 1 : ((double)tries / (double)optimal);	// Special case, avoid divide by zero

		return	"\tName: " + playerName + "\n" +
				"\tRounds: " + rounds + "\n" +
				"\tSuccesses: " + success + "\n" +
				"\tFailures: " + failure + "\n" +
				"\tRatio (successes only): " + ratio;
	}
	
	public void setPass(String password) {
		this.password = password;
	}
	
	public String getPass() {
		return password;
	}

	public String toStringFile() {
		return	playerName + ',' + password + ',' + rounds + ',' + success + ',' + optimal + ',' + tries;
	}
}


