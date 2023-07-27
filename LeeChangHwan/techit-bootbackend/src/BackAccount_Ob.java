public class BackAccount_Ob {

    // 멤버변수
    // private => 동일클래스
    private int bankCode;   // 은행이 가지는 개별적코드
    private int accountNo;  // 계좌번호
    private String owner;   // 예금주
    private int balance;    // 잔액
    private boolean isDormant;  // 휴먼계좌인지 아닌지 판별 (T/F)
                        // true나 false로 판별될 때 is 접두사 사용.
    private int password;

    // 총 6개의 멤버변수를 가지게됨.

    // 메소드(함수)
    public void inquiry() {}  // 계좌자체를 단순히 조회(int선언도 가능)
    public void deposit() {}  // 계좌입금
    public void heldInDormant() {} // 휴면계좌로 전환
    public void changePassword(int password){
        this.password = password;
    }

    // 생성자
    // *** 클래스 내부에 정의, 생성자 메소드명은 클래스명과 일치!
    // new 연산자와 함께 사용


    BackAccount_Ob( // 생성에 필요한 정보는 생성자이름 () 안에다가 넣기.
    ){ // {}안에는 의미있는 인스턴스를 만드는 것
        this.bankCode = bankCode;
        this.accountNo = accountNo;
        this.owner = owner;
        this.balance = balance;
        this.isDormant = isDormant;
        this.password = password;
        // = 기준으로 왼쪽 Ex)bankCode는 클래스에 정의된 멤버변수
        // 오른쪽 Ex)bankCode는 사용자로부터 입력받은 값이다.
    }

    public int getBankCode() {
        return bankCode;
    }

    public void setBankCode(int bankCode) {
        this.bankCode = bankCode;
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
