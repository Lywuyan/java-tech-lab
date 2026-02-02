package org.wuyan.demo1_bio_nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NioServer {
    public static void main(String[] args) throws IOException {
        // 创建 Selector
        try (Selector selector = Selector.open()) {
            // 创建 ServerSocketChannel
            try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {
                serverSocketChannel.configureBlocking(false);
                serverSocketChannel.bind(new InetSocketAddress(8081));

                // 注册 ACCEPT 事件
                serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
                System.out.println("NIO Server 启动，端口8081");

                while (true) {
                    // 阻塞等待事件
                    selector.select();
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = selectionKeys.iterator();
                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        iterator.remove();

                        // 新连接
                        if (key.isAcceptable()) {
                            try (ServerSocketChannel ssc = (ServerSocketChannel) key.channel()) {
                                SocketChannel sc = ssc.accept();

                                sc.configureBlocking(false);
                                sc.register(selector, SelectionKey.OP_READ);
                                System.out.println("收到一个连接" + sc);
                            }
                        } else if (key.isReadable()) {
                            SocketChannel sc = (SocketChannel) key.channel();
                            ByteBuffer buffer = ByteBuffer.allocate(1024);

                            int len = sc.read(buffer);

                            if(len == -1){
                                System.out.println("连接关闭");
                                sc.close();
                                continue;
                            }
                            buffer.flip();
                            String msg = new String(buffer.array(), 0, len);
                            System.out.println("收到" + msg);

                        }
                    }
                }
            }
        }
    }
}
