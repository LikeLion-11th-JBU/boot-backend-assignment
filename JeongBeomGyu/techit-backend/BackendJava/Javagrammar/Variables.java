public class Variables {
    public static void main(String[] args) {
        //변수 -> 데이터가 저장되는 공간

        //1. 1개의 변수 => 1개의 값만 할당 가능
        //2. 변수에 저장된 값 => 재할당을 통해 변경이 가능
        //3. 값의 형태에 맞는 자료형을 사용
        //4. 변수명은 소문자로 시작, 변수 앞에다가 숫자 사용이 불가능하다.
        //5. 대소문자 구분, 공백 포함 불가능
        //6. 자바 예약어
        int num = 1;  //정수 자료형 int
        double width  = 12.34; //실수형 자료형 double
        String content ="Programming"; //문자형 데이터, 참조형 데이터, 실제 메모리를 heap이라는 저장공간에 저장하고 content라는 변수에는 힙메모리의 주소만 들어간다.

        num = 10; //num이라는 변수가 재할당됨
        System.out.println(num);
        //int int = 1 int는 이미 타입을 가리키는 예약어이기 때문에 변수 int로 사용 불가하다.

        // String a = 1234; int타입의 데이터는 String으로 처리하지 못한다.


    }
}
