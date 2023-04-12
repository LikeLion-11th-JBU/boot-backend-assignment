import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class UserRegister {

    public static void main(String[] args) {

        System.out.println("================");
        System.out.println("회원등록");
        System.out.println("================");

        boolean register = false;

        Scanner sc = new Scanner(System.in); // 외부의 입력장치로부터 사용자의 입력을 받겠다는 의미

        while (!register) {

            System.out.println("회원가입을 하시겠습니까? \nY: 진행     N: 취소");
            System.out.print(">> ");

            String register_input = sc.nextLine(); // 사용자들의 입력을 대기함 -> 엔터를 누르면 register_input에 할당됨

            if (register_input.equalsIgnoreCase("y")) {
                register = true;
                System.out.println("================");
                System.out.println("회원가입이 진행됩니다.");
                System.out.println("================");
            } else if (register_input.equalsIgnoreCase("n")) {
                System.out.println("================");
                System.out.println("회원가입을 취소합니다.");
                System.out.println("================");
                System.exit(0);
            }
            else {
                System.out.println("입력 값을 확인해주세요.");
            }
        }

        ArrayList users = new ArrayList(); // 크기 지정 안함

        while (true) {

            HashMap user = new HashMap();

            // ID
            System.out.print("ID : ");
            String username = sc.nextLine();

            // PW
            String password = ""; // 빈 값으로 초기화함
            while (true) {
                System.out.print("PW : ");
                password = sc.nextLine();
                System.out.print("PW 확인 : ");
                String password_confirm = sc.nextLine();

                if (password.equals(password_confirm)) { // 두 문자열의 값이 같은지 확인
                    break;
                } else {
                    System.out.println("================");
                    System.out.println("패스워드가 일치하지 않습니다.");
                    System.out.println("패스워드를 다시 입력해주세요.");
                    System.out.println("================");
                }
            }

            // 이름
            System.out.print("성명 : ");
            String name = sc.nextLine();

            // 생년월일 (6자리로 입력받도록)
            String birth_date = "";
            while (true) {
                System.out.print("생년월일 (6자리) : ");
                birth_date = sc.nextLine();
                if (birth_date.length() == 6) {
                    break;
                } else {
                    System.out.println("==================");
                    System.out.println("생년월일 자릿수가 올바르지 않습니다.");
                    System.out.println("생년월일을 다시 입력해주세요.");
                    System.out.println("==================");
                }
            }

            // 이메일
            System.out.print("이메일 : ");
            String email = sc.nextLine();


            user.put("username", username); // key의 이름과 그 값을 매핑시켜서 user 안에 추가
            user.put("password", password   );
            user.put("name", name);
            user.put("birth_date", birth_date);
            user.put("email", email);

            users.add(user);

            System.out.println("-----------------------------");
            System.out.println(user.get("name") + "님, 가입을 환영합니다.");
            System.out.println("ID는" + user.get("username") + "입니다.");
            System.out.println("-----------------------------");

            System.out.println("회원가입 이어서 진행하시겠습니까? \nY: 진행     N: 취소");
            System.out.print(">> ");
            String register_again = sc.nextLine();

            if (register_again.equalsIgnoreCase("y")) {
                ;
            } else if (register_again.equalsIgnoreCase("n")) {
                System.exit(0);
            }


        }


    }
}
