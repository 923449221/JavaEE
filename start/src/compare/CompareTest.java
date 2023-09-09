package compare;


import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author li
 * @create 2022--06   默认重写，实现compare接口，并重写compareto接口
 * @description    实现compartor接口定制 ，不用接口，直接创建匿名类重写
 */
public class CompareTest {
    public static void main(String[] args) {
        Animal animal = new Animal(10, "grid");
        Dog dog = new Dog() {    //调用父类无参构造    2.显式重写  3.覆盖了默认重写 4.无需重写所有
            @Override
            public void eat() {
                System.out.println("显式重写");
            }
        };
        dog.eat();
        dog.rotate();

        Dog[] dogArray = new Dog[]{new Dog(12, "11"), new Dog(13, "12"), new Dog(11, "13"),new Dog(12, "13")};
        Arrays.sort(dogArray); //如果不重写会报错
        System.out.println(Arrays.toString(dogArray)); //直接打印为地址 不重写分别打印地址
        Arrays.sort(dogArray, new Comparator<Dog>() {
            @Override
            public int compare(Dog o1, Dog o2) {

                    Dog dog1 = o1;
                    Dog dog2 = o2;

                    if (dog1.age > dog2.age) { //一般这里可以先减，如果不为0，则返回减的值
                        return 1;     //返回正数时交换，则为升序，从小到大
                    } else if (dog1.age < dog2.age) {
                        return -1;
                    }
                    return 0;


                }

        });
        System.out.println(Arrays.toString(dogArray));
        //注意相同的会被从set中排除，这里时降序，因为是dog里的copareable接口
        TreeSet treeSet =new TreeSet();
        treeSet.addAll(Arrays.asList(dogArray));
    /*    treeSet.add(new Dog(12, "11"));
        treeSet.add(new Dog(13, "12"));
        treeSet.add(new Dog(11, "13"));
        treeSet.add(new Dog(12, "13"));*/
        System.out.println("Treeset---"+treeSet);





    }
}

