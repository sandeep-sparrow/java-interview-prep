package design.pattern.creational.builder;

public class DemoFluent {
    public static void main(String[] args) {
        EmployeeBuilder pb = new EmployeeBuilder();
        Person sandeep = pb.withName("Sandeep")
            .worksAt("DXC")
            .build();

        System.out.println(sandeep.toString());
    }    
}

class Person{
    public String name;
    public String position;

    @Override
    public String toString() {
        return "Person [name=" + name + ", position=" + position + "]";
    }

}

class PersonBuilder<SELF extends PersonBuilder<SELF>> {

    // object we are building
    protected Person person = new Person();

    public SELF withName(String name){
        person.name = name;
        return self();
    }

    public Person build(){
        return person;
    }

    @SuppressWarnings("unchecked")
    protected SELF self(){
        return (SELF) this;
    }
}

class EmployeeBuilder extends PersonBuilder<EmployeeBuilder>{

    public EmployeeBuilder worksAt(String position){
        person.position = position;
        return self();
    }

    @Override
    protected EmployeeBuilder self() {
        return this;
    }

    
}