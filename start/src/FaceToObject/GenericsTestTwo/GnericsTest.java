package FaceToObject.GenericsTestTwo;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

/**
 * @author li
 * @create 2022--08
 * @description 注意list<父类>不可以可以指向list<子类>，（可以理解为并列）而数组可以。
 * ?通配符让方法的参数可以实现如多态一般的功能，使子类可以向上转型。
 *///分别用通配符和泛型方法写方法
public class GnericsTest {


    public static void main(String[] args) {
        List<Son> s = null;
        List<Person> p = null;
//  p= s;                         编译错误，这是并列关系

        List<?> list = null;
//        list = s;  可以通过


        s = new ArrayList<>();
        s.add(new Son());
        s.add(new Son());
        p = new ArrayList<>();
        p.add(new Person());
        p.add(new Person());

        Object[] arr =  getArray(s);
        Object[] arr2 =  getArrayTwo(s);
        System.out.println(s);
        System.out.println(arr);
        System.out.println(arr2);

    }


    public static Object[] getArray(List<?> list) {          //通配符
                                                             // 返回任意泛型集合转换的数组，参数可以是任意泛型
        List<Object> list1 = new ArrayList<>();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object o = iterator.next();
            list1.add(o);
        }

        Object[] arr = list1.toArray();
        return arr;


    }
    public  static  <E> E[]  getArrayTwo(List<E> list){     //第一个<E>为标识，表示为泛型方法
        List<E> list1 = new ArrayList<>();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            E o = (E) iterator.next();
            list1.add(o);
        }

        E[] arr = (E[]) list1.toArray();
        return arr;


    }



}
