package annotionAndenum.customize;

import java.lang.annotation.*;

/**
 * @author li
        * @create 2022--06
        * @description
        */
@Repeatable(NEWCustomizeAnnomations.class)
@Inherited //使注解可以被继承
@Retention(RetentionPolicy.RUNTIME)//生命周期，1.编译2. class文件3.运行，加载到内存，只有这时可以被反射获取
@Target({ElementType.TYPE,ElementType.TYPE_PARAMETER,ElementType.TYPE_USE})//限定修饰的部位，不写为所有
@Documented//java.doc生成文档，没有的话生成控制台报错，生成文档中没有
public @interface CustomizeAnnomation {
    String value() default "aa";
    //String value() ;
    //方法表示变量
    //可以是注解
    //default没有的时候，使用时空参会报错
}
