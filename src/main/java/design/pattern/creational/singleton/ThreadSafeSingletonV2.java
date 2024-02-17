package design.pattern.creational.singleton;

public class ThreadSafeSingletonV2 {

    private static ThreadSafeSingletonV2 instance;

    private ThreadSafeSingletonV2(){}

    public static ThreadSafeSingletonV2 getInstance(){
        if(instance == null){
            synchronized (ThreadSafeSingletonV2.class){
                if(instance == null){
                    instance = new ThreadSafeSingletonV2();
                }
            }
        }
        return instance;
    }
}
