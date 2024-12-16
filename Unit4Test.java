/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Code Plan:
 * 1. Create a `Card` class to represent a playing card:
 *    - Each card has a `suit` (Clubs, Diamonds, Hearts, Spades) and a `faceValue` (1-13).
 *    - Generate random values for the suit and faceValue using the `Random` class.
 *    - Implement an `equals` method to check for duplicate cards.
 * 
 * 2. In the `main` method:
 *    - Create an array to hold 5 unique cards.
 *    - Use a loop to generate cards and ensure they are unique by comparing with existing cards in the array.
 * 
 * 3. Print all the cards in the hand to the console.
 * 
 * 4. Determine which card has the highest value:
 *    - Loop through the hand to find the card with the highest `faceValue`.
 * 
 * 5. Print the card with the highest console
 */


package com.mycompany.unit4test;
import java.util.Random;

public class Unit4Test {

    public static void main(String[] args) {
        // Array to store 5 cards
        Card[] hand = new Card[5];
        Random random = new Random();

        // Generate 5 unique cards
        for (int i = 0; i < hand.length; i++) {
            Card newCard;
            boolean isDuplicate;

            // Keep generating until a unique card is created
            do {
                newCard = new Card();
                isDuplicate = false;

                // Check for duplicates in the hand
                for (int j = 0; j < i; j++) {
                    if (hand[j].equals(newCard)) {
                        isDuplicate = true;
                        break;
                    }
                }
            } while (isDuplicate);

            hand[i] = newCard;
        }

        // Find the card with the highest value
        Card highestCard = hand[0];
        System.out.println("Dealt Cards:");
        for (Card card : hand) {
            System.out.println("Card: " + card.getFaceValue() + " of " + card.getSuit());
            if (card.getFaceValue() > highestCard.getFaceValue()) {
                highestCard = card;
            }
        }

        System.out.println("\nThe card with the highest value is: " +
                highestCard.getFaceValue() + " of " + highestCard.getSuit());
    }
}

class Card {
    private String suit;
    private int faceValue;

    // Possible suits
    private static final String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};

    // Constructor generates a random card
    public Card() {
        Random rand = new Random();
        this.suit = SUITS[rand.nextInt(SUITS.length)];
        this.faceValue = rand.nextInt(13) + 1; // 1-13
    }

    public String getSuit() {
        return suit;
    }

    public int getFaceValue() {
        return faceValue;
    }

    // Check if two cards are the same
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Card card = (Card) obj;
        return faceValue == card.faceValue && suit.equals(card.suit);
    }
}
