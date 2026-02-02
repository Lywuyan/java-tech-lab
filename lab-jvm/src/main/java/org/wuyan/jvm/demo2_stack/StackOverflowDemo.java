package org.wuyan.jvm.demo2_stack;

public class StackOverflowDemo {
    public static void main(String[] args) {
        recursive();
    }

    private static void recursive() {
        recursive();
    }
}
