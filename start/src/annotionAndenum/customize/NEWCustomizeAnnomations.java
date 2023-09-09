package annotionAndenum.customize;


import java.lang.annotation.*;
@Inherited
@Retention(RetentionPolicy.RUNTIME)//生命周期，1.编译2. class文件3.运行，加载到内存，只有这时可以被反射获取
@Target(ElementType.TYPE)//限定修饰的部位，不写为所有
@Documented
public @interface NEWCustomizeAnnomations {
CustomizeAnnomation[] value();


}
