import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class UserRegister {

    public static void main(String[] args) {

        System.out.println("========");
        System.out.println("회원등록");
        System.out.println("========");

        boolean register = false;
        Scanner sc = new Scanner(System.in);

        while (!register) {
            System.out.println("회원가입을 하시겠습니까? \nY : 진행  N : 취소");
            System.out.print(">>>");

            String register_input = sc.nextLine();  // nextLine을 쓰면 데이터를  대기 후 입력받고,
                                                    // register_input 에 할당 후 다음 로직으로 넘어감.

            // 넘어갈지, 대기할지 정해야함.
            if(register_input.equalsIgnoreCase("Y")){
                register = true;
                System.out.println("=====================");
                System.out.println("회원가입이 진행됩니다.");
                System.out.println("=====================");
            } else if (register_input.equalsIgnoreCase("N")){
                System.out.println("=====================");
                System.out.println("회원가입이 종료됩니다.");
                System.out.println("=====================");
                System.exit(0);
            } else {
                System.out.println("입력 값을 다시 확인해주세요.");
            }

        }

        // 회원가입된 자료가 쌓이게 됨
        ArrayList users = new ArrayList();
        //회원가입을 다시 한 번 더 진행하겠냐고 물어볼려고
        while (true){

            HashMap user = new HashMap();

            //ID
            System.out.print("ID : ");
            String username = sc.nextLine();

            //PW
            String password = "";   // 빈칸으로 초기화시켜준 것.
            while (true) {          // 입력받은 암호와 다시 입력하는 암호를 비교하도록 하는 것.
                System.out.print("PW : ");
                password = sc.nextLine();
                System.out.print("PW 확인 : ");
                String password_confirm = sc.nextLine();

                    if(password.equals(password_confirm)){
                        break;
                    } else {
                        System.out.println("======================");
                        System.out.println("PW가 일치하지 않습니다.");
                        System.out.println("PW를 다시 입력해주세요.");
                        System.out.println("======================");
                    }
            }

            // 이름
            System.out.println("NAME : ");
            String name = sc.nextLine();

            //생년월일(6자리)
            // 6자리가 아니면 다시 처음부터 적게 만듬.
            String birth_date = ""; // 당장 사용안해도 빈값으로 초기화시키는게 좋음.
            while(true){
                System.out.println("BIRTH(6자리) : ");
                birth_date = sc.nextLine();
                    if(birth_date.length() == 6){
                        break;
                    } else {
                        System.out.println("============================");
                        System.out.println("생년월일을 다시 입력해주세요.");
                        System.out.println("생년월일 Ex) 990219");
                        System.out.println("============================");
                    }
            }

            // E-MAIL
            System.out.println("E-MAIL : ");
            String email = sc.nextLine();

            //회원가입한 회원의 장부를 작성하는 것.
            user.put("username", username);
            user.put("password", password);
            user.put("name", name);
            user.put("birth_date", birth_date);
            user.put("email", email);

            users.add(user);

            // 가입여부 판별
            System.out.println("=======================================");
            System.out.println(user.get("name")+"님, 가입을 환영합니다.");
            System.out.println("ID는 "+user.get("username")+" 입니다.");
            System.out.println("=======================================");

            // 다른사람이 가입을 하려하는지 (회원가입을 또 진행할려는지) 묻기
            System.out.println("회원가입을 이어서 진행하시겠습니까? \nY : 진행  N : 취소");
            System.out.print(">>>");

            String register_again = sc.nextLine();

            if (register_again.equalsIgnoreCase("Y")) {
                ;
            } else if (register_again.equalsIgnoreCase("N")){
                System.exit(0);
            }
        }
    }
}
