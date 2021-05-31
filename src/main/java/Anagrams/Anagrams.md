### Anagrams

Write a method __anagrams()__ which:
 - receives 2 String values as parameters (word1, word2);
 - checks if they are anagrams - meaning that they contain the exact same 
   letters, including the number of duplicates, but in a different order, 
   and ignoring the upper/lower case difference - and returns a boolean result
   indicating this.

_Examples:_
```
    anagrams("", "")              => true
    anagrams("A", "a")            => true
    anagrams("binary", "brainy")  => true
    anagrams("Listen", "Silent")  => true

    anagrams("ab", "ac")          => false
    anagrams("Aa", "a")           => false
    anagrams("anagram", "angrm")  => false
    anagrams("baac", "cabb")      => false
``` 