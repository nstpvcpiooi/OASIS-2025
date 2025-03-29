public class Staff extends Person {
    private String school;
    private double pay;

    /** Constructor. */
    public Staff(String name, String address) {
        super(name, address);
    }

    /** Constructor. */
    public Staff(String name, String address, String school, double pay) {
        super(name, address);
        this.school = school;
        this.pay = pay;
    }

    /** Get School. */
    public String getSchool() {
        return school;
    }

    /** Set School. */
    public void setSchool(String school) {
        this.school = school;
    }

    /** Get Pay. */
    public double getPay() {
        return pay;
    }

    /** Set Pay. */
    public void setPay(double pay) {
        this.pay = pay;
    }

    /** To String. */
    public String toString() {
        return "Staff[" + super.toString() + ",school=" + this.school
                + ",pay=" + this.pay + "]";
    }
}
