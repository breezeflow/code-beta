package org.breeze.io.bio.BIODemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class BIOClient {

    private final static int BIO_SERVER_PORT =  9999;
    private final static String BIO_SERVER_ADDR=  "127.0.0.1";


    public static void main(String[] args) {
        Socket socket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        try{
            socket=new Socket(BIO_SERVER_ADDR,BIO_SERVER_PORT);
            out = new PrintWriter(socket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner sin = new Scanner(System.in);
            String line = sin.nextLine();
            while (!line.equals("exit")){
                //注意这里使用的是  out.println()  而不是 out.write()
                //往服务器端发送消息
                out.println(line);
//                out.write(line+"\r\n");
                out.flush();
                //获取服务器端响应的消息
                System.out.println(in.readLine());
                line = sin.nextLine();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            out.close();
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
