package design.pattern.creational.prototype;

public class Address implements Cloneable{
    public String streetName;
    public int houseNumber;

    public Address(String streetName, int houseNumber) {
        this.streetName = streetName;
        this.houseNumber = houseNumber;
    }

    @Override
    public String toString() {
        return "Address [streetName=" + streetName + ", houseNumber=" + houseNumber + "]";
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        // replicating a new address - deep copying
        return new Address(streetName, houseNumber);
    }
}