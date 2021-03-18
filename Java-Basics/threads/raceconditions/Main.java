public class Main {

    private Main() {

        /*
         * n number of threads try to update the value of global count variable in
         * Counter at the same time because of that different threads read different
         * values resulting in different values during each run.
         */

        Counter counter = new Counter();

        Thread threads[] = new Thread[5];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(counter::addLong);
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("(not thread safe) = " + counter.getCount());

        /*
         * This time we use run addLongSync which used synchronized keyword which only
         * lets thread enter the method body at once. Due to which all the threads enter
         * the method one after the other aka Thread-Safe.
         */

        counter = new Counter();

        threads = new Thread[5];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(counter::addLongSync);
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("(thread safe) = " + counter.getCount());

        /*
        */

        counter = new Counter();

        threads = new Thread[5];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(counter::addLongSyncBetter);
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("(divived-sync) = " + counter.getCount1() + ", " + counter.getCount2());

    }

    private class Counter {

        private long count = 0;
        private Long count1 = Long.valueOf(0);
        private Long count2 = Long.valueOf(0);

        void addLong() {
            for (int i = 0; i < 100000; i++) {
                this.count += 1;
            }
        }

        synchronized void addLongSync() {
            addLong();
        }

        // works better than it is supposed to.
        void addLongSyncBetter() {

            synchronized (count1) {
                for (int i = 0; i < 100000; i++) {
                    this.count1++;
                }
            }

            synchronized (count2) {
                for (int i = 0; i < 100000; i++) {
                    this.count2++;
                }
            }

        }

        public long getCount() {
            return this.count;
        }

        public long getCount1() {
            return count1.longValue();
        }

        public long getCount2() {
            return count2.longValue();
        }

    }

    public static void main(String[] args) {
        new Main();
    }

}