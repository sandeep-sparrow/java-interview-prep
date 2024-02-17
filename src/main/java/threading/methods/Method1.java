package threading.methods;

public class Method1 extends Thread{

    @Override
    public void run() {
        super.run();
        System.out.println("Your are now in thread " + Thread.currentThread().getName());
    }
}
