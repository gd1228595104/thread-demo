package demo4;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/**
 * @author dawn
 * @date 2022-03-18
 */
public class CountDownLatchDemo1 {

    private static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("this is thread A");
            countDownLatch.countDown();
        }).start();
        new Thread(() -> {
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("this is thread B");
            countDownLatch.countDown();
        }).start();
        countDownLatch.await();
        System.out.println("this is main thread");
    }

    private void countDown() {
        countDownLatch.countDown();
    }
}
