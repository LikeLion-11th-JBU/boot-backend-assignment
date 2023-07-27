import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class publicclass {
    public static void main(String[] args) {
        System.out.println("===========");
        System.out.println("회원등록");
        System.out.println("===========");
        boolean register = false;
        Scanner SC = new Scanner(System.in);

        while (!register){
            System.out.println("회원가입을 하시겠습니까?\ny:진행 n:취소");
            System.out.print(">> ");
            String register_input = SC.nextLine();
            if (register_input.equalsIgnoreCase("y")){
                register = true;
                System.out.println("============");
                System.out.println("회원가입을 진행합니다.");
                System.out.println("============");
            }
            else if (register_input.equalsIgnoreCase("n")){
                System.out.println("============");
                System.out.println("회원가입이 종료됩니다.");
                System.out.println("============");
                System.exit(0);
            }
            else{
                System.out.println("입력값을 확인해주세요.");
            }
        }
        //회원정보를 실제로 담을 자료구조, 가입되는 회원이 저장될 arraylist를 만들기
        ArrayList users = new ArrayList();
        //나중에 회원가입을 추가로 하겠는지 물어보기 위해서
        while (true){
            //유저를 해쉬맵으로 변수로 선언 /항목별로 저장하기 위해서
            HashMap user = new HashMap();

            //id 변수로 username을 사용
            System.out.print("ID: ");
            //사용자들이 입력한 아이디 값을 받는다. next.line함수를 통해서 사용자들이 입력한 값을 받아온다.
            String username = SC.nextLine();

            //password 2번 입력하게 만들어야함. password를 변수로 잡고, 빈 값으로 초기화한다. 정해지지 않은 값에는 빈값으로 초기화
            String password = " ";
            // 두 값을 비교하도록 만든다.
            while (true) {
                System.out.println("PW: ");
                password =SC.nextLine(); //입력값을 password 변수에 저장
                System.out.println( "PW: 확인"); //password확인
                String password_confirm = SC.nextLine();
                //두 값을 비교
                if (password.equals(password_confirm)){
                    break;
                }else{
                    System.out.println("=============");
                    System.out.println("패스워드가 일치하지 않습니다..");
                    System.out.println("패스워드를 다시 입력해주세요");
                    System.out.println("=============");
                }
            }
            //이름
            System.out.print("이름: ");
            String name = SC.nextLine();

            //생년월일(6자리)
            //6자리가 아닌 경우 다시 생년월일을 입력하도록 한다. while 사용
            //바깥에서 참조해야하는 데이터이기 때문에 외부에서 변수를 선언해야 한다.
            String birth_date = " ";  //빈값으로 초기화
            while(true){
                System.out.print("생년월일(6자리): ");
                birth_date = SC.nextLine();  //사용자가 입력한 값을 변수에 저장한다.
                if(birth_date.length() == 6){
                    break;
                }else{        //일치하지 않을 경우
                    System.out.println("=============");
                    System.out.println("생년월일 자릿수가 올바르지 않습니다..");
                    System.out.println("생년월일을 다시 입력해주세요");
                    System.out.println("=============");
                }
            }
            //이메일
            System.out.print("이메일: ");
            String email = SC.nextLine();
            //이렇게 사용자의 입력값을 전부 변수에 저장했고 이 저장된 변수값은 하나의 해쉬맵의 키 값 상으로 저장해서 구상하도록 해야한다.
            //user라는 해시맵에 각각의 키 값 쌍으로 구상한다음에 추가해 줘야한다.
            user.put("username",username);
            user.put("password",password);
            user.put("name",name);
            user.put("birth_date",birth_date);
            user.put("email",email);

            //모든 회원이 array값으로 저장되는 users에 우리가 만든 user라는 해쉬맵을 추가해준다.
            users.add(user);

            //사용자가 가입이 됐는지 판별하기위한 안내 메시지
            System.out.println("--------------");
            System.out.println(user.get("name")+" 님, 가입을 환영합니다");//user라는 해쉬맵에 name이라는 키를 가지고 가입한 사람의 이름을 가져온다.
            System.out.println("ID는 " + user.get("username") + " 입니다." );
            System.out.println("--------------");

            System.out.println("회원가입을 이어서 진행 하시겠습니까?\ny:진행 n:취소");
            System.out.print(">> ");
            String register_again = SC.nextLine();
            if ( register_again.equalsIgnoreCase("y")){
                ; // y를 가리키면 아무런 로직을 하지 않는다.
            }else if (register_again.equalsIgnoreCase("n")){
                System.exit(0);
            }

        }
    }
}
