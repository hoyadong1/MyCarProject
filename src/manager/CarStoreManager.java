package manager;

import facade.DataEngineImpl;
import mycar.CarStore;

public class CarStoreManager extends DataEngineImpl<CarStore> {

    private static CarStoreManager instance = null;
    private String[] headers = {"name", "location"};

    private CarStoreManager() {
        setLabels(headers);
    }

    public static CarStoreManager getInstance() {
        if (instance == null) {
            instance = new CarStoreManager();
        }
        return instance;
    }
}
