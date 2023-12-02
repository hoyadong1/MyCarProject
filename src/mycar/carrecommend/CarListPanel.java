package mycar;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.Color;

public class CarListPanel extends JPanel {
    private JTable carTable;
    String[] columnNames;
    DefaultTableModel model;
    
    public JTable getCarTable() {
        return carTable;
    }

    public void setCarTable(JTable carTable) {
        this.carTable = carTable;
    }

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * Create the panel.
     */
    public CarListPanel() {
        setBackground(Color.LIGHT_GRAY);
        this.setBounds(0, 0, 1194, 761);
        this.setLayout(null);
        this.setVisible(false);

        JLabel lblNewLabel = new JLabel("입력한 스펙에 맞는 차량 리스트");
        lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 30));
        lblNewLabel.setBounds(12, 10, 498, 36);
        this.add(lblNewLabel);

        columnNames = new String[] {"Car code", "Car name", "Car price", "Car year",
                "Car fuel", "Fuel efficiency", "Car power"};
        model = new DefaultTableModel(Start1.data, columnNames);
        carTable = new JTable(model);
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY);
        panel.setBounds(12, 523, 1170, 228);
        add(panel);
        panel.setLayout(null);
        
        JPanel front = new JPanel();
        front.setBounds(12, 10, 311, 208);
        panel.add(front);
        
        JPanel side = new JPanel();
        side.setBounds(422, 10, 311, 208);
        panel.add(side);
        
        JPanel back = new JPanel();
        back.setBounds(847, 10, 311, 208);
        panel.add(back);
        
        ListSelectionModel selectionModel = carTable.getSelectionModel();
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = carTable.getSelectedRow();

                    // Ensure a row is selected
                    if (selectedRow != -1) {
                        // Get the value of the first column in the selected row
                        Object value = carTable.getValueAt(selectedRow, 0);

                        // Convert the value to a String
                        String selectedValue = String.valueOf(value);

                        ImagePanel frontImage = new ImagePanel(new ImageIcon("./images/"+selectedValue +"_front.jpg").getImage());
                        frontImage.setSize(311, 208);
                        ImagePanel sideImage = new ImagePanel(new ImageIcon("./images/"+selectedValue +"_side.jpg").getImage());
                        sideImage.setSize(311, 208);
                        ImagePanel backImage = new ImagePanel(new ImageIcon("./images/"+selectedValue +"_back.jpg").getImage());
                        backImage.setSize(311, 208);

                        // Print or use the selected value as needed
                        System.out.println("./images/"+selectedValue +"_front.jpg");
                    }
                }
            }
        });

        TableColumnModel columnModel = carTable.getColumnModel();
        for (int i = 0; i < columnNames.length; i++) {
            TableColumn column = columnModel.getColumn(i);
            column.setHeaderValue(columnNames[i]);
        }
        carTable.setFont(new Font("굴림", Font.BOLD, 13));
        carTable.setPreferredScrollableViewportSize(new Dimension(700, 600));
        carTable.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(carTable);
        scrollPane.setSize(1170, 446);
        scrollPane.setLocation(12, 67);
        this.add(scrollPane);
    }
}
