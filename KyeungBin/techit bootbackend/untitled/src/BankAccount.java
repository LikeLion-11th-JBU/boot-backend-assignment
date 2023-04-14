public class BankAccount {

    // 멤버 변수
    // private => 동일한 클래스 안에서만 참조가능
    private int bankCode;
    private int accountNo;
    private String owner;
    private int balance;
    private boolean isDormant;
    private int password;

    // 메소드

    void inquiry() {}
    void deposit() {}
    void heldInDormant() {}
    void changePassword(int password) {
        this.password = password;
    }

    // 생성자
    // 클래스 내부에 정의, 생성자 메서드명은 클래스명과 일치해야한다. (중요!)
    // new 연산자와 함께 사용
    BankAccount () {

    }

    BankAccount(
            int bankCode,
            int accountNo,
            String owner,
            int balance,
            int password,
            boolean isDormant
    ) {

        this.bankCode = bankCode; // 왼쪽에 있는 값은 클래스의 정의를 가지는 멤버변수, 오른쪽에 있는 값은 사용자로부터 입력받은 값 의미.
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
