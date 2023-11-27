package manager;

import facade.DataEngineImpl;
import mycar.Part;

public class PartManager extends DataEngineImpl<Part> {

    private static PartManager instance = null;
    private String[] headers = {"name", "code", "price", "fixPrice"};

    private PartManager() {
        setLabels(headers);
    }

    public static PartManager getInstance() {
        if (instance == null) {
            instance = new PartManager();
        }
        return instance;
    }
}
