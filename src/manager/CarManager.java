package manager;

import facade.DataEngineImpl;
import mycar.Car;

public class CarManager extends DataEngineImpl<Car> {

    private static CarManager instance = null;
    private String[] headers = {"name", "code", "price"};

    private CarManager() {
        setLabels(headers);
    }

    public static CarManager getInstance() {
        if (instance == null) {
            instance = new CarManager();
        }
        return instance;
    }

}
