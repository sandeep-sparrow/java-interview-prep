package design.pattern.behavioral.observer;

public interface Observer<T> {

    void handle(PropertyChangedEventArgs<T> args);
    
}
