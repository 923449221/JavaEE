package Stream;


import java.util.ArrayList;
import java.util.Arrays;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author li
 * @create 2023--04          拉姆达表达式其实就是创建匿名子类的简化写法，需要一个函数式接口，看见箭头，和前半部分类的声明就可以确定是哪个接口，那么也就确定了形参，所以形参可以省略。
 * 代码从compare中复制修改而来
 * @description 方法引用只有实现的方法形参返回值相同就可以使用，但有种特殊形式就是类名：：动态方法，这种方式默认调用者为第一个形参           此外方法引用的形参全部省略
 */
public class TestClass {

    public static void main(String[] args) {
        Dog[] dogArray = new Dog[]{new Dog(12, "11"), new Dog(13, "12"), new Dog(11, "13"), new Dog(12, "13")};
        System.out.println(dogArray);
        System.out.println(Arrays.toString(dogArray));
        Arrays.sort(dogArray, new Comparator<Dog>() {
            @Override
            public int compare(Dog o1, Dog o2) {                   //函数式接口compare

                Dog dog1 = o1;
                Dog dog2 = o2;

                if (dog1.age > dog2.age) {
                    return 1;
                } else if (dog1.age < dog2.age) {
                    return -1;
                }
                return 0;


            }

        });
        System.out.println(Arrays.toString(dogArray));
        //以下为拉姆达
        Comparator<Dog> comparator2 = (o1, o2) -> -1;             // 类型省略（类型推断：泛型决定接口方法形参）
        // 只有一个形参括号省略，只有一句话大括号省略，return也要省略
        Arrays.sort(dogArray, comparator2);
        //重排序
        System.out.println(Arrays.toString(dogArray));
        Comparator<Dog> comparator3 = Dog::compareTo;            //(dog1,dog2)->dog1.compareTo(dog2)          //特殊方法引用

        Arrays.sort(dogArray, comparator3);

        Consumer consumer = System.out::print;                  //简易写法
        /*   Consumer consumer = o-> System.out.println(o);*/
        consumer.get(dogArray[1]);

        System.out.println();

        Stream<Integer> stream = Arrays.stream(dogArray).map(t -> t.getAge());           //不用终止操作可以继续，用了要重新获得
        stream.filter(t -> t > 12).forEach(System.out::println);
        Integer[] array = new Integer[]{1, 1, 3, 4, 5};
        ArrayList<Integer> list = new ArrayList(Arrays.asList(array));              //由工具类生成的arraylist是内部类，没有add方法并且结果会因为array的变化而变化。
        Optional<Integer> stream1 =    list.stream().map(e->e.intValue()+1).filter(e->e>3).reduce(Integer::sum);
        System.out.println(stream1);




    }
}
