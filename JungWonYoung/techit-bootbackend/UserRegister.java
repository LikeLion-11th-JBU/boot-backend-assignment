import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class UserRegister {
    public static void main(String[] args) {
        System.out.println("===================");
        System.out.println("회원등록");
        System.out.println("===================");

        boolean register = false;
        Scanner sc = new Scanner(System.in);

        while(!register){
            System.out.println("회원가입을 하시겠습니까?\ny : 진행\tn : 취소");
            System.out.print(">>");
            String register_input = sc.nextLine();

            if (register_input.equalsIgnoreCase("y")){
                register = true;
                System.out.println("===================");
                System.out.println("회원가입이 진행됩니다.");
                System.out.println("===================");
            }
            else if(register_input.equalsIgnoreCase("n")){
                System.out.println("===================");
                System.out.println("회원가입이 종료됩니다.");
                System.out.println("===================");
                System.exit(0);
            }
            else{
                System.out.println("입력값을 확인해주세요.");
            }
        }

        ArrayList users = new ArrayList();

        while (true){

            HashMap user = new HashMap();

            System.out.print("ID : ");
            String username =  sc.nextLine();

            System.out.println("PW : ");
            String password = "";
            password = sc.nextLine();

            while (true){

                System.out.println("PW 확인 : ");
                String password_con = sc.nextLine();

                if(password_con.equals(password)){
                    break;
                }
                else{
                    System.out.println("===================");
                    System.out.println("PW가 일치하지 않습니다.");
                    System.out.println("===================");
                }
            }

            System.out.println("성명 : ");
            String name = sc.nextLine();

            String birth_date = "";
            while(true){
                System.out.println("생년월일(YYMMDD) : ");
                birth_date = sc.nextLine();
                if(birth_date.length() == 6){
                    break;
                }
                else{
                    System.out.println("===================");
                    System.out.println("생년월일 자리수가 올바르지 않습니다.");
                    System.out.println("===================");
                }
            }

            System.out.println("이메일 : ");
            String email = sc.nextLine();

            user.put("username", username);
            user.put("password", password);
            user.put("name", name);
            user.put("birth_date", birth_date);
            user.put("email", email);

            users.add(user);

            System.out.println("===================");
            System.out.println(user.get("name") + "님, 가입을 환영합니다.");
            System.out.println("ID는 "+ user.get("username") + "입니다.");
            System.out.println("===================");


            boolean register_again = false;
            while(!register_again){
                System.out.println("회원가입을 이어서 하시겠습니까?\ny : 진행\tn : 취소");
                System.out.print(">>");
                String register_input = sc.nextLine();

                if (register_input.equalsIgnoreCase("y")){
                    register_again = true;
                    System.out.println("===================");
                    System.out.println("회원가입이 진행됩니다.");
                    System.out.println("===================");
                }
                else if(register_input.equalsIgnoreCase("n")){
                    System.out.println("===================");
                    System.out.println("회원가입이 종료됩니다.");
                    System.out.println("===================");
                    System.exit(0);
                }
                else{
                    System.out.println("입력값을 확인해주세요.");
                }
            }
        }
    }
}
