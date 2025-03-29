public class Person {
    private String name;
    private String address;

    /** Constructor. */
    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    /** Get Name. */
    public String getName() {
        return name;
    }

    /** Get Address. */
    public String getAddress() {
        return address;
    }

    /** Set Name. */
    public void setName(String name) {
        this.name = name;
    }

    /** Set Address. */
    public void setAddress(String address) {
        this.address = address;
    }

    /** To String. */
    public String toString() {
        return "Person[name=" + this.name + ",address=" + this.address + "]";
    }
}
