package Io;


import java.io.*;

/**
 * @author li
 * @create 2022--09
 * @description \在win上代表目录，但在java中代表转义，所以\\代表\本身的意思
 * 异常不能进行抛出，而是要进行处理，为了防止流关闭不了，trycatch与finally是分离的，因此对象要建在外面
 * 而catch以后也是会向下运行，只是平常都在里面抛错误而已。
 *                                    注意一个个流只能读取一次
 */
public class CharacterIo {


    public static void main(String[] args) {
        FileReader f1 = null;
        FileWriter w1 = null;
        try {
            File file = new File("A.TXT");         //main函数中路径默认为module下，而junit为项目下
            File file2 = new File("B.TXT");
            System.out.println(file.getAbsolutePath());      //此时只是创建对象，并没有创建文件
            f1 = new FileReader(file);
            w1 = new FileWriter(file2);
            //方式一：
         /*   int data;
            while ((data = f1.read()) != -1) {           //一个一个读  返回单个字符的acill码
                System.out.print((char) data);
            }*/
            //方式二：
            char[] chars = new char[5];                   //5个字符一起读
            /*   while(f1.read(chars)!=-1){                //此写法会导致最后一个数组有出错的可能，因为char数组只会被部分覆盖
                    System.out.println(chars);
               }*/


           int len;
            while ((len = f1.read(chars)) != -1) {                 //返回读的个数

                for (int i = 0; i < len; i++) {
                    System.out.print(chars[i]);
                    w1.write(chars[i]);                //默认覆盖 而不是往下写
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (f1 != null && w1 != null) {       //防止流未创建时关闭
                    //file不需要关闭
                    f1.close();
                    w1.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }
}
