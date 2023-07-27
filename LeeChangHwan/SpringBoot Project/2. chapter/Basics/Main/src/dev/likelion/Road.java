package dev.likelion;

import java.util.ArrayList;
import java.util.List;

public class Road {
    private ArrayList<CarInterface> carsOnRoad;

    public Road() {
        this.carsOnRoad = new ArrayList<>();
    }

    public Road(ArrayList<CarInterface> carsOnRoad) {
        this.carsOnRoad = (ArrayList<CarInterface>) carsOnRoad;
    }

    public void addCar(CarInterface car){
        this.carsOnRoad.add(car);
    }
}
