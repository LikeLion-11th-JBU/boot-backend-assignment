public class SavingsAccount extends BankAccount implements withdrawable{
    //extends bankaccount를 통해서 자식 클래스는 부모클래스가 가지고 있는 모든것을 가지고 시작한다
    //자유 입출금 통장
    //implements를 하면 오류가 나는 이유는 인터페이스를 구현하기로 해놓고 구현을 하지 않았기 때문에, 클래스에서 인터페이스를 구현해야한다.

    boolean isOverdraft; //마이너스 통장
    void transfer(){}; // 계좌를 송금하는 통장 (매서드)
    public void withdraw(){
        System.out.println("withdraw");
    }; // 소스를 가져오면 인터페이스를 implements했다고 뜨고, 내부적으로 구현부를 완성하면 된다.
    //이떄 또 에러 메세지가 나오는데, 외부의 인터페이스에서 함수를 가져와서 재정의해서 사용하는 것이기 떄문에, 재정의를 할때는 접근제어자를 붙여줘야한다.
    //외부에서 이 클래스에 접근해서 withdraw라고 하는 재정의된 함수를 사용할 수 있도록 하기 위해서이다
}
