package dev.aquashdw;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        // 여러 사람의 driver
//        Driver unlicensed = new Driver("unlicensed",0);
//        Driver me = new Driver("me",1);
//        CarInterface car = new GoCart();    // 어떠한 구현체이든지 동일한 인터페이스를 상속한다.
//        car.setDriver(me);
//
//        car = new SmallCar();   // 새로운 객체를 car에 생성
//        car.setDriver(me);
//        car.setDriver(unlicensed); -> 무면허 운전자가 운전을 할 때 문제가 생긴다.

        //Road라는 객체를 사용하고자 하는 개발자가 ArrayList 대신에 LinkedList를 사용한다.
        LinkedList<CarInterface> linkedList = new LinkedList<>();
        Road route88 = new Road(linkedList);  // 길위에 올라가는 자동차들의 집합을 알고 싶기 때문에 ()안에 LinkedList를 넣으면 오류가 나온다. 왜냐하면 필요한 형은 ArrayList이기 때문이다.
    }
}