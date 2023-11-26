package mycar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

    private static User instance = null;
    ArrayList<Car> basket = new ArrayList<>();
    Map<String, Car> map;

    public void addBasket(Car car) {
        System.out.println(car + ": 차량이 추가되었습니다.");
        basket.add(car);
    }
    
    public void addListNameMap(String name, Car car) {
    	map = new HashMap<String, Car>();
    	map.put(name, car);
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