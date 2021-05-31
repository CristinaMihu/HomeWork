package main.java.Collections.PersonRegistry;

import java.util.*;

class PersonsRegistryImpl implements PersonsRegistry {

    private final Map<Integer, Person> persons = new HashMap<>();

    @Override
    public void register(Person p) {
        System.out.println("Registering person: " + p);
        if (persons.containsKey(p.getCnp())) {
            System.err.println("Error: person with same cnp already registered: " + persons.get(p.getCnp()));
        } else {
            persons.put(p.getCnp(), p);
        }
    }

    @Override
    public void unregister(int cnp) {
        System.out.println("Unregistering person with cnp: " + cnp);
        persons.remove(cnp);
    }

    @Override
    public int count() {
        return persons.size();
    }

    @Override
    public Set<Integer> cnps() {
        return new TreeSet<>(persons.keySet());
    }

    @Override
    public Set<String> uniqueNames() {
        Set<String> names = new TreeSet<>();
        for (Person p : persons.values()) {
            names.add(p.getName());
        }
        return names;
    }

    @Override
    public Person findByCnp(int cnp) {
        return persons.get(cnp);
    }

    @Override
    public Set<Person> findByName(String name) {
        Set<Person> results = new HashSet<>();
        for (Person p : persons.values()) {
            if (p.getName().equalsIgnoreCase(name)) {
                results.add(p);
            }
        }
        return results;
    }

    @Override
    public double averageAge() {
        if (persons.isEmpty()) return 0;
        int sum = 0;
        for (Person p : persons.values()) {
            sum += p.getAge();
        }
        return (double) sum / persons.size();
    }

    @Override
    public double adultsPercentage() {
        if (persons.isEmpty()) return 0;
        int adults = 0;
        for (Person p : persons.values()) {
            if (p.getAge() >= 18) {
                adults++;
            }
        }
        return ((double) adults / persons.size() * 100);
    }

    @Override
    public double adultsWhoVotedPercentage() {
        int adults = 0;
        int voted = 0;
        for (Person p : persons.values()) {
            if (p.getAge() >= 18) {
                adults++;
                if (p.isHasVoted()) {
                    voted++;
                }
            }
        }
        return adults == 0 ? 0 : ((double) voted / adults * 100);
    }

    /**
     * Just for some manual tests
     */
    public static void main(String[] args) {
        PersonsRegistryImpl reg = new PersonsRegistryImpl();
        reg.register(new Person(1234, "Ion", 14, false));
        reg.register(new Person(2233, "Ana", 12, false));
        reg.register(new Person(2678, "Ana", 3, false));
        reg.register(new Person(1235, "Costel", 21, false));
        reg.register(new Person(2367, "Maria", 33, true));

        System.out.println("Registered persons count: " + reg.count());
        System.out.println("Average age: " + reg.averageAge());
        System.out.println("Adults percentage: " + reg.adultsPercentage());
        System.out.println("Voters percentage (vs all adults): " + reg.adultsWhoVotedPercentage());

        System.out.println("Unique names: " + reg.uniqueNames());
        System.out.println("Persons named 'ana': " + reg.findByName("ana"));
        System.out.println("Person with cnp 2678: " + reg.findByCnp(2678));
        System.out.println("Person with cnp 1000: " + reg.findByCnp(1000));

        reg.unregister(2678);
        System.out.println("Registered persons count: " + reg.count());
        System.out.println("Person with cnp 2678: " + reg.findByCnp(2678));
    }
}
