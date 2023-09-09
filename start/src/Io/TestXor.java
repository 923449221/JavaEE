package Io;

import org.junit.Test;

/**
 * @author li
 * @create 2022--09
 * @description //异或交换                异或相同时为0，不相同为1
 *                                        由此得出 a^a为0，a^0为a
 * //异或                                 求一个数的1的个数，与运算，
 *                                       则一个数减一然后与减之前与，则结果为消去了最后一位，以此循环，能循环几次就几个1。
 */
public class TestXor {
    class exchange {               //实现不用第三变量来交换
        int a = 1;
        int b = 2;

        public void exchangeOne() {
            a = a - b;
            b = a + b;
            a = b - a;
        }

        public void exchangeTwo() {
            a = a ^ b;
            b = a ^ b;
            a = a ^ b;


        }

    }


    class check {
        //只有一个不重复，找这个数

            public char checkMethod() {
                char[] chars = {'a', 'b', 'c', 'd', 'b', 'c', 'a'};
                int i =0;
                int j =0;
                while(true){
                    if(i> chars.length-1){
                        break;
                    }
                    j^=chars[i];
                    i++;

                }
                return (char) j;


            }







    }

    public static void main(String[] args) {

        TestXor.check checkOne = new TestXor().new check();
        System.out.println( checkOne.checkMethod());
    
    }
}
