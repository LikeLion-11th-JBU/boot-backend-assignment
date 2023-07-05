import java.awt.*;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[ ] args) {
            //System.out.println("hello world!");

            //int num = 1;
           // double width = 12.34;
            //String content = "Programming";

         //   num = 10;

            //System.out.println(num);

         //   int productPrice = 5;
            //5-3

         //   double a = 1.23;
          //  float b = 9.45f;

            //System.out.println(a);
            //System.out.println(b);

          //  char char_1 = 'a';
            //char char_2 = 97;  //아스키코드값으로 문자열 출력
            //char char_3 = 43;
            //char char_4 = 0x61; //유니코드


            //System.out.println(char_1);
            //System.out.println(char_2);
           // System.out.println(char_3);

            //boolean bool_1 = true;
            //boolean bool_2 = false;
            //boolean bool_3 = (100 < 0);
            // boolean bool_4 = 1; boolean에는 1이나 0을 넣지 못함

            //System.out.print(bool_1);
            //System.out.print(bool_2);
            //System.out.print(bool_3);

        //String a = new String(original:"Hello!");

        //System.out.println(a);

        //String b = "Hello!";
        //String c = "Hello!";

        //if (a == b) {
        //    System.out.println("a == b");
        //}
        //if (b == c) {
        //    System.out.println("b == c");
        //}

        //final double PI = 3.14;
        //final double PI_value = 3.14;
        //System.out.println(PI);
        //PI = 3.141525245; 고정값(불변값)이기 때문에 재할당 불가능

        //int a = 128;
        //short b = (short) a; //강제 형변환(명시적 형변환)

        //byte c = (byte) a; //결과값이 -128 => 오버플로우
        //실제로 형변환을 할때 오버플로우 발생하지 않는지 확인 및 주의
        //short x = 10;
        //int y = x;

        //int m = 80;
        //double n = m;

        //double q = 10.31231214235253453454234;
        //float w = (float) q;

        //int e = 10;
        //short f = 20;

        //short g = (short)  (e + f); //형변환을 할때는 전체로 묶기

        //System.out.println(x);
        //System.out.println(y);

        //System.out.println(a);
        //System.out.println(b);
        //System.out.println(c);

        //System.out.println(m);
        //System.out.println(n); //실수형으로 출력 (리터럴)

        //System.out.println(q);
        //System.out.println(w); //자리가 너무 길면 float 크기에 맞춰 자르기

        //System.out.println(g);
        

        //String str = "안녕하세요!"; //문자열 리터럴
        //String str_2 = new String(original:"안녕하세요!"); //생성자
        //String str_3 = "안녕하세요!";

        //System.out.println(str);
        //System.out.println(str_2);

        Scanner sc = new Scanner(System.in);

        System.out.print("아이디를 입력해주세요. >> ");
        String username = sc.nextLine();

        System.out.print("생년월일을 입력해주세요. >> ");
        int birthDate = sc.nextInt();

        System.out.printf("%s\n%d", username, birthDate);




    }
}
