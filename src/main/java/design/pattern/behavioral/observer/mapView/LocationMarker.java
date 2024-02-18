package design.pattern.behavioral.observer.mapView;

public class LocationMarker implements MapObserver {

    private String location;

    @Override
    public void update(String location) {
        this.location = location;
        System.out.println("Location marker updated to: " + location);
        //some other modules being called here.
        // fetch all the gas station - Raw Map inforation
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
}
