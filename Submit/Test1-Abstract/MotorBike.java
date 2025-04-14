public class MotorBike extends Vehicle {
    private boolean hasSidecar;

    /**
     * Constructor for the MotorBike class.
     *
     * @param brand The brand of the motorbike.
     * @param model The model of the motorbike.
     * @param registrationNumber The registration number of the motorbike.
     * @param owner The owner of the motorbike.
     * @param hasSidecar Indicates if the motorbike has a sidecar.
     */
    public MotorBike(String brand, String model, String registrationNumber,
                     Person owner, boolean hasSidecar) {
        super(brand, model, registrationNumber, owner);
        this.hasSidecar = hasSidecar;
    }

    /**
     * Method to get the information of the motorbike.
     *
     * @return A string containing the information of the motorbike.
     */
    public String getInfo() {
        return "Motor Bike:\n"
                + "\tBrand: " + brand + "\n"
                + "\tModel: " + model + "\n"
                + "\tRegistration Number: " + registrationNumber + "\n"
                + "\tHas Side Car: " + hasSidecar + "\n"
                + "\tBelongs to " + owner.getName() + " - " + owner.getAddress();
    }

    /**
     * Method to check if the motorbike has a sidecar.
     *
     * @return true if the motorbike has a sidecar, false otherwise.
     */
    public boolean isHasSidecar() {
        return hasSidecar;
    }

    /**
     * Method to set if the motorbike has a sidecar.
     *
     * @param hasSidecar Indicates if the motorbike has a sidecar.
     */
    public void setHasSidecar(boolean hasSidecar) {
        this.hasSidecar = hasSidecar;
    }
}
