package edu.mtc.egr283.poker;
/**
 * Class for handling the "kind" of the playing card
* @author Christian Batista
 * @version 1.00 2019-02-04
 * Copyright (C) 2019 by Christian Batista. All rights reserved
 */
public enum Rank {

	DEUCE("Deuce", '2'), TREY("Trey", '3'), FOUR("Four", '4'),
	FIVE("Five", '5'), SIX("Six", '6'), SEVEN("Seven", '7'),
	EIGHT("Eight", '8'), NINE("Nine", '9'), TEN("Ten", 'T'),
	JACK("Jack", 'J'), QUEEN("Queen", 'Q'),  KING("King", 'K'), 
	ACE("Ace",'A');
	
	private String rank;
	private char symbol;
	
	private Rank(String newRank) {
		this.rank = newRank;
	}// Ending bracket of constructor
	
	private Rank(String newRank, char newSymbol) {
		this.rank = newRank;
		this.symbol = newSymbol;
	}// Ending bracket of constructor
	
	public String getRank() {
		return this.rank;
	}// Ending bracket of method getRank
	
	public int getIntRank() {
		
	 int temp;
        switch (symbol) {
            case '2': temp = 2;
                    	break;
            case '3':  temp = 3;
                     break;
            case '4':  temp = 4;
                     break;
            case '5':  temp = 5;
                     break;
            case '6':  temp = 6;
                     break;
            case '7':  temp = 7;
                     break;
            case '8':  temp = 8;
                     break;
            case '9':  temp = 9;
                     break;
            case 'T':  temp = 10;
                     break;
            case 'J': temp = 11;
                     break;
            case 'Q': temp = 12;
                     break;
            case 'K': temp = 13;
                     break;
            default: temp = 1;
                     break;
        }// Ending bracket of switch
        return temp;
    }// Ending bracket of getIntRank
				
	public char getSymbol() {
		return this.symbol;
	}// Ending bracket of getSymbol
	
}// Ending bracket of enum Rank