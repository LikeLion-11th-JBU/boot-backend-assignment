public class ClassExample_Ob {

    public static void main(String[] args) {

        BackAccount_Ob bankAccount = new BackAccount_Ob();
        bankAccount.changePassword(12345);
        System.out.println(bankAccount.getPassword());

        //getter setter 함수 덕에 12345가 찾아진것
        // gettersetter는 마우스우클릭 generate 누르면 나옴.
    }
}
