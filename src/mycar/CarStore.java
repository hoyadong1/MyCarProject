package mycar;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import manager.Manageable;

public class CarStore implements Manageable {

    String name;
    String location;

    HashMap<Car, Integer> carList = new HashMap<>();

    @Override
    public void read(Scanner scan) {
        name = scan.next();
        location = scan.next();

        while (true) {
            String code = scan.next();
            if (code.equals("0")) {
                break;
            }
            int num = scan.nextInt();
            Car c = MyCarProgram.findCar(code);

            carList.put(c, num);
        }
    }

    @Override
    public void print() {
        Iterator<HashMap.Entry<Car, Integer>> iterator = carList.entrySet().iterator();
        System.out.printf("%s %s\n", name, location);
        while (iterator.hasNext()) {
            HashMap.Entry<Car, Integer> entry = iterator.next();
            System.out.printf("%s : %d\n", entry.getKey().code, entry.getValue());
        }
    }

    @Override
    public boolean matches(String kwd) {
        if (kwd.equals(name)) {
            return true;
        }
        return false;
    }

    public boolean haveCar(Car car) {
        Iterator<HashMap.Entry<Car, Integer>> iterator = carList.entrySet().iterator();
        while (iterator.hasNext()) {
            HashMap.Entry<Car, Integer> entry = iterator.next();
            if (entry.getKey().code.equals(car.code)) {
                return true;
            }
        }
        return false;
    }

}
