package mycar.purchasecar.swing;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import mycar.Car;

public class CarOptionListPanel extends JPanel {

    private void setting() {
        setBackground(new Color(88, 88, 241));
        setPreferredSize(new Dimension(400, 280));
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    }

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
        tempJList.setPreferredSize(new Dimension(380, 260));
        return tempJList;
    }

    public CarOptionListPanel(Car car) {
        //----set-----
        setting();
        JList<String> purchaseCarOptionList = makeList(car);
        add(purchaseCarOptionList);
    }
}
