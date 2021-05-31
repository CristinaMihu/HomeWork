### First power above

Write a method which receives two input parameters - 'base' and 'limit' (both
are integer numbers, and you may assume/expect them to be positive) - and then
computes the successive powers of 'base'  (base ^ x), stopping and returning
the first such power which is greater than the given 'limit' value.

_Examples:_

```
firstPowerAbove(2, 1000) => 1024  (as: 2^9=512, 2^10=1024 > 1000)
firstPowerAbove(7, 0.1)  =>    1  (as: 7^0 = 1 > 0.1)
```



___Question__: we could use at each step the method `Math.pow()` to compute
               the power value. How efficient is this? Does your code perform
               any unnecessary/repeating operations between consecutive steps?
               Can you find a more efficient solution? (to perform a minimum
               number of multiplications)_