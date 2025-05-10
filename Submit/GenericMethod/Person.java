public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String address;

    /**
     * Default constructor.
     */
    public Person() {
        this.name = "";
        this.age = 0;
        this.address = "";
    }

    /**
     * Constructor with parameters.
     *
     * @param name the name of the person.
     * @param age the age of the person.
     * @param address the address of the person.
     */
    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    /**
     * Get name.
     *
     * @return the name of the person.
     */
    public String getName() {
        return name;
    }

    /**
     * Set name.
     *
     * @param name the name of the person.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get age.
     *
     * @return the age of the person.
     */
    public int getAge() {
        return age;
    }

    /**
     * Set age.
     *
     * @param age the age of the person.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Get address.
     *
     * @return the address of the person.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set address.
     *
     * @param address the address of the person.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /** Compare this person with another person by name.
     *
     * @param other the other person to compare with.
     * @return a negative integer, zero, or a positive integer as this person
     *         is less than, equal to, or greater than the specified object.
     */
    public int compareTo(Person other) {
        int nameCompare = this.name.compareTo(other.getName());
        if (nameCompare != 0) {
            return nameCompare;
        }
        return Integer.compare(this.age, other.getAge());
    }
}
