package main.java.Collections.CardDeck;

import java.util.Objects;

public class Card {

    private final int number;
    private final Suit suit;

    Card(int number, Suit suit) {
        this.number = number;
        this.suit = suit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return number == card.number && Objects.equals(suit, card.suit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, suit);
    }

    @Override
    public String toString() {
        return "{" + number + " of " + suit + "}";
    }
}
