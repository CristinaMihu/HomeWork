### Distinct Words Count

Our goal now is to count only the _distinct_ words of a text. To reach the
solution for this, we will proceed with a few intermediary steps:

**a)** Write a method __splitToWords(text)__ which receives a text (a String
       value) as an input parameter, splits it to separate words, and returns
       an array containing all these words. Words are considered to be
       separated by one or more spaces.

__Hints:__
 
 - You can start with the code from previous problem (word counter), and just
   add the part for collecting the words in an array to return.
   
 - ___Comparing String values___:
 
   - Using __'=='__ will __not work correctly__ for Strings: as they are 
     reference types, not primitives, '==' will compare their address in memory,
     and may return false for Strings with same content!
 
   - Use instead the __.equals()__ method from the String class, like:   
        `"abc".equals("de") => false`  
        `myStringVar.equals("some text or var") => ..`    
     _Note that you should also handle the case when the string variable on
     which you call .equals() is null.._
        
   - _More info: [Comparing strings in Java](https://www.geeksforgeeks.org/java-equals-compareto-equalsignorecase-and-compare)_

&nbsp;

**b)** Write a method __contains(wordsArray, word)__ which receives an array
       of words (String values) and a separate specific word as input parameters
       (also String) and checks if the given word is present in the array,
       returning a boolean result (true if is contained).

&nbsp;

**c)** Write a method __distinctWordCount(text)__ which receives a text
       (a String value), splits it into words (using spaces as separators),
       and then counts only the distinct (unique) words, and returns this
       counter value. 

__Hints:__ 
 - you will need a way to compare each word with the list of unique words
   detected up until that moment, in order to decide if to increase unique
   words counter for this word or not..
 - you should use the methods defined for a), b) 

_Examples:_ 
```
    splitToWords("  ")             => [ ]
    splitToWords(" aa  bb ")       => [ "aa", "bb" ] 
    splitToWords("aa bb cc aa bb") => [ "aa", "bb", "cc", "aa", "bb" ]
    
    contains(new String[]{"aa", "bb"}, "zz")       => false
    contains(new String[]{"aa", "bb", "aa"}, "bb") => true
    
    distinctWordCount("  ")             => 0
    distinctWordCount(" aa  bb ")       => 2
    distinctWordCount("aa bb cc aa bb") => 3
```