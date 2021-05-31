### 9. Reverse array (16p)

1. Write a method __reversedCopy(array)__ which receives as input parameter
   an array of String values, and returns a copy of the array containing
   the same elements, but in reversed order (first one becomes last one, etc)
   
   __Note__: the result should be a new (separate) array, and the original array
             should remain unchanged!

2. Write a similar method __reverse(array)__ which also receives an array of
   String values, but returns no value (result type is 'void'), and performs
   an in-place update of the original array, so after the method call finishes,
   the array's elements are now in reversed order.

   - __Note__: you should __not__ use the existing `Collections.reverse()`
               method (or check its implementation), but write your own solution.

   - ___Hint__: it could be useful to define first a helper method 
                `swapPositions(String[] arr, int i, int j)` which will swap
                 between them the values of elements from 2 specified indexes
                 (i,j) in the given array, and then use it to implement
                 the methods for b)_