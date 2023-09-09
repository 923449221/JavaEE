package annotionAndenum.Enum;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory;

/**
 * @author li
 * @create 2022--06
 * @description  旧枚举类
 */
//里面都是对象，对象为常量，里面的属性为常量
public class oldEnum {
    //常量初始化，因为要动态的,所以在构造函数中初始化
    private final String name ;
    private final int age;
    //禁止其他文件中调用,自己new
    private  oldEnum(String a,int b){
        this.name = a;
        this.age=b;
    }
    //fianl保证不修改对象指针
    //static使其通过类名调用
    public     static final oldEnum ONE =new oldEnum("1",1);
    private static  final oldEnum TWO =new oldEnum("2",2);

    @Override
    public String toString() {
        return "oldEnum{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static void main(String[] args) {
        System.out.println(oldEnum.ONE.getAge());
        System.out.println(oldEnum.TWO.getAge());

    }
}



