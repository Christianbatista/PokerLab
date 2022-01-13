package edu.mtc.egr283.poker;
import java.util.Random;
/**
 * Class that holds cards and contains methods for dealing and shuffling the cars to players
 * @author Christian Batista
 * @version 1.00 2019-02-04
 * Copyright (C) 2019 by Christian Batista. All rights reserved
 */
public class Deck {
	//instance variables
	private PlayingCard[] cards;
	static final int DECK_SIZE = 52;
	private Random randomizer;
	
	public Deck() {
		int arrayIndex = 0;
		this.cards = new PlayingCard[DECK_SIZE]; 
		this.randomizer = new Random();
		
		for(Suit suit : Suit.values()) {
			for(Rank rank: Rank.values()) {
				cards[arrayIndex++] = new PlayingCard(rank,suit);
			}// Ending bracket of outer foreach loop - Rank
		}// Ending bracket of outer foreach loop - Suit
	}// Ending bracket of constructor
		
	public PlayingCard deal() {
		PlayingCard returnValue = null;
		int index = 0;
		
		do {
			index = randomizer.nextInt(DECK_SIZE);
			returnValue = cards[index];
		} while(returnValue == null);
		
		cards[index] = null;
		return returnValue;
	}// Ending bracket of method deal
	
	public void displayDeck() {
		for(PlayingCard card : cards) {
			System.out.println(card.toString());
			
		}// Ending bracket of foreach loop
	}// Ending bracket of method displayDeck
		
	public void displayDeckSymbols() {
		for(PlayingCard card : cards) {
			System.out.println(card.toStringSymbol());
		}// Ending bracket of foreach loop
	}// Ending bracket of method displayDeck
	
}// Ending bracket of class Deck