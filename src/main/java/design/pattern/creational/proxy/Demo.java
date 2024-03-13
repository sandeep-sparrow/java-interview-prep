package design.pattern.creational.proxy;

public class Demo {

    public static void main(String[] args) {
     
        Car car = new CarProxy(new Driver(17));
        car.drive();
    }
    
}

interface Drivable{
    void drive();
}

class Car implements Drivable{
    public Driver driver;

    public Car(Driver driver){
        this.driver = driver;
    }

    @Override
    public void drive() {
        System.out.println("Car is being driven...");
    }
}

class Driver{
    int age;

    public Driver(int age){
        this.age = age;
    }
}

// Protection Proxy
class CarProxy extends Car{

    public CarProxy(Driver driver) {
        super(driver);
    }

    @Override
    public void drive(){
        if(driver.age >= 16){
            super.drive();
        }else{
            System.out.println("Driver to young!");
        }
    }

}
