### Word counting (warm-up)

You have a text (a String value) composed of multiple words, separated
by some space(s).

Write the methods to fulfill the requirements below.

**Note:** for this exercise, try to __avoid using arrays__ in your code (think
instead which of the recently learned collections types could help you best
in each case)


1. `List<String> words(String text)` - receives a text (as a String), splits it
   into separate words (using spaces as separators) and returns all words as
   a list (preserving their initial order, and including possible duplicates)
   _(hint: may use String.split(), even regular expressions..)_

2. `int wordCount(String text)` - receives a text and returns the number of
   words it contains. _(hint: make use of the previous method)_

3. `Collection<String> sortedWords(String text)` - returns all the words
   contained in the text, sorted alphabetically. _(hint: see Collections.sort())_

4. `Collection<String> distinctWords(String text)` - returns only the _distinct_
   words (no duplicates) contained in the text, in their initial order.

5. `Collection<String> distinctSortedWords(String text)` - returns only the
   _distinct_ words contained in the text, also _sorted alphabetically_.

6. `Map<String, Integer> wordsUsageCount(String text)` - for each distinct word,
   it counts how many times it appears in text, and returns this info as a Map,
   where the keys are the words and the value is its usage counter.

7. `Map<String, Integer> wordsUsageCountSortedByWord(String text)` - the same,
   but now sort the word-count pairs alphabetically by word.

8. **[Optional]**:
   `List<Map.Entry<String, Integer>> wordsUsageCountSortedByCountThenWord(String text)` -
   similar to the previous ones, it computes and returns a list of
   (word,usage count) pairs, but now as a List and sorted in this custom order:
   first by count (descending), then alphabetically by word 


_Examples:_

``` 
    text: "Once upon a time in a land far far away there lived a great king whose name was a great mystery"
    
    all (initial order): [once, upon, a, time, in, a, land, far, far, away, there, lived, a, great, king, whose, name, was, a, great, mystery]
    word count: 21
    
    all (sorted): [a, a, a, a, away, far, far, great, great, in, king, land, lived, mystery, name, once, there, time, upon, was, whose]
    unique (initial order): [once, upon, a, time, in, land, far, away, there, lived, great, king, whose, name, was, mystery]
    unique (sorted): [a, away, far, great, in, king, land, lived, mystery, name, once, there, time, upon, was, whose]
    
    word counts (initial order): {once=1, upon=1, a=4, time=1, in=1, land=1, far=2, away=1, there=1, lived=1, great=2, king=1, whose=1, name=1, was=1, mystery=1}
    word counts (sorted by word): {a=4, away=1, far=2, great=2, in=1, king=1, land=1, lived=1, mystery=1, name=1, once=1, there=1, time=1, upon=1, was=1, whose=1}
    word counts (sorted by count, then word): [a=4, far=2, great=2, away=1, in=1, king=1, land=1, lived=1, mystery=1, name=1, once=1, there=1, time=1, upon=1, was=1, whose=1]
```