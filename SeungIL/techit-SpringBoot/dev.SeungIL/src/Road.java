import java.util.ArrayList;

public class Road {
    private ArrayList<Carinterface> carsOnRoad;

    public Road(){
        this.carsOnRoad = new ArrayList<>();
    }

    public Road(ArrayList<Carinterface> carsOnRoad) {
        this.carsOnRoad = carsOnRoad;
    }

    public void addCar(Carinterface car){
        this.carsOnRoad.add(car);
    }
}
