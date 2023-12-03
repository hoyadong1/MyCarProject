package mycar.purchasecar.swing.comparepanel;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import mycar.Car;
import mycar.swing.tools.LoadImage;
import mycar.ui.Palette;

public class CarInformationPanel extends JPanel {

    JPanel carImagePanel;
    CarTextPanel carTextPanel;

    private void setting() {
        setLayout(null);
        setPreferredSize(new Dimension(516, 258));
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setBorder(new LineBorder(Color.black, 2));
        setBackground(Palette.firstPanel);
    }

    private void makeLayout(JComponent component, int x, int y, int w, int h) {
        component.setSize(w, h);
        component.setLocation(x, y);
        add(component);
    }

    public void updateCar(Car car) {
        carTextPanel.updateLabel(car);
    }

    public CarInformationPanel(Car car) {
        setting();

        carImagePanel = new LoadImage("../../../images/none.png", 200, 200);
        makeLayout(carImagePanel, 24, 29, 200, 200);
        carTextPanel = new CarTextPanel(car);
        makeLayout(carTextPanel, 244, 29, 248, 200);

    }
}
