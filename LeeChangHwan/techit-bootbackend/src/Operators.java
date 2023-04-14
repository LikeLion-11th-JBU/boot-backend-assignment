import org.w3c.dom.ls.LSOutput;

public class Operators {

    public static void main(String[] args) {

        // 산술연산자 ( + , -, *, /, %,...)
        /*
        int a = 10;
        int b = 20;
        String c = "abc";

        double d = 10;
        double e = 20;

        System.out.println(a + b);
        System.out.println(a - b);
        System.out.println(a * b);
        System.out.println(a / b);      // 몫을 반환하는 나누기 연산자
        System.out.println(a % b);      // 나머지를 반환하는 % 연산자

        // 그러면 소수 계산은 안되는걸까? double 사용해볼게!

        System.out.println(d / e);
        System.out.println(d % e);

        //int 형과 string 형을 더해보자!
        System.out.println(a + c);      // 10은 문자열로 타입이 바뀌고, 문자열과 병합이 된다.
                                        // 즉, 전부다 String으로 바뀜.
        */
        //비교 연산자
        /*
        int a = 5;
        int b = 8;

        System.out.println(a > b);
        System.out.println(a < b);
        System.out.println(a >= b);
        System.out.println(a <= b);
        System.out.println(a == b);     // == 2개면 비교연산자
        System.out.println(a = b);      // =  1개면 대입연산자
        System.out.println(a != b);     // !는 프로그래밍에서 not의 의미를 가짐
        */

        // 논리 연산자
        /*
        int a = 3;
        int b = 3;
        int c = 5;

            //1. AND(&&) : 교집합
            System.out.println(c > a && c > b); // 결과값 : true && true 이므로 >>> true
            System.out.println(c > a && c < b); // 결과값 : true && false 이므로 >>> false
                                                // 즉, 모든 피연산자들이 true 여야만 ture이다.

            //2. OR(||) :  합집합
            System.out.println(c > a && c < b); // 결과값 : true || false 이므로 >>> true
                                                // 즉, ||연산자는 하나라도 true이면 true를 반환한다.
            // >>> 여러 조건 중 모두 만족 AND, 하나만 만족 OR 사용

            //3. NOT(!) : 여집합
            System.out.println(!true);          // 결과값 : false
            System.out.println(!false);         // 결과값 : true
        */

        // 대입 연산자
        /*
        int a = 1;
        double price = 12.5;
        */
        // 증감 연산자

        int a = 1;
        // a++;    >> a = a + 1
        //System.out.println(a++); // 결과값 : 1
        //System.out.println(a);   // 결과값 : 2
        // a--;    >> a = a - 1

        // ++a;    >>
        System.out.println(++a); // 결과값 : 2  (*증감연산을 먼저 하고 DATA값을 반환해줌.)
        System.out.println(a);   // 결과값 : 2
        // --a;    >>

    }
}
