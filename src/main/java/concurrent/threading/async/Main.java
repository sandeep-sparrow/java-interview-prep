package concurrent.threading.async;

import java.util.Random;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Future<Integer> futureValue = executorService.submit(new Task());

        try{
            Integer result = futureValue.get(); // blocking
            System.out.println("Resutlf from task is: " + result);
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    static class Task implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {
            return new Random().nextInt();
        }
    }
}
