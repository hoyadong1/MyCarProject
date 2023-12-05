package mycar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

    private static User instance = null;
    // ArrayList<Car> basket = new ArrayList<>();
    Map<String, Car> basket = new HashMap<String, Car>();;

    public void addBasket(String name, Car car) {
        System.out.println(car + ": 차량이 추가되었습니다.");
        basket.put(name, car);
    }

    public Map<String, Car> getList() {
        return basket;
    }

    public static User getInstance() {
        if (instance == null) {
            instance = new User();
        }
        return instance;
    }

    public Car findCar(String kwd) {
        for (Car car : basket.values()) {
            if (car.matches(kwd)) {
                return car;
            }
        }
        return null;
    }

    public List<String> getKeyList() {
        return new ArrayList<>(basket.keySet());
    }

    private User() {

    }
}
