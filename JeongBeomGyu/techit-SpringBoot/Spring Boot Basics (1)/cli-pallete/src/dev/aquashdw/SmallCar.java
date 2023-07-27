package dev.aquashdw;

public class SmallCar extends AbstractCar implements CarInterface{
    private Driver driver;

    @Override
    public void setDriver(Driver driver) {
        if(driver.getLicense() < 1){
            throw new RuntimeException("insufficient license");
        }
    }

    @Override
    public void accelerate() {
        this.velocity += 10;

    }

    @Override
    public void brake() {
        this.velocity -= 10;
        // if(this.velocity < 0) this.velocity = 0;    // 좋은 모습이 아님 -> 모든 인터페이스들이 공유를 하는 기능을 만들기 위해서는 안터페이스말고 추상클래스를 만들어주는 것이 더 효율적이다.
        super.brake();
    }
}
