package Io;

import sun.nio.cs.ext.GBK;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author li                字符流只是包括了字节流和字符转换流，编码方式是默认的，自定义就需要转换流
 *                              流程为字节--字符（字节）---字节
 *                              java的String默认utf16编码，String也就是char数组也就是byte数组。
 *                              文本文件有自己的编码方式，但里面没有编码标记，只有大端小端标记，
 * @create 2022--11
 * @description
 */
public class transformateIo {
    public static void main(String[] args) {

        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;

        try {
            inputStreamReader = new InputStreamReader(new FileInputStream(new File("D:\\aliyun\\GBK.txt")),"GBK");
            outputStreamWriter = new OutputStreamWriter(new FileOutputStream(new File("D:\\aliyun\\UTF8.txt")), StandardCharsets.UTF_8);
            char[] chars = new char[5];
            int len;
            while ((len = inputStreamReader.read(chars)) != -1) {
                System.out.print(new String(chars, 0, len));   //这一步读到内存形成String时几率出乱码，因为字符被切割了 ，
                // 而最后形成的文字或者图片不会被切割
                outputStreamWriter.write(chars, 0, len);

            }

        } catch (
                IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStreamReader != null && outputStreamWriter != null) {
                    inputStreamReader.close();
                    outputStreamWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }
}
