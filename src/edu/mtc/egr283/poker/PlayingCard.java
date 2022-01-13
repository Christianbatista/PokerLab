package edu.mtc.egr283.poker;
/**
 * Class handles the individual cards
 * @author Christian Batista
 * @version 1.00 2019-02-04
 * Copyright (C) 2019 by Christian Batista. All rights reserved
*/
public class PlayingCard {
	// NUM_OF_RANKS and NUM_OF_SUITS are use as the Array lengths 
	//within the getPokerHand method
	public static final int NUM_OF_RANKS = 14;
	public static final int NUM_OF_SUITS = 4;
	
	//instance variables
	private final Rank rank;
	private final Suit suit;
	
	public PlayingCard(Rank newRank, Suit newSuit) {
		this.rank = newRank;
		this.suit = newSuit;
	}// Ending bracket of constructor
	
	public Rank getRank() {
		return this.rank;
	}// Ending bracket of method getRank
	
	public Suit getSuit() {
		return this.suit;
	}// Ending bracket of method getSuit
	
	public int getIntRank() {
		return this.rank.getIntRank();
	}// Ending bracket of getIntRank
	
	public int getIntSuit() {
		return this.suit.getIntSuit();
	}// Ending bracket of method getIntSuit

	public int getRankValue() {
		return this.rank.ordinal() + 2;	
	}// Ending bracket of method getRankValue
	
	public boolean isSameSuit(PlayingCard otherCard) {
		return (this.getSuit() == otherCard.getSuit());
	}// Ending bracket of method is SameSuit
	
	public boolean isSameRank(PlayingCard otherCard) {
		return (this.getRank() == otherCard.getRank());
	}// Ending bracket of method is SameRank
	
	public String toString() {
		return this.rank.getRank() + " of " + this.suit.getSuit();
	}// Ending bracket of method toString
	
	public String toStringSymbol() {
		return this.rank.getSymbol() + "" + this.suit.getSymbol();
	}// Ending bracket of method toStringSymbol
	
}// Ending bracket of class PlayingCard