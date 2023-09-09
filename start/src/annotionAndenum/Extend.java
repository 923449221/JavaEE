package annotionAndenum;

/**
 * @author li
 * @create 2022--06
 * @deprecated  question继承
 */
public class Extend {

    String name;
    int age;

    public Extend(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void work(){
        System.out.println("aa");
    }

}
//为何父类没有无参构造器，则子类报错
//因为没有手动写super，会自动调用super(),调不到就会报错
//25-27行加上以后，子类不会报错
//只要写了super，就不会再默认调用。
class Son extends Extend{
    public  Son(String aaa,int b){
        super(aaa,b);
    }
    @Override
    public void work() {
        super.work();
    }
}
