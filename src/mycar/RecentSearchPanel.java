package mycar;

import javax.swing.*;

import mycar.ui.Palette;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class RecentSearchPanel extends JPanel {
    private List<JButton> carButtons;
    private final int MAX_RECENT_SEARCHES = 5;
    private JTextField carCodeField; 
    private JPanel centerPanel;  // 차량 버튼들을 추가할 패널

    public RecentSearchPanel(JTextField carCodeField) {  
        this.setLayout(new BorderLayout()); 
        this.carButtons = new ArrayList<>();
        this.carCodeField = carCodeField;

        JLabel title = new JLabel("최근 검색한 차량");
        title.setFont(new Font("굴림", Font.BOLD, 20));
        title.setForeground(Color.black);
        title.setOpaque(true);  
        title.setBackground(Palette.button);
        title.setHorizontalAlignment(JLabel.CENTER);  // 라벨을 가운데 정렬
        this.add(title, BorderLayout.NORTH);


        this.centerPanel = new JPanel();
        this.centerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.centerPanel.setBackground(Palette.button);  // centerPanel의 배경색 설정
        this.add(this.centerPanel, BorderLayout.CENTER);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    }

    public void updatePanel(String carCode) {
        for (JButton existingButton : carButtons) {
            if (existingButton.getText().equals(carCode)) {
                // 이미 검색한 차량 코드라면 메소드를 종료합니다.
                return;
            }
        }
        if (carButtons.size() == MAX_RECENT_SEARCHES) {
            this.centerPanel.remove(carButtons.get(MAX_RECENT_SEARCHES - 1));  // 가장 오래된 차량 제거
            carButtons.remove(MAX_RECENT_SEARCHES - 1);
        }

        JButton carButton = new JButton(carCode);
        carButton.setForeground(Color.black);  
        carButton.setBackground(Palette.button);  
        carButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carCodeField.setText(carCode);  // 버튼 클릭 시 텍스트 필드에 해당 차량 코드를 입력
            }
        });
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(100, 25));  // 원하는 크기로 설정
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(carButton);

        this.centerPanel.add(buttonPanel, 0);  // 차량을 centerPanel의 맨 앞에 추가
        carButtons.add(0, carButton);  // 차량을 리스트의 맨 앞에 추가
        
        this.revalidate();
        this.repaint();
    }
}
