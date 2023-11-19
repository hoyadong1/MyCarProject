package mycar.purchasecar.swing;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import mycar.Car;
import mycar.Option;

public class PurchaseCarResult extends JPanel {
    private JList<String> purchaseCarOptionList;
    private JList<String> purchaseCarOptionList2;
    private DefaultListModel<String> purchaseCarOptionModel;
    //private DefaultListModel<String> purchaseCarOptionModel2;

    private JList<String> makeList(Car car){
        purchaseCarOptionModel = new DefaultListModel<>();

        for(String optionName : car.getOptionListName()){
            purchaseCarOptionModel.addElement(optionName);
        }
        JList<String> tempJList;
        tempJList = new JList<>(purchaseCarOptionModel);
        return tempJList;
    }

    public PurchaseCarResult(Car userMadeCar){
        purchaseCarOptionList = makeList(userMadeCar);
        this.add(purchaseCarOptionList);
    }
}
