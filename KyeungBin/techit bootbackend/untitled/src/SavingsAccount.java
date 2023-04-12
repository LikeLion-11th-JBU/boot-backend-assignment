public class SavingsAccount extends BankAccount implements Withdrawable {

    boolean isOverdraft; // 마이너스통장??
    void transfer() {}; //
    public void withdraw() {
        System.out.println("Withdraw");
    };

}
