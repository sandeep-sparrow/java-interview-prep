package threading.jmm;

public class VolatileVisibility{

    volatile int x = 0;

    public void writer(){
        x = 1;
        System.out.println("Writer: " + x);
    }

    public void reader(){
        int y = x;
        System.out.println("Reader: " + y);
    }
}
