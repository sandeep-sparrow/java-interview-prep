package design.pattern.behavioral.observer;

public class Person extends Observable<Person> {

    int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(this.age == age) return;
        this.age = age;
        propertyChanged(this, "age", age);
    }
    
}
