public class MethodsExample {
    public static void main(String[] args) {

        // 함수(메서드)
        // 어떠한 값이 넘겨지거나 아무값도 넘겨지지 않았을 때
        // 작업을 수행한 후
        // 반환 하거나 혹은 반환하지 않고 종료
        int mod_result = mod(3,2);
        System.out.println(mod_result);

        printNum(10);

        String str = greeting();
        System.out.println(str);

        greeting_2();


    }
    //1. 입력 있고 , 출력 있는 경우
    // 입력 0, 출력 0 으로 했을 경우
    // int 뒤 메소드 이름 정의
    //int 로 값을 반환 받겠다 안에 매개변수 파라미터를 정읠 해준다.
    static int mod (int a, int b) {
        int result = a % b;
        return result; // int 와 result 타입이 같아야 반환
    }
    //2.입력 0 , 출력 (반환) X
    //출력이 없다는거는 어떤한 데이터 타입 형태로도 반환하지 않겟다는 void를 사용한다
    static void printNum (int a) {
        System.out.println(a); // void
    }
    //3.입력 x , 출력0
    static String greeting() {
        return "Hello";// 컴퓨터 다시 사용할 수 있게 리턴으로 반환해준다.
    }
    //4. 입력 X 출력 X
    static void greeting_2() {
        System.out.println("Hello"); //다시 반환하지 않고 휘발된다.
    }
} // 함수를 main 안에서 실행하기 위해 각 함수 앞에 static을 붙힌다.
