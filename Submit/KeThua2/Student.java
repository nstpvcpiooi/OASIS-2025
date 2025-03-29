public class Student extends Person {
    private String program;
    private int year;
    private double fee;

    /** Constructor. */
    public Student(String name, String address) {
        super(name, address);
    }

    /** Constructor. */
    public Student(String name, String address, String program, int year, double fee) {
        super(name, address);
        this.program = program;
        this.year = year;
        this.fee = fee;
    }

    /** Get Program. */
    public String getProgram() {
        return program;
    }

    /** Set Program. */
    public void setProgram(String program) {
        this.program = program;
    }

    /** Get Year. */
    public int getYear() {
        return year;
    }

    /** Set Year. */
    public void setYear(int year) {
        this.year = year;
    }

    /** Get Fee. */
    public double getFee() {
        return fee;
    }

    /** Set Fee. */
    public void setFee(double fee) {
        this.fee = fee;
    }

    /** To String. */
    public String toString() {
        return "Student[" + super.toString() + ",program=" + this.program
                + ",year=" + this.year + ",fee=" + this.fee + "]";
    }
}