package annotionAndenum.Enum;

import java.sql.SQLOutput;

/**
 * @author li
 * @create 2022--06
 * @description
 */
//对象声明必须在开头
//枚举类默认重写了toString，显示为对象名
//默认继承class java.lang.Enum，可在test中查看
    //重写使可以和类一样，也可以分别重写,写了会覆盖，不屑默认为基本，具体在test
public enum NewEnum  implements IEnum{
    //分别重写
    THREE("three", 3){
        public void show(){
            System.out.println("分别操作");
        }
    },
    FOUR("four", 4);
    private final String name;
    private final int age;

    private NewEnum(String a, int b) {
        this.name = a;
        this.age = b;

    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    public void show(){
        System.out.println("基本操作");
    }
}
