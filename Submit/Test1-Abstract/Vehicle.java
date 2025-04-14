public abstract class Vehicle {
    protected String brand;
    protected String model;
    protected String registrationNumber;
    protected Person owner;

    /**
     * Constructor for the Vehicle class.
     *
     * @param brand The brand of the vehicle.
     * @param model The model of the vehicle.
     * @param registrationNumber The registration number of the vehicle.
     * @param owner The owner of the vehicle.
     */
    public Vehicle(String brand, String model, String registrationNumber, Person owner) {
        this.brand = brand;
        this.model = model;
        this.registrationNumber = registrationNumber;
        this.owner = owner;
    }

    /**
     * Abstract method to get information about the vehicle.
     *
     * @return A string containing information about the vehicle.
     */
    protected abstract String getInfo();

    /**
     * Method to transfer ownership of the vehicle to a new owner.
     *
     * @param newOwner The new owner of the vehicle.
     */
    void transferOwnership(Person newOwner) {
        this.setOwner(newOwner);
    }

    /**
     * Method to get the brand of the vehicle.
     *
     * @return The brand of the vehicle.
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Method to set the brand of the vehicle.
     *
     * @param brand The brand of the vehicle.
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Method to get the model of the vehicle.
     *
     * @return The model of the vehicle.
     */
    public String getModel() {
        return model;
    }

    /**
     * Method to set the model of the vehicle.
     *
     * @param model The model of the vehicle.
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Method to get the registration number of the vehicle.
     *
     * @return The registration number of the vehicle.
     */
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    /**
     * Method to set the registration number of the vehicle.
     *
     * @param registrationNumber The registration number of the vehicle.
     */
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    /**
     * Method to get the owner of the vehicle.
     *
     * @return The owner of the vehicle.
     */
    public Person getOwner() {
        return owner;
    }

    /**
     * Method to set the owner of the vehicle.
     *
     * @param owner The owner of the vehicle.
     */
    public void setOwner(Person owner) {
        this.owner = owner;
    }
}
