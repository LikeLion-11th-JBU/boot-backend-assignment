public class TypeCasting {
    public static void main(String[] args) {
//        형병환
//        byte < short < int < long <<< float << double

//        강제 형 변환 (명시적 형 변환 )
//        int a = 128;
//        short b = (short)a;
//        byte c = (byte)a; //-128 ~127 오버플로우로 처음으로 돌아가 출력
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);
//
//        자동형변환
//
//        short x = 10;
//        int y = x;
//        System.out.println(x);
//        System.out.println(y);

//        int m = 80;
//        double n = m;
//
//        System.out.println(m);
//        System.out.println(n);
//
//        double c = 10.32131231234;
//        float d = (float)c;
//
//        System.out.println(c);
//        System.out.println(d);

   ////     int n = 70;
       //// double m = n;
        //// System.out.println(n,%d);

        int e = 10;
        short f = 20;

        short g = (short) (e + f);

        System.out.println(g);



    }

}
