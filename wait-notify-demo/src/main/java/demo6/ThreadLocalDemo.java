package demo6;

import com.sun.prism.shader.AlphaOne_Color_AlphaTest_Loader;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author dawn
 * @date 2022-04-15
 */
public class ThreadLocalDemo {
    static ThreadLocal local = ThreadLocal.withInitial(() -> "DEFAULT");

    public static void main(String[] args) throws InterruptedException {
        System.out.println("main -->" + local.get());
        local.set("MAIN");
        Thread t = new Thread(() -> {
            System.out.println("t1 --> " + local.get());
        });
        t.start();
        t.join();
        System.out.println("main set value -> " + local.get());
    }
}
