public class ReferenceType {
             //참조
    public static void main(String[] args){

        // 참조형 Ex) String
        // 참조형 데이터의 값 => 힙 메모리 영역
        // 변수에 대입되는 값 => 힙 메모리 영역의 주소값

        String a = new String("Hello!"); //new는 새로만드는 작업만 하기에
                                                 // 같은 문자열 데이터가 있건없건무조건 생성한다.
        System.out.println(a);

        String b = "Hello!"; // 값 자체를 대입하는 경우에는
                             // 기존의 동일한 데이터를 활용하기 위해 주소를 동일하게 가져감.
        String c = "Hello!";

        // String a와 String b에 있는 "Hello!"는 같은 장소인가? 다른 장소인가?

        if(a == b){ //a와 b가 값은 주소값을 가지고 있다면 어떠한 명령값을 실행해! 라는 뜻~
            System.out.println("a == b"); // 이것을 출력시키면 실행이 안되고 위에 10번째행만
                                          // 결과값이 출력되므로 다른 주소값을 가진다.
        }
        if(b == c){
            System.out.println("b == c");
        }

    }
}
