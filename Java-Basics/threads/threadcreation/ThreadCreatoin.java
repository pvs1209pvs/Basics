class ThreadCreation{

    private ThreadCreation(){

        /* Main thread calls the run() on all the threads we craeted here and that is done using the start method. */

        /* Extending the Thread class */
        Thread myThread = new MyThread();
        myThread.start();

        /* Anonymous class implementation of Thread */
        Thread thread = new Thread("LaryTheThread"){
            @Override
            public void run(){
                System.out.println("This is anonymous class implementation of Thread.");
            }
        };
        System.out.println(thread.getName());
        thread.start();

        /* Implementing Runnable Interface */

        /* Passing in the runnable object */
        (new Thread(new Worker())).start();

        /* Anonymous implementation of Runnable */
        (new Thread(new Runnable(){
            @Override
            public void run(){
                System.out.println("Hey there, I am Anonymous implementation of Runnable Interfaces.");
            }
        })).start();

        /* Lambda implementation of Runnable interface */
        (new Thread(()->System.out.println("Implementating Runnable with Lambda is pretty sick, isn't!"))).start();
    }

    private class MyThread extends Thread {
        @Override
        public void run(){
            System.out.println("This thread-implementation extends the Thead class.");
        }
    } // MyThread

    private class Worker implements Runnable{
        @Override
        public void run(){
            System.out.println("I implement Runnable Interface.");
        }
    }
    public static void main(String[] args) {
        new ThreadCreation();
    }
    
}