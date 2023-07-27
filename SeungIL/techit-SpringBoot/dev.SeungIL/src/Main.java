import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Driver unlicensed = new Driver("unlicensed",0);
        Driver me = new Driver("me",1);
        Carinterface car = new GoCart();
        car.setDriver(me);
        car.setDriver(unlicensed);

        car = new SmallCar();
        car.setDriver(me);
//        car.setDriver(unlicensed);

        List<Carinterface> linkedList = new LinkedList<>();
//        Road route88 = new Road(linkedList);

    }
}