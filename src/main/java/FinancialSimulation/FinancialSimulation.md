### Financial simulation 

John wants to open a deposit to a bank, and wonders in how many years he will
accumulate a desired total amount, considering the interest added each year
to his deposit.

Write a method to help him check various scenarios, and find out in how many
years can he happily retire :)

Method format:  __simulate( initial, interest_rate_pct, target)__
 - __initial__ - the initial amount added when creating the deposit
 - __interest_rate_pct__:
   - the yearly interest rate, as a percent! For example, "2.5" means 2.5% 
     (meaning 0.025 as an absolute factor)
   - after each year, the yearly interest is computed based on this rate and
     the current deposit amount, and then this value is added to the deposit
     (increasing its current amount, for next year)
 - __target__: the amount at which John wants to arrive.

The method should:
 - Compute the interest and total amount after each year, and display these
   clearly (including year number!)
 - Stop when the total deposit amount grows bigger than the target amount
 - Return as final result the number of years taken to reach the target amount


_Examples:_

 - Scenario 1:  simulate (1000, 10, 1500):
   - returns 5 
   - should also print:
     ```
     Simulation parameters: initial= 1000, interest= 10%, target= 1500
       Year 1: amount: 1000.00, interest: 100.00 => total amount: 1100.00
       Year 2: amount: 1100.00, interest: 110.00 => total amount: 1210.00
       Year 3: amount: 1210.00, interest: 121.00 => total amount: 1331.00
       Year 4: amount: 1331.00, interest: 133.10 => total amount: 1464.10
       Year 5: amount: 1464.10, interest: 146.41 => total amount: 1610.51
     Can happily retire in: 5 years!
     ```
  
 - Scenario 2:  simulate (1000, 2.5, 1500):
   - returns 17 
   - should also print:
     ```
     Simulation parameters: initial= 1000, interest= 2.5%, target= 1500
       Year 1: amount: 1000.00, interest: 25.00 => total amount: 1025.00
       Year 2: amount: 1025.00, interest: 25.62 => total amount: 1050.62
       ...
       Year 17: amount: 1484.51, interest: 37.11 => total amount: 1521.62
     Can happily retire in: 17 years!
     ```
