package concurrency;

import java.util.concurrent.TimeUnit;

// jvm ends when all non-daemon threads done, even finally block may not run
// risky if you need to clean up in daemon thread - no guarantee
public class DaemonThread {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new ADaemon());
        t.setDaemon(true);
        t.start();

        //TimeUnit.SECONDS.sleep(2);
        System.out.println("end of main");
    }

    private static class ADaemon implements Runnable {

        public void run() {
            try {
                System.out.println("start daemon");
                TimeUnit.SECONDS.sleep(1);  //let main thread first

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("finally");
            }
        }
    }
}
