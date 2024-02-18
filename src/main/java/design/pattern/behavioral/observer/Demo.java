package design.pattern.behavioral.observer;

public class Demo implements Observer<Person> {

    public static void main(String[] args) {
        new Demo();
    }

    public Demo(){
        Person person1 = new Person();
        person1.subscribe(this);
        Person person2 = new Person();
        person2.subscribe(this);
        for(int i = 20; i < 25; i++){
            person1.setAge(i);
        }
        for(int i = 15; i < 20; i++){
            person2.setAge(i);
        }
    }

    @Override
    public void handle(PropertyChangedEventArgs<Person> args) {
        System.out.println("Person's: " + args.propertyName + " has changes to: " + args.newValue);
    }
    
}
