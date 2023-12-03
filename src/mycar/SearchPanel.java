package mycar;

import javax.swing.*;
import manager.CarStoreManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SearchPanel extends JPanel {
    JTextField carCodeField;
    JTextArea resultArea;
    JButton searchButton;
    MyCarProgram mcp;
    CarStoreListPanel carStoreListPanel;
    public SearchPanel(MyCarProgram mcp, CarStoreListPanel carStoreListPanel) {
        this.mcp = mcp;
        this.carStoreListPanel = carStoreListPanel;
        this.setBackground(new Color(255, 255, 255));
        this.setBounds(0, 0, 964, 523);
        this.setLayout(null);
        this.setVisible(false);

        JLabel lblNewLabel_1 = new JLabel("Enter car code");
        lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 30));
        lblNewLabel_1.setBounds(359, 10, 244, 60);
        this.add(lblNewLabel_1);

        carCodeField = new JTextField();
        carCodeField.setBounds((964-232)/2, 167, 232, 28); 
        this.add(carCodeField);
        carCodeField.setColumns(10);

        searchButton = new JButton("Search");
        searchButton.setBounds((964-232)/2, 217, 232, 35);  
        this.add(searchButton);

        resultArea = new JTextArea();
        resultArea.setBounds((964-910)/2, 267, 910, 246);  
        this.add(resultArea);

        addSearchButtonListener();
    }

    private void addSearchButtonListener() {
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String carCode = carCodeField.getText();
                Car findingCar = mcp.findCar(carCode);
                if (findingCar != null) {
                    ArrayList<Object[]> rows = new ArrayList<>();
                    boolean carExists = false;
                    for (CarStore store : CarStoreManager.getInstance().mList) {
                        if (store.haveCar(findingCar)) {
                            carExists = true;
                            rows.add(new Object[]{store.name, store.location, store.carList.get(findingCar)});
                        }
                    }
                    if (carExists) {
                        carStoreListPanel.updateTableData(rows.toArray(new Object[0][]));
                        carStoreListPanel.setVisible(true);
                        SearchPanel.this.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "해당 차량은 현재 전국 매장에 존재하지 않습니다.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "차량 코드가 잘못되었습니다. 다시 입력해주세요.");
                }
            }
        });
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> branch 'branch1' of https://github.com/hoyadong1/MyCarProject.git
