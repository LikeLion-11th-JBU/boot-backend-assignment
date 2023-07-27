package dev.aquashdw;

import java.util.List;
import java.util.ArrayList;

public class Road {
    //carInterface를 담아주는 Road 클래스
    private List<CarInterface> carsOnRoad; // 반면 사용된 멤버변수는 ArrayList이다. ArrayList는 구현체이다. ArrayList는 List이지만, List는 ArrayList가 아니다.(is-a관계)
                                                // 내부에서 구현체로 사용할 때에는 가능하면 List로 만들어준다. -> 즉 인터페이스로 만들어준다.
    public Road() {
        this.carsOnRoad = new ArrayList<>();    // 이렇게 내부에서 사용할 구현체라면 원하는 것을 사용해도 상관없다.
    }

    public Road(List<CarInterface> carsOnRoad) {    // 인자가 List로 작성, List는 interface이다. -> 코드상에서 사용하게될 인자는 interface형태로 받아주는 형태로 작성
        this.carsOnRoad = carsOnRoad; //List를 ArrayList로 변환해서 처리 -> 좋지 않다.
    }

    public void addCar(CarInterface car){
        this.carsOnRoad.add(car);
        // 이렇게 하면 SmallCar도 사용할 수 있고, GoCart도 사용할 수 있다.
    }

}
