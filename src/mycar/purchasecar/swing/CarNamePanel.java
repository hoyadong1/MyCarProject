package mycar.purchasecar.swing;

import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class CarNamePanel extends JPanel {

    private JLabel makeJlabel(String carName) {
        JLabel label = new JLabel(carName);
        JLabelFont.setFont(label, 12);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return label;
    }

    public CarNamePanel(String userMadeCarName, String basketCarName) {

        setLayout(new GridLayout(1, 2));

        JLabel userMadeCarNameLabel = makeJlabel(userMadeCarName);
        this.add(userMadeCarNameLabel);

        JLabel basketCarNameLabel = makeJlabel(basketCarName);
        this.add(basketCarNameLabel);
    }
}
