package org.wuyan.jvm.demo1_memory;

import java.util.ArrayList;
import java.util.List;

public class StaticLeakDemo {
    private static final List<byte[]> CACHE = new ArrayList<>();

    public static void main(String[] args) {
        while (true){
            CACHE.add(new byte[1024 * 1024]);
        }
    }
}
