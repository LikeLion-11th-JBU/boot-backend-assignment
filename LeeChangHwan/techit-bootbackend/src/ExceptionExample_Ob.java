import java.util.ArrayList;

public class ExceptionExample_Ob {

    public static void main(String[] args) {

        // 예외(Exceptions) >> 코드를 실행했을 때 생기는 error 중에 하나
        // error라는 큰 범위에서 예상이 되고, JAVA에서 유형화 된 error코드를
        // 예외라고 한다.

        /*
        int a = 10;
        int b = 0;
        int c = a / b;
        */

        /*
        ArrayList arrayList = new ArrayList(3);
        arrayList.get(10);
        // 이대로 실행하면 error 뜸 Index 10 뭐시기~
        */

        /*
        ArrayList arrayList = new ArrayList(3);

        try{
            arrayList.get(10);
        } catch (Exception e) {
            e.printStackTrace(); // 얘를 입력 안했다면,
                                 // error가 어디서 났는지 알 수 없다.
            System.out.println("error 발생");
        } finally {
            System.out.println("finally");
        }
        */

        /*
        ArrayList arrayList = new ArrayList(3);

        try{
            arrayList.get(10);
        } catch (IndexOutOfBoundsException ioe) {
            System.out.println("IndexOutOfBoundsException 발생");
        } catch(IllegalArgumentException iae){ //catch는 다중으로 사용 가능.
            System.out.println("IllegalArgumentException 발생");
        }
            finally {
            System.out.println("finally");
        }
        */
        //이렇게 하면 동작하지 않음.

        ArrayList arrayList = new ArrayList(3);

        try{
            // arrayList.get(10);
            int a = 10;
            int b = 0;
            int c = a / b;
        } catch (IndexOutOfBoundsException ioe) {
            System.out.println("IndexOutOfBoundsException 발생");
        } catch(IllegalArgumentException iae){ //catch는 다중으로 사용 가능.
            System.out.println("IllegalArgumentException 발생");
        } catch(Exception e){
            System.out.println("Exception 발생");
        }
        finally {
            System.out.println("finally");
        }
        // finally는 실행되지만 error코드에서는 산술관련해서는 error가 뜸.
        // error코드를 안띄우려면?
        // => catch(Exception e){
        //    System.out.println("Exception 발생"); [64열, 65열] 넣어주기




    }
}
