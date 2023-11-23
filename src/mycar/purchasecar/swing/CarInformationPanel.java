package mycar.purchasecar.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import mycar.Car;
import mycar.swing.tools.JLabelFont;
import mycar.swing.tools.LoadImage;

public class CarInformationPanel extends JPanel {

    class CarTextPanel extends JPanel {

        private void setting() {
            setPreferredSize(new Dimension(230, 160));
            setLayout(new GridLayout(2, 1));
        }

        private JLabel makeLabel(String string, int fontSize) {
            JLabel tempLabel = new JLabel(string);
            JLabelFont.setFont(tempLabel, fontSize);
            setOpaque(true);
            setBackground(new Color(0x7ea0b7));
            setBorder(BorderFactory.createEmptyBorder(5, 10, 0, 5));

            return tempLabel;
        }

        public CarTextPanel(Car car) {
            setting();
            String carName = (car == null) ? "없음" : car.getCarName();
            JLabel carNameLabel = makeLabel(carName, 20);
            //TODO: 자동차 정보 어떻게 받을건지 정하기
            JLabel carInformationLabel = makeLabel("자동차 정보 예시", 15);
            add(carNameLabel);
            add(carInformationLabel);
        }
    }

    private void setting() {
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    }

    public CarInformationPanel(Car car) {
        setting();

        JPanel carImagePanel = new LoadImage("../../../images/none.png", 160, 160);
        add(carImagePanel);
        JPanel carTextPanel = new CarTextPanel(car);
        add(carTextPanel);

    }
}
