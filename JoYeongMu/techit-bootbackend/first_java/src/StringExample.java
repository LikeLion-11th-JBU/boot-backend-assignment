public class StringExample {
    public static void main(String[] args) {

//        String => 힙 메모리 영역
//        변수 = > 힙 메모리 영역의 주소

//        String str = "안녕하셔요!"; // 문자열 리터럴
//        String str_2 = new String("안녕하셔요!"); // 생성자 / 무조건 새로운 객체로 생성되어 힙 메모리에 위치시킨다
//        String str_3 = "안녕하셔요!";

//        if (str == str_2)
//            System.out.println("str == str_2");
//        if (str == str_3)
//            System.out.println("str == str_3");
//        if (str_2 == str_3)
//            System.out.println("str_2 == str_3");
//--------------------------------------------
//        내용 자체만 비교 하기 때문에 같다고 뜬다.
//        if (str.equals(str_2)) {
//            System.out.println("str.equals(str_2)");
//        }
//        if (str.equals(str_3)) {
//            System.out.println("str.equals(str_3)");
//        }
//        if (str_2.equals(str_3)){
//            System.out.println("str.equals(str_3)");
//        }
//        문자열 병합
//        1. '+'연산자 이용 임시로 스트링 객체를 할당하기 때문에 힙메모리에 올라간다
//        작업이 쌓이면 메모리에 영향을 준다
//        String str_1 = "Hello";
//        String str_2 = "world";
//        System.out.println(str_1 + " " +str_2);
//
//        2.StringBuilder 임시로 말고 메모리에 그대로 데이터를 붙힣 수 있는 방법
//
//        StringBuilder strBdr_1 = new StringBuilder("Hello");
//        strBdr_1.append(" ");
//        strBdr_1.append("world");
//        String str_new = strBdr_1.toString();
//        System.out.println(str_new);

//        문자열 슬라이스
//        String str_1 = "이름: 조영무";
//        System.out.println(str_1.indexOf("무"));
//        String str_name = str_1.substring(4,7); //시작과 끝을 정해줌
//        System.out.println(str_name);

//        문자열 대소문자 변환
//        String str_1 = "abc";
//        String str_2 = "ABC";

//        str_1 = str_2.toUpperCase();
//        str_2 = str_2.toLowerCase();
//
//        System.out.println(str_1);
//        System.out.println(str_2);
//        equalsIgnoreCase() => 대소문자를 무시하고 비교하겠다.
//        if (str_1.equalsIgnoreCase(str_2)) {
//            System.out.println("str_1.equls(str_2)");
//    }
//        공백 제거
//        1. 양쪽 끝 공백
        String str_1 = "     Hello   ";
        str_1 = str_1.trim();
        System.out.println(str_1);
//        2.문자열 중간 공백
        String str_2 = "    hel  lo   ";
        str_2 = str_2.trim();
        str_2 = str_2.replace(" ","");// 어떤 문자를 치환 하겠다라는 것 =>replace
        System.out.println(str_2);

    }
}
