public class ArraysExample {

    public static void main(String[] args) {

        // 배열(Arrays)
        /*
        int[] price = {10000, 9000, 40000, 7000};
        String[] mbti = {"INFP", "ENTJ", "ENFP", "ISTJ"};

        //System.out.println(price[0]);
        //System.out.println(mbti[0]);

        price[1] = 8000;                //원하는 INDEX를 대입연사자를 통해 수정 가능.
        //System.out.println(price[1]);

        System.out.println(price);      //주소를 가르키는 결과값이 나옴.
        */

        int[] price = {10000, 9000, 40000, 7000};
        String[] mbti = {"INFP", "ENTJ", "ENFP", "ISTJ"};

        //System.out.println(mbti.length); // 4개의 요소를 가지고 있어서 결과값 : 4 로 나옴.

        for (int i = 0; i < mbti.length; i++) { // i를 0부터것이 좋다.
         System.out.println(mbti[i]);
        }
    }
}
