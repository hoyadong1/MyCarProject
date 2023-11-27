package manager;

import facade.DataEngineImpl;
import mycar.Option;

public class OptionManager extends DataEngineImpl<Option> {

    private static OptionManager instance = null;
    private String[] headers = {"name", "price"};

    private OptionManager() {
        setLabels(headers);
    }

    public static OptionManager getInstance() {
        if (instance == null) {
            instance = new OptionManager();
        }
        return instance;
    }
}
