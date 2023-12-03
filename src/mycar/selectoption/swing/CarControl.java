package mycar.selectoption.swing;

import mycar.Car;
import mycar.User;

public class CarControl {
	static Car instance = null;
	private CarControl(){
		
	}
	public static Car getCar() {
		return instance;
	}
	public static void setCarName(Car car) {
		instance.setName(car.getCarName());
	}
	public static void setCarOption(Car car) {
		instance.setOptionList(car.getOptionList());
	}
    public static Car getInstance() {
        if (instance == null) {
            instance = new Car();
        }
        return instance;
    }
}
