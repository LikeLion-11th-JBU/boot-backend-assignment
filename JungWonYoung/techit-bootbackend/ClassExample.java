public class classExample{
    public static void main(String[] args) {
        BankAccount bankAccount = new BanckAccount();
        bankAccount.changePassword(12345);
        System.out.println(bankAccount.getPassword());
    }
}