### Buildings Registry

1. Create a **Building** class representing a building, with these properties:
   - category (possible values: residential, office, hospital, religious)
   - price
   - neighborhood
   

2. Create a **BuildingRegistry** class, containing these _static_ methods
   (each receives a `List<Building>` as an input parameter, and you need
   to decide on their return type):

   - **`categoriesCount()`** - returns the number of categories (of the
     actual buildings, not all possible categories)
     
   - **`neighborhoodsList()`** - returns the list of names of unique
     neighborhoods, sorted alphabetically (hint: may use a Set; what
     implementation could you use to also help you with sorting?..)

   - **`averagePriceForOneCategory()`** - returns the average price for
     buildings from only one category (given as a 2nd input param to the method)
     - _Question: what should be the return type for this method?.._

   - **`averagePricePerCategory()`** - returns the average price for each
     building category (note: for the defined categories which don't have
     any buildings now, you may either not return any key in map, or you
     may return a key but with value 0, as you like)
     - _Question: what kind of return type should this method have?
       (as it should return an average price for each used category,
        so kind of returning a list of pairs of 2 values - category+price)_

   - **`averagePricePerNeighborhood()`** - returns the average price for each neighborhood.
