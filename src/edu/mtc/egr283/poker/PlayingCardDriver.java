package edu.mtc.egr283.poker;

public class PlayingCardDriver {

	public static void main(String[] args) {
		
	PlayingCard c1 = new PlayingCard(Rank.KING, Suit.SPADES);
	System.out.println(c1.toString()); 
	System.out.println(c1.toStringSymbol());
	
	PlayingCard c2 = new PlayingCard(Rank.ACE, Suit.CLUBS);
	System.out.println(c1.isSameRank(c2));
	System.out.println(c1.isSameSuit(c2));

	}// Ending bracket of method main
	
}// Ending bracket of class PlayingCardDriver