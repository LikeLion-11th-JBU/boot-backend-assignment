public class Loops {
    public static void main(String[] args) {

        // 반복문
        // 1. for
        //초기화된 변수 . 조건식 . 증감식

//        for (int i = 0; i < 10; i++) {
//            System.out.println(i);
//        } // 정수형 int 인 초기화된 변수가 들어간다. 관형적으로 i 를 사용
        // while    외부에서 변수 지정하는 일이 많음 for는 안에서 지정
        int b =10;

//        while (b > 0) {
//            System.out.println(b);
//            b--;
//        }
        //while은 조건문은 평가하고 시작하지만 do 는 일단 최초에 한번 출력하고 조건을 평가 한다
        do {
            System.out.println(b);
            b--;
        }while (b > 0);
    }
}
