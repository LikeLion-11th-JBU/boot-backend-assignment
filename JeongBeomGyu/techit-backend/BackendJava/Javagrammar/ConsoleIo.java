import java.util.Scanner;

public class ConsoleIo {

    public static void main(String[] args) {

        //사용자로부터 데이터를 입력받기 위해서 scanner 객체가 필요함. new연산자를 통해서 객체를 만들어줌
        Scanner sc =  new Scanner(System.in);  //System.in은 사용자의 디바이스의 입력창지를 연결하는것 ex)키보드
        System.out.println("아이디를 입력해주세요. >>");  //print 뒤에 ln을 붙이면 자동으로 개행이 이뤄진다. 그렇기 때문에 바로 옆에 입력 창을 만들고 싶으면 in을 때면 된다.

        //사용자의 입력값을 받는 변수를 만들어준다
        String username = sc.nextLine();   //nextLine을 쓰면 사용자로 부터 받은 데이터를 문자형형태로 username에 받을 수 있다.

        System.out.println("생년월일을 입력해주세요. >>");
        int birthDate = sc.nextInt();  //사용자로부터 입력받은 값을 int형 자료형으로 birthDate라는 변수에 받을 수 있다.


        System.out.printf("%s%d",username,birthDate); // 입력받은 값을 출력하기 위해서는 printf에다가 String 형태의 데이터는 %s, int 형태의 데이터는 %d를 사용한다.
                                                        //%s\n%d를 하면 입력받은 이름과 생년월일을 개행으로 출력된다.
        System.out.printf("%s\n%d", username, birthDate); // %s\t%d를 하면 출력 간격이 tab간격으로 나타난다.



    }
}
