public class Loop {

    public static void main(String[] args) {


        //반복문 for, while
        // 1. for
        // 초기화된 변수, 조건식(무한루프가 안생기도록 주의), 증감식


        /*for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }*/

        // 2. while

        int b = 10;

        /*while (b > 0) {
            System.out.println(b);
            b--;
        }*/

        do { //do를 먼저 쓰면 일단 무조건 한번은 실행
            System.out.println(b);
            b--;
        } while (b > 0);
    }
}