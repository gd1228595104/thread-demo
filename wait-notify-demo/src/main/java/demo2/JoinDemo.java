package demo2;

/**
 * @author dawn
 * @date 2022-01-29
 */
public class JoinDemo {
    static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count++;
            }
        });
        t1.start();
        System.out.println("before join: " + count);
        t1.join();
        System.out.println("after join: " + count);
    }

}
