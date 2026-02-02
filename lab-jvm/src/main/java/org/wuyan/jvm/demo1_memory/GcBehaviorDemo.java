package org.wuyan.jvm.demo1_memory;

import java.util.ArrayList;
import java.util.List;

public class GcBehaviorDemo {
    public static void main(String[] args) {
        List<byte[]> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            // 不断创建短生命周期对象
            byte[] data = new byte[1024 * 1024];
            list.add(data);
            // 模拟部分对象很快失去引用
            if(i % 3 == 0){
                list.clear();
            }
        }
        System.out.println("程序结束");
    }
}
