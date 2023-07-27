import org.w3c.dom.ls.LSOutput;

public class SavingAccount_Ob extends BackAccount_Ob implements Withdrawable_Ob{


    //자유입출금계좌에 해당되는 멤버변수들 설정
    boolean isOverdraft; //마이너스 통장
    void transfer() {};      //송금
    public void withdraw() {
        System.out.println("Withdraw");
    }
}
