package demo1;

import java.util.Queue;

/**
 * @author dawn
 * @date 2022-01-29
 */
public class Producer implements Runnable {

    private Queue<String> queue;

    private int capacity;

    public Producer(Queue<String> queue, int capacity) {
        this.queue = queue;
        this.capacity = capacity;
    }

    public void run() {
        int i = 0;
        for (; ; ) {
            synchronized (this.queue) {
                if (capacity == queue.size()) {
                    try {
                        System.out.println("-----producer.wait()-----");
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
                String content = "HelloWorld" + i;
                i++;
                queue.add(content);
                System.out.println("producer -- > " + content);
                queue.notify();
            }
        }
    }
}
