public class ClassExample {
    public static void main(String[] args) {
        /*BankAccount account = new BankAccount(

        );
        System.out.println(account);
        System.out.println(account.bankCode);
        System.out.println(account.isDormant);
        */
        BankAccount bankAccount = new BankAccount();
        //bankAccount.password = 123456;
        //System.out.println(bankAccount.password);
        //다음과 같이 마음대로 변경하지 못하도록 접근제어자 설정
        bankAccount.changePassword(123456);
        System.out.println(bankAccount.getPassword());
    }
}
