import java.util.Scanner;

public class ConsoleI0 {
    public static void main(String[] args) {
//      print 뒤에 ln 하면 출력값 대행이 이루어짐
//      싫다면 ln을 지워야함
        Scanner sc = new Scanner(System.in);//scanner 사용자에게 입력 받겠다 in 입력 장치를 의미하는 인자
        System.out.print("아이디를 입력하시오...");
        String username = sc.nextLine();//String으로 받을 거라서 Line

        System.out.print("생년월일을 입력하시오...");
        int birthDate = sc.nextInt();//정수로 받기위해 Int

        System.out.printf("%s\n%d",username,birthDate);// \n빼면 일열


    }
}
