package org.breeze.io.socket;

import java.io.IOException;
import java.net.Socket;

/**
 * @author andy
 * @version 1.0.0
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
