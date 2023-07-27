public class ClassExample {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(); // 기본 생성자를 만든다. 임의로 수정하는 방법은 list나 map처럼 해당 데이터를 호출하는 표기법으로 나타낸다.
        bankAccount.changePassword(12345);
        //bankAccount.password = 123145; //를하면 password가 수정이 된다. 접근제어자가 없을 경우
        //System.out.println(bankAccount.password);
        System.out.println(bankAccount.getPassword());
        //하나의 클래스에 정의된 멤버변수들, 인스턴스의 속성이 되는 것은 임의로 덮어씌우는 식으로 변경을 하는것이 아니라 각각에 맞는 함수를 만들어서 변경시켜야한다.
        //private을 붙이면 오류가 나온다.

        //password를 임의로 바꿈



        //System.out.println(account);
        //System.out.println(account.bankCode);
        //System.out.println(account.isDormant);
    }
}
