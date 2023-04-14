public class MethodsExample {

    public static void main(String[] args) {

        //1.  int mod_result = mod(3, 2);         // static 메모리를 사용하고자 하는 함수에 넣어줘야함.
        //    System.out.println(mod_result);

        //2.  printNum(10);

        //3.  String str = greeting();
        //    System.out.println(str);

        //4.  greeting_2();


    }
        // 함수(메소드)
        // 어떠한 값이 넘겨지거나 아무값도 넘겨지지 않았을때,
        // 작업을 수행한 후 반환하거나 반환하지 않고 종료.

            //1. 입력 O, 출력O
            static int mod (int a, int b) {
                int result = a % b;
                return result;           // int에 들어가는 값과 result 값이 같아야 출력이 된다.
            }

            // 2. 입력 O, 출력(반환)X
            static void printNum (int a) {
                System.out.println(a);  // a가 같아도 다른 함수에서 쓰이면 각각 별개이다.
            }

            // 3. 입력 X, 출력 O
            static String greeting() {
                return "Hello!";
            }

            // 4. 입력 X, 출력 X
            static void greeting_2(){
                System.out.println("Hello!");
            }
}
