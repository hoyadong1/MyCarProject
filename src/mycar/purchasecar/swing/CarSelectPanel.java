package mycar.purchasecar.swing;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import manager.CarManager;
import mycar.Car;
import mycar.MyCarProgram;
import mycar.swing.tools.JLabelFont;
import mycar.swing.tools.LoadImage;

public class CarSelectPanel extends JPanel {

    private Car selectCar = null;
    JLabel carName;
    ButtonClickListener buttonClickListener = new ButtonClickListener();

    private void setting() {
        setLayout(null);
        setBackground(new Color(0xE8F1E8));
    }


    private JList<String> makeList() {
        DefaultListModel<String> listModel = new DefaultListModel<>();

        JList<String> tempJList;
        HashSet<String> carType = new HashSet<>();
        for (Car car : CarManager.getInstance().mList) {
            carType.add(car.getCarName());
        }
        for (String carName : carType) {
            listModel.addElement(carName);
        }

        tempJList = new JList<>(listModel);
        tempJList.setPreferredSize(new Dimension(500, 700));
        tempJList.setBorder(new LineBorder(Color.black, 2));
        tempJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tempJList.setCellRenderer(new CustomListCellRenderer());
        tempJList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) { // 이벤트가 두 번 발생하는 것을 방지
                // 선택된 아이템 가져오기
                String selectCarName = tempJList.getSelectedValue();
                selectCar = MyCarProgram.findCar(selectCarName);
                carName.setText(selectCar.getCarName());
                System.out.println(selectCar.getCarName());
            }
        });
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
                setBackground(new Color(0x55ABE3)); // 선택할 때의 배경색
                setForeground(Color.WHITE); // 선택할 때의 전경색
            } else {
                setBackground(new Color(0xDAE6EE));
            }
            return this;
        }
    }

    class CarInfoPanel extends JPanel {

        private void setting() {
            setLayout(null);
            setPreferredSize(new Dimension(540, 400));
            setBackground(new Color(0x5F738A));
            setBorder(new LineBorder(Color.black, 2));
        }

        public CarInfoPanel() {
            setting();

            JPanel carImgPanel = new LoadImage("../../../images/none.png", 240, 240);
            carImgPanel.setBorder(new LineBorder(Color.black, 2));
            carImgPanel.setLocation(47, 76);
            carImgPanel.setSize(240, 240);
            add(carImgPanel);

            carName = new JLabel("없음");
            carName.setLocation(309, 165);
            carName.setSize(200, 62);
            JLabelFont.setFont(carName, 30);
            add(carName);
        }
    }

    class ButtonClickListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //CarOptionSelect.processButtonClick(selectCar);

        }
    }

    public CarSelectPanel() {
        setting();
        JList<String> carList = makeList();
        carList.setSize(466, 664);
        carList.setLocation(67, 68);
        add(carList);

        JPanel carInfo = new CarInfoPanel();
        carInfo.setSize(540, 400);
        carInfo.setLocation(600, 140);
        add(carInfo);

        JButton backButton = new JButton("back");
        backButton.setSize(179, 62);
        backButton.setLocation(647, 598);
        add(backButton);

        JButton frontButton = new JButton("next");
        frontButton.setSize(179, 62);
        frontButton.setLocation(909, 598);
        frontButton.addActionListener(buttonClickListener);
        add(frontButton);
    }
}
