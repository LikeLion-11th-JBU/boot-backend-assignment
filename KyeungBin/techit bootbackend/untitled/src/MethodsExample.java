public class MethodsExample {

    public static void main(String[] args) {

        // 함수(메서드)
        // 어떠한 값이 넘겨지거나, 아무것도 넘겨지지 않았을 때
        // (1) 작업을 수행한 후 반환하거나  (2) 반환하지 않고 종료.

        // 1번 함수
        int mod_result = mod(3, 2);
        System.out.println(mod_result);
        // 2번 함수
        printNum(10);
        // 3번 함수
        String str = greeting();
        System.out.println(str);
        // 4번 함수
        greeting_2();

    }

    // 1. 입력 0, 출력(반환) 0
    static int mod (int a, int b) {
        int result = a % b;
        return result;
    }

    // 2. 입력 1, 출력(반환) 0

    static void printNum (int a) {
        System.out.println(a);
    }

    // 3. 입력 x, 출력 o

    static String greeting() {
        return "Hello!"; // 다시 사용할 수 있게 컴퓨터에 반환
    }

    // 4. 입력 x, 출력 x

    static void greeting_2() {
        System.out.println("Hello!"); // 출력만해주고 사라지는 휘발성 데이터
    }



}
