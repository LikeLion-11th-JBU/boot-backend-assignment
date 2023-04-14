public class StringExample {

    public static void main(String[] args) {

        // String => 문자열 객체
        // 객체 => 힙 메모리 영역
        // 변수 => 힙 메모리 영역의 주소

/*
        String str = "안녕하세요!"; // 문자열 리터럴 (값 자체를 가리키는 용어)
        String str_2 = new String("안녕하세요!"); // 생성자를 통해 새로운 객체를 만듦
        String str_3 = "안녕하세요!";

        if (str == str_2) {
            System.out.println("str == str_2");
        }

        if (str == str_3) {
            System.out.println("str == str_3");
        }

        if (str_2 == str_3) {
            System.out.println("str_2 == str_3");
        }

        // 식별할 수 있는 값이 같은지 판단

        if (str.equals(str_2)) {
            System.out.println("str.equals(str_2)");
        }
        if (str.equals(str_3)) {
            System.out.println("str.equals(str_3)");
        }
        if (str_2.equals(str_3)) {
            System.out.println("str_2.equals(str_3)");
        }

*/

        // 문자열 병합

        // 1. '+' 연산자
/*
        String str_1 = "Hello,";
        String str_2 = "World!";

        System.out.println(str_1 + str_2);
        System.out.println(str_1 + " " +str_2); // 공백 넣을 때
*/
        // 2. StringBuilder 메모리를 생성하지 않고 ?

/*
        StringBuilder strBdr_1 = new StringBuilder("Hello,");

        strBdr_1.append(" ");
        strBdr_1.append("World!");

        String str_new = strBdr_1.toString();

        System.out.println(strBdr_1);
        System.out.println(str_new);
*/

        // 문자열 슬라이스

        /*
        String str_1 = "이름: 김자바";

//        System.out.println(str_1.indexOf("이"));
//        System.out.println(str_1.indexOf("름"));

        String str_name = str_1.substring(4, 7); // 끝 인덱스는 마지막 단어보다 하나 높게
        System.out.println(str_name);

*/
        // 문자열 대소문자 변환
/*
        String str_1 = "abc";
        String str_2 = "ABC";

        str_1 = str_1.toUpperCase();
        str_2 = str_2.toLowerCase();

        System.out.println(str_1);
        System.out.println(str_2);
*/

        /*
        if (str_1.equals(str_2)) {
            System.out.println("str_1.equals(str_2)");

        }

        // 대소문자 구분없이 비교하는 구문
        if (str_1.equalsIgnoreCase(str_2)) {
            System.out.println("str_1.equals(str_2)");

        }
*/

        // 공백 제거

        // 1. 양쪽 끝 공백 (trim을 사용)
/*
        String str_1 = "                    Hello                ";
        str_1 = str_1.trim();
        System.out.println(str_1);
*/
        // 2. 문자열 중간 공백

        String str_2 = "       H e       l lo       ";
        str_2 = str_2.trim();
        str_2 = str_2.replace(" ", "");
        // 다른 문자로 치환하겠다~ 이말이야

        System.out.println(str_2);

    }
}
