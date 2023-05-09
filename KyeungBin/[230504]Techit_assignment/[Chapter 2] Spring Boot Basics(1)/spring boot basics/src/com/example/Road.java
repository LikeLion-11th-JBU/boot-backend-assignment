package com.example;

import java.util.ArrayList;
import java.util.LinkedList;

public class Road {
    private ArrayList<CarInterface> carsOnRoad;

    public Road(LinkedList<CarInterface> linkedList) {
        this.carsOnRoad = new ArrayList<>();
    }

    public Road(ArrayList<CarInterface> carsOnRoad) {
        this.carsOnRoad = carsOnRoad;
    }

    public void addCar(CarInterface car) {
        this.carsOnRoad.add(car);
    }



}
