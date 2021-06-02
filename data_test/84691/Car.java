public class Car extends Vehicle {

    private int numberOfDoors;

    /**
     * Constructor Car.
     */
    public Car(String brand, String model,
               String registrationNumber, Person owner,int numberOfDoors) {
        super(brand, model, registrationNumber, owner);
        this.numberOfDoors = numberOfDoors;
    }

    /**
     * Phuong thuc in ra thong tin cua Car.
     */
    @Override
    public String getInfo() {
        return "Car:\n" + "\tBrand: " + getBrand() + "\n" + "\tModel: " + getModel() + "\n"
                + "\tRegistration Number: " + getRegistrationNumber() + "\n"
                + "\tNumber of Doors: " + getNumberOfDoors() + "\n"
                + "\tBelongs to " + owner.getName() + " - " + owner.getAddress();
    }

    //Getter, Setter
    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }
}
