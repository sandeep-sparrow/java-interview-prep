package design.pattern.creational.singleton;

public class EagerLoadingSingleton {

    private static final EagerLoadingSingleton instance = new EagerLoadingSingleton();


    private EagerLoadingSingleton() {}

    public static EagerLoadingSingleton getInstance() {
        return instance;
    }
}
