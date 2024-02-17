package design.pattern.creational.singleton;

public class LazyLoadingSingleton {

    private static LazyLoadingSingleton instance;

    public LazyLoadingSingleton() {}

    // But this is not thread safe
    public static LazyLoadingSingleton getInstance() {
        if(instance == null) {
            instance = new LazyLoadingSingleton();
        }
        return instance;
    }
}
