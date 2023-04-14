public class Loops {

    public static void main(String[] args) {

        // 반복문

            // 1. for
            /*
            for(int i = 0; i < 10; i++) {   // for문은 초기화된 변수, 조건식, 증감식이 필요하다.
                System.out.println(i);
            }
            */
            // 2. while

            int b = 10;
            /*
            while(b > 0) {
                System.out.println(b); // 이 상태로 실행하면 무한루프에 빠짐. b의 범위를 설정해야함!
                b--;                   // 결과값 : 10 9 8 7 ... 1 로 줄어드는 결과값이 나옴.
             */
            do {
                System.out.println(b);
                b--;
            } while(b > 0);            // while과 값은 같지만 while은 조건식을 처음부터 평가하지만
                                       // do while 처음에 평가하지않고, 값을 찍고 반복이 돌때 평가가 시작된다.
    }
}
