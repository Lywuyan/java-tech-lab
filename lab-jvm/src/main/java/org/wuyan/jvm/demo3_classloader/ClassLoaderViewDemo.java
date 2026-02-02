package org.wuyan.jvm.demo3_classloader;

public class ClassLoaderViewDemo {
    public static void main(String[] args) {
        ClassLoader app = ClassLoaderViewDemo.class.getClassLoader();
        System.out.println("Application ClassLoader" + app);

        ClassLoader platform = app.getParent();
        System.out.println("Platform ClassLoader" + platform);

        ClassLoader bootstrap = platform.getParent();
        System.out.println("Bootstrap ClassLoader" + bootstrap);
    }
}
