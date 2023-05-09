package dev.aquashdw;

public class GoCart extends AbstractCar implements CarInterface{
    private Driver driver;

    @Override
    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Override
    public void accelerate() {
        this.velocity += 5;

    }

    @Override
    public void brake() {
        this.velocity -= 5; // 여기 velocity는 AbstractCar의 velocity이다.
        super.brake();  // super.brake는 오버라이드를 했던 추상클래스의 미리 정의되어 있떤 brake함수에 도달하기 위해서 사용하는 함수이다.
    }
}
