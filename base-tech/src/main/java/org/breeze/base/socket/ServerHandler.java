package org.breeze.base.socket;

import lombok.SneakyThrows;
import org.springframework.util.StringUtils;

import java.io.*;
import java.net.Socket;

/**
 * @author andy
 * @version 2023/06/06
 */
public class ServerHandler implements Runnable {

    private Socket socket;

    public ServerHandler(Socket socket) {
        this.socket = socket;
    }


    @Override
    public void run() {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            while (true){
                String s = reader.readLine();
                if(!StringUtils.isEmpty(s.trim())){
                    if(s.equalsIgnoreCase("\r") || s.equalsIgnoreCase("q") || s.equalsIgnoreCase("exit")){
                        break;
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}