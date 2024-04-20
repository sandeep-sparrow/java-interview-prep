package async;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static int Compute(int n){
         System.out.println("Compute called...");
         try {
             Thread.sleep(200);
         } catch (InterruptedException e) {
             System.out.println(e.getMessage());
         }
         if(n <= 0){
             throw new RuntimeException("Invalid input");
         }
        return n * 2;
    }

    public static CompletableFuture<Integer> create(int n){
        // Supplier
        return CompletableFuture.supplyAsync(() -> Compute(n));
    }

    public static CompletableFuture<Integer> welcome(int n){
        CompletableFuture<Integer> cf = new CompletableFuture<Integer>();
        cf.thenApply(data -> data + 1)
          .thenApply(data -> data * 10)
          .thenAccept(System.out::println);

        return cf;
   }

    public static void testCombine(){
        System.out.println("Test Combine Running!");
        CompletableFuture<Integer> cf1 = create(2);
        CompletableFuture<Integer> cf2 = create(3);
        cf1.thenCombine(cf2, Integer::sum)
            .thenAccept(System.out::println);
    }

    public static void main(String[] args) {
        // CASE1: passing a fun which returns a value
        // issue the request
        create(-4) // non-blocking, CompletableFuture<Integer>
            .thenApply(data -> { // Similar to map(Function<T, R>) which accepts input and return result in Streams API
                System.out.println(Thread.currentThread());
                return data + 1.0; // CompletableFuture<Double>
            })
            .exceptionally(err -> {
                System.out.println(err.getMessage());
                throw new RuntimeException("Something went wrong");
            })
            .thenAccept(System.out::println) // accepts the darta and return nothing, Similar to a forEach(Consumer<T>) functional interface in Streams API, CompletableFuture<Void>
            // data -> SaveToDb(data)
            .thenRun(() -> System.out.println("log some info")) // CF<Void>
            .thenRun(() -> System.out.println("do some post operations")) // CF<Void>
            // fair enough - never ending pipeline when working CF<K>, CompletableFuture<SendResult<K, V>> - when working KafkaTemplate to make an async call by default...
            .exceptionally((err) -> {
                System.out.println(err.getMessage());
                throw new RuntimeException("We can't do much at all");
            });


        System.out.println("started the computation " + Thread.currentThread());

        try{ Thread.sleep(2000); } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        CompletableFuture<Integer> cf = welcome(4);

        cf.complete(7);
        testCombine();
        // CASE2: passing a fun which returns a CF

        System.out.println("Passing thenCompose functionality");
        create(5)
            .thenCompose(Main::create)
            .thenAccept(System.out::println);
    }
    
}
