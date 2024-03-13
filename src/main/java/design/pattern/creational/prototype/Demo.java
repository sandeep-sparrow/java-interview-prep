package design.pattern.creational.prototype;

import java.io.Serializable;

import org.apache.commons.lang3.SerializationUtils;

public class Demo {

    public static void main(String[] args) throws CloneNotSupportedException {
        // Prototyping
        Person sandeep = new Person(new String[]{"sandeep", "dhairya"}, new Address("vastral", 603));
        Person ramesh = (Person) sandeep.clone();

        ramesh.names[1] = "sandeep";
        ramesh.names[0] = "ramesh";
        ramesh.address.streetName = "malad";
        ramesh.address.houseNumber = 1805;

        System.out.println(sandeep.toString());
        System.out.println(ramesh.toString());

        Foo o1 = new Foo(123, "life");
        Foo o2 = SerializationUtils.roundtrip(o1);

        o2.whatever = "xyz";
        System.out.println(o1.toString());
        System.out.println(o2.toString());
        
    }
    
}

class Foo implements Serializable{
    public int stuff;
    public String whatever;

    public Foo(int stuff, String whatever) {
        this.stuff = stuff;
        this.whatever = whatever;
    }

    @Override
    public String toString() {
        return "Foo [stuff=" + stuff + ", whatever=" + whatever + "]";
    }

}
