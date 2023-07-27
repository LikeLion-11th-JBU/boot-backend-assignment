public class TypeCasting {
    public static void main(String[] args) {

        // 형변환
        //byte < short < int <long <<< float < double

        int a = 128;
        // short b = a; a의 자료형이 int로 b의 자료형보다 크기 때문에 오류가 발생한다.
        short b =(short)a; //큰 자료형을 작은 자료형에 넣으려면 명시적형변환을 통해서 short로 바꿔준다.
        short x =10;
        int y = x; // x의 자료형이 short로 y의 자료형 int보다 작기 때문에 대입이 가능하다. 큰 범위에다가 작은 범위를 넣으려고하면 자동적으로 형변환이 일어남
        byte c = (byte)a; //-1이 나오는 이유는 오버플로우가 발생했기 때문이다.


        int m = 80;
        double n = m;
        System.out.println(m);
        System.out.println(n); //n은 실수형 80.0으로 출력이 되는데, 이는 80이 n에 대입되기 전에 double로 변형된 다음에 b에 들어가기 때문이다.

        double d =10.3312341212313;
        float e = (float)d;
        System.out.println(d);
        System.out.println(e); // 강제로 형변환을 했으므로 소수점 7자리 이후에는 데이터가 잘린다.

        int f = 10;
        short g = 20;
        //short h = e + f; e가 int 자료형이기 때문에 (short) 명시적 형변환을 시켜줘야한다.
        short h = (short) (f+g);
        System.out.println(h);

    }
}
