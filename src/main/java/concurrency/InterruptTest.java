package concurrency;

import java.util.concurrent.TimeUnit;

// a "running" or "ready to run" thread can not really paused by "interrupt", it only set the flag of "interrupted"
// unless thread is "sleeping" or "blocked",
// see Thread.interrupt() - this flag is also not reliable, different behavior in different case
public class InterruptTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Running());
        t.start();

        TimeUnit.MILLISECONDS.sleep(1);

        for (int i = 0; i < 100; i++) {
            System.out.println(" ############ interrupting ###############");
            t.interrupt();
            Thread.yield();
        }

        System.out.println("end of main");


    }

    private static class Running implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                System.out.println(i + " running " + Thread.currentThread().isInterrupted());
                Thread.yield();
                if(Thread.currentThread().isInterrupted()){
                    break;
                }
            }
        }
    }
}
