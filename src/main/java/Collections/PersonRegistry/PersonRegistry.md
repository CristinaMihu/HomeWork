### Persons Registry

We want to create a class which can hold the details of some registered persons,
and then allow us to search for them, and get some statistical info about them.

1. Create a **Person** class having these properties:
   - _cnp_      - an integer (optional: validate value is > 0)
   - _name_     - a string   (optional: validate it's not empty)
   - _age_      - an integer (optional: validate value is > 0)
   - _hasVoted_ - a boolean, true if person has voted in last elections

2. You are given a **PersonsRegistry** _interface_.  
   Create a **PersonsRegistryImpl** class which implements this interface.

   _Notes:_
   
     - The methods implementations should respect not only the contract
       imposed by the interface, but you should _also consider the details
       from the method comments!_ (like for handling special cases, etc)
     
     - The class will need some way to store a group of persons. Which
       collection type would be a good fit here? (_hint_: it may be preferable
       to index the persons by their cnp, for easy searching later and also
       for easier validation that there are no duplicate cnp values...)

```java
     public interface PersonsRegistry {
    
       //Adds a new person to the registry. If a person with same CNP already exists,
       //it will NOT register this new person (just ignore it, and show an error)
       void register(Person p);
    
       //Finds a person by cnp and removes it from registry.
       //If person is not found, will still work (no errors, and does nothing)
       void unregister(int cnp);
    
       //Get the number of currently registered persons.
       int count();
    
       //Get the list of cnp values of all persons.
       Set<Integer> cnps();
    
       //Get the list of unique names of all persons.
       Set<String> uniqueNames();
    
       //Find a person by cnp; returns null if no person found.
       Person findByCnp(int cnp);
    
       //Find the persons with a specified name (may be zero, one or more)
       //Comparing person name with specified name should be case insensitive.
       Set<Person> findByName(String name);
    
       //Get the average age for all persons (or 0 if it cannot be computed)
       double averageAge();
    
       //Get the percent (value between 0-100) of adults (persons with age>=18)
       //from the number of all persons (or 0 as default if it cannot be computed)
       double adultsPercentage();
    
       //Get the percent (value between 0-100) of adults who voted
       //from the number of all adult persons (age>=18)
       double adultsWhoVotedPercentage();
     }
```

Once solved, run all the provided JUnit tests.
