package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ThrowsException {

    /* 1 */
    public Class loadClass(String fileName, String className) throws FileNotFoundException, ClassNotFoundException {
        FileInputStream fls = new FileInputStream(fileName);
        Class c = Class.forName(className);
        return c;
    }
    // 예외가 발생할 수 있는 상황을 try-catch 로 감싸지 않고
    // throws 를 메소드에 붙여서 이 메소드를 호출하는 곳에서 처리하도록 위임한다.

    /* 2 */
    public static void main_another(String[] args) {
        ThrowsException test = new ThrowsException();
        test.loadClass("b.txt", "java.lang.string");
    }
    // loadClass 에서 예외를 미루는데 이를 호출하는 곳에서도 try-catch 핸들링을 해주지 않으면
    // JVM 이 알아서 처리하도록 미뤄버린다.
    // 따라서 여기서는 우리가 처리해줘야 한다.

    /* 3 */
    public static void main(String[] args) {
        ThrowsException test = new ThrowsException();
        try {
            test.loadClass("b.txt", "java.lang.string");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
