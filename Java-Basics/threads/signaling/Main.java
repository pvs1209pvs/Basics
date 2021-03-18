import java.util.Scanner;

public class Main {

    private Main() {

        MyObj myObj = new MyObj();

        Thread t1 = new Thread(() -> {
            try {
                myObj.produce();
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                myObj.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }

    private class MyObj{

        /* wait() and notify() NEED to be called on the same object and inside a 
        synchronized block */

        /* wait() and notify() are for waiting and notifying only.
           synchronized is for lock handlings. */

        public void produce() throws InterruptedException {
           
            synchronized(this){
                System.out.println("produces started");

                /* this thread will give up it's control over 'this' object
                and enter the wait state. Letting any other thread accquire
                the lock for the 'this' object.

                This thread will only resume execution when two things happen:-
                1. it needs to re-accquire the lock.
                2. it needs to be notified (woken up from the wait state) by
                   some other thread. */ 
                wait();

                /* at this point the producer thread has released the lock on
                'this' object */
                
                System.out.println("produced resumed");
            }

        };

        public void consume() throws InterruptedException {
            
            /* just to make sure producers executes first */
            Thread.sleep(2000);

            synchronized(this){
                
                /* to make this thread notify the other thread when we hit
                enter */
                System.out.println("waiting for return key");
                (new Scanner(System.in)).nextLine();
                System.out.println("return key pressed");

                /* producer thread has gone in wait state which means this 
                consumer thread can accquire the 'this' object and once it
                reacher here it will notify the thread waiting on 'this' object 
                that it can resume execution but for that this thread has to
                leave the synchronized block. */
                notify(); 

                /* at this point the other waiting thread has been 
                notified but that other object hasn't gotten the lock, which
                will happen once the synchronized block ends. */

            }
        
        };

    }

    public static void main(String[] args){
        new Main();
    }
    
}