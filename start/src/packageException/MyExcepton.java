package packageException;

/**
 * @author li
 * @create 2022--04
 * @description 自定义异常
 */
public class MyExcepton extends RuntimeException {
    //运行时异常，交由虚拟机捕获，不会再编译器报错
    MyExcepton(){}
    MyExcepton(String msg){
        super(msg);
    }
}
