package dev.aquashdw;

public interface CarInterface {
    //Car를 객체로 선언하는것이 아니라 interFace로 선언한다.
    void setDriver(Driver driver);
    void accelerate();
    void brake();
    // 이렇게 인터페이스를 정의하게 되면 앞으로 만들어질 다양할 자동차들을 동일한 인터페이스로 작동을한다. 또한 더 늘어나는 자동차에 대해서도 유동적으로 대처가 가능하다.
}
