package collection.List;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author li
 * @create 2022--06
 * @description java集合不能存放基本数据类型, 只能存放数据引用
 *       //一定要注意，如果不用new Arraylist包起来，
 *       直接用Arrays.aslist 则不能用add和remove等方法，因为此方法饰建立了array的内部类，与arrayList虽然同名，但没有重写
 */
public class test {
    @Test
    public void test() {
        Collection coll = new ArrayList();
        coll.add("123");
        coll.add('c');//自动装箱
        coll.add(123);//自动装箱
        coll.add(new Person("123", 123, '1'));
        /* coll.add(new Person());*///未初始化int为0，char为0对应的码，引用变量为null
        System.out.println(coll);//直接打印内容
        System.out.println(coll.contains(123));//源码可知，arraylist调用了equals方法,相当于==
        System.out.println(coll.contains("123"));//String重写了equals方法
        System.out.println(coll.contains(new Person("123", 123, '1')));    // 未重写equal方法结果为false，重写后为true
 /*     ArrayList a =  new ArrayList<String>();
        a.add("123");
*/
        //挨个eauals比较集合中的每个值
        System.out.println(coll.containsAll(Arrays.asList(new String[]{"123"})));
        System.out.println(coll.containsAll(Arrays.asList(new Integer[]{123})));//为何用基本类型123不行，integer可以，里面都自动装箱了
        //以下内容打印类型
        //迭代器理解为初始指针指向为-1，next是先移动在读取。
        Iterator iterator = coll.iterator();
        while (iterator.hasNext()) {
            Class clazz = iterator.next().getClass();
            System.out.println(clazz);
        }

        //    Object[] list =list1.toArray();     集合转数组
        //数组转list
      //一定要注意，如果不用new Arraylist包起来，直接用Arrays.aslist 则不能用add和remove等方法，因为此方法饰建立了array的内部类，与arrayList虽然同名，但没有重写
        List list1 = new ArrayList(Arrays.asList(123,123, 456));
        list1.add("String");
        list1.add("String");
        list1.add(new Person("123", 123, '1'));
        System.out.println(list1);

        List list2 =new ArrayList( Arrays.asList(new int[]{123, 456})); //此结果为地址值，可能是基本数据类型的数组只有一个地址，被识别为一个元素的缘故
        System.out.println(list2);
        List list3 = new ArrayList(Arrays.asList(new Integer[]{123, 456})); //数组中存储2个地址
        System.out.println(list3);

        // remove           此方法也是比较equals方法 removeall也是挨个比较equals后移除

        System.out.println(list1);
        //此处写int会被重载为index参数，需用interger类型,对其打断点，发现也经过了equals方法，而观察代码为两个int值的==。
        //经查证，remove（object t）只会u删除第一个元素
        list1.remove((Integer)123);
        System.out.println(list1);
        list1.remove(("String"));
        System.out.println(list1);
        list1.remove((new Person("123", 123, '1')));
        System.out.println(list1);


    }


}
