package demo1;

import java.util.Queue;

/**
 * @author dawn
 * @date 2022-01-29
 */
public class Consumer implements Runnable {
    private Queue<String> queue;

    public Consumer(Queue<String> queue) {
        this.queue = queue;
    }

    public void run() {
        for (; ; ) {
            synchronized (queue) {
                if (queue.isEmpty()) {
                    try {
                        System.out.println("-----consumer.wait()-----");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String poll = queue.poll();
                System.out.println("consumer --> " + poll);
                queue.notify();
            }
        }
    }
}
