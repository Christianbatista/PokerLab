package edu.mtc.egr283.poker;
/**
 * Class for handling players
 * @author Christian Batista
 * @version 1.00 2019-02-04
 * Copyright (C) 2019 by Christian Batista. All rights reserved
 */
public class PokerPlayer {
	
	//instance variables
	private String name;
	private Hand hand;
	
	public PokerPlayer() {
		name = "No Record";
	}// Default Constructor
	
	public PokerPlayer(String newName, int numberOfCards) {
		this.setName(newName);
		this.setHand(new Hand(numberOfCards));
	} // Ending bracket of PokerPlayer constructor
			
	public void addCard(PlayingCard newCard) {
		this.hand.addCard(newCard);
	}// Ending bracket of method addCard
			
	public String getName() {
		return this.name;
	}// Ending bracket of method getName
	
	public void setName(String newName) {
		this.name = newName;
	}// Ending bracket of method setName
	
	public Hand getHand() {
		return this.hand;
	}// Ending bracket of method getHand
	
	public void setHand(Hand newHand) {
		this.hand = newHand;
	}// Ending bracket of method setHand
	
}// Ending bracket of PokerPlayer Class