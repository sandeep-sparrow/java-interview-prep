package design.pattern.behavioral.observer.mapView;

public interface MapObservable {

    void addObserver(MapObserver observer);
    void removeObserver(MapObserver observer);
    void notifyObservers();
    
}
