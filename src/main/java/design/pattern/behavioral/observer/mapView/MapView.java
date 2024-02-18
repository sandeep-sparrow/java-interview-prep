package design.pattern.behavioral.observer.mapView;

import java.util.ArrayList;
import java.util.List;

public class MapView implements MapObservable {

    List<MapObserver> observers = new ArrayList<>();
    private String currentLocation;

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
        notifyObservers();
    }

    @Override
    public void addObserver(MapObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(MapObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (MapObserver observer : observers) {
            observer.update(currentLocation);
        }
    }
    
}
