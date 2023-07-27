package dev.aquashdw;

public abstract class AbstractCar implements CarInterface {
    // AbstractCar는 CarInterface를 구현하기 이한 추상자동차가 된다.
    protected int velocity = 0;
    @Override
    public void brake(){
        if(this.velocity < 0) this.velocity = 0;    // 모든 자동차는 브레이크를 밟았을 때 0밑으로 내려가면 0으로 내려간다.
    }
}
