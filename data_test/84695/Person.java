public class Person {

    private String name;
    protected String address;

    /**
     * Constructor.
     */
    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    //Getter, Setter
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Phuong thuc in ra thong tin Person.
     */
    public String toString() {
        return "Person[name=" + name + ",address=" + address + "]";
    }
}
