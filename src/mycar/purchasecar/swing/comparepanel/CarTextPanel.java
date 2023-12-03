package mycar.purchasecar.swing.comparepanel;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import mycar.Car;
import mycar.swing.tools.JLabelFont;
import mycar.ui.Palette;

public class CarTextPanel extends JPanel {

    JLabel carNameLabel;
    JLabel carPriceLabel;
    JLabel carOtionLabel;
    String carName, carPrice, carOptionRate;

    private void setting() {
        setPreferredSize(new Dimension(230, 160));
        setLayout(null);
    }

    private void makeGridBag(JComponent component, int x, int y, int w, int h) {
        component.setSize(w, h);
        component.setLocation(x, y);
        add(component);
    }

    private JLabel makeLabel(String string, int fontSize) {
        JLabel tempLabel = new JLabel(string);
        JLabelFont.setFont(tempLabel, fontSize);
        setOpaque(true);
        setBackground(Palette.secondPanel);
        setBorder(BorderFactory.createEmptyBorder(5, 10, 0, 5));

        return tempLabel;
    }

    public void updateLabel(Car car) {
        carName = car.getCarName();
        carPrice = Integer.toString(car.getCarPrice());
        carOptionRate = String.format("%.2f", car.getOptionRate());

        carNameLabel.setText(carName);
        carPriceLabel.setText("가격 : " + carPrice + "만원");
        carOtionLabel.setText("옵션 평점 : " + carOptionRate);
    }

    public CarTextPanel(Car car) {
        setting();
        if (car == null) {
            carName = "없음";
            carPrice = "없음";
            carOptionRate = "없음";
        } else {
            carName = car.getCarName();
            carPrice = Integer.toString(car.getCarPrice());
            carOptionRate = String.format("%.2f", car.getOptionRate());
        }
        carNameLabel = makeLabel(carName, 30);
        makeGridBag(carNameLabel, 15, 19, 218, 64);
        add(carNameLabel);

        carPriceLabel = makeLabel("가격 : " + carPrice + "만원", 20);
        carOtionLabel = makeLabel("옵션 평점 : " + carOptionRate, 20);
        makeGridBag(carPriceLabel, 15, 90, 218, 42);
        add(carPriceLabel);

        makeGridBag(carOtionLabel, 15, 139, 218, 42);
        add(carOtionLabel);
    }
}
