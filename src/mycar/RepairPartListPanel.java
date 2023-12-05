package mycar;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;

public class RepairPartListPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    JTable repairTable;
    JLabel nameLabel;
    JLabel priceLabel;
    String[] columnNames;
    Object[][] data;
    DefaultTableModel repairModel;
    JLabel part;
    JLabel location;

    public RepairPartListPanel() {
        setBackground(Color.LIGHT_GRAY);
        this.setBounds(0, 0, 1194, 761);
        this.setVisible(false);
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY);
        panel.setBounds(12, 523, 1170, 228);
        add(panel);
        panel.setLayout(null);

        // 기능 제목
        JLabel lblNewLabel1 = new JLabel("Repair Part List");
        lblNewLabel1.setFont(new Font("굴림", Font.BOLD, 25));
        lblNewLabel1.setBounds(12, 10, 498, 36);
        lblNewLabel1.setForeground(Color.BLACK);
        add(lblNewLabel1);

        nameLabel = new JLabel();
        nameLabel.setBounds(50, 100, 300, 20);
        add(nameLabel);

        priceLabel = new JLabel();
        priceLabel.setBounds(50, 130, 300, 20);
        add(priceLabel);

        columnNames = new String[]{"repair code", "repair price"};
        data = new Object[0][columnNames.length];
        repairModel = new DefaultTableModel(data, columnNames);
        repairTable = new JTable(repairModel);

        part = new JLabel();
        part.setBounds(12, 10, 310, 216);
        panel.add(part);

        location = new JLabel();
        location.setBounds(735, 10, 405, 208);
        panel.add(location);

        JLabel newLabel = new JLabel("부품");
        newLabel.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 12));
        newLabel.setBounds(334, 110, 57, 15);
        panel.add(newLabel);

        JLabel newLabel_2 = new JLabel("정비소 위치");
        newLabel_2.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 12));
        newLabel_2.setBounds(650, 110, 57, 15);
        panel.add(newLabel_2);

        JScrollPane scrollPane = new JScrollPane(repairTable);
        scrollPane.setSize(1170, 463);
        scrollPane.setLocation(12, 50);
        add(scrollPane);

        ListSelectionModel selectionModel_1 = repairTable.getSelectionModel();
        selectionModel_1.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = repairTable.getSelectedRow();
                    if (selectedRow != -1) {
                        Object value = repairTable.getValueAt(selectedRow, 0);
                        String code = String.valueOf(value);
                        addImages("./images/" + code + ".jpg", "./images/" + code + "_map.jpg");
                    }
                }
            }
        });

        TableColumnModel columnModel = repairTable.getColumnModel();
        for (int i = 0; i < columnNames.length; i++) {
            TableColumn column = new TableColumn(i);
            column.setHeaderValue(columnNames[i]);
            columnModel.addColumn(column);
        }

        repairTable.setFont(new Font("맑은 고딕", Font.BOLD, 13));
        repairTable.setPreferredScrollableViewportSize(new Dimension(700, 600));
        repairTable.setFillsViewportHeight(true);
    }

    public void addImages(String p, String l) {
        ImageIcon partImage = new ImageIcon(p);
        ImageIcon locationImage = new ImageIcon(l);
        part.setIcon(partImage);
        location.setIcon(locationImage);
    }
}