package org.breeze.socket;

import java.io.IOException;
import java.net.Socket;

/**
 * @author andy
 * @version 2023/06/06
 */
public class Client {

    public static void main(String[] args) {

        try {
            Socket client = new Socket("localhost", 9998);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
