package mycar;

import java.util.ArrayList;
import java.util.List;

public class User {

    private static User instance = null;
    ArrayList<Car> basket = new ArrayList<>();

    public void addBasket(Car car) {
        System.out.println(car + ": 차량이 추가되었습니다.");
        basket.add(car);
    }

    public List<Car> getList() {
        return basket;
    }

    public static User getInstance() {
        if (instance == null) {
            instance = new User();
        }
        return instance;
    }

    public Car findCar(String kwd) {
        for (Car car : basket) {
            if (car.matches(kwd)) {
                return car;
            }
        }
        return null;
    }

    private User() {

    }
}