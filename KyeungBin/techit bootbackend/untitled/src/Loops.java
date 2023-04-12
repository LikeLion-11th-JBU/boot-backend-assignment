public class Loops {

    public static void main(String[] args) {

        // 반복문 -> for, while
        // 1. for
        // 초기화된 변수, 조건식, 증감식 -> 이 세가지가 필요. (무한루프 발생하지 않도록 주의)
        // for 은 변수를 미리 초기화 해야함.
/*
        for (int i = 0; i < 10; i =i+2) {
            System.out.println(i);
        }*/


        // 2. while
        //

        int b = 10;

        //while (b > 0) {
        //    System.out.println(b);
        //    b--;
    //}

        // 3. do while -> 무조건 한 번은 실행한다

        do {
            System.out.println(b);
            b--;
        } while (b > 0);

    }
}
