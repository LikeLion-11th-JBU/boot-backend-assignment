public class BankAccount {

    //맴버변수
    //private => 동일 클래스에서만 확인하고 수정 할 수 있다
    private int bankCode;
    private int accountNo;
    private String owner;
    private int balance;
    private boolean isDormant;
    private int password;

    //메서드 기능부분
    public void inquiry() {}
    public void deposit() {}
    public void heldInDormant() {}
    public void changePassword(int password) {
        this.password = password;
    }

    //생성자
    // 클래스 내부에 정의, 생성자 메서드명은 클래스의 클래스명과 일치 해야한다.
    // new 연산자와 함꼐 사용
    BankAccount() {

    }
    BankAccount(
            int bankCode,
            int accountNo,
            String owner,
            int balance,
            boolean isDormant,
            int password
    ) {
        this.bankCode = bankCode;
        //왼쪽은 클래스에 정의된 맴버변수 오른쪽은 사용자로 부터 입력 받은 값
        this.accountNo = accountNo;
        this.owner = owner;
        this.balance = balance;
        this.password = password;
        this.isDormant = isDormant;
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
