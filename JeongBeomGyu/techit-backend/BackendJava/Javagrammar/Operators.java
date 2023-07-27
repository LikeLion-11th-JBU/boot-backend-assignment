public class Operators {

    public static void main(String[] args) {

        //산술 연산자

        int a = 10;
        int b = 20;
        String c = "abc";

        System.out.println(a + c);  // +연산자를 가지고 문자형 연산자가 아닌 10을 문자열로 바꾼다음 합해진다. 즉 10도 Spring으로 여겨진다.

        double d = 10;
        double e = 20;

        System.out.println(d / e);    //자료형이 실수일때 분수형 결과값이 나온다.

        System.out.println(a + b);
        System.out.println(a - b);
        System.out.println(a * b);
        System.out.println(a / b);   //몫을 반환하는 나누기 연산
        System.out.println(a % b);   //나머지 연산

        //비교연산자

        int f = 5;
        int g = 8;

        // 비교연산자릴 사용하기 위해서는 부등호를 사용하면 된다.

        System.out.println(f > g);   // false라는 boolean 값을 출력한다.
        System.out.println(f < g);   // true라는 boolean 값을 출력한다.

        System.out.println(f >= g);  // 크거나 같다.
        System.out.println(f <= g);  // 작거나 같다.

        // = 대입연산자,  == 비교연산자
        System.out.println( f == g);
        System.out.println( a != b);  // a와 b는 다르다. !는 부정을 의미한다.

        //참조형데이터는 등호로 비교할 수 없다. equals라는 메소드로 비교할 수 있다.

        //논리 연산자
        int h = 3;
        int i = 3;
        int j = 5;


        //AND(&&) - 교집합
        System.out.println( j > h && j >i);   //true&&true 두 조건(모든 피연산자들)이 모두 true여야지 true이다.

        //OR(||) - 합집합
        System.out.println(j > h || j < i);   //두 피연산자중 하나만 true여도 true이다.

        //NOT(!) - 여집합
        System.out.println(!true);  //true라는 값에 반대되는 값을 반환한다. 결국 false를 반환한다.
        System.out.println(!false);

        //대입 연산자

        int k = 1;
        double l = 12.5;

        // 증감 연산자
        System.out.println(k++);  //k를 출력한다음 k에 1을 더한다.
        System.out.println(k);    // k+1을 축력한다.
        System.out.println(++l);  //l에 +1을 한다음 출력이 된다.



    }
}
