package FaceToObject;

import org.junit.Test;

/**
 * @author li
 * @create 2022--06
 * @description
 */
public class Student extends Person {
    public String adr;   //第三条时放开
    public int age;  //第四条放开


    /*   public Student(int age, String adr) {       //第三条时放开
           super(age, adr);
       }*/
    public Student(int age, String adr) {
        this.age = age;
        this.adr = adr;
    }

    public void otherCheck() {
        System.out.println("子类方法otherCheck "+age);
    }
   public void  TestThree(){
        testOne();
   }

    public void SonCheck() { //第四条放开
        System.out.println("---------------");
        System.out.println("子类方法" + age);
        super.fatherCheck();

    }
}





