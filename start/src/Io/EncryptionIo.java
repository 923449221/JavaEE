package Io;

import java.io.*;

/**
 * @author li
 * @create 2022--09
 * @description
 */
public  class EncryptionIo {
    public  static void encryption(String absolution) {               //利用异或一个方法可以实现加密和解码
        FileInputStream fileInputStream=null;
        FileOutputStream fileOutputStream =null;
        try {
            fileInputStream =new FileInputStream(new File(absolution));
            fileOutputStream= new FileOutputStream(new File(absolution+"copy.png"));
            byte[] bytes = new byte[5];
            int len =0;
            while ((len = fileInputStream.read(bytes))!=-1) {
                for (int i = 0; i < len; i++) {
                    bytes[i] = (byte) (bytes[i] ^ 9);
                }
                fileOutputStream.write(bytes, 0, len);
            }

            }

         catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream!=null&&fileOutputStream!=null) {
                try {
                    fileInputStream.close();
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }



    public static void main(String[] args) {
     String absolution = "zuoaiboge.png";
     String absolution2 = "zuoaiboge.pngcopy.png";
        encryption(absolution2);

    }
}
