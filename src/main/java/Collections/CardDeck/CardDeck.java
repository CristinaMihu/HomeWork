package main.java.Collections.CardDeck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeck {
    private final List<Card> cards = new ArrayList<>();

    CardDeck() {
        shuffle();
    }

    void shuffle() {
        cards.clear();
        for (Suit suite : Suit.values()) {
            for (int i = 2; i <= 14; i++) {
                cards.add(new Card(i, suite));
            }
        }
        Collections.shuffle(cards);
    }

    List<Card> dealHand(int handSize) {
        List<Card> hand = new ArrayList<>();
        for (int i = 0; i < handSize && cards.size() > 0; i++) {
            Card card = cards.remove(0); //always take 1st, as they are in random order anyway
            hand.add(card);
        }
        return hand;
    }

    int getAvailableCardCount() {
        return cards.size();
    }

    int getUsedCardCount() {
        return 52 - cards.size();
    }


    /**
     * Just for some manual tests
     */
    public static void main(String[] args) {
        CardDeck deck = new CardDeck();
        System.out.println(deck.dealHand(5)); // <- print 5 cards 3 times
        System.out.println(deck.dealHand(5));
        System.out.println(deck.dealHand(5));
        System.out.println(deck.dealHand(50)); // <- only 39 cards should be printed here
        System.out.println(deck.dealHand(50)); // <- and empty list should be printed
        deck.shuffle();
        System.out.println(deck.dealHand(5)); // <- another 5 cards
    }

}
