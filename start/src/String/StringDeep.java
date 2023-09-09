package String;


import FaceToObject.*;

/**
 * @author li
 * @create 2022--06
 * @description
Student s1 = new Student("a",11,"b");
AnotherStudent a1 = new AnotherStudent("a",12,"b");
System.out.println(s1.name==a1.name&&s1.adr==a1.adr);  //true
 * 注意字面量定义也算对象，所以 new String("abc")创建了两个对象,计算u你不同的对象，只要字面量相同那么他们地址就相等
 * //理解为内容绝对不可重复就可
 * //注意静态类必须为内部类
 * 常量池不可重复
 * fianl类不可继承，f
 * inal数组效果不明，只是让数组地址不可被赋值，但一个引用变量（数组）就算被赋值，也是在堆中新建地址，并传值给引用变量，这里并不知道常量池是如何运作的
 * 没有提供修改内容的方法
 * 关于变量的拼接、视为new
 * 此类要展示变量的拼接，测试字面量定义下的类属性
 */
public class StringDeep {

    String name;
    int age;

    public StringDeep(String a, int b) {
        this.name = a;
        this.age = b;
    }

    public static void main(String[] args) {


        String s1 = "aaa";
        String s2 = s1 + "bbb";//相当于new
        String s3 = "aaa" + "bbb";
        String s4 = "aaabbb";
        System.out.println(s2 == s3);  //false
        System.out.println(s4 == s3);  //true
        StringDeep d1 = new StringDeep("aaa", 1);
        StringDeep d2 = new StringDeep("aaa", 1);
        System.out.println(d1.name == d2.name);   //true
        StringDeep d3 = new StringDeep("aaa" + s1, 1);
        StringDeep d4 = new StringDeep("aaa" + s1, 1);
        System.out.println(d3.name == d4.name);  //false


    }
}
