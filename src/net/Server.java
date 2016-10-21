package net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by yuandl on 2016-10-17.
 * 服务端接收客户端发送过来的数据，并打印在控制台上。
 * 建立tcp服务端的思路：
 * 1，创建服务端socket服务。通过ServerSocket对象。
 * 2，服务端必须对外提供一个端口，否则客户端无法连接。
 * 3，获取连接过来的客户端对象。
 * 4，通过客户端对象获取socket流读取客户端发来的数据
 * 并打印在控制台上。
 * 5，关闭资源。关客户端，关服务端。
 */


public class Server {
    static ServerSocket serverSocket = null;

    public static void main(String[] args) {
        try {
            //1创建服务端对象。
            serverSocket = new ServerSocket(8868);
            //2,获取连接过来的客户端对象。
            Socket socket = serverSocket.accept();
            System.out.println("来自客户端【" + socket.getInetAddress().getHostAddress() + "】的连接");
            BufferedReader bufferedReader = null;
            BufferedReader bufferedReader_SystemIN = null;
            BufferedWriter bufferedWriter = null;
            //3，通过socket对象获取输入流，要读取客户端发来的数据
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //4，通过字符输入流获取键盘输入，要读取控制台写给客户端的数据
            bufferedReader_SystemIN = new BufferedReader(new InputStreamReader(System.in));
            //5.使用客户端socket对象的输出流给客户端返回数据
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            String message = "";
            while ((message = bufferedReader.readLine()) != null) {
                System.out.println("来自客户端【" + socket.getInetAddress().getHostAddress() + "】说:" + message);
                System.out.print("请输入：");
                String s = bufferedReader_SystemIN.readLine();
                bufferedWriter.write(s);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static class FromClient implements Runnable {
        private Socket socket;

        public FromClient(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            BufferedReader bufferedReader = null;
            BufferedWriter bufferedWriter = null;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println("来自客户端【" + socket.getInetAddress().getHostAddress() + "】说:" + bufferedReader.readLine());
                System.out.print("请输入:");
                bufferedReader = new BufferedReader(new InputStreamReader(System.in));

                bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                bufferedWriter.write(bufferedReader.readLine());

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    bufferedReader.close();
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

