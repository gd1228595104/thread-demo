package demo5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author dawn
 * @date 2022-03-27
 */
public class CyclicBarrierDemo {

    private static CyclicBarrier system = new CyclicBarrier(2, () -> System.out.println("项目启动完成"));

    public static void main(String[] args) {
        // 定义mysql连接线程
        Thread mysqlConnect = new Thread(() -> {
            try {
                System.out.println("connecting mysql...");
                Thread.sleep(500);
                System.out.println("connect mysql completed");
                system.await();
            }catch (Exception e){
                e.printStackTrace();
            }
        });
        // 定义redis连接线程
        Thread redisConnect = new Thread(() -> {
            try {
                System.out.println("connecting redis...");
                Thread.sleep(500);
                System.out.println("connect redis completed");
                system.await();
            }catch (Exception e){
                e.printStackTrace();
            }
        });

        // CyclicBarrier
        CyclicBarrier readProperties = new CyclicBarrier(1,() -> {
            System.out.println("-------------try connect database---------");
            mysqlConnect.start();
            redisConnect.start();
        });

        // 定义读取配置线程
        Thread propertiesThread = new Thread(() -> {
            try {
                System.out.println("reading properties");
                Thread.sleep(1000);
                System.out.println("read properties complete");
                readProperties.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // 启动读取配置线程
        propertiesThread.start();

    }
}
