package packageException;

import java.util.Scanner;

public class HelloWord {
    public static void main(String[] args) {

        shuRu();

    }
    public  static void  shuRu(){
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        if (i>0){

            System.out.println("+++ /n" +"请输入");

            shuRu();
        }else {
            throw new MyExcepton("---");
        }
    }



}
