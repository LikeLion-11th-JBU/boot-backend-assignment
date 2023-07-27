public class StringExample {

    public static void main(String[] args) {

        //String => 문자열 객체
        //객체 => 힙 메모리 영역에 저장
        //변수 => 힙 메모리 영역의 주소

        String str = "안녕하세요!"; //문자열 리터럴
        String str_2 = new String("안녕하세요!"); //new뒤에 객체의 종류와 파라미터에 어떤 데이터를 담을 것인지를 정한다.
                                                        //생성자
        String str_3 = "안녕하세요!";

        //객체의 주소비교

        if (str == str_2){
            System.out.println("str==str_2");
        }
        if(str == str_3){
            System.out.println("str ==str_3");
        }
        if(str_2 == str_3){
            System.out.println("str_2 == str_3");
        }




        //객체의 내용 비교, 값을 비교할 때는 등호가 아니라 equals 메소드를 통해서 비교를 해야한다.
        if (str.equals(str_2)) { //str이라고하는 문자열객체와 비교대상과 내용이 같은지 확인해주는 equals
            System.out.println("str.equals(str_2)");
        }
        if (str.equals(str_3)){
            System.out.println("str.equals(str_3)");
        }
        if(str_2.equals(str_3)){
            System.out.println("str_2.equals(str_3)");
        }

        //문자열 병합

        // 1. '+' 연산자
        String str_4 = "Hello,";
        String str_5 = "World!";
        System.out.println(str_4 + " " + str_2); // +는 힙메모리를 사용함. 임시 객체를 만듬

        // 2. StringBuilder
        StringBuilder strBdr_1 = new StringBuilder("Hello,"); //new연산자를 통해서 Hello를 넣어줘야함

        strBdr_1.append(" ");// 띄어쓰기를 추가하려면  " "을 쓰던지 World앞에 띄어쓰기를 붙인다.
        strBdr_1.append("World!"); // Builder에 문자를 붙일 때 사용 => 객체를 만들지 않음. 사용하던 Hello 메모리에 World를 붙인다.

        String str_new = strBdr_1.toString();
        System.out.println(str_new);  //String으로 바꾸기 위해서는 strBdr_1라는 객체가 들어있는 변수에다가 toString을 붙인다.

        //문자열 슬라이스
        String str_6 = "이름: 김자바"; //컴퓨터는 순서를 인덱스 순서를 붙여서 관리하고 있다.
        System.out.println(str_6.indexOf("이")); //이의 인덱스 값을 확인가능하다.
        System.out.println(str_6.indexOf("름")); //름의 인덱스 값을 확인가능하다.

        //substring()으로 문자를 자를 수 있다.
        String str_name = str_6.substring(4,7);   // 첫 인덱스 4는 4를 포함하고, 끝인덱스 7은 7문자를 포함하지 않는다.
        System.out.println(str_name);


        //문자열 대소문자 변환
        String str_7 = "abc";
        String str_8 = "ABC";

        str_7 = str_7.toUpperCase(); //소문자 abc를 대문자로 바꾸는 메소드 toUpperCase()
        str_8 = str_8.toLowerCase(); //대문자 ABC를 소문자로 바꾸는 메소드 toLowerCase()

        System.out.println(str_7);
        System.out.println(str_8);

        if(str_7.equals(str_8)){
            System.out.println("str_7.equals(str_8)");  //대소문자를 비교해서 내용을 비교한다.
        }

        if(str_7.equalsIgnoreCase(str_8)){
            System.out.println("str_7.equalsIgnoreCase(str_8)"); //대소문자를 고려하지않고 내용을 비교한다.
        }

        //공백 제거

        // 1. 양쪽 끝 공백
        String str_9 = "          Hello    ";
        str_9 = str_9.trim(); //양쪽 끝의 공백을 없애주는 trim()
        System.out.println(str_9);

        // 2. 문자열 중간 공백
        String str_10 = "   Hel    lo    ";
        str_10 = str_10.trim();
        str_10 = str_10.replace(" ","");   //어떤문자를 다른문자로 치환해주는 메소드
        System.out.println(str_10);


    }
}
