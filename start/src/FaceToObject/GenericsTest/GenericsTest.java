package FaceToObject.GenericsTest;


/**
 * @author li
 * @create 2022--07
 * @description
 *                               后面的String可以省略，自动推断
 *                               泛型不可以用基本变量，可以用封装类
 *                                注意list<父类>不可以可以指向list<子类>，（可以理解为并列）而数组可以。
 *
 *
 */
public class GenericsTest {

    public static void main(String[] args) {
       Dao<String> dao =new Dao<>();         //后面的String可以省略
       User user =new User();             //如果已经指明父类泛型类，则无需再声明，已经固定

    }
    
}
