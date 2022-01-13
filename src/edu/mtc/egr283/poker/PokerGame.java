package edu.mtc.egr283.poker;
import java.util.Scanner;
/**************************************************************
 * PokerGame class to drive application
 * This program asks for 4 players whom will play a game of 5 card poker and 
 * display their hands and determine the winner.
 * @author Christian Batista
 * @version 1.00 2019-02-04
 * Copyright (C) 2019 by Christian Batista. All rights reserved
 */
public class PokerGame {

	public static void main(String[] args) {
		final int numberOfPlayers = 4;
		final int numberofCards = 5;
		String input = "Yes";
		String playAgain ="No";
		Scanner console = new Scanner(System.in);
		PokerPlayer[] newPlayers;
		Deck newDeck; // creates a new Deck
		
		System.out.println("Lets Play Poker");
		do {
			newDeck = new Deck();
			newPlayers = new PokerPlayer[numberOfPlayers + 1];// the array is 5, the index is 4	
			System.out.println("Enter the name of the 4 players below.\n");
			for(int i = 1; i <= numberOfPlayers; i++) {
				System.out.print("Enter the name of player " + i + ":");
				String name = console.next();
				newPlayers[i] = new PokerPlayer(name,numberofCards);
			}// Ending bracket of for loop
			
			// The below for loop does the work
			for(int j = 1;j <= numberOfPlayers; ++j) {
				for(int i = 0; i < numberofCards; i++) {
					newPlayers[j].addCard(newDeck.deal());
				}// Ending bracket of inner for loop
				newPlayers[j].getHand().sort();
			}// Ending bracket of outer for loop
			
			System.out.println();
			//The below is to display the players cards
			System.out.println("The players have the following cards."); 
			for(int i = 1; i <= numberOfPlayers; i++) {
			System.out.println(newPlayers[i].getName() + " - " + newPlayers[i].getHand().toStringSymbol());		
			}// ending bracket of for loop to show player Cards
			
			System.out.println();
			// Display the hands 
			for(int i = 1; i <= numberOfPlayers; i++) {
				System.out.println(newPlayers[i].getName() +" - " +
						Hand.getPokerHand(newPlayers[i].getHand().getPlayingCard()));
			}// Ending bracket		
			
			System.out.println();
			PokerPlayer temp = null;
			int intTemp = -1;
			
			for(int i = 1; i <= numberOfPlayers; i++) {				
				if(Hand.getPokerHand(newPlayers[i].getHand().getPlayingCard()).getHandInt() > intTemp) {
					temp = newPlayers[i];
					intTemp =Hand.getPokerHand(newPlayers[i].getHand().getPlayingCard()).getHandInt();
				}// Ending bracket of if 
			}// Ending bracket of for loop
			System.out.println("the winner is; " + temp.getName());
			
			System.out.print("Want to play again:");
			playAgain = console.next();
		}while(input.equalsIgnoreCase(playAgain));
		
			System.out.println();
			System.out.print("Thank you for playing");
		console.close();
	}// Ending bracket of method main
}// Ending bracket of PokerGame