### Hangman

Code the 'hangman' game:
 - computer reads some words from a text file (dictionary, contains one word
   per line) and chooses a random one;
   
 - it then prints the first and last letter of the word, and the '_' character
   for each of the intermediary letters. Note: if there are other intermediary
   letters which are the same as first/last letter, they should be displayed
   too, not masked. (example: for `"transportor"`, show: `"tr-----rt-r"`)
   
 - user is given a number of attempts (like 7) to guess the remaining letters: 
   - computer reads a letter, and if it belongs to the word, it displays it
     in the proper location (instead of '_');
   - if letter doesn't belong to the word, user loses an attempt;
   - if user guesses all letters, he wins; if he runs out of attempts, he loses.


**[Optional]:** 
 - make the game have 3 difficulty levels: easy, medium, hard; depending
   on them, select only the shorter or longer words for the dictionary file;
  
 - depending on word's length and/or difficulty level, show him a different
   number of letters when starting the game (2-3-4..)
  
 - also change your code to display first the letters from some random positions
   (instead of always the first and last letters)
 
 - add a ASCII graphical representation of the hanging man? (updated on each step)
