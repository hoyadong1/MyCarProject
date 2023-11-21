package mycar.purchasecar.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import mycar.Car;

public class PurchaseCarResult extends JPanel {

    public PurchaseCarResult(Car userMadeCar, Car basketCar) {
        //setLayout(new GridLayout(5,2));
        setLayout(new BorderLayout());

        //-----setting----
        this.setBackground(new Color(215, 157, 157));
        //-----header----
        String userMadeCarName = userMadeCar.getCarName();
        String basketCarName = (basketCar == null) ? "없음" : basketCar.getCarName();
        JPanel carNamePanel = new CarNamePanel(userMadeCarName, basketCarName);
        this.add(carNamePanel, BorderLayout.NORTH);

        //------body-------
        JPanel purchaseCarOptionPanel = new CarOptionListPanel(userMadeCar);
        add(purchaseCarOptionPanel, BorderLayout.WEST);

        JLabel lblCarRepairEstimate = new JLabel("");
        JLabelFont.setFont(lblCarRepairEstimate, 30);
        lblCarRepairEstimate.setBounds(555, 485, 167, 15);
        this.add(lblCarRepairEstimate);

        JPanel purchaseBasketCarOptionPanel = new CarOptionListPanel(basketCar);
        add(purchaseBasketCarOptionPanel, BorderLayout.EAST);

        //-----footer----
        JPanel carOptionComparePanel = new CarOptionComparePanel(userMadeCar, basketCar);
        add(carOptionComparePanel, BorderLayout.SOUTH);
    }
}
