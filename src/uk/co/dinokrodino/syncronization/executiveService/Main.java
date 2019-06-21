package uk.co.dinokrodino.syncronization.executiveService;

import java.util.Random;
import java.util.concurrent.*;

import static uk.co.dinokrodino.syncronization.executiveService.Main.EOF;

//Executive Service itf extends executor itf(execute), provide us threads pools(limited nr of available tasks managed for us)
//creation(optimized)/start/thread scheduling / can limit number of active tasks
//we provide runnable objs(code to execute) to the service
//we create implementation of executive service and give it to the task we wanna run

public class Main {

    public static final String EOF = "EOF";

    public static void main(String[] args) {
        //set capacity since the list is bounded -> in need of 1 since we always delete the last
        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<String>(2);
        //based on the the type of thread pools we want the service to use
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_YELLOW);
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.ANSI_PURPLE);
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_CYAN);


        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);

        //receive a value back from a background method -> submit() accept callable obj return future
        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(ThreadColor.ANSI_WHITE);
                return "This is the callable result";
            }
        });
        //this call block until the result will be available
        try {
            System.out.println(future.get());
        } catch(ExecutionException e) {
            System.out.println("Something went wrong");
        } catch(InterruptedException e) {
            System.out.println("Thread running the task was interrupted");
        }

        //orderly shutdown -> complete remaining tasks / not accept any new tasks
        executorService.shutdown();

        //immediately shutdown
        //executorService.shutdownNow();
    }

}

class MyProducer implements Runnable {
    private ArrayBlockingQueue<String> buffer;
    private String color;

    public MyProducer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};

        for (String num : nums) {
            try {
                System.out.println(color + "Adding..." + num);
                //add/remove would thrown exeption if operation can't be performed immediately if another thread got the lock
                //the put/take will block when the queue is locked -> automatically block lock for us
                buffer.put(num);

                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted");
            }
        }

        System.out.println(color + "Adding EOF and exiting...");
        try {
            buffer.put("EOF");
        } catch (InterruptedException e) {
            System.out.println("Producer was interrupted");
        }
    }
}

class MyConsumer implements Runnable {
    private ArrayBlockingQueue<String> buffer;
    private String color;

    public MyConsumer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    public void run() {

        while (true) {
            synchronized (buffer) {
                try {
                    if (buffer.isEmpty()) {
                        continue;
                    }
                    //syncronization since here I could have a bug
                    if (buffer.peek().equals(EOF)) {
                        System.out.println(color + "Exiting");
                        break;
                    } else {
                        System.out.println(color + "Removed " + buffer.take());
                        //peek/take are FIFO -> don't need to specify first element
                    }
                } catch (InterruptedException e) {

                }
            }
        }
    }

}
