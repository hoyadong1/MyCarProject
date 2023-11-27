package manager;

import facade.DataEngineImpl;
import mycar.RepairShop;

public class RepairShopManager extends DataEngineImpl<RepairShop> {

    private static RepairShopManager instance = null;
    private String[] headers = {"name", "location", "cost"};

    private RepairShopManager() {
        setLabels(headers);
    }

    public static RepairShopManager getInstance() {
        if (instance == null) {
            instance = new RepairShopManager();
        }
        return instance;
    }
}
