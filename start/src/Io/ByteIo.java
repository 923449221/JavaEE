package Io;

import java.io.*;

/**
 * @author li
 * @create 2022--09
 * @description
 */
public class ByteIo {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            fileInputStream = new FileInputStream(new File("A.TXT"));
            fileOutputStream = new FileOutputStream(new File("C.TXT"));
            byte[] bytes = new byte[5];
            int len;
            while ((len = fileInputStream.read(bytes)) != -1) {
                System.out.print(new String(bytes, 0, len));   //这一步读到内存形成String时几率出乱码，因为字符被切割了 ，
                // 而最后形成的文字或者图片不会被切割
                fileOutputStream.write(bytes, 0, len);

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null && fileOutputStream != null) {
                    fileInputStream.close();
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }
}
