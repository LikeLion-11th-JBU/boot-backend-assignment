import java.util.ArrayList;

public class ExceptionExample {
    public static void main(String[] args) {
        //예외 (Exceptions)
//        int a = 10;
//        int b = 0;
//
//        int c = a / b;

        ArrayList arrayList = new ArrayList(3);

        try {
//            arrayList.get(10);
            int a = 10;
            int b = 0;
            int c = a / b;
        } catch (IndexOutOfBoundsException ioe) {
//            e.printStackTrace(); 에러 내용 출력
            System.out.println("IndexOutOfBoundsException 에러발생");
        } catch (IllegalArgumentException iae) {
            System.out.println("IllegalArgumentException");
        } catch (Exception e) {
            System.out.println("에러발생");
        } finally {
            System.out.println("finally");
        }


    }
}
