package edu.mtc.egr283.poker;
/**
 * Class for handling the players hand and contains methods for determining the type of hand.
* @author Christian Batista
 * @version 1.00 2019-02-04
 * Copyright (C) 2019 by Christian Batista. All rights reserved
 */

enum PokerHand {
	HIGH_CARD(0, "high card"), ONE_PAIR(1, "one pair"), TWO_PAIR(2, "two pair"), THREE_OF_A_KIND(3, "three of a kind"), 
	STRAIGHT(4, "straight"), FLUSH(5, "flush"), FULL_HOUSE(6, "full house"), 
	FOUR_OF_A_KIND(7, "four of a kind"), STRAIGHT_FLUSH(8, "straight flush"), ROYAL_FLUSH(9, "royal flush");

	private int handInt;
	private String handValue;

	private PokerHand(int newHandInt, String NewHandValue) {
		this.setHandInt(newHandInt);
		this.setHandValue(NewHandValue);
	}// Ending bracket of constructor
	
	public int getHandInt() {
		return handInt;
	}// Ending bracket of getHandInt
	
	public void setHandInt(int handInt) {
		this.handInt = handInt;
	}// Ending bracket of setHandInt
	
	public String getHandValue() {
		return handValue;
	}// Ending bracket of getHandValue
	
	public void setHandValue(String handValue) {
		this.handValue = handValue;
	}// Ending bracket of setHandValue
	
}// Ending bracket of enum PokerHand


public class Hand {
	//instance variables
	private PlayingCard[] cards;
	private int currentNumberOfCards;
	private static final String COMMA_SPACE =", ";
	PokerHand pokerHand;
	
	public int pokerHandvalue() {
		return this.pokerHand.getHandInt();
	}
	
	public void addCard(PlayingCard newCard) {
		this.cards[this.currentNumberOfCards] = newCard;
		this.currentNumberOfCards++;
	}// Ending bracket of method addCard
	
	public PlayingCard[] getPlayingCard() {
		return this.cards;
	}// Ending bracket of getPlayingCard
	
	public Hand(int numberOfCardsToHold) {
		this.cards = new PlayingCard[numberOfCardsToHold];
		this.currentNumberOfCards = 0;
	}// Ending bracket of constructor
	
	public void sort() {
		boolean isNotSorted = true;
		PlayingCard tempCard = null;
		while(isNotSorted) {
			isNotSorted = false;
			for(int i = 0; i < this.cards.length - 1; ++i) {
				if(this.cards[i].getRankValue() < this.cards[i+1].getRankValue()) {
					tempCard = this.cards[i];
					this.cards[i] = this.cards[i+1];
					this.cards[i+1] = tempCard;
					isNotSorted = true;
				}// Ending bracket of if
			}// Ending bracket of for loop
		}// Ending bracket of while loop
	}//Ending bracket of sort method
	
	public static PokerHand getPokerHand(PlayingCard[] cardFromHand) {
		int[] rankIndex = new int[PlayingCard.NUM_OF_RANKS];
		int[] suitIndex = new int[PlayingCard.NUM_OF_SUITS];
		int[] rankIndexCounts = new int[cardFromHand.length];
		boolean hasStraight = false;
		boolean hasRoyal = false;
		int TotalOfAKind = 0;
		
		// for loop goes through players cards hand and then within rankIndex is  
		//the rankIdex changes the value of zero to 1
		for (PlayingCard card : cardFromHand) {
			rankIndex[card.getIntRank()]++;
			suitIndex[card.getIntSuit()]++;
		}//Ending bracket of for loop
		
		// Compute count of rankIndex, you cannot have more then 4 of a kind, 
		// determines how many pairs of a kind player has in hand.
		for (int count : rankIndex) {
			// tracks what the cards are, rank know all of player "kinds". 
			// Checks through the list to see if they have the same value.
			//if they do, updates the TotalofAkind variable
				rankIndexCounts[count]++;
				if (count > TotalOfAKind)
					TotalOfAKind = count;
			}// Ending bracket of for loop
			
		//check to see if the players hand is a flush
		boolean hasFlush = false;
		for (int i = 0; i < PlayingCard.NUM_OF_SUITS; i++) {
			if (suitIndex[i] != 0) {
				if (suitIndex[i] == cardFromHand.length)
					hasFlush = true;
				break;
			}// Ending bracket of if
		}// Ending bracket of for loop
		
		// check to see if the players hand is a straight 
		for (int rank =0; rank <= PlayingCard.NUM_OF_RANKS - 5 && rankIndex[rank] == 0;rank++) {
			hasStraight = (rank <= PlayingCard.NUM_OF_RANKS - 5 && rankIndex[rank] == 1 && rankIndex[rank + 1] == 1 
						&& rankIndex[rank + 2] == 1 && rankIndex[rank + 3] == 1 && rankIndex[rank + 4] == 1);
		
			if (rankIndex[0] == 1 && rankIndex[12] == 1 && rankIndex[11] == 1 && rankIndex[10] == 1 && rankIndex[9] == 1) 
				hasStraight = hasRoyal = true;
		}// Ending bracket of while loop
		
		// check if the flush is either royal or straight
		if (hasFlush) {
			if (hasRoyal)
				return PokerHand.ROYAL_FLUSH; // Royal Flush
			if (hasStraight)
				return PokerHand.STRAIGHT_FLUSH; // Straight Flush
		}// Ending bracket of if
		// 
		if (TotalOfAKind == 4)// max of a kind 
			return PokerHand.FOUR_OF_A_KIND; // Four of a Kind
		if (rankIndexCounts[3] == 1 && rankIndexCounts[2] == 1)
			return PokerHand.FULL_HOUSE; // Full House
		if (hasFlush)
			return PokerHand.FLUSH; // Flush
		if (hasStraight)
			return PokerHand.STRAIGHT; // Straight
		if (TotalOfAKind == 3)
			return PokerHand.THREE_OF_A_KIND; // Three of a Kind
		if (rankIndexCounts[2] == 2)
			return PokerHand.TWO_PAIR; // Two Pair
		if (rankIndexCounts[2] == 1)
			return PokerHand.ONE_PAIR; // One Pair
		return PokerHand.HIGH_CARD; // Otherwise, High Card.  This applies to empty Card arrays as well.
	}// Ending bracket of method PokerPlayer	
	
	public String toString() {
		StringBuffer sb = new StringBuffer();	
		for(PlayingCard card : this.cards) {
			sb.append(card.toString());
			sb.append(COMMA_SPACE);
		}// Ending bracket of foreach loop - Cards
		return sb.toString();
	}//Ending bracket of method toString
	
	public String toStringSymbol() {
		StringBuffer sb = new StringBuffer();
		for(PlayingCard card : this.cards) {
			sb.append(card.toStringSymbol());
			sb.append(COMMA_SPACE);
		}// Ending bracket of foreach loop - Cards
		return sb.toString();
	}// Ending bracket of toStringSymbol
	
}// Ending bracket of class Hand