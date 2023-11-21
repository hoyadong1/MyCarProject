package mycar;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class CarListPanel extends JPanel {
    private JTable carTable;
    String[] columnNames;
    DefaultTableModel model; 
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * Create the panel.
     */
    public CarListPanel() {
        this.setBounds(0, 0, 964, 523);
        this.setLayout(null);
        this.setVisible(false);

        JLabel lblNewLabel = new JLabel("List of cars that match the specs");
        lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 30));
        lblNewLabel.setBounds(12, 10, 498, 36);
        this.add(lblNewLabel);

        columnNames = new String[] {"Car code", "Car name", "Car price", "Car year",
                "Car fuel", "Fuel efficiency", "Car power"};
        model = new DefaultTableModel(Start1.data, columnNames);
        carTable = new JTable(model);

        TableColumnModel columnModel = carTable.getColumnModel();
        for (int i = 0; i < columnNames.length; i++) {
            TableColumn column = columnModel.getColumn(i);
            column.setHeaderValue(columnNames[i]);
        }
        carTable.setFont(new Font("굴림", Font.BOLD, 13));
        carTable.setPreferredScrollableViewportSize(new Dimension(700, 600));
        carTable.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(carTable);
        scrollPane.setSize(940, 446);
        scrollPane.setLocation(12, 67);
        this.add(scrollPane);
    }

}
