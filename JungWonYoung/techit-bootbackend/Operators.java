public class Operators {

    public static void main(String[] args) {
        
        int a = 10;
        int b = 20;
        String c = "abc";

        System.out.println("=================");
        System.out.println(a + c);  

        double d = 10;
        double e = 20;

        System.out.println("=================");
        System.out.println(d / e);    
        System.out.println(a + b);
        System.out.println(a - b);
        System.out.println(a * b);
        System.out.println(a / b);
        System.out.println(a % b);   
        System.out.println("=================");

        int f = 5;
        int g = 8;

        System.out.println("=================");
        System.out.println(f > g);
        System.out.println(f < g);   
        System.out.println(f >= g); 
        System.out.println(f <= g); 
        System.out.println( f == g);
        System.out.println( a != b); 
        System.out.println("=================");

        int h = 3;
        int i = 3;
        int j = 5;

        System.out.println("=================");
        System.out.println( j > h && j >i);  
        System.out.println(j > h || j < i);  
        System.out.println(!true); 
        System.out.println(!false);
        System.out.println("=================");

        int k = 1;
        double l = 12.5;

        System.out.println("=================");
        System.out.println(k++);
        System.out.println(k);   
        System.out.println(++l);
        System.out.println("=================");
    }
}
