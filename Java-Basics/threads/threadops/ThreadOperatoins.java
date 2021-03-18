class ThreadOperations{

    private ThreadOperations(){

        // /* Thread.currentThread() returns the Thread that is currently being executed. We named
        // out thread LaryTheThread so we get back LaryTheThread when this thread was being run. */
        // Thread thread = new Thread(()->System.out.println("Howdy, it's your friend = " + Thread.currentThread().getName()), "LaryTheThread");
        // thread.start();

        // /* Right now main-thread is being run so we get back the main-thread. Nice and easy. */
        // System.out.println(Thread.currentThread().getName());

        // /* Keep in mind the threads may not execute in sequential order. JVM and/or OS determines the order
        // in which the threads run. */
        // for (int i = 0; i < 10; i++) {
        //     (new Thread(()->System.out.println(Thread.currentThread().getName() +" is running."), String.valueOf(i))).start();
        // }

        // /* Pausing the main-thread */
    
        // try{
        //     System.out.println("Current thread = " + Thread.currentThread().getName());
        //     Thread.sleep(3000);
        // }catch(InterruptedException e){
        //     e.printStackTrace();
        // }

        // /* Pauing MyThread */

        // Thread myThread = new Thread(
        //     ()->{
        //         System.out.println("Starting = " + Thread.currentThread().getName());
        //         try{
        //             System.out.println("Going to sleep = " + Thread.currentThread().getName());
        //             Thread.sleep(3000);
        //         }catch(InterruptedException e){
        //             e.printStackTrace();
        //         }
        //         System.out.println("Done sleeping = " + Thread.currentThread().getName());
        //     }
        //     ,"MyThread");

        //     myThread.start();

            /* Stopping a thread */

            CoolThread ct = new CoolThread();

            Thread coolThread = new Thread(ct);
            coolThread.start(); 

            try {
                Thread.sleep(2000);
            }catch (InterruptedException e) {
            e.printStackTrace();
            }

            ct.stopMe();

            

    }

    private class CoolThread implements Runnable {

        private boolean stop = false;
        
        public synchronized void stopMe(){
            this.stop = true;
        }

        synchronized boolean isExecutable(){
            return this.stop == false;
        }
        
        @Override
        public void run(){
            while(isExecutable()){
                try {
                    System.out.println("I am your thread.");
                    Thread.sleep(500);
                }catch (InterruptedException e) {
                e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new ThreadOperations();
    }
    
}