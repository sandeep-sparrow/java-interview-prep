package design.pattern.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class Observable<T> {

    List<Observer<T>> observers = new ArrayList<>();

    public void subscribe(Observer<T> observer){
        observers.add(observer);
    }

    public void propertyChanged(T source, String propertyName, Object newValue){
        for(Observer<T> o : observers){
            o.handle(new PropertyChangedEventArgs<T>(source, propertyName, newValue));
        }
    }
    
}
