package edu.mtc.egr283.poker;
/**
 * Class for handling the suit of the playing card
* @author Christian Batista
 * @version 1.00 2019-02-04
 * Copyright (C) 2019 by Christian Batista. All rights reserved
 */
public enum Suit {

	CLUBS("Clubs", '\u2663'), DIAMONDS("Diamonds", '\u2666'),
	HEARTS("Hearts", '\u2665'), SPADES("Spades", '\u2660');
	
	private String suit;
	private char symbol;
	
	private Suit(String newSuit, char newSymbol) {
		this.suit = newSuit;
		this.symbol = newSymbol;
	}// Ending bracket of constructor
	
	public String getSuit() {
		return this.suit;
	}// Ending bracket of method getSuit

	public int getIntSuit() {
		if(symbol == '\u2663' || symbol == '\u2666'|| symbol == '\u2665'|| symbol == '\u2660' ) {
	}
		return ordinal();
		
	}// Ending bracket of method getIntSuit
		
	public char getSymbol() {
		return this.symbol;
	}// Ending bracket of method getSymbol
	
}// Ending bracket of enum Suit