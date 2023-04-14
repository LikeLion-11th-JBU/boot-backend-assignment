public class Conditional {

    public static void main(String[] args) {

        //
/*
        int a = 1;
        int b = 100;


        // 다중 조건문일 경우, 조건을 만족하는 최초의 분기만 실행. (만족하는 조건이 중복될 경우 최초의 코드만 출력?)
        if (a == b) {
            System.out.println("a == b");
        } else if (a < b) {
            System.out.println("a <= b");
        } //else if (a <= b) {
            //System.out.println("a <= b");
        //}
        else {
            System.out.println("else block");
        }

        //if (a == b) {
        //    System.out.println("a == b");
        //} else {
        //    System.out.println("else block");
        //}


        //if (a != b) {
        //    System.out.println("a != b");
        //}


*/

        int a = 11;
/*
        switch (a + 1) {

            case 9:
                System.out.println("a + 1 == 9");
            case 10:
                System.out.println("a + 1 == 10");
            case 11:
                System.out.println("a + 1 == 11");
        }

*/
        switch (a + 1) {
            // 거꾸로 해놓아도 아래 코드들이 작동하므로 따로 break; 를 해주어야 함.
            case 11:
                System.out.println("a + 1 == 11");
                break;
            case 10:
                System.out.println("a + 1 == 10");
                break;
            case 9:
                System.out.println("a + 1 == 9");
                break;
            default:
                System.out.println("default");
        }





    }
}









