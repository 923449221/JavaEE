package annotionAndenum.Enum;

/**
 * @author li
 * @create 2022--06
        * @description  验证private的作用
        */
public class EnumTest {
    public static void main(String[] args) {
        //私有只是在本文件起作用，Two会报错。而本文件的main就不会报错
        System.out.println(oldEnum.ONE.getAge());
        // System.out.println(oldEnum.TWO.getAge());
        System.out.println(NewEnum.THREE);
        System.out.println(NewEnum.class.getSuperclass());






        //常用api
        //注意用枚举类数组直接接
        NewEnum[]  newEnums = NewEnum.values();
        for(int i=0;i<newEnums.length;i++){
            System.out.println(newEnums[i]);
        }
        //根据字符串获取对象
        NewEnum newEnum2 = NewEnum.valueOf("THREE");
        System.out.println(newEnum2.getAge());




//枚举类接口调用
        NewEnum.THREE.show();
        NewEnum.FOUR.show();







    }
}
