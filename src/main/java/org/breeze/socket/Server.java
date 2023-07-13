package org.breeze.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author andy
 * @version 1.0.0
 */
public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9998);

            while (true) {
                Socket socket = serverSocket.accept();

                //创建一个线程处理 客户端请求
                Thread serverHandler = new Thread(new ServerHandler(socket));
                serverHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
