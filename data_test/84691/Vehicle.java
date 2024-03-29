public abstract class Vehicle {

    protected String brand;
    protected String model;
    protected String registrationNumber;
    protected Person owner;

    /**
     * Constructor.
     */
    public Vehicle(String brand, String model, String registrationNumber, Person owner) {
        this.brand = brand;
        this.model = model;
        this.registrationNumber = registrationNumber;
        this.owner = owner;
    }

    /**
     * Phuong thuc abstract in ra thong tin.
     */
    public abstract String getInfo();

    /**
     * Phuong thuc chuyen nhuong chu so huu.
     */
    public void transferOwnership(Person newOwer) {
        setOwner(newOwer);
    }

    //Getter, Setter
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }
}
