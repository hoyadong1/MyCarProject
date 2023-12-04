package mycar;

import javax.swing.*;
import manager.CarStoreManager;
import mycar.ui.Palette;
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
    RecentSearchPanel recentSearchPanel;

    public SearchPanel(MyCarProgram mcp, CarStoreListPanel carStoreListPanel) {
        this.mcp = mcp;
        this.carStoreListPanel = carStoreListPanel;

        this.setBackground(Palette.background); 

        this.setBounds(0, 0, 1200, 800);
        this.setLayout(null);
        this.setVisible(false);

        carCodeField = new JTextField();
        carCodeField.setBounds((1200 - 232) / 2, 167, 232, 28); 
        this.add(carCodeField);

        this.recentSearchPanel = new RecentSearchPanel(carCodeField);
        this.recentSearchPanel.setBounds(0, 600, 600, 200); 
        this.recentSearchPanel.setBackground(Palette.firstPanel);  
        this.recentSearchPanel.setVisible(false); // 초기에는 패널이 보이지 않도록 설정
        this.add(recentSearchPanel);
        
        JLabel lblNewLabel_1 = new JLabel("찾고싶은 차량의 차량 코드를 입력하시오");
        lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 20)); 
        lblNewLabel_1.setBounds((1200 - 400) / 2, 10, 400, 60); 
        lblNewLabel_1.setHorizontalAlignment(JLabel.CENTER); 
        lblNewLabel_1.setVerticalAlignment(JLabel.CENTER); 
        this.add(lblNewLabel_1);
        
        searchButton = new JButton("Search");
        searchButton.setBounds((1200 - 232) / 2, 217, 232, 35);  
        searchButton.setBackground(Palette.button);  
        this.add(searchButton);

        resultArea = new JTextArea();
        resultArea.setBounds((964-910)/2, 267, 910, 246);  
        resultArea.setBackground(Palette.background);  
        addSearchButtonListener();
    }
    
    public void showRecentSearchPanel() {
        this.recentSearchPanel.setVisible(true);
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
                            rows.add(new Object[]{carCode,store.name, store.location, store.carList.get(findingCar)});
                        }
                    }
                    carCodeField.setText("");
                    if (carExists) {
                        carStoreListPanel.updateTableData(rows.toArray(new Object[0][]));
                        carStoreListPanel.setVisible(true);
                        SearchPanel.this.setVisible(false);
                        recentSearchPanel.updatePanel(carCode); // 이전 검색 결과를 업데이트
                        recentSearchPanel.setVisible(true); // RecentSearchPanel을 보이게 
                    } else {
                        JOptionPane.showMessageDialog(null, "해당 차량은 현재 전국 매장에 존재하지 않습니다.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "차량 코드가 잘못되었습니다. 다시 입력해주세요.");
                }
            }
        });
    }
}