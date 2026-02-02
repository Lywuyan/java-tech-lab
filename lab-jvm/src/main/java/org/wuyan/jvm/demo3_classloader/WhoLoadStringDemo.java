package org.wuyan.jvm.demo3_classloader;

public class WhoLoadStringDemo {
    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader());
        System.out.println(WhoLoadStringDemo.class.getClassLoader());
    }
}
