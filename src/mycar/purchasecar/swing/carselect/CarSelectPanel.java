package mycar.purchasecar.swing.carselect;

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
import mycar.purchasecar.swing.MainPanel;
import mycar.selectoption.swing.CarOptionSelect;
import mycar.swing.tools.JLabelFont;
import mycar.swing.tools.LoadImage;
import mycar.ui.Palette;
import mycar.Start1;
public class CarSelectPanel extends JPanel {

    private Car selectCar = null;
    JButton backButton;
    JLabel carName;
    CarInfoPanel carInfo;

    ButtonClickListener buttonClickListener = new ButtonClickListener();

    private void setting() {
        setLayout(null);
        setBackground(Palette.background);
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
            if (!e.getValueIsAdjusting()) {
                String selectCarName = tempJList.getSelectedValue();
                selectCar = MyCarProgram.findCar(selectCarName);
                selectCar.removeOption();
                carInfo.updateImage(selectCar.getCarCode(),selectCar.getCarName());
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
                setBackground(Palette.listSelect); // 선택할 때의 배경색
                setForeground(Color.BLACK); // 선택할 때의 전경색
            } else {
                setBackground(Palette.listNotSelect);
            }
            return this;
        }
    }

    class CarInfoPanel extends JPanel {

        public void updateImage(String code, String name){
            removeAll();
            if(code.equals("")){
                JPanel carImgPanel = new LoadImage("../../../images/none.png", 240, 240);
                carImgPanel.setBorder(new LineBorder(Color.black, 2));
                carImgPanel.setLocation(47, 76);
                carImgPanel.setSize(240, 240);
                add(carImgPanel);
            }
            else {
                JPanel carImgPanel = new LoadImage("../../../images/"+code+"_front.jpg", 240, 240);
                carImgPanel.setBorder(new LineBorder(Color.black, 2));
                carImgPanel.setLocation(47, 76);
                carImgPanel.setSize(240, 240);
                add(carImgPanel);
            }
            update();
            carName.setText(name);
            revalidate();
            repaint();
        }
        private void setting() {
            setLayout(null);
            setPreferredSize(new Dimension(540, 400));
            setBackground(Palette.firstPanel);
            setBorder(new LineBorder(Color.black, 2));
        }
        private void update(){

            carName = new JLabel("없음");
            carName.setLocation(309, 165);
            carName.setSize(200, 62);
            JLabelFont.setFont(carName, 30);
            add(carName);
        }
        public CarInfoPanel() {
            setting();
            updateImage("","없음");
            update();
        }
    }

    class ButtonClickListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            CarOptionSelect carOptionSelect = new CarOptionSelect(selectCar);
            MainPanel.getInstance().add(carOptionSelect, "panel2");
            MainPanel.getInstance().showPanel("panel2");

        }
    }

    public CarSelectPanel() {
        setting();
        JList<String> carList = makeList();
        carList.setSize(466, 664);
        carList.setLocation(67, 68);
        add(carList);

        carInfo = new CarInfoPanel();
        carInfo.setSize(540, 400);
        carInfo.setLocation(600, 140);
        add(carInfo);

        backButton = new JButton("back");
        backButton.setSize(179, 62);
        backButton.setLocation(647, 598);
        backButton.addActionListener(e -> Start1.showMain());
        add(backButton);

        JButton frontButton = new JButton("next");
        frontButton.setSize(179, 62);
        frontButton.setLocation(909, 598);
        frontButton.addActionListener(buttonClickListener);
        add(frontButton);
    }
}
