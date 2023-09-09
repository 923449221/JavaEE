package annotionAndenum;

import annotionAndenum.customize.CustomizeAnnomation;
import annotionAndenum.customize.CustomizeAnnomations;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.util.ArrayList;

/**
 * @author li
 * @create 2022--06
 * @description
 */

@CustomizeAnnomation("aa")
public class test1 {


}

//验证继承性
//注意要改为runtime方法，否则反射获取不到

class test2 extends test1 {


    public static void main(String[] args) {

            Class test2Class = test2.class;
            Annotation[] annotations = test2Class.getAnnotations();
            for (int i = 0; i < annotations.length ; i++) {
                System.out.println(annotations[i]);
            }


    }
}

//java8可重复注解
@CustomizeAnnomation("aa")
@CustomizeAnnomation("aa")
class test3{

}
//旧版可重复注解
@CustomizeAnnomations({@CustomizeAnnomation("aa"),@CustomizeAnnomation("aa")})
class test4{

}

//泛型与类型注解  java8新出
class test5<@CustomizeAnnomation T>{
    ArrayList<@CustomizeAnnomation String> list = new ArrayList();
    int i = (@CustomizeAnnomation int)10L;


}