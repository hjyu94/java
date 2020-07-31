package _30_Exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ResourceException {
//    // FileInputStream 은 예외를 처리해야 한다.
//    public static void main_1(String[] args) {
//        FileInputStream fis= null;
//        fis = new FileInputStream("a.txt");
//    }

    // FileInputStream 을 열었으면 닫는 처리를 반드시 해야한다.
    // 열었을 때 예외가 발생할 수 있고 닫는 중에 예외가 발생할 수 있다.
    public static void main_2(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("a.txt");
        } catch (FileNotFoundException e) {
            System.out.println(e);
            return;
            // return 이 수행되도 finally 문 수행함.
            // sout("end"); 는 수행되지 않는다.
        } finally {
            try {
                fis.close();
            } catch (Exception e) { // fis 가 열리지 않으면 NullptrEception 발생
                System.out.println(e);
            }
        }
        System.out.println("end");
    }

    // AutoCloseable를 구현한 클래스의 경우 auto-close 기능을 사용할 수 있다.
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("a.txt")) {
            // ...
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
