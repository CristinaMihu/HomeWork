### Josephus problem
 
A number of N soldiers (named as 1..N) are standing in a circle, waiting to be
executed. Counting starts in one direction (ascending by their numbers) and
every M-th is killed. The last remaining one is spared. Which soldier remains
the last one? (print the numbers of killed soldiers, in their elimination order,
and the name/number of the remaining one)

_More details:
[Josephus problem (wikipedia)](https://en.wikipedia.org/wiki/Josephus_problem)_
 
_Examples:_
 
    N = 1, M = 1  =>  remaining: 1
    N = 3, M = 1  =>  eliminated: 1, 2;   remaining: 3
    N = 7, M = 2  =>  eliminated: 2, 4, 6, 1, 5, 3;   remaining: 7
    N =10, M = 3  =>  eliminated: 3, 6, 9, 2, 7, 1, 8, 5, 10;   remaining: 4
 
**Hints:**
 
 - Would be nicer (and easier to manually test it) if your code would print
   at each step some info like the current remaining list of soldiers
   and the number of the soldier chosen to be next;
   
 - May be solved using either: 
   - a _regular List (or array)_ - but you need to make sure you count correctly
     when reaching the end of list ('roll' your counter correctly over the
     list size limit - what arithmetic operator could be useful here?...)
   - or: a _custom circular linked list_ (harder to create it, easier to count)
 