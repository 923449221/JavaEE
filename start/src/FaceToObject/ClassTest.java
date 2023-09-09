package FaceToObject;

import java.util.LinkedHashMap;

//此为独立的一个类，用于验证多态的另一种情况，即在父类中直接调用已经重写的方法，也会走多态
//验证父类对象直接调走不走多态
//验证 printB
public class ClassTest {



    public class A {
        public void printA() {
            System.out.println("这是A的方法");
        }

        public void print() {
            System.out.println("这是公共打印方法");
            this.printA();                       //这个this加不加一样
        }
    }

    public  class B extends A {

        public void printA() {
            System.out.println("这是重写了A中打印方法,但这是B中的方法");
        }
        public void printB(){             //验证是否super调用的会不会重写
            super.printA();
        }
    }

   public static void main(String[] args) {
       //* B b = new B();*//*
       ClassTest.B b = new ClassTest().new B();
       b.print();
       ClassTest.A a = new ClassTest().new A();
       a.print();                                                  /* 连个调用者一样有不一样的结果，说明和调用者有关系，可以理解为，父类调用肯定不会走多态，但子类会走多态
                                                                     就算是子类继承自父类的方法，也看做子类的方法，继而这个方法，包括方法内部都可以走多态。*/


   }
}


