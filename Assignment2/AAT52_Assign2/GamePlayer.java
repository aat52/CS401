
/*
encapsulate the functionality of a player of your game
GamePlayer will represent each player of the game and should 
have data to represent the player's name, number of rounds played, and other information
include methods to update the values as needed and to represent the data in a form 
that can be saved into a file

*/

public class GamePlayer 
{
	private String playerName;
	private int rounds;
	private int success;
	private int failure;
	private int optimal;
	private int tries;
	
	public GamePlayer() 
	{
	
	}
	
	public GamePlayer(String name) 
	{
		playerName = name;
	}
	
	public GamePlayer(String name, int rounds, int success, int optimal, int tries) 
	{
		playerName = name;
		this.rounds = rounds;
		this.success = success;
		this.optimal = optimal;
		this.tries = tries;
	}
	
	public void success(int tries, int optimal) 
	{
		this.success++;
		
		this.tries += tries;
		if (optimal != 0) 
			this.optimal += optimal;
		
		rounds++;
	}
	
	public void failure() 
	{
		this.failure++;
		rounds++;
	}
	
	public String getName() 
	{
		return this.playerName;
	}
	
	public String toString() 
	{
		return	"Here are your current stats:\n" +
				"\tName: " + playerName + "\n" +
				"\tRounds: " + rounds + "\n" +
				"\tSuccesses: " + success + "\n" +
				"\tFailures: " + failure + "\n" +
				"\tRatio (successes only): " + 
				((double)tries / (double)optimal) + "\n\n";
	}
	
	public String toStringFile() 
	{
		return	rounds + "\n" + success + "\n" + optimal + "\n" + tries + "\n";
	}
	
//	public static void main(String[] args) {
//		GamePlayer p1 = new GamePlayer();
//		p1.success(5,5);
//		p1.success(8,8);
//		p1.success(7,6);
//		System.out.println(p1);
//	}
	
}
