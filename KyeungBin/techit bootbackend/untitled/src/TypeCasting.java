public class TypeCasting {

    public static void main(String[] args) {

        // 형변환
        // byte < short < int < long , float < double

        // 강제 형변환

        /*
        int a = 128;
        short b = (short) a;
        byte c = (byte) a; // -128 ~ 127 (오버플로우 현상)
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        */

         //short x = 10;
         //int y = x;

        //int m = 80;
        //double n = m;

        //System.out.println(m);
        //System.out.println(n);

        //double c = 10.312345678987654321;
        //float d = (float) c;

        //System.out.println(c);
        //System.out.println(d);

        int e = 10;
        short f = 20;

        short g = (short) (e + f);

        System.out.println(e);
        System.out.println(f);
        System.out.println(g);


    }
}
