public class Car extends Vehicle {
    private int numberOfDoors;

    /**
     * Constructor for the Car class.
     *
     * @param brand The brand of the car.
     * @param model The model of the car.
     * @param registrationNumber The registration number of the car.
     * @param owner The owner of the car.
     * @param numberOfDoors The number of doors in the car.
     */
    public Car(String brand, String model, String registrationNumber,
               Person owner, int numberOfDoors) {
        super(brand, model, registrationNumber, owner);
        this.numberOfDoors = numberOfDoors;
    }

    /**
     * Method to get the information of the car.
     *
     * @return A string containing the information of the car.
     */
    public String getInfo() {
        return "Car:\n"
                + "\tBrand: " + brand + "\n"
                + "\tModel: " + model + "\n"
                + "\tRegistration Number: " + registrationNumber + "\n"
                + "\tNumber of Doors: " + numberOfDoors + "\n"
                + "\tBelongs to " + owner.getName() + " - " + owner.getAddress();
    }

    /**
     * Method to get the number of doors in the car.
     *
     * @return The number of doors in the car.
     */
    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    /**
     * Method to set the number of doors in the car.
     *
     * @param numberOfDoors The number of doors in the car.
     */
    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }
}
