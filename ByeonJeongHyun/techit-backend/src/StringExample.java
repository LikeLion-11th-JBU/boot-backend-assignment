public class StringExample {
    public static void main(String[] args) {

        // String => 문자열 객체
        // 객체 => 힙 메모리 영역
        // 변수 => 힙 메모리 영역의 주소

//        String str = "안녕하세요!"; //문자열 리터럴
//        String str_2 = new String("안녕하세요!"); //생성자
//        String str_3 = "안녕하세요!";
        //new 연산자를 사용하면 무조건 새로운 객체롤 생성함

//        if(str==str_2) {
//            System.out.println("str==str_2");
//        }
//
//        if(str==str_3) {
//            System.out.println("str==str_3");
//        }
//        if(str_2==str_3) {
//            System.out.println("str_2==str_3");
//        }

//        if (str.equals(str_2)) {
//            System.out.println("str.equals(str_2)");
//        }
//        if (str.equals(str_3)) {
//            System.out.println("str.equals(str_3)");
//        }if (str_2.equals(str_3)) {
//            System.out.println("str_2.equals(str_3)");
//        }

        // 문자열 병합

        // 1. '+' 연산자
//        String str_1 = "Hello,";
//        String str_2 = "World!";
//
//        System.out.println(str_1+" "+str_2);

        // 2. StringBuilder
//        StringBuilder strBdr_1 = new StringBuilder("Hello,");
//
//        strBdr_1.append("World!");
//        strBdr_1.append("World!");
//
//        String str_new = strBdr_1.toString();
//
//        System.out.println(str_new);

        //문자열 슬라이스

//        String str_1 = "이름: 김자바";
//        System.out.println(str_1.indexOf("이"));
//        System.out.println(str_1.indexOf("름"));
//
//        String str_name = str_1.substring(4, 7); //시작은 포함하고 끝은 포함하지않는다
//        System.out.println(str_name);

        //문자열 대소문자 변환

//        String str_1 = "abc";
//        String str_2 = "ABC";
//
//        str_1 = str_1.toUpperCase();
//        str_2 = str_2.toUpperCase();
//
//        System.out.println(str_1);
//        System.out.println(str_2);

//        if (str_1.equals(str_2)) {
//            System.out.println("str_1.equals(str_2)");
//        }
//        if (str_1.equalsIgnoreCase(str_2)) {
//            System.out.println("str_1.equalsIgnoreCase(str_2)");
//        }

        //공백제거

        //1. 양쪽 끝 공백
        String str_1 = "     Hello ";
        str_1 = str_1.trim();
        System.out.println(str_1);



        //2. 문자열 중간 공백
        String str_2 = " Hel lo ";
        str_2 = str_2.trim();
        str_2 = str_2.replace(" ", "");
        System.out.println(str_2);


    }
}
