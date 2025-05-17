package FamilyTree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String gender;
    private String birthDate;
    private Person spouse;
    private List<Person> children;

    public Person(String name, String gender, String birthDate) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.children = new ArrayList<>();
        this.spouse = null;
    }

    public void marry(Person spouse) {
        this.spouse = spouse;
        spouse.spouse = this;
    }

    public void addChild(Person child) {
        children.add(child);
    }

    public List<Person> getChildren() {
        return children;
    }

    public Person getSpouse() {
        return spouse;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public boolean isMarried() {
        return spouse != null;
    }

    public List<Person> getUnmarriedPeople() {
        List<Person> unmarried = new ArrayList<>();
        if (!isMarried()) {
            unmarried.add(this);
        }
        for (Person child : children) {
            unmarried.addAll(child.getUnmarriedPeople());
        }
        return unmarried;
    }

    public List<Person[]> getCouplesWithTwoChildren() {
        List<Person[]> couples = new ArrayList<>();
        if (isMarried() && children.size() == 2) {
            couples.add(new Person[]{this, spouse});
        }
        for (Person child : children) {
            couples.addAll(child.getCouplesWithTwoChildren());
        }
        return couples;
    }

    public List<Person> getLatestGeneration() {
        if (children.isEmpty()) {
            List<Person> result = new ArrayList<>();
            result.add(this);
            return result;
        }
        List<Person> latestGen = new ArrayList<>();
        for (Person child : children) {
            latestGen.addAll(child.getLatestGeneration());
        }
        return latestGen;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", spouse=" + (spouse != null ? spouse.getName() : "None") +
                ", children=" + children.size() +
                '}';
    }
} 