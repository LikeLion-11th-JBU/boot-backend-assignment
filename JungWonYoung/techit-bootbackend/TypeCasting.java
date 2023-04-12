public class TypeCasting {
    public static void main(String[] args) {


        int a = 128;
        short b =(short)a; 
        short x =10;
        int y = x; 
        byte c = (byte)a; 

        int m = 80;
        double n = m;
        System.out.println(m);
        System.out.println(n);

        double d =10.3312341212313;
        float e = (float)d;
        System.out.println(d);
        System.out.println(e);

        int f = 10;
        short g = 20;
        short h = (short) (f+g);
        System.out.println(h);

    }
}
