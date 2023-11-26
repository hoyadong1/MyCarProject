package mycar;

import java.util.ArrayList;

public class User {

    ArrayList<Car> basket = new ArrayList<>();

    public void addBasket(Car car) {
        basket.add(car);
    }
}
