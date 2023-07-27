public class BankAccount {

    //멤버 번수, 정적인 데이터
    //private => 동일 클래스 내에서만 참조, 수정 가능
    private int bankCode;  //은행이 각각 개별적으로 가지는 은행 코드
    //.을 붙여서 마음대로 변경하지 못하게 private이라는 접근제어자를 멤버변수 앞에 붙여줘야한다.
    private int accountNo; //계좌번호
    private String owner;  //예금주
    private int balance;   //잔액
    private boolean isDormant; //휴면 상태
    private int password;   //계좌 비밀번호
    // 총 6개의 멤버 변수, 즉 속성을 얻는다.

    //메소드 정의를 해줘야한다 (기능 or 함수), 동적인 데이터
    public void inquiry(){} //계좌를 단순히 조회하는것
    public void deposit(){} //계좌 입금
    //public void withdraw(){}//휴면계좌로 전환
    public void heldInDormant(){}//출금
    public void changePassword(int password){
        this.password = password;
    }
    //생성자
    //클래스 내부에 정의, 생성자 메서드명은 클래스명과 일치!
    //new 연산자와 함께 사용해야 한다.
    BankAccount(
            ){
        this.bankCode = bankCode; //왼쪽의 bankcode는 클래스에 정의된 멤버변수를 가지고, 오른쪽 bankcode는 사용자로 부터 입력 받은값이다.
        this.accountNo = accountNo;
        this.owner = owner;
        this.balance = balance;
        this.password = password;
        this.isDormant = isDormant;


    }

    public int getBankCode() {
        return bankCode;  //값을 리턴하는 get
    }

    public void setBankCode(int bankCode) {
        this.bankCode = bankCode;   // 값을 변경하는 setter
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public boolean isDormant() {
        return isDormant;
    }

    public void setDormant(boolean dormant) {
        isDormant = dormant;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
}
