package FaceToObject.GenericsTest;

/**
 * @author li
 * @create 2022--07
 * @description          构造函数无需用T标识
 *                       注意泛型类不可修饰静态方法，因为泛型是在new对象时标识的
 *                       而泛型方法可以
 */
public class Dao<T> {
     public T getT(T t){
        return t;
    }
   public static  <E> E getE(E e){            //泛型方法的作用主要根据方法参数类型确定返回值类型
        return e;
    }
}
