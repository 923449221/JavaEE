package FaceToObject;


/**
 * @author li           忽略封装性的情况下,讨论用super，乃至其他类调用方法，调用的是方法代码的拷贝，还是具体到某个类 ,主要现象就是，
 * 当方法中出现this，super，super(),this()时，如何判断this，super，super(),this()指向的是调用者（代码拷贝）还是
 * this，super，super(),this()所在类的对象（具体到所在类）。
 * 1.经验证，子类没有属性，会自动调用父类属性。
 * <p>
 * 2.子类父类有重名变量，正常情况下，调用的属性类型决定
 * Person s1 =new Student(20,"hh");
 * System.out.println(s1.adr);  //null
 * <p>
 * Student s2 = (Student)s1;
 * System.out.println(s2.adr);   //hh
 * 3.前一条有例外情况，构造函数为super(adr)时，操作的是父类变量，子类属性为默认值null，
 * 配合第一条，就可以得出如下结果：     由此可知，this指的是其所在类
 * <p>
 * Person s1 =new Student(20,"hh");
 * System.out.println(s1.adr);   //hh
 * Student s2 = (Student)s1;
 * System.out.println(s2.adr);     //null
 * 4.调用方法所处理的属性为方法所在类的属性，与调用者无关
 * 5.可以认为，只要子类重写，那就会调用子类，不管是在哪儿调用的。
 * *
 * * @create 2022--06
 * @description
 */
public class ObjectTest {


    public static void main(String[] args) {
//以下为第四条
        Person s1 = new Student(20, "hh");
        s1.fatherCheck();  //0 ,123456 //重写子类后，为20 123456
        Student s2 = (Student) s1;
        s2.SonCheck();


        System.out.println("-----=--------------");
        //对比get获得父类私有属性，方法也可以获得，说明 1.代码不是复制到本类，而是调用父类 2。在父类中的方法就不收private的限制
        s2.testOne();


    }

}
