package mycar.purchasecar.swing.comparepanel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import mycar.Car;
import mycar.ui.Palette;

public class CarOptionListPanel extends JPanel {

    DefaultListModel<String> purchaseCarOptionModel = new DefaultListModel<>();

    private void setting() {
        setLayout(null);
        setBackground(Palette.firstPanel);
        setPreferredSize(new Dimension(474, 282));
        setBorder(new LineBorder(Color.black, 2));
    }

    private void addList(Car car) {
        purchaseCarOptionModel.clear();
        if (car != null) {
            for (String optionName : car.getOptionListName()) {
                purchaseCarOptionModel.addElement(optionName);
            }
        } else {
            purchaseCarOptionModel.addElement("없음");
        }
    }

    public void updateCar(Car car) {
        System.out.println("list update");
        addList(car);
    }

    private JList<String> makeList(Car car) {
        addList(car);
        JList<String> tempJList;
        tempJList = new JList<>(purchaseCarOptionModel);
        tempJList.setPreferredSize(new Dimension(380, 260));
        tempJList.setBorder(new LineBorder(Color.black, 1));
        tempJList.setCellRenderer(new CustomListCellRenderer());
        return tempJList;
    }

    private static class CustomListCellRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index,
            boolean isSelected, boolean cellHasFocus) {
            // 부모 클래스의 기본 렌더러 호출
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            Border lineBorder = BorderFactory.createLineBorder(Color.BLACK);
            Border emptyBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
            setBorder(BorderFactory.createCompoundBorder(lineBorder, emptyBorder));
            setPreferredSize(new Dimension(getPreferredSize().width, 30));
            if (isSelected) {
                setBackground(Palette.listSelect); // 선택할 때의 배경색
                setForeground(Color.WHITE); // 선택할 때의 전경색
            } else {
                setBackground(Palette.listNotSelect);
            }
            return this;
        }
    }

    public CarOptionListPanel(Car car) {
        setting();
        JList<String> purchaseCarOptionList = makeList(car);
        purchaseCarOptionList.setSize(new Dimension(474, 282));
        purchaseCarOptionList.setLocation(21, 21);
        add(purchaseCarOptionList);
    }
}
