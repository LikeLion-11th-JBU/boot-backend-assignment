public class Loops {
    public static void main(String[] args) {

        //반복문
        // 1. for 3가지의 조건이 필요하다
        // 초기화된 변수, 조건식, 증감식 3가지 조건이 필요하다.

       // for(int 형태의 초기화된 변수 i를 넣어준다 = 0; i 라는 변수의 범위를 정해준다 < 10 ; i++ i의 값을 1씩 키워나가는 증감식 )

        for (int i = 0; i < 10; i = i+2){
            System.out.println(i);
        }

        // 2. while문
        // for문은 내부에서 사용할 변수를 안에서 초기화 가능하지만 while같은 경우는 외부에서 만들어서 사용가능하다.

        int b = 10;

        while( b > 0){
            System.out.println(b);
            b--;   //한번 반복이 될때마다 값이 1씩 줄어든다.
        }


        // 3. do while

        do {
            System.out.println(b);     //do는 조건식과 상관없이 무조건 한번은 실행한다. 그 다음 조건식을 통해서 실행한다.
            b--;
        }while( b > 0);

    }

}
