package design.pattern.creational.factory;
 
import java.lang.Math;

public class DemoFactory{
    public static void main(String[] args) {
        @SuppressWarnings("unused")
        Point point = Point.Factory.newCartesianPodouble(5, 5); 
    }
}

class Point{
    @SuppressWarnings("unused")
    private double a, b;

    private Point(double a, double b){
        this.a = a;
        this.b = b;
    }

    public static class Factory{
        public static Point newCartesianPodouble(double x, double y){
            return new Point(x, y);
        }

        public static Point newPolarPodouble(double x, double y){
            return new Point(x*Math.cos(y), y*Math.sin(x));
        }
    }
}