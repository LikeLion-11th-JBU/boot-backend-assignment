public class TypeCasting {
             // 형변환
    public static void main(String[] args) {

        // 형변환
        // 용량순서대로 : byte < short < int < long <<< float < double

        //강제 형변환
        /*int a = 128;
        short b = (short) a;    //short 타입을 원하는데 int 타입을 받아서 error를 발생시킴.
                                // 즉 int로 선언된것을 더 좁은 공간에 넣으려고 하닌까 error를 발생시킨다는 것이다.
                                // 좁은 공간으로 넣으려하면 JAVA에서 자동 형 변환이 일어남.
                                // (short) 바꾸려는 대상 타입을 임의로 설정해줘야함.
                                // >>> 그러면 a = 128 , b = 128로 출력된다. (숫자로)
        byte c = (byte) a;      // -128 ~ 127 이 범위인데 127보다 1이큰 128이 아닌
                                // 한바퀴 빙 되돌아서 -127이 나오는 것이다 => overflow(오버플로우)

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);  // byte 값에서 -(마이너스) 값이 나옴.  */


        //자동 형변환
        /*short x = 10;
        int y = x;

        System.out.println(x);
        System.out.println(y);  */

        /*int m = 80;             // 정수값
        double n = m;           // m에 있는 정수형값이 실제 n에 대입되기전에 double로 캐스팅(형변환)이 되면서
                                //그 데이터가 n에대가 할당이 되기에 실제로 n이 대입되기전에
                                // 80.0이라는 필수형 데이터를 가지게 되는것이다.


        System.out.println(m);
        System.out.println(n);  */

       /* double c = 10.35432456543245;
        float d =(float) c;     // float d = c; 로 하면 error 뜸 <앞에서 한 소화할 수 있는 크기차이>

        System.out.println(c);
        System.out.println(d);  */

        // 강제로 형변환을 할 때는 내가 실제로 예상했던 DATA에서 왜곡이 되지 않는지 확인!

        // 계산할 때 형변환이 일어나는 과정 알아보기
        int e = 10;
        int f = 20;

        short g = (short) (e + f); // ()괄호없이 e + f 만 치면 f는 상관없이 e만 본다.
        System.out.println(g);

    }
}
