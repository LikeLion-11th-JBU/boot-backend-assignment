import java.util.Scanner;

public class LittleTest {
    public static void main(String[] args) {

        // 간단하게 값을 입력받고 출력하는거 연습
    /*
        Scanner input = new Scanner(System.in); // 시스템으로부터 입력받음. 이후 값을 입력받을 때 input.nextLine() 사용.
        System.out.print("아무거나 써보자 : "); // 안내메시지
        String Trash = input.nextLine(); // 생성한 스캐너에 입력받은 문자열 Trash 에 대입?
        System.out.println(Trash);
    */


        // 파이썬에서 했던 예제들 변환해서 해보기
        // 1. 직접 구구단 입력해서 출력하기. (while , for 사용)

/*

        System.out.println("===========================");
        System.out.println("구구단 검색기를 시작합니다!");
        System.out.println("[ 0을 눌러 종료 ]");
        System.out.println("===========================");
        System.out.println("몇 단을 검색할까요? ");


        Scanner Num = new Scanner(System.in);
        int Gugu = 1;

        while (true) {

            Gugu = Num.nextInt(); // 입력값을 숫자로 제한
            if (Gugu == 0) {
                break;
            }

            System.out.println(Gugu + "단을 검색합니다!");
            for  (int i = 0; i < 10; i++) {
                int result = Gugu * i;
                System.out.println(Gugu + "x" + i + "=" + result);
            }
            System.out.println("===========================");
            System.out.println("몇 단을 검색할까요? : ");

        }

        System.out.println("===========================");
        System.out.println("구구단을 종료합니다.");
        System.out.println("===========================");
*/



    }
}
