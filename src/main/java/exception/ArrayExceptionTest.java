package exception;

public class ArrayExceptionTest {

    // try-catch 로 감싸지 않았다면 서버가 죽은 것이지만
    // 이 경우는 서버가 죽은게 아님

    public static void main(String[] args) {
        int[] arr = new int[5];

        try {
            for (int i = 0; i <= 5; i++) {
                System.out.println(arr[i]);
            }
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println(e.toString());
            System.out.println("예외 처리");
        }

        System.out.println("프로그램 종료");
    }

}
