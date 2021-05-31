### Fibonacci

Write a method which computes the numbers of _Fibonacci's sequence_.
This sequence is defined recursively in math, like this: 
> fib(0) = 1,  
  fib(1) = 1  
  fib(N) = fib(N-1) + fib(N-2)

_More info: [Fibonacci number (wikipedia)](https://en.wikipedia.org/wiki/Fibonacci_number)_

a) Write a method __fibonacci__ which receives as input param a number N and
   returns the value of fibonacci(N). Test it for various values of N (0,1,10,..)

b) Write a method __fibonacciSequence__ which receives a number N and returns
   an array of length N containing the first N numbers of the fibonacci sequence
   (meaning: _fib(0) ... fib(N-1)_)


_Examples:_
```
fibonacci(1)  => 1
fibonacci(10) => 89
fibonacci(20) => 10946

fibonacciSequence(20) =>  [1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946]
```