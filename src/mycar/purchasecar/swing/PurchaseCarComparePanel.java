package mycar.purchasecar.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import mycar.Car;

public class PurchaseCarComparePanel extends JPanel {

    GridBagConstraints gridBagConstraints = new GridBagConstraints();
    GridBagLayout gridBagLayout = new GridBagLayout();

    private void setting() {
        setLayout(gridBagLayout);
        this.setBackground(new Color(215, 157, 157));
        gridBagConstraints.fill = GridBagConstraints.BOTH;

    }

    private void makeGridBag(JComponent c, int x, int y, int w, int h) {
        gridBagConstraints.gridx = x;
        gridBagConstraints.gridy = y;
        gridBagConstraints.gridwidth = w;
        gridBagConstraints.gridheight = h;

        gridBagLayout.setConstraints(c, gridBagConstraints);

    }

    public PurchaseCarComparePanel(Car userMadeCar, Car basketCar) {
        setting();

        JPanel userMadeCarPanel = new CarInformationPanel(userMadeCar);
        makeGridBag(userMadeCarPanel, 0, 0, 40, 16);
        add(userMadeCarPanel, gridBagConstraints);

        JPanel userMadeCarList = new CarOptionListPanel(userMadeCar);
        makeGridBag(userMadeCarList, 0, 16, 40, 28);
        add(userMadeCarList, gridBagConstraints);

        JPanel nonePanel = new JPanel();
        nonePanel.setPreferredSize(new Dimension(40, 460));
        makeGridBag(nonePanel, 40, 0, 4, 46);
        gridBagConstraints.weighty = 0.1;
        add(nonePanel, gridBagConstraints);

        JPanel basketCarPanel = new CarInformationPanel(basketCar);
        makeGridBag(basketCarPanel, 44, 0, 40, 16);
        add(basketCarPanel, gridBagConstraints);

        JPanel basketCarList = new CarOptionListPanel(basketCar);
        makeGridBag(basketCarList, 44, 16, 40, 28);
        add(basketCarList, gridBagConstraints);

        JButton backButton = new JButton("back");
        backButton.setPreferredSize(new Dimension(60, 40));
        makeGridBag(backButton, 44, 44, 20, 4);
        add(backButton);

        JButton nextButton = new JButton("next");
        nonePanel.setPreferredSize(new Dimension(6, 40));
        makeGridBag(nextButton, 64, 44, 20, 4);
        add(nextButton);
    }
}
