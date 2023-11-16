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
        this.setBackground(new Color(255, 255, 255));
        this.setBounds(0, 0, 964, 523);
        this.setLayout(null);
        this.setVisible(false);

        JLabel lblNewLabel1 = new JLabel("enter car sepcs");
        lblNewLabel1.setFont(new Font("굴림", Font.BOLD, 30));
        lblNewLabel1.setBounds(359, 10, 244, 60);
        this.add(lblNewLabel1);

        startPrice = new JTextField();
        startPrice.setText("0");
        startPrice.setBounds(27, 167, 84, 28);
        this.add(startPrice);
        startPrice.setColumns(10);

        endPrice = new JTextField();
        endPrice.setText("9000");
        endPrice.setColumns(10);
        endPrice.setBounds(175, 167, 84, 28);
        this.add(endPrice);

        startYear = new JTextField();
        startYear.setText("1990");
        startYear.setColumns(10);
        startYear.setBounds(372, 167, 84, 28);
        this.add(startYear);

        endYear = new JTextField();
        endYear.setText("2030");
        endYear.setColumns(10);
        endYear.setBounds(511, 167, 84, 28);
        this.add(endYear);

        startPower = new JTextField();
        startPower.setText("0");
        startPower.setColumns(10);
        startPower.setBounds(372, 377, 84, 28);
        this.add(startPower);

        endPower = new JTextField();
        endPower.setText("800");
        endPower.setColumns(10);
        endPower.setBounds(511, 377, 84, 28);
        this.add(endPower);

        startFuelEffi = new JTextField();
        startFuelEffi.setText("0");
        startFuelEffi.setColumns(10);
        startFuelEffi.setBounds(27, 377, 84, 28);
        this.add(startFuelEffi);

        endFuelEffi = new JTextField();
        endFuelEffi.setText("500");
        endFuelEffi.setColumns(10);
        endFuelEffi.setBounds(175, 377, 84, 28);
        this.add(endFuelEffi);

        JLabel lblNewLabel_1 = new JLabel("Price range");
        lblNewLabel_1.setBounds(110, 121, 89, 36);
        this.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("Car year range");
        lblNewLabel_1_1.setBounds(438, 121, 101, 36);
        this.add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_2 = new JLabel("Fuel efficient range");
        lblNewLabel_1_2.setBounds(86, 331, 117, 36);
        this.add(lblNewLabel_1_2);

        JLabel lblNewLabel_1_3 = new JLabel("Car power range");
        lblNewLabel_1_3.setBounds(438, 331, 101, 36);
        this.add(lblNewLabel_1_3);

        JLabel lblNewLabel_2 = new JLabel("  ~");
        lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 25));
        lblNewLabel_2.setBounds(120, 173, 57, 15);
        this.add(lblNewLabel_2);

        lblNewLabel_3 = new JLabel("  ~");
        lblNewLabel_3.setFont(new Font("Arial Black", Font.BOLD, 25));
        lblNewLabel_3.setBounds(460, 173, 57, 15);
        this.add(lblNewLabel_3);

        lblNewLabel_4 = new JLabel("  ~");
        lblNewLabel_4.setFont(new Font("Arial Black", Font.BOLD, 25));
        lblNewLabel_4.setBounds(120, 383, 57, 15);
        this.add(lblNewLabel_4);

        lblNewLabel_5 = new JLabel("  ~");
        lblNewLabel_5.setFont(new Font("Arial Black", Font.BOLD, 25));
        lblNewLabel_5.setBounds(460, 383, 57, 15);
        this.add(lblNewLabel_5);

        lblNewLabel_1_4 = new JLabel("Choose the fuel");
        lblNewLabel_1_4.setBounds(744, 121, 89, 36);
        this.add(lblNewLabel_1_4);

        list = new JList<>();
        list.setFont(new Font("굴림", Font.BOLD, 37));
        list.setModel(new AbstractListModel<String>() {
            private static final long serialVersionUID = 1L;
            String[] values = new String[] {"Gasoline", "", "LPG", "", "Diesel", "", "Electric", "",
                    "Hybrid"};

            public int getSize() {
                return values.length;
            }

            public String getElementAt(int index) {
                return values[index];
            }
        });
        list.setBounds(695, 167, 197, 233);
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        this.add(list);
    }

}
