public class DollarAccount extends BankAccount{
    //extends bankaccount를 통해서 자식 클래스는 부모클래스가 가지고 있는 모든것을 가지고 시작한다


    // 오버로딩 => 부모클래스에서 상속받은 매서드에서 파라미터를 변경
    // 새로운 매서드 정의
    //오버라이딩 => 부모클래스에서 상속받은 메서드의 내용을 변경하는 것이다. 자식 클래스의 상황에 맞게, 매서드의 코드블락(중괄호)이 변경된다.
    void inquiry(double currentRate){} //부모 클래스 매서드 명은 의미적으로 같지만, 잔액을 조회했을 때 한국돈이 아니라 미화로 결과를 확인할 수 있다.
    public void deposit(){
        //bankaccount에 정의된 deposit을 쓰지 안고 dolloraccount만의 고유한 입금 방식을 취하기 위해서 deposit을 다시 재정의한다.
        // 오버라이딩이 된 매서드의 경우 부모 클래스의 파라미터를 그대로 따른다.
        //오버라이딩 하는 경우 자식 클래스에도 접근제어자를 붙여준다.

    }


}
