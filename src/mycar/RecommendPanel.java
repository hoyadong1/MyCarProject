package mycar;

import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.AbstractListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import mycar.ui.Palette;

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
    private JPanel panel;

    /**
     * Create the panel.
     */
    public RecommendPanel() {
        this.setBackground(Palette.background);
        this.setBounds(0, 0, 1194, 761);
        this.setLayout(null);
        this.setVisible(false);

        LineBorder border = new LineBorder(Color.black, 5);
        LineBorder labelBorder = new LineBorder(Color.black, 2);

        JLabel lblNewLabel1 = new JLabel("차량 스펙 입력");
        lblNewLabel1.setFont(new Font("굴림", Font.BOLD, 40));
        lblNewLabel1.setBounds(433, 10, 284, 79);
        lblNewLabel1.setBorder(border);
        this.add(lblNewLabel1);

        lblNewLabel_1_4 = new JLabel("연료 선택");
        lblNewLabel_1_4.setFont(new Font("굴림", Font.BOLD, 18));
        lblNewLabel_1_4.setBounds(967, 133, 86, 36);
        lblNewLabel_1_4.setBorder(labelBorder);
        this.add(lblNewLabel_1_4);

        list = new JList<>();
        list.setBorder(new LineBorder(Color.DARK_GRAY, 3));
        list.setBackground(Palette.listNotSelect);
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

        panel = new JPanel();
        panel.setBackground(Palette.firstPanel);
        panel.setBounds(23, 179, 811, 428);
        panel.setBorder(labelBorder);
        add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("선호 가격 범위");
        lblNewLabel_1.setBounds(152, 33, 117, 49);
        panel.add(lblNewLabel_1);
        lblNewLabel_1.setBackground(Color.WHITE);
        lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 16));
        lblNewLabel_1.setBorder(labelBorder);

        startPrice = new JTextField();
        startPrice.setBounds(44, 114, 145, 54);
        startPrice.setBackground(Color.decode("#C4FFF9"));
        panel.add(startPrice);
        startPrice.setFont(new Font("굴림", Font.BOLD, 20));
        startPrice.setText("0");
        startPrice.setColumns(10);

        endPrice = new JTextField();
        endPrice.setBounds(236, 114, 145, 54);
        panel.add(endPrice);
        endPrice.setBackground(Color.decode("#C4FFF9"));
        endPrice.setFont(new Font("굴림", Font.BOLD, 20));
        endPrice.setText("9000");
        endPrice.setColumns(10);

        JLabel lblNewLabel_1_1 = new JLabel("선호  연식 범위");
        lblNewLabel_1_1.setBounds(540, 30, 122, 54);
        panel.add(lblNewLabel_1_1);
        lblNewLabel_1_1.setFont(new Font("굴림", Font.BOLD, 16));
        lblNewLabel_1_1.setBorder(labelBorder);

        JLabel lblNewLabel_1_2 = new JLabel("선호 연비 범위");
        lblNewLabel_1_2.setBounds(152, 278, 117, 54);
        panel.add(lblNewLabel_1_2);
        lblNewLabel_1_2.setFont(new Font("굴림", Font.BOLD, 16));
        lblNewLabel_1_2.setBorder(labelBorder);

        startFuelEffi = new JTextField();
        startFuelEffi.setBounds(44, 364, 145, 54);
        panel.add(startFuelEffi);
        startFuelEffi.setBackground(Color.decode("#C4FFF9"));
        startFuelEffi.setFont(new Font("굴림", Font.BOLD, 20));
        startFuelEffi.setText("0");
        startFuelEffi.setColumns(10);

        endFuelEffi = new JTextField();
        endFuelEffi.setBounds(236, 364, 145, 54);
        panel.add(endFuelEffi);
        endFuelEffi.setBackground(Color.decode("#C4FFF9"));
        endFuelEffi.setFont(new Font("굴림", Font.BOLD, 20));
        endFuelEffi.setText("500");
        endFuelEffi.setColumns(10);

        JLabel lblNewLabel_1_3 = new JLabel("출력(마력) 범위");
        lblNewLabel_1_3.setBounds(540, 278, 122, 54);
        panel.add(lblNewLabel_1_3);
        lblNewLabel_1_3.setFont(new Font("굴림", Font.BOLD, 16));
        lblNewLabel_1_3.setBorder(labelBorder);

        startPower = new JTextField();
        startPower.setBounds(438, 364, 145, 54);
        panel.add(startPower);
        startPower.setBackground(Color.decode("#C4FFF9"));
        startPower.setFont(new Font("굴림", Font.BOLD, 20));
        startPower.setText("0");
        startPower.setColumns(10);

        endPower = new JTextField();
        endPower.setBounds(632, 364, 145, 54);
        panel.add(endPower);
        endPower.setBackground(Color.decode("#C4FFF9"));
        endPower.setFont(new Font("굴림", Font.BOLD, 20));
        endPower.setText("800");
        endPower.setColumns(10);

        startYear = new JTextField();
        startYear.setBounds(438, 114, 145, 54);
        panel.add(startYear);
        startYear.setBackground(Color.decode("#C4FFF9"));
        startYear.setFont(new Font("굴림", Font.BOLD, 20));
        startYear.setText("1990");
        startYear.setColumns(10);

        endYear = new JTextField();
        endYear.setBounds(632, 114, 145, 54);
        panel.add(endYear);
        endYear.setBackground(Color.decode("#C4FFF9"));
        endYear.setFont(new Font("굴림", Font.BOLD, 20));
        endYear.setText("2030");
        endYear.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("  ~");
        lblNewLabel_2.setBounds(189, 380, 57, 15);
        panel.add(lblNewLabel_2);
        lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 25));

        lblNewLabel_3 = new JLabel("  ~");
        lblNewLabel_3.setBounds(583, 130, 57, 15);
        panel.add(lblNewLabel_3);
        lblNewLabel_3.setFont(new Font("Arial Black", Font.BOLD, 25));

        lblNewLabel_4 = new JLabel("  ~");
        lblNewLabel_4.setBounds(583, 380, 57, 15);
        panel.add(lblNewLabel_4);
        lblNewLabel_4.setFont(new Font("Arial Black", Font.BOLD, 25));

        lblNewLabel_5 = new JLabel("  ~");
        lblNewLabel_5.setBounds(189, 130, 47, 15);
        panel.add(lblNewLabel_5);
        lblNewLabel_5.setFont(new Font("Arial Black", Font.BOLD, 25));
    }

}