package compare;

/**
 * @author li
 * @create 2022--06
 * @description
 */

public class Animal implements  Robot {
    public int age;
    public  String name;

    public Animal(int age, String name) {
        this.age = age;
        this.name = name;
    }
    public Animal(){
        System.out.println("无参构造");
    }
    public void eat(){
        System.out.println("animal吃");
    }
    public void call(){
        System.out.println("animal叫");
    }

    @Override
    public void rotate() {
        System.out.println("旋转");
    }

    @Override
    public String toString() {
        return "Animal{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
