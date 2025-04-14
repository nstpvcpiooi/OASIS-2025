import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String address;
    private List<Vehicle> vehicleList = new ArrayList<>();

    /**
     * Constructor for the Person class.
     *
     * @param name The name of the person.
     * @param address The address of the person.
     */
    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    /**
     * Method to get the list of vehicles owned by the person.
     *
     * @return A list of vehicles owned by the person.
     */
    void addVehicle(Vehicle vehicle) {
        if (vehicle != null) {
            vehicleList.add(vehicle);
        }
    }

    /**
     * Method to remove a vehicle from the person's list of vehicles.
     *
     * @param registrationNumber The registration number of the vehicle to be removed.
     */
    void removeVehicle(String registrationNumber) {
        for (int i = 0; i < vehicleList.size(); i++) {
            if (vehicleList.get(i).getRegistrationNumber().equals(registrationNumber)) {
                vehicleList.remove(i);
                break;
            }
        }
    }

    /**
     * Method to get the name of the person.
     *
     * @return The name of the person.
     */
    public String getName() {
        return name;
    }

    /**
     * Method to set the name of the person.
     *
     * @param name The name of the person.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method to get the address of the person.
     *
     * @return The address of the person.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Method to set the address of the person.
     *
     * @param address The address of the person.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Method to get the information of the person and their vehicles.
     *
     * @return A string containing the information of the person and their vehicles.
     */
    public String getVehiclesInfo() {
        if (vehicleList.isEmpty()) {
            return this.getName() + " has no vehicle!";
        } else {
            String info = name + " has:\n";
            for (Vehicle vehicle : vehicleList) {
                info += "\n" + vehicle.getInfo();
            }
            return info;
        }
    }
}
