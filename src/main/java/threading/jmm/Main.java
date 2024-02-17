package threading.jmm;

public class Main {

    public static void main(String[] args) {

        VolatileVisibility volatileVisibility = new VolatileVisibility();

        Thread thread1 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                // System.out.println("Thread 2: Count " + i);
                try {
                    Thread.sleep(500); // Simulate some work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            volatileVisibility.writer();
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                // System.out.println("Thread 2: Count " + i);
                try {
                    Thread.sleep(500); // Simulate some work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            volatileVisibility.reader();
        });

        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.MAX_PRIORITY);
        thread1.start();
        thread2.start();

    }
}
