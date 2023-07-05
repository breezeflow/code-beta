package org.breeze.io.NIO;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * NIO C/S 通信 ——  服务端
 */
public class NIOServer {

    public static void main(String[] args) throws Exception {


        /**
         * 不同操作系统，多路复用的实现不同
         * Selector.open() 默认会使用系统提供的多路复用实现
         * linux 多路复用器默认使用 epoll，可通过启动参数指定使用 select、poll 或者 epoll
         * epoll模式下 open会调用一个调用系统调用 epoll_create 返回文件描述符 fd3
         */
        Selector selector = Selector.open();

        // 服务端通信 通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        //非阻塞
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().bind(new InetSocketAddress(9999));

        /**
         * 注册 到 selector 并监听 它的  客户端连接事件
         *
         * 对应系统调用
         * select，poll模式下：jvm里开辟一个文件描述符数组，并吧 fd4 放入
         * epoll模式下： 调用内核 epoll_ctl(fd3,ADD,fd4,EPOLLIN)
         */
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {

            Set<SelectionKey> keys = selector.keys();
            System.out.println("可处理事件数量 " + keys.size());

            /**
             * 对应系统调用
             * select，poll模式下： 调用 内核 select（fd4）  poll(fd4)
             * epoll： 调用内核 epoll_wait()
             */
            int select = selector.select(1000);
            if (select == 0) {
                continue;
            }

            Set<SelectionKey> selectionKeys = selector.selectedKeys();

            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                // 连接事件
                if (key.isAcceptable()) {
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    System.out.println("监听到一个客户端连接事件，客户端Channel的hashCode" + socketChannel.hashCode());
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                }
                // 读事件
                if (key.isReadable()) {
                    System.out.println("监听到一个读事件");
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    ByteBuffer byteBuffer = (ByteBuffer) key.attachment();
                    System.out.println("旧position 位置 " + byteBuffer.position());
                    int start = byteBuffer.position();
                    //将channel数据 写到byteBuffer
                    socketChannel.read(byteBuffer);
                    System.out.println("新position 位置 " + byteBuffer.position());
                    int end = byteBuffer.position();
                    String result = new String(byteBuffer.array());
                    System.out.println("byteBuffer中的内容：" + new String(byteBuffer.array()));
                    System.out.println("本次通信的内容：" + result.trim().substring(start, end));

                }
                // 写事件
                if(key.isWritable()){

                }
                // 事件处理后要移除掉，否则会一直被处理
                iterator.remove();
            }
        }
    }

}
