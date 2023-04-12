import java.util.ArrayList;

public class ExceptionExample {

    public static void main(String[] args) {

        // 예외(Exceptions)

        //int a = 10;
        //int b = 0;

        //int c = a / b;


        ArrayList arrayList = new ArrayList(3);

        try {
            int a = 10;
            int b = 0;
            int c = a / b;
        } catch (IndexOutOfBoundsException ioe) {
            //e.printStackTrace(); // 에러 메시지 표시 (나중에는 안 보이게 하는게 보안상 좋다)
            System.out.println("IndexOutOfBoundsException 에러발생");
        } catch (IllegalArgumentException iae) {
            System.out.println("IllegalArgumentException 에러발생");

        } catch (Exception e) { // 가장 마지막엔 최상위의 에러 넣어주기
            System.out.println("Exception 발생");
        } finally {
            System.out.println("Finally");

        }




    }
}
