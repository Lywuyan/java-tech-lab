package org.wuyan.jvm.demo1_memory;

import java.util.ArrayList;
import java.util.List;

public class FullGcDemo {
    public static void main(String[] args) throws InterruptedException {
        List<byte[]> list = new ArrayList<>();
        while (true){
            // 大对象
            byte[] bytes = new byte[1024 * 1024 * 5];
            list.add(bytes);
            if (list.size() > 3) {
                list.clear();
            }
            Thread.sleep(200);
        }
    }
}
