package mycar.purchasecar.swing;

import javax.swing.JLabel;
import javax.swing.JPanel;
import mycar.Car;

public class CarOptionComparePanel extends JPanel {

    private void compareCarOption(Car madeCar, Car basketCar) {

    }

    private void priceCompareLabel() {

    }

    class PriceCompare extends JLabel {

        public PriceCompare(int madeCarPrice, int basketCarPrice) {
            int gap = Math.abs(madeCarPrice - basketCarPrice);
            setText((madeCarPrice > basketCarPrice) ?
                String.format("<html>가격비교 : <b>%d원</b> vs %d원 || 차이값 :%d원</html>", madeCarPrice,
                    basketCarPrice, gap) :
                String.format("<html>가격비교 : %d원 vs <b>%d원</b> || 차이값 :%d원</html>", madeCarPrice,
                    basketCarPrice, gap));
        }
    }

    public CarOptionComparePanel(Car madeCar, Car basketCar) {

        int madeCarPrice = madeCar.getCarPrice();
        int basketCarPrice = (basketCar == null) ?
            0 :
            basketCar.getCarPrice();
        JLabel priceCompareLabel = new PriceCompare(madeCarPrice, basketCarPrice);
        add(priceCompareLabel);
    }
}
