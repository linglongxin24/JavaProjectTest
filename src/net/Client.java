package net;

import java.io.*;
import java.net.Socket;

/**
 * Created by yuandl on 2016-10-17.
 * 客户端发数据到服务端
 * Tcp传输，客户端建立的过程。
 * 1，创建tcp客户端socket服务。使用的是Socket对象。
 * 建议该对象一创建就明确目的地。要连接的主机。
 * 2，如果连接建立成功，说明数据传输通道已建立。
 * 该通道就是socket流 ,是底层建立好的。 既然是流，说明这里既有输入，又有输出。
 * 想要输入或者输出流对象，可以找Socket来获取。
 * 可以通过getOutputStream(),和getInputStream()来获取两个字节流。
 * 3，使用输出流，将数据写出。
 * 4，关闭资源。
 */
public class Client {

    public static void main(String[] args) {
        Socket socket = null;
        BufferedReader bufferedReader = null;
        BufferedReader bufferedReader_Server = null;
        BufferedWriter bufferedWriter = null;
        try {
            //1,创建socket客户端对象。
            socket = new Socket("127.0.0.1", 8868);
            //2，获取键盘录入。获取控制台用户输入的信息
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            //3,socket输入流。读取服务端返回的数据
            bufferedReader_Server = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //4,socket输出流。将控制台信息数据输出给服务端
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            System.out.print("请输入：");
            String message = "";
            while ((message = bufferedReader.readLine()) != null) {
                bufferedWriter.write(message);
                bufferedWriter.newLine();
                bufferedWriter.flush();
                String getMessage = bufferedReader_Server.readLine();
                System.out.println("来自服务器说：" + getMessage);
                System.out.print("请输入：");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
