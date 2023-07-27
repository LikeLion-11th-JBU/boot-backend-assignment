public class ArraysExample {
    public static void main(String[] args) {

        // 배열(Arrays) : 특정한 자료형에 대해서 자료형을 모아놓은

        int[] price = {10000,9000,40000,7000};  //int를 모아놓은 배열이다. 여기서 price는 int를 모아놓은 배열의 변수이다. 복수의 int값을 넣을 수 있다. 단 int가 아닌 값을 넣으면 에러가 나온다.
        String[] mbti = {"INFP","ENFP","ISTJ","ESTP"};  //배열의 요소들은 자기만의 순서를 가지고 있다. 첫 배열의 순서는 0이라는 인덱스값을 가지고 있다.

        System.out.println(price[0]);
        System.out.println(mbti[0]); // mbti라는 변수에 저장되어 있는 0번째 배열을 출력한다.


        //임의의 값을 수정하는 방법
        //1. 값을 가져오기
        //2. 대입연산자를 통해서 새롭게 대입한다.
        price[1] = 8000;
        System.out.println(price[1]); //1번 인덱스에 저장되어 있던 9000이 8000을 바뀐다.
        //만약 price배열을 출력하고 싶어서 배열이 입력된 변수를 출력해보면 주소값이 나온다. System.out.println(price)를 하면 배열의 주소값이 나온다.

        //for 반복문을 이용해서 배열을 조작하는 방법
        // 그러기 위해서는 배열의 길이를 알아야한다.
        //mbti 라는 배열의 크기를 구하기 위해서는 .length라는 함수를 사용해야한다.
        System.out.println(mbti.length);

        for(int i = 0; i < mbti.length; i++){
            System.out.println(mbti[i]);
        }






    }
}
