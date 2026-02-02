package org.wuyan.demo1_bio_nio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class BioServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("BIO Server 启动，端口8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("收到一个连接" + socket);

            new Thread(() -> {
                try {
                    InputStream in = socket.getInputStream();
                    byte[] buffer = new byte[1024];

                    int len;
                    while ((len = in.read(buffer)) != -1) {
                        String msg = new String(buffer, 0, len);
                        System.out.println("收到" + msg);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
