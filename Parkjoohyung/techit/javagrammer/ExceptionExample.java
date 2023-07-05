import java.util.ArrayList;

public class ExceptionExample {
    public static void main(String[] args) {
        //예외(Exceptions)


/*
        int a = 10;
        int b = 0;
        int c = a / b;
*/


        ArrayList arrayList = new ArrayList(3);


        try {
            int a = 10;
            int b = 0;
            int c = a / b;

            //arrayList.get(10);
        } catch (IndexOutOfBoundsException ioe) {
            System.out.println("IndexOutOfBoundsException 발생");
        /*} catch (Exception e) {
            e.printStackTrace(); //입력하지 않으면 에러메시지는 나오지 않음, 외부에는 노출시키지않는게 좋음 => 취약점
            System.out.println("에러발생"); //이렇게 안써주는게 보안에 더 좋긴함*/
        } catch (IllegalArgumentException iae){
            System.out.println("IllegalArgumentException 발생");
        } catch (Exception e) {
            System.out.println("Exception 발생");
        }finally {
            System.out.println("finally");
        }


    }
}
