package mycar;

import java.awt.Color;
import java.awt.Font;
import javax.swing.AbstractListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class RecommendPanel extends JPanel {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    JTextField startPrice;
    JTextField endPrice;
    JTextField startYear;
    JTextField endYear;
    JTextField startPower;
    JTextField endPower;
    JTextField startFuelEffi;
    JTextField endFuelEffi;
    JLabel lblNewLabel_3;
    JLabel lblNewLabel_4;
    JLabel lblNewLabel_5;
    JLabel lblNewLabel_1_4;
    JList<String> list;

    /**
     * Create the panel.
     */
    public RecommendPanel() {
        this.setBackground(Color.LIGHT_GRAY);
        this.setBounds(0, 0, 1194, 761);
        this.setLayout(null);
        this.setVisible(false);

        JLabel lblNewLabel1 = new JLabel("차량 스펙 입력");
        lblNewLabel1.setFont(new Font("굴림", Font.BOLD, 40));
        lblNewLabel1.setBounds(433, 10, 359, 79);
        this.add(lblNewLabel1);

        startPrice = new JTextField();
        startPrice.setFont(new Font("굴림", Font.PLAIN, 20));
        startPrice.setText("0");
        startPrice.setBounds(12, 231, 145, 54);
        this.add(startPrice);
        startPrice.setColumns(10);

        endPrice = new JTextField();
        endPrice.setFont(new Font("굴림", Font.PLAIN, 20));
        endPrice.setText("9000");
        endPrice.setColumns(10);
        endPrice.setBounds(213, 231, 145, 54);
        this.add(endPrice);

        startYear = new JTextField();
        startYear.setFont(new Font("굴림", Font.PLAIN, 20));
        startYear.setText("1990");
        startYear.setColumns(10);
        startYear.setBounds(442, 231, 145, 54);
        this.add(startYear);

        endYear = new JTextField();
        endYear.setFont(new Font("굴림", Font.PLAIN, 20));
        endYear.setText("2030");
        endYear.setColumns(10);
        endYear.setBounds(668, 231, 145, 54);
        this.add(endYear);

        startPower = new JTextField();
        startPower.setFont(new Font("굴림", Font.PLAIN, 20));
        startPower.setText("0");
        startPower.setColumns(10);
        startPower.setBounds(442, 553, 145, 54);
        this.add(startPower);

        endPower = new JTextField();
        endPower.setFont(new Font("굴림", Font.PLAIN, 20));
        endPower.setText("800");
        endPower.setColumns(10);
        endPower.setBounds(668, 553, 145, 54);
        this.add(endPower);

        startFuelEffi = new JTextField();
        startFuelEffi.setFont(new Font("굴림", Font.PLAIN, 20));
        startFuelEffi.setText("0");
        startFuelEffi.setColumns(10);
        startFuelEffi.setBounds(12, 553, 145, 54);
        this.add(startFuelEffi);

        endFuelEffi = new JTextField();
        endFuelEffi.setFont(new Font("굴림", Font.PLAIN, 20));
        endFuelEffi.setText("500");
        endFuelEffi.setColumns(10);
        endFuelEffi.setBounds(213, 553, 145, 54);
        this.add(endFuelEffi);

        JLabel lblNewLabel_1 = new JLabel("선호 가격 범위");
        lblNewLabel_1.setBackground(Color.WHITE);
        lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 16));
        lblNewLabel_1.setBounds(125, 163, 145, 49);
        this.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("선호  연식 범위");
        lblNewLabel_1_1.setFont(new Font("굴림", Font.BOLD, 16));
        lblNewLabel_1_1.setBounds(560, 158, 145, 54);
        this.add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_2 = new JLabel("선호 연비 범위");
        lblNewLabel_1_2.setFont(new Font("굴림", Font.BOLD, 16));
        lblNewLabel_1_2.setBounds(125, 480, 145, 54);
        this.add(lblNewLabel_1_2);

        JLabel lblNewLabel_1_3 = new JLabel("출력(마력) 범위");
        lblNewLabel_1_3.setFont(new Font("굴림", Font.BOLD, 16));
        lblNewLabel_1_3.setBounds(560, 480, 145, 54);
        this.add(lblNewLabel_1_3);

        JLabel lblNewLabel_2 = new JLabel("  ~");
        lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 25));
        lblNewLabel_2.setBounds(157, 254, 57, 15);
        this.add(lblNewLabel_2);

        lblNewLabel_3 = new JLabel("  ~");
        lblNewLabel_3.setFont(new Font("Arial Black", Font.BOLD, 25));
        lblNewLabel_3.setBounds(599, 254, 57, 15);
        this.add(lblNewLabel_3);

        lblNewLabel_4 = new JLabel("  ~");
        lblNewLabel_4.setFont(new Font("Arial Black", Font.BOLD, 25));
        lblNewLabel_4.setBounds(157, 577, 57, 15);
        this.add(lblNewLabel_4);

        lblNewLabel_5 = new JLabel("  ~");
        lblNewLabel_5.setFont(new Font("Arial Black", Font.BOLD, 25));
        lblNewLabel_5.setBounds(599, 577, 57, 15);
        this.add(lblNewLabel_5);

        lblNewLabel_1_4 = new JLabel("연료 선택");
        lblNewLabel_1_4.setFont(new Font("굴림", Font.BOLD, 18));
        lblNewLabel_1_4.setBounds(983, 121, 89, 36);
        this.add(lblNewLabel_1_4);

        list = new JList<>();
        list.setFont(new Font("굴림", Font.BOLD, 60));
        list.setModel(new AbstractListModel() {
            String[] values = new String[] {"가솔린", "", "LPG", "", "디젤", "", "전기", "", "하이브리드"};
            public int getSize() {
                return values.length;
            }
            public Object getElementAt(int index) {
                return values[index];
            }
        });
        list.setBounds(851, 179, 317, 428);
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        this.add(list);
    }

}
