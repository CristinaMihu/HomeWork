### FizzBuzz

a) Write a method 'String fizzBuzz(int n)' which receives an integer number as
   an input parameter and returns one of the possible result values:
   - "fizz" - if the number can be divided by 3
   - "buzz" - if it can be divided by 5
   - "fizzbuzz" - if it can be divided by both 3 and 5
   - the number itself (as a String) - in all other cases

  _Examples:_
  ```
  fizzbuzz(2)  => "2"
  fizzbuzz(15) => "fizzbuzz"
  fizzbuzz(10) => "buzz"
  fizzbuzz(9)  => "fizz"
  ```

b) Write a method 'void printAllFizzBuzzUpTo(int n)' which receives an integer
   number n as input param, returns no value (void) and for each number from
   interval 1..n it prints its 'fizzbuzz' value (according to logic from point
   a), each on a separate line.