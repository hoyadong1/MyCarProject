package manager;

import facade.DataEngineImpl;
import mycar.Review;

public class ReviewManager extends DataEngineImpl<Review> {

    private static ReviewManager instance = null;
    private String[] headers = {"optionName", "rating", "reviewComment"};

    private ReviewManager() {
        setLabels(headers);
    }

    public static ReviewManager getInstance() {
        if (instance == null) {
            instance = new ReviewManager();
        }
        return instance;
    }
}
