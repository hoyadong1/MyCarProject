package mycar;

import java.util.ArrayList;

public class User {

    private static User instance = null;
    ArrayList<Car> basket = new ArrayList<>();

    public void addBasket(Car car) {
        basket.add(car);
    }

    public static User getInstance() {
        if (instance == null) {
            instance = new User();
        }
        return instance;
    }

    private User() {
        
    }
}