import java.util.Scanner;

public class ConSoleI0 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);                // 어떤 DATA를 입력받기위해선 Scanner 객체가 필요함.
        System.out.println("아이디를 입력하시오. >>> ");    // 사용자의 디바이스 입력장치를 연결하기 위함 Ex) 키보드
        String username = sc.nextLine();    // 문자열 DATA기에 String 사용.
                                            // nextLine 사용 시 사용자로부터 입력값으로 받아서 문자형태로 받을 수 있음.
        System.out.println("생년월일을 입력하시오. >>>");
        int birthDate = sc.nextInt();       // 정수값 DATA기에 Int 사용.

        // System.out.println(); or System.out.print(); 차이는? >>> "행 변환"

        System.out.printf("%s\n%d", username, birthDate);    // println과 다르게 printf 시 포맷설정해주는것.
                                                             // '\n' : 행변환, '\t' : Tab만큼 간견설정
    }
}
