package exception;

public class IDFormatException extends Exception {
    public IDFormatException(String message) {
        super(message);
    }
}

class IDFormatTest {

    private String userID;
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) throws IDFormatException {
        if(userID == null) {
            throw new IDFormatException("아이디는 null일 수 없습니다.");
        }
        else if(userID.length() < 8 || userID.length() > 20) {
            throw new IDFormatException("아이디는 7자 이상 20자 이하로 쓰세요.");
        }
        this.userID = userID;
    }
    // 예외를 미룬다.
    // 호출하는 곳에서 try-catch 로 처리해줘야한다.
    // 끝까지 계속 미루면 JVM이 마음대로 처리한다.

    public static void main(String[] args) {
        IDFormatTest test = new IDFormatTest();
        String myId = null;
        try {
            test.setUserID(myId);
        } catch (IDFormatException e) {
            System.out.println(e);
        }
        // setUserID() 는 예외가 발생할 수도 있는 메소드이므로
        // 호출하는 부분에서 try-cath 로 처리하자
    }
}