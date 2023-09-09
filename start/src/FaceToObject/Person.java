package FaceToObject;


/**
 * @author li
 * @create 2022--06
 * @description  //多态下，方法动态绑定，但对于父类没有的方法，也要过编译（编译会认为引用的类型为父类，格式为类型@地址），所以虽然有方法，只有向下转型后才能使用
 *                //类调用和new都会加载类，加载常量在加载阶段，类调用少了动态的部分，也就是创建对象以及一系列初始化的部分
 *
 *                //
 *               //创建子类对象不会创建父类对象，只是调用构造方法进行初始化，在子类中有父类引用，所以可以调用父类的属性和方法
 */
public class Person {

    public String adr;
    public int age;

    public Person() {

    }




    public Person(int age, String adr) {

        this.adr = adr;
        this.age = age;
    }
    private void  testTwo(){
        System.out.println("父类私有");
    }
    public void testOne(){
        testTwo();
    }

    public void otherCheck() {
        System.out.println("父类方法otherCheck "+age);
    }

    public void fatherCheck(){
        //第四条放开
        System.out.println("父类方法"+age);
        age=123456;
        System.out.println("父类方法"+age);
        this.otherCheck();
    }





}
