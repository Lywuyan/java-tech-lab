package org.wuyan.jvm.demo3_classloader;

public class ContextClassLoaderDemo {
    public static void main(String[] args) {
        ClassLoader context = Thread.currentThread().getContextClassLoader();
        System.out.println("Context ClassLoader" + context);

        ClassLoader system = ClassLoader.getSystemClassLoader();
        System.out.println("System ClassLoader" + system);
    }
}
