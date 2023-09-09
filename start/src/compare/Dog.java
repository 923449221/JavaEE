package compare;

/**
 * @author li
 * @create 2022--06
 * @description   //实现compar接口并重写方法
 */
public class Dog extends Animal implements Comparable   {
    @Override
    public void eat() {
        System.out.println("狗吃");
    }

    public Dog(int age, String name) {
        super(age, name);
    }

    public Dog() {
    }



            @Override
            public int compareTo(Object o)  throws  RuntimeException{
                if (o instanceof Dog) {//是否可以转换成dog，即为dog的子类
                    Dog dog = (Dog) o;
                    if (this.age > dog.age) {
                        return -1;           //-Integer.compare(this.age,dog.age);
                    } else if (this.age < dog.age) {
                        return 1;            //Integer.compare(this.age,dog.age);
                    }
                    return 0;


                }

            throw   new RuntimeException("不相等");

    }
}

