package org.wuyan.jvm.demo1_memory;

import java.util.ArrayList;
import java.util.List;

public class HeapOOMDemo {
    public static void main(String[] args) {
        List<byte[]> list = new ArrayList<>();
        while (true){
            // 每次分配1MB
            list.add(new byte[1024 * 1024]);
        }
    }
}
