package threading.methods;

public class Method2 implements Runnable{
    @Override
    public void run() {
        System.out.println("Your are now in Thread created using Runnable Interface " + Thread.currentThread().getName());
        System.out.println("Current Thread priority " + Thread.currentThread().getPriority());
        throw new RuntimeException("Intentional Exception");
    }
}
