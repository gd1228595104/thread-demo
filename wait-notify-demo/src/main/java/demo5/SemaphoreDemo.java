package demo5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;

/**
 * @author dawn
 * @date 2022-03-24
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        for (int i = 0; i < 10; i++) {
            final int t = i;
            new Thread(() -> {
                try {
                    semaphore.acquire(1);
                    Thread.sleep(10);
                    System.out.println(Thread.currentThread().getName() + " get a semaphore, semaphore's queue size is " + semaphore.getQueueLength());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }, "Thread-" + t).start();
        }
    }
}
