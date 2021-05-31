package main.java.Collections.BuildingRegistry;

import java.util.*;

enum Category {
    RESIDENTIAL, OFFICE, HOSPITAL, RELIGIOUS
}

class Building {
    private Category category;
    private int price;
    private String neighborhood;

    public Building(Category category, int price, String neighborhood) {
        this.category = category;
        this.price = price;
        this.neighborhood = neighborhood;
    }

    public Category getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }

    public String getNeighborhood() {
        return neighborhood;
    }
}

class BuildingRegistry {

    static int categoriesCount(List<Building> buildings) {
        Set<Category> categs = new HashSet<>();

        for (Building b : buildings) {
            categs.add(b.getCategory());
        }
        System.out.println("used categories: " + categs);

        return categs.size();

        /*Map<Category, Boolean> usageMap = new HashMap<>();
        for (Building b : buildings) {
            usageMap.put(b.getCategory(), true);
        }
        return usageMap.size();*/
    }

    //version1: using a Set to eliminate duplicate names (then convert to list)
    static List<String> neighborhoodsList(List<Building> buildings) {

        Set<String> namesSet = new TreeSet<>(); //using a TreeSet implementation to also have them sorted directly

        for (Building b : buildings) {
            namesSet.add(b.getNeighborhood());
        }

        /*List list = new ArrayList();
        list.addAll(namesSet);
        return list;*/

        return new ArrayList<>(namesSet);
    }

    //version2: using directly a list, and manually avoiding to add duplicates to it
    static List<String> neighborhoodsList_v2(List<Building> buildings) {

        List<String> namesList = new ArrayList<>();

        for (Building b : buildings) {
            String name = b.getNeighborhood();

            if (!namesList.contains(name)) {
                namesList.add(name);
            }
        }

        Collections.sort(namesList); //need to also sort it

        return namesList;
    }

    static double averagePriceForOneCategory(List<Building> buildings, Category selectedCategory) {

        double sum = 0;
        int count = 0;

        for (Building b : buildings) {
            //if (b.getCategory().equals(selectedCategory)) {
            if (b.getCategory() == selectedCategory) {
                sum += b.getPrice();
                count++;
            }
        }

        return count == 0 ? 0 : sum / count;
    }

    static Map<Category, Double> averagePricePerCategory(List<Building> buildings) {

        //--- version1: simpler, but not very fast (looks over all building 4 times!), and required writing averagePriceForOneCategory()
        Map<Category, Double> map = new HashMap<>();
        for (Category cat : Category.values()) {
            double avgPrice = averagePriceForOneCategory(buildings, cat);
            map.put(cat, avgPrice);
        }
        return map;


        //--- version 2: more complex, but faster (looks at buildings only once)
        /*
        Map<Category, Integer> pricesMap = new HashMap<>();
        Map<Category, Integer> countMap = new HashMap<>();

        for (Building b : buildings) {

            //update prices map
            int oldSum = pricesMap.getOrDefault(b.getCategory(), 0);
            pricesMap.put(b.getCategory(), oldSum + b.getPrice());

            //update count map
            int oldCount = countMap.getOrDefault(b.getCategory(), 0);
            countMap.put(b.getCategory(), oldCount + 1);
        }

        System.out.println("prices map: " + pricesMap);
        System.out.println("count map: " + countMap);


        Map<Category, Double> avgMap = new HashMap<>();
        for (Category cat : pricesMap.keySet()) {
            double sum = pricesMap.get(cat);
            int count = countMap.get(cat);

            double avg = sum / count;

            avgMap.put(cat, avg);
        }

        System.out.println("final map with average price pe categ: " + avgMap);
        return avgMap;
         */
    }

    static Map<String, Double> averagePricePerNeighborhood(List<Building> buildings) {
        Map<String, Double> avgMap = new HashMap<>();

        Map<String, Double> priceMap = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>();
        for (Building b : buildings) {
            double oldSum = priceMap.getOrDefault(b.getNeighborhood(), 0.0);
            priceMap.put(b.getNeighborhood(), oldSum + b.getPrice());

            int oldCount = countMap.getOrDefault(b.getNeighborhood(), 0);
            countMap.put(b.getNeighborhood(), oldCount + 1);
        }

        for (String neigh : priceMap.keySet()) {

            double sum = priceMap.get(neigh);
            int count = countMap.get(neigh);
            avgMap.put(neigh, sum / count);
        }
        return avgMap;

    }


    /**
     * Some manual tests
     */
    public static void main(String[] args) {

        List<Building> buildings = Arrays.asList(
                new Building(Category.OFFICE, 10, "tudor"),
                new Building(Category.OFFICE, 40, "centru"),
                new Building(Category.OFFICE, 20, "pacurari"),
                new Building(Category.RESIDENTIAL, 15, "pacurari"),
                new Building(Category.HOSPITAL, 35, "pacurari"),
                new Building(Category.HOSPITAL, 30, "copou"));

        System.out.println("Actual categories: " + categoriesCount(buildings));

        System.out.println("Actual neighborhoods: " + neighborhoodsList(buildings));

        System.out.println("Average price for OFFICE category: " + averagePriceForOneCategory(buildings, Category.OFFICE));
        System.out.println("Average price for RELIGIOUS category: " + averagePriceForOneCategory(buildings, Category.RELIGIOUS));

        System.out.println("Average price per category: " + averagePricePerCategory(buildings));
        System.out.println("Average price per neighborhood: " + averagePricePerNeighborhood(buildings));
    }
}

