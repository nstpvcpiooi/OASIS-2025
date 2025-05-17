package FamilyTree;

import java.util.List;

public class FamilyTreeDemo {
    public static void main(String[] args) {
        // Create family members
        Person james = new Person("James", "Male", "1970-01-01");
        Person hana = new Person("Hana", "Female", "1972-02-02");
        Person ryan = new Person("Ryan", "Male", "1995-03-03");
        Person kai = new Person("Kai", "Male", "1997-04-04");
        Person jennifer = new Person("Jennifer", "Female", "1998-05-05");

        // Create children of Kai and Jennifer
        Person child1 = new Person("Child1", "Male", "2020-01-01");
        Person child2 = new Person("Child2", "Male", "2021-02-02");
        Person child3 = new Person("Child3", "Female", "2022-03-03");
        Person child4 = new Person("Child4", "Female", "2023-04-04");

        // Build family relationships
        james.marry(hana);
        james.addChild(ryan);
        james.addChild(kai);
        kai.marry(jennifer);
        kai.addChild(child1);
        kai.addChild(child2);
        kai.addChild(child3);
        kai.addChild(child4);

        // Test 1: Find all unmarried people
        System.out.println("Unmarried people:");
        List<Person> unmarried = james.getUnmarriedPeople();
        for (Person person : unmarried) {
            System.out.println(person);
        }

        // Test 2: Find couples with two children
        System.out.println("\nCouples with two children:");
        List<Person[]> couples = james.getCouplesWithTwoChildren();
        for (Person[] couple : couples) {
            System.out.println(couple[0].getName() + " and " + couple[1].getName());
        }

        // Test 3: Find latest generation
        System.out.println("\nLatest generation:");
        List<Person> latestGen = james.getLatestGeneration();
        for (Person person : latestGen) {
            System.out.println(person);
        }
    }
} 