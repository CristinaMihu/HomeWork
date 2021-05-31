### Number guessing game

a) Code this simple game:
  - computer chooses a secret random number between 1 and 100;
  - it then asks the user to guess this number;
  - it then compares the user guess with its secret number:
    - if they are _equal_: game over, user won (guessed it); 
    - if they are _different_: computer responds with `"My number is Higher"`/
      `"My number is Lower"`, depending on how the guess is vs the secret number;
  -  if game didn't end yet, it should repeat these steps, allowing the user 
     to try at most 7 guesses (after that, the game ends with user loosing).

**Hint**: start simple, and then make it more complex step by step:
  - First choose a random number, in a given range, and display it 
    (test it repeatedly to check the generated numbers);
  - Read user input (1 guess), and print Yes/No if he guessed the number;
  - Read user input repeatedly, up to a maximum number of allowed tries;
  - After each wrong guess, give user also hints (higher/lower..);
  - Display to user nice messages, including the number of current count,
    and the computer chosen number if he loses the game.

**[Optional]**: make the game playable multiple times (without 
  restarting the app), and keep/display a global score (wins vs loses) 

___
b) **[Optional]** Reversed game:
  - now ask the user to choose a secret random number between 1..100;
  - computer tries to guess it (max 10 attempts), displaying a number
    it chose and asking the user to confirm if this number is Equal, 
    Lower or Higher than his secret number.
