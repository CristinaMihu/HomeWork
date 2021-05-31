### Card Deck

1. Create a **Card** class to represent each individual card in a deck.
   It should have 2 fields: 
   - number (2 - 14)
   - suit - one of the 4 types: diamonds (♦), clubs (♣), hearts (♥) and spades (♠)
     (hint: use an `enum` for these values)

2. Create a **CardDeck** class to represent a full deck of cards. 

   - it should store a list of _currently available cards_, which should start
     with the full pack of 52 cards, and then be updated when dealing any cards
     so as to remember which ones are still available;
   
   - it should provide the following _methods_:
   
     - **`void shuffle()`**:
       - restores a full/complete deck (mark all the cards as available)
       - should also re-shuffle it (ensure somehow that the next `dealHand()` 
         operations will select the cards to return in some new random order,
         compared to previous rounds/the situation before this shuffle);

     - **`List<Card> dealHand(int cards)`**:
       - returns the requested number of cards from the currently available ones;
       - the returned cards should be chosen in some random order; 
       - once picked, a card is marked as 'used' ('dealt'), so its not available
         anymore when dealing next cards;
       - if there are not enough available cards left, return as many as
         possible (may even be an empty list, if the deck was empty);
             
     - **`int getAvailableCardCount()`** - returns how many cards are still
       available for selection in the deck;
       
     - **`int getUsedCardCount()`** - returns how many cards were dealt
       until now (in the current round, since the last shuffle).

**Hints:**   
 - for storing the full list of cards, as well as the lists of available/used
   cards, you could use some instances of List;
 - for shuffling a collection, you could use the `Collections.shuffle()` method.

**Testing:** 
 - Once completed, the CardDeck class should behave like this:
 
        CardDeck deck = new CardDeck();
        System.out.println(deck.dealHand(5));  // <- print 5 cards (x3 times)
        System.out.println(deck.dealHand(5));
        System.out.println(deck.dealHand(5));
        System.out.println(deck.dealHand(50)); // <- prints only 39 cards
        System.out.println(deck.dealHand(50)); // <- prints an empty list
        deck.shuffle();
        System.out.println(deck.dealHand(5));  // <- prints another 5 cards 

 - Run all the provided JUnit tests (may also add new tests of your own there)
