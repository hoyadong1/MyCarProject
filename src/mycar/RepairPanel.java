package mycar;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.*;


public class RepairPanel extends JPanel{
    private static final long serialVersionUID = 1L;
    JTextField repairCode;
    public RepairPanel() {
        this.setBackground(Color.LIGHT_GRAY);
        this.setBounds(0, 0, 1194, 761);
        this.setLayout(null);
        this.setVisible(false);

        JButton engine = new JButton("");
        engine.setIcon(new ImageIcon("./images/engine.jpg"));
        engine.setBounds(433, 450, 383, 218);
        add(engine);

        // 기능 제목
        JLabel lblNewLabel1 = new JLabel("enter part codes");
        lblNewLabel1.setFont(new Font("굴림", Font.BOLD, 40));
        lblNewLabel1.setBounds(433, 10, 500, 79);
        this.add(lblNewLabel1);

        // 부품코드 입력
        repairCode = new JTextField();
        repairCode.setText("");
        repairCode.setBounds(405, 250, 84, 28);
        this.add(repairCode);
        repairCode.setColumns(10);

        // 부품코드 입력부 설명
        JLabel lblNewLabel_1 = new JLabel("repair codes");
        lblNewLabel_1.setBounds(385, 200, 200, 36);
        lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 20));
        this.add(lblNewLabel_1);
    }
}