package threading;

import threading.methods.Method1;
import threading.methods.Method2;

public class Main {

    public static void main(String[] args) throws InterruptedException{

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("We are now in thread " + Thread.currentThread().getName());
            }
        });

        System.out.println("We are in thread " + Thread.currentThread().getName() + " before starting a new thread");
        thread.start();
        System.out.println("We are in thread " + Thread.currentThread().getName() + " after starting a new thread");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Method1 method1 = new Method1();
        method1.start();

        Thread thread1 = new Thread(new Method2());
        thread1.setName("Sandeep");
        thread1.setPriority(Thread.MAX_PRIORITY);

        thread1.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("A Critical Error happened in thread " + t.getName()
                    + " the error is " + e.getMessage());
            }
        });

        thread1.start();
    }
}
