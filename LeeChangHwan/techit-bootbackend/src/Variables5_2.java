import org.w3c.dom.ls.LSOutput;

public class Variables5_2 {

    // 변수 = variables
    // 변수 => 데이터가 저장되는 공간

    // 1. 1개의 변수 => 1개의 값만 할당 가능
    // 2. 변수에 저장딘 값 => 재할당을 통해 변경 가능
    // 3. 값의 형태에 맞는 자료형을 사용
    // 4. 변수명은 소문자로 시작
    // 5. 대소문자 구분, 공백 포함 불가능
    // 6. JAVA 예약어 사용 불가

    public static void main(String[] args) {
        int num = 1; // = 은 같다가 아니라 좌측의 변수에 데이터를 할당시킨다!
        double width = 12.34; // double은 실수(소수)
        String content = "Programming"; // string은 문자
        num = 10;

        int Num = 10 ; //이렇게 써도 에러는 안나지만 JAVA안에서의 규칙이다. (4)번
        int num1 = 10 ; // 변수명 앞에 1num은 NoNo, 변수명 뒤에 num1은 Okay
        System.out.println(num);

      // int int = 1; , int double = 1; 과 같이 변수가 이미 JAVA에서 사용중인 '예약어'인 것이다. (6)번

      //  String a = 1234; String에 숫자데이터를 할당시킬 수 있나? NoNo
    }
}
