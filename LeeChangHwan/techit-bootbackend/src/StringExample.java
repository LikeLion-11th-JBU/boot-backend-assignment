public class StringExample {

    public static void main(String[] args) {

        // String => 문자열 객체 (주소비교)
        // 객체 => 힙 메모리 영역
        // 변수 => 힙 메모리 영역의 주소
        /*
        String str = "안녕하세요!"; // 문자열 리터럴
                                    // String은 " " 큰따옴표로 감싸주어야함.
        String str_2 = new String("안녕하세요!"); // 생성자
                                                          // 객체에서 new 연산자를 사용하게 되면, 무조건
                                                          // 힙 메모리에 위치 시킴.
        String str_3 = "안녕하세요!"; // 처음에 생성한 것을 그대로 주소만 가져와서 사용함.
        */
        /*
        if (str == str_2){
            System.out.println("str == str_2");
        }
        if (str == str_3){
            System.out.println("str == str_3");
        }
        if (str_2 == str_3){
            System.out.println("str_2 == str_3");  // 같지 않음.
        }
        */

        // 위에서 한 주소와 상관없이 문자열간에서 내용을 비교하는 방법을 확인

        /*
        if (str.equals(str_2));{                        // str이라는 문자열 객체와 어떤 대상과
            System.out.println("str.equals(str_2)");    // 내용이 같은지 T/F로 판단해줌
        }
        if (str.equals(str_3));{
            System.out.println("str.equals(str_3)");
        }
        if (str_2.equals(str_3));{
            System.out.println("str_2.equals(str_3)");
        }
        */
        // 문자열을 병합(합치는 방법)

            // 1. '+' 연산자
            /*
            String str_1 = "Hello, ";
            String str_2 = "World!";

            System.out.println(str_1 + str_2);  // 혹은 Hello, 쉼표뒤에 공백을 넣던가,
                                                // str_1 + " " + str_2 연산자에 " " 공백을 넣기!

            // 2. StringBuilder
            StringBuilder strBdr_1 = new StringBuilder("Hello, "); // 이렇게해서 ,뒤에 공백 넣던가,
            // strBdr_1.append(" "); 사용해서 공백 넣어주면 띄어쓰기 생김.
            strBdr_1.append("World!");

            String str_new = strBdr_1.toString();
            System.out.println(strBdr_1.toString());
            */

        //문자열 슬라이스 (어떤 규칙을 가지고 배열을 가지고 있는지 알아야함.)
            /*
            String str_1 = "이름 : 이창환";
            // System.out.println(str_1.indexOf("이")); // >> 결과값 : 0
            // System.out.println(str_1.indexOf("름")); // >> 결과값 : 1

            String str_name = str_1.substring(5,8); // 5는 시작INDEX '이'를 뜻하고,
                                                    // 8은 마지막INDEX를 포함하지 않고 바로 전 INDEX인 "환"을 뜻함.
            System.out.println(str_name);           // >>> 결과값 : '이창환'
            */
        //문자열 대소문자 변환
            /*
            String str_1 = "abc";
            String str_2 = "ABC";

            str_1 = str_1.toUpperCase();    // 대문자
            str_2 = str_2.toLowerCase();    // 소문자

            System.out.println(str_1);
            System.out.println(str_2);
            */

        // 대소문자 비교 무시하고 하는 케이스

            String str_1 = "abc";
            String str_2 = "ABC";

            if (str_1.equals(str_2)){
                System.out.println("str_1.equals(str_2)");
            }

            if (str_1.equalsIgnoreCase(str_2)){
            System.out.println("str_1.equalsIgnoreCase(str_2)");
            }

        //공백 제거

            //1. 양쪽 끝 공백
            /*
            String str_1 = "    Hello   ";
            str_1 = str_1.trim();           // .trim()만 적어주면 된다.
            System.out.println(str_1);
            */
            /*
            //2. 문자열 중간 공백
            String str_2 = "    Hel lo   ";
            str_2 = str_2.trim();           // 이렇게만 적으면 Hel lo로 출력됨.
            str_2 = str_2.replace(" ", "");   // replace는 어떤문자로 치환하겠다는 뜻.
            System.out.println(str_2);
            */
    }
}
