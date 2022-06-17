public class War {
	
	private static MultiDS<Card> deck = new MultiDS<Card>(52); //deck of 52
	private static MultiDS<Card> player0 = new MultiDS<Card>(26); //p0's deck
	private static MultiDS<Card> player1 = new MultiDS<Card>(26); //p1's deck
	private static MultiDS<Card> discard0 = new MultiDS<Card>(26); //p0's discard
	private static MultiDS<Card> discard1 = new MultiDS<Card>(26); //p1's discard
	private static MultiDS<Card> warDeck = new MultiDS<Card>(6); //total
	
	public static void main(String[] args) {

		final int ROUNDS;
		
		//args[0] or default 500 rounds
		if (args.length != 0)
			ROUNDS = Integer.parseInt(args[0]);
		else
			ROUNDS = 500;
		
		//create deck
		for (Card.Suits s : Card.Suits.values()) {
			for (Card.Ranks r : Card.Ranks.values()){
				deck.addItem(new Card(s, r));
			}
		}
		
		deck.shuffle();
		
		System.out.println("Welcome to the Game of War! \n");
		System.out.println("Dealing cards to players...");
		
		for (int i = 0; i < 26; i++) {
			player0.addItem(deck.removeItem());
			player1.addItem(deck.removeItem());
		}
		
		System.out.println("Player 0's hand: ");
		System.out.println(player0 + "\n");
		System.out.println("Player 1's hand: ");
		System.out.println(player1 + "\n");
		
		System.out.println("Starting War! \n"); 
		
		int round = 0;
		
		while (player0.size() > 0 && player1.size() > 0 && round < ROUNDS) {
			int cardsUsed = 0;
			
			Card p0hand = player0.removeItem();
			Card p1hand = player1.removeItem();
			
			//begin game
			if (p0hand.compareTo(p1hand) == 0) {
				do {
					System.out.println("\tWar: "+ p0hand + " ties " + p1hand + "\n");
					cardsUsed += 2;
					warDeck.addItem(p0hand);
					warDeck.addItem(p1hand);
					
					//at risk non-comparing cards
					recycleDiscardShuffle();
					p0hand = player0.removeItem();
					p1hand = player1.removeItem();
					System.out.println("\tPlayer 0: " + p0hand + " and " + " Player 1" + p1hand + " are at risk! \n");
					cardsUsed += 2;
					warDeck.addItem(p0hand);
					warDeck.addItem(p1hand);
					
					//get cards for comparison
					recycleDiscardShuffle();
					p0hand = player0.removeItem();
					p1hand = player1.removeItem();					
				}while (p0hand.compareTo(p1hand) == 0);
				
				//add to warDeck
				cardsUsed += 2;
				warDeck.addItem(p0hand);
				warDeck.addItem(p1hand);
			
			//p0 wins, p0 merges with warDeck
			if (p0hand.compareTo(p1hand) > 0) {
				System.out.println("Player 0 wins round " + (round++) + " : " + compareCards(p0hand, p1hand) + " : " + cardsUsed + " cards");
				
				//showCardCounts();
				
				System.out.println();
				
				int warDeckSize = warDeck.size();
				for (int i = 0; i < warDeckSize; i++) {
					player0.addItem(warDeck.removeItem());
				}
			}
			
			//p1 wins, p1 merges with warDeck
			if (p1hand.compareTo(p0hand) > 0) {
				System.out.println("Player 1 wins round " + (round++) + " : " + compareCards(p1hand, p0hand) + " : " + cardsUsed + " cards");
				
				//showCardCounts();
				
				System.out.println();
				
				int warDeckSize = warDeck.size();
				for (int i = 0; i < warDeckSize; i++) {
					player1.addItem(warDeck.removeItem());
				}
			}
		}
		//end and give alternative
		else {
			if (p0hand.compareTo(p1hand) > 0) {
				//p0 wins, add cards to p0's discard
				cardsUsed += 2;
				System.out.println("Player 0 wins round " + (round++) + " : " + compareCards(p0hand, p1hand) + " : " + cardsUsed + " cards");
				
				discard0.addItem(p0hand);
				discard0.addItem(p1hand);
				
				//showCardCounts();
				
				System.out.println("\n----------------------------");
			}
			
			if (p1hand.compareTo(p0hand) > 0) {
				//p0 wins, add cards to p0's discard
				cardsUsed += 2;
				System.out.println("Player 1 wins round " + (round++) + " : " + compareCards(p1hand, p0hand) + " : " + cardsUsed + " cards");
				
				discard1.addItem(p0hand);
				discard1.addItem(p1hand);
				
				//showCardCounts();
				
				System.out.println("\n----------------------------");
			}
		}
		
		//round up, sum player's cards and collect discards
		collectPlayer0Discard();
		collectPlayer1Discard();
		
		}
		
		//print results
				System.out.println("\nAfter " + round + " rounds, here are the results:\n");
				System.out.println("\tPlayer 0 has " + player0.size() + " cards\n");
				System.out.println("\tPlayer 1 has " + player1.size() + " cards\n");
				
				if (player0.size() == player1.size())
					System.out.println("Stalemate!");
				
				if (player0.size() > player1.size())
					System.out.println("Player 0 wins!");
				
				if (player0.size() < player1.size())
					System.out.println("Player 1 wins!");
	}
	
	private static void recycleDiscardShuffle() {
		//collect discards if player does not have cards
		if (player0.size() == 0) {
			collectPlayer0Discard();
			
			System.out.println("\tGetting and shuffling for player 0");
			player0.shuffle();
		}
		
		if (player1.size() == 0) {
			collectPlayer1Discard();
			
			System.out.println("\tGetting and shuffling for player 1");
			player1.shuffle();
		}
		
		//check if player still out of cards
		if (player0.size() == 0) {
			System.out.println("\nPlayer 0 is out of cards");
			System.out.println("Player 1 wins!");
			System.exit(0);
		}
		
		if (player1.size() == 0) {
			System.out.println("\nPlayer 1 is out of cards");
			System.out.println("Player 0 wins!");
			System.exit(0);
		}
	}
	
	//method to collect discards for p0
	private static void collectPlayer0Discard() {
		int discardDeckSize = discard0.size();
		for (int i = 0; i < discardDeckSize; i++)
			player0.addItem(discard0.removeItem());
	}
	
	//method to collect discards for p1
	private static void collectPlayer1Discard() {
		int discardDeckSize = discard1.size();
		for (int i = 0; i < discardDeckSize; i++)
			player1.addItem(discard1.removeItem());
	}
	
	private static String compareCards(Card x, Card y) {
		if (x.compareTo(y) == 0)
			return "Tie!";
		
		if (x.compareTo(y) > 0)
			return x + " beats " + y;
		else
			return x + " loses to " + y;
	}
	/*
	private static void showCardCounts() {
		if (warDeck.size() == 0)
			System.out.printf("\t[%2d, %2d] + [%2d, %2d] = %2d", 
					player0.size(), discard0.size(), 
					player1.size(), discard1.size(), 
					player0.size() + player1.size() + discard0.size() + discard1.size());
		else
			System.out.printf("\t[%2d, %2d] + [%2d, %2d] = %2d", 
					player0.size(), discard0.size(), 
					player1.size(), discard1.size(), 
					warDeck.size(),
					player0.size() + player1.size() +discard0.size() + discard1.size() + warDeck.size());
	}
	*/
}
