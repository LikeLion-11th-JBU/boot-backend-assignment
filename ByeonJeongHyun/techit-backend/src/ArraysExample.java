public class ArraysExample {
    public static void main(String[] args) {

        //배열 (Arrays)

        int[] price = {10000, 9000, 40000, 7000};
        String[] mbti = {"infp", "istp", "isfp", "intp"};

        System.out.println(mbti.length);
        for (int i = 0; i < mbti.length; i++) {
            System.out.println(mbti[i]);
        }
    }
}
