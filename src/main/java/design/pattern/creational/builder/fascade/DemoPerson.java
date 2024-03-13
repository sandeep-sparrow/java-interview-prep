package design.pattern.creational.builder.fascade;

public class DemoPerson {

    public static void main(String[] args) {
        PersonBuilder pb = new PersonBuilder();
        Person person = pb
            .lives()
                .at("Malad [East], Western Express Highway")
                .withPostCode("400097")
                .in("Mumbai")
            .works()
                .at("HERE technologies")
                .asA("Sr Java Full Stack Developer")
                .earning(27)
            .build();

        System.out.println(person.toString());
    }
    
}

class Person{
    // address
    public String streetAddress, postCode, city;

    // employment
    public String companyName, position;
    public int annualIncome;
    @Override
    public String toString() {
        return "Person [streetAddress=" + streetAddress + ", postCode=" + postCode + ", city=" + city + ", companyName="
                + companyName + ", position=" + position + ", annualIncome=" + annualIncome + "]";
    }
}

// builder fascade
class PersonBuilder{
    protected Person person = new Person();

    public PersonAddressBuilder lives(){
        return new PersonAddressBuilder(person);
    }

    public PersonWorkBuilder works(){
        return new PersonWorkBuilder(person);
    }

    public Person build(){
        return person;
    }
}

// sub builders
class PersonAddressBuilder extends PersonBuilder{

    public PersonAddressBuilder(Person person){
        this.person = person;
    }

    public PersonAddressBuilder at(String streetAddress){
        person.streetAddress = streetAddress;
        return this;
    }

    public PersonAddressBuilder withPostCode(String postCode){
        person.postCode = postCode;
        return this;
    }

    public PersonAddressBuilder in(String city){
        person.city = city;
        return this;
    }
}

// sub builder
class PersonWorkBuilder extends PersonBuilder{

    public PersonWorkBuilder(Person person){
        this.person = person;
    }

    public PersonWorkBuilder at(String companyName){
        person.companyName = companyName;
        return this;
    }

    public PersonWorkBuilder asA(String position){
        person.position = position;
        return this;
    }

    public PersonWorkBuilder earning(int annualIncome){
        person.annualIncome = annualIncome;
        return this;
    }
}
