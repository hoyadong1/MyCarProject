package mycar.purchasecar.swing.comparepanel;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import mycar.Car;
import mycar.User;
import mycar.purchasecar.swing.MainPanel;

public class CarComparePanel extends JPanel {

    GridBagConstraints gridBagConstraints = new GridBagConstraints();
    GridBagLayout gridBagLayout = new GridBagLayout();
    Car userMadeCar = null, basketCar = null;
    CarPanel userMadeCarPanel, basketCarPanel;
    private static List<String> carList = new ArrayList<>();

    private void setting() {
        setLayout(null);
        this.setBackground(new Color(133, 160, 222, 103));

    }

    public void getObject(Car car1, Car car2) {
        userMadeCar = car1;
        basketCar = car2;
    }

    private void makeGridBag(JComponent component, int x, int y, int w, int h) {
        component.setSize(w, h);
        component.setLocation(x, y);
        add(component);
    }

    private class CarPanel extends JPanel {

        CarInformationPanel informationPanel;
        CarOptionListPanel optionListPanel;

        private void setting() {
            setLayout(null);
            setBackground(new Color(0x000A18));
            setBorder(new LineBorder(Color.black, 2));
        }

        private void makeGridBag(JComponent component, int x, int y, int w, int h) {
            component.setSize(w, h);
            component.setLocation(x, y);
            add(component);
        }

        public void updateCar(Car car) {
            informationPanel.updateCar(car);
        }

        public CarPanel(Car car) {
            setting();
            informationPanel = new CarInformationPanel(car);
            makeGridBag(informationPanel, 0, 0, 516, 258);

            optionListPanel = new CarOptionListPanel(car);
            makeGridBag(optionListPanel, 0, 258, 516, 325);
        }
    }

    private void showListPopup() {
        for (Car car : User.getInstance().getList()) {
            carList.add(car.getCarName());
        }
        String[] options = carList.toArray(new String[0]);

        JList<String> list = new JList<>(options);
        JScrollPane scrollPane = new JScrollPane(list);

        int result = JOptionPane.showOptionDialog(
            null,
            scrollPane,
            "리스트 선택",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.PLAIN_MESSAGE,
            null,
            null,
            null);

        if (result == JOptionPane.OK_OPTION) {
            // 사용자가 OK 버튼을 눌렀을 때 선택된 항목 출력
            String selectedOption = list.getSelectedValue();
            if (selectedOption != null) {
                basketCar = User.getInstance().findCar(selectedOption);
                basketCarPanel.updateCar(basketCar);
            } else {
                System.out.println("선택된 항목이 없습니다.");
            }
        } else {
            System.out.println("사용자가 선택을 취소했습니다.");
        }
    }

    private void back() {
        MainPanel.getInstance().showPanel("panel2");
    }

    private void next() {

    }

    public CarComparePanel(Car userMadeCar, Car basketCar) {
        setting();

        userMadeCarPanel = new CarPanel(userMadeCar);
        makeGridBag(userMadeCarPanel, 51, 63, 516, 583);

        basketCarPanel = new CarPanel(basketCar);
        makeGridBag(basketCarPanel, 633, 63, 516, 583);

        JButton backButton = new JButton("back");
        makeGridBag(backButton, 51, 687, 237, 60);
        backButton.addActionListener(e -> back());

        JButton listButton = new JButton("List");
        makeGridBag(listButton, 633, 687, 237, 60);
        listButton.addActionListener(e -> showListPopup());

        JButton nextButton = new JButton("next");
        makeGridBag(nextButton, 912, 687, 237, 60);
    }
}
