package mycar.review.swing;

import javax.swing.JPanel;
import mycar.Option;

public class ReviewMainPanel extends JPanel {

    public ReviewMainPanel(Option option) {
        JPanel optionDataPanel = new OptionDataPanel(option);
        add(optionDataPanel);
    }
}
