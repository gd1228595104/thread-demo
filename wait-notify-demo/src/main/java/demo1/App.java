package demo1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author dawn
 * @date 2022-01-29
 */
public class App {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<String>();
        Producer producer = new Producer(queue, 10);
        Consumer consumer = new Consumer(queue);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
