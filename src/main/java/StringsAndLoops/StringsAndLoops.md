### Strings, loops (warm-up)

**a)** Write a method __ends(text)__ which receives a string value as a
       parameter and returns another string composed of only the first
       and last letter (the 'ends') of the original string.

   _Example:_
   ```
   ends("abcdef") => "af"
   ends("ab")     => "ab"
   ends("a")      => "a"
   ends("")       => ""
   ```
&nbsp;

**b)** Write a method __middle(text)__ which receives a string value as a
       parameter and returns another string composed of only the letters
       placed exactly in the middle of the original string (may get 0-2
       letters, depending on text's length)

   _Example:_
   ``` 	
   middle("abcdef") => "cd", 
   middle("abc")    => "b", 
   middle("ab")     => "ab",
   middle("a")      => "a",
   middle("")       => ""
   ```
&nbsp;

**c)** Write a method __onlyUpper(text)__ which receives a string value as a
       parameter and returns another string composed of only the uppercase
       letters of the original string (in the same order).

   _Example:_
   ```
   onlyUpper("A Fost OdaTa..") => "AFOT"
   ```
&nbsp;

**d)** Write a method __contains(text, letter)__ which receives a text
       (String) and a letter (char), and returns a boolean result of true
       if text contains that letter, or false otherwise.
   
   _Example:_
   ```
   contains("abcde", 'x')  => false
   contains("abcde", 'c')  => true
   ```

   __[Optional]__ Try to write the code in a few different ways:
   - first without using arrays (iterate over the string, with .charAt()..)
   - then with arrays (converting the string to array first - toCharArray())
   - for iteration: use first 'while' or regular 'for' loop (with manual
     management of index), then with a simplified 'for' loop (foreach)

&nbsp;

**e)** Write a method __count(text, letter)__ which counts how many times does
       the given letter appear in the given text, and returns this counter value.
	
   _Example:_ 	
   ```
   count("aabcdeef", 'e') => 2
   count("aabcdeef", 'y') => 0
   ```
&nbsp;

**f)** Write a method __countVowels(text)__ which receives a String value as
       a parameter, counts how many vowels (_a,e,i,o,u_) it contains and
       returns this counter.

   _Example:_
   ```
   countVowels("aabcdeefo u!") => 6
   count_vowels("xyzpv?")      => 0
   ```
&nbsp;

**g)** Write a method __isSorted(text)__ which receives a String value as a
       parameter and checks if its characters are all sorted alphabetically
       (in ascending order by their ascii code), and returns true in this case. 
       _(note: non-strict order, meaning equal elements are ok)_

   _Example:_
   ```
   isSorted("")       => true
   isSorted("ab")     => true
   isSorted("abdeez") => true
   isSorted("abca?")  => false
   ```
&nbsp;

**h)** Write a method __sorted(text)__ which receives a String as a parameter,
       and returns a new String with the same letters, but sorted alphabetically.

   _Example:_
   ```
   sorted("eddab") => "abdde"
   ```
________________________________________________________________________________
 