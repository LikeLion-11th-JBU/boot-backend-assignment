import java.util.ArrayList;

public class ExceptionExample {
    public static void main(String[] args) {
        //예외(Exceptions) => 실행단계에서 발생하는 에러중에 하나, 그 중에서 이러한 에러는 예측이 돼서 유형화해서 가지고 있는 것
        //예외 만들기
      //  int a = 10;
       // int b = 0;
      //  int c = a/b; // 0으로 나눌 수 없으므로 오류 발생, 이때 exception으로 예측되었음을 볼 수 있다.
                    //이러한 상황을 적절히 처리해줄 필요 있음. 컴퓨터의 시스템 자체에서 처리될 수 있도록 즉,회피하거나 대체적인 동작, 에러
                    //메세지가 뜰 수 있도록 처리 해야한다.

        //arraylist로 예외 만들기
        ArrayList arrayList = new ArrayList(3);
        //arrayList.get(10); // 범위를 벗어나서 exception이 발생한다.
                            // try catch라고 하는 구문을 이용해서 예외를 처리할 수 있다. 에러가 발생할 수 있는 코드를 try에 넣는다
                            //예외가 발생하면 대체 동작을 수행할 수 있도록 하는 catch. 다중으로 세팅 할 수 있다.
        try {
            // arrayList.get(10);
            int a = 10;
            int b = 0;
            int c = a/b; //산술적인 예외를 처리하지 못하고 강제종료 된것을 볼 수 있다. 그렇기 떄문에 가장 마지막에는 최상위의 exception을 넣어서 처리되지 않는 예외가 없도록 만든다.
        }catch (IndexOutOfBoundsException ioe) //(Exception e)  //가장 최상위에 exception이라는 객체가 있어서 모든 exception은 여기에 포함이 되어, 어떠한 에러가 발생하더라도 catch에 걸리게된다.
        {
            //발생한 에러 종류를 세분화
           // e.printStackTrace(); //에러의 내용을 확인 할 때
            // System.out.println("에러발생"); //catch문 안에는 system과 println문은 넣지않는 것이 보안에 좋다.
            System.out.println("IndexOutOfBoundsException 발생");
        }catch (IllegalArgumentException iae){   // 함수에 다가 매개변수를 잘못 넘겼을 때 나오는 에러
            System.out.println("IllegalArgumentException 발생");
        }catch (Exception e){
            System.out.println("Exception 발생");
        }
        finally {   //위와 상관없이 무조건 수행되는 그러한 소스를 가리킨다.
            System.out.println("finally");

        }
    }
}
