package design.pattern.behavioral.observer.mapView;

public class Main {

    public static void main(String[] args) {
        
        MapView mapView = new MapView();

        LocationMarker locationMarker = new LocationMarker();
        mapView.addObserver(locationMarker);

        // triggered by map search bar - user input - coming react JS UI
        mapView.setCurrentLocation("Mumbai");
        mapView.setCurrentLocation("New Yourk");
    }
    
}
