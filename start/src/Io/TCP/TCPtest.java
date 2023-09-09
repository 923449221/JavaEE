package Io.TCP;

import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author li
 * @create 2022--11
 * 注意愤青前面有没有带file，accecpt和read都是阻塞方法，read只有发送端关闭以后（close或者shutsown）才会取消阻塞
 * 可以通过分别注释两端的close来推断
 * 第二次的阻塞确实被close关闭了，
 * 注释read方，程序会完美结束，因为write方关闭了，结束发送数据，自己这边结束阻塞，两边都往下运行。
 * 注释write方，则read方程序会报错，因为read被强行关闭，write方找不到接收方报错。
 * @description 如果发送出去没有接受就会被报错，需提前开启服务端   udp只管发不管接
 * read方法为阻塞式，没有明确标识结束，不会往下运行
 * main路径默认整个项目而不是当前模块
 */
public class TCPtest {
    private static class Client {
        public static void main(String[] args) throws IOException {

            Socket socket = new Socket("127.0.0.1", 8088); //目标的地址端口
            OutputStream OutputStream = socket.getOutputStream();
            FileInputStream fileInputStream = new FileInputStream(new File("TCP.txt"));


            byte[] bytes = new byte[3];
            char[] chars = new char[2];
            int len = 0;
            System.out.println("111");
            while ((len = fileInputStream.read(bytes)) != -1) {
                OutputStream.write(bytes, 0, len);                   //拼出来肯定是整的，不用担心分割字符 //传出去
            }
            socket.shutdownOutput();        //概念比数据输出，提醒对面终止接收
            System.out.println("222");
            InputStream is = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
            while ((len = inputStreamReader.read(chars)) != -1) {
                System.out.print(String.valueOf(chars, 0, len));
            }
            System.out.println("333");
            is.close();
            fileInputStream.close();
            OutputStream.close();
            socket.close();


        }
    }

    private static class Serverse {
        public static void main(String[] args) throws IOException {
            ServerSocket serverSocket = new ServerSocket(8088);
            Socket socket = serverSocket.accept();             //接收//这是个阻塞方法
            InputStream is = socket.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            FileWriter fileWriter = new FileWriter(new File("TCP2.txt"));
            //为防止字节读有切割字符的风险，使用byte数组或者用转换流//这里只是方便读
            //里面是字节数组，写的时候都写进内存，然后一起写出来
            byte[] bt = new byte[2];
            int len;
            System.out.println("111");
            while ((len = is.read(bt)) != -1) {                         //这也是个阻塞方法
                byteArrayOutputStream.write(bt, 0, len);
            }

            System.out.println("222");
            System.out.println(byteArrayOutputStream.toString("utf8"));
            fileWriter.write(byteArrayOutputStream.toString());

            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("已收到".getBytes());            //为何这里没有发生二次阻塞呢，如果是close，那么是客户端的close还是服务端的呢

            fileWriter.close();
            is.close();
            outputStream.close();
            socket.close();
            serverSocket.close();


        }
    }
}
