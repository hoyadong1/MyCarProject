package mycar.purchasecar.swing;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import mycar.Car;

public class CarOptionListPanel extends JPanel {

    private JList<String> makeList(Car car) {
        DefaultListModel<String> purchaseCarOptionModel = new DefaultListModel<>();
        if (car != null) {
            for (String optionName : car.getOptionListName()) {
                purchaseCarOptionModel.addElement(optionName);
            }
        } else {
            purchaseCarOptionModel.addElement("없음");
        }
        JList<String> tempJList;
        tempJList = new JList<>(purchaseCarOptionModel);
        tempJList.setPreferredSize(new Dimension(350, 200));
        return tempJList;
    }

    public CarOptionListPanel(Car car) {
        //----set-----
        setBackground(new Color(88, 88, 241));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JList<String> purchaseCarOptionList = makeList(car);
        add(purchaseCarOptionList);
    }
}
