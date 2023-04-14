public class SavingsAccount extends BankAccount implements withdrawable{

    boolean isOverdraft; 
    void transfer(){}; 
    public void withdraw(){
        System.out.println("withdraw");
    };
}
