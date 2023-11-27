package mycar.carrecommend;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
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
import mycar.Start1;

public class CarListPanel extends JPanel {
    private JTable carTable;
    public String[] columnNames;
    public DefaultTableModel model;
    public JLabel front;
    public JLabel side;
    public JLabel back;
    
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
        
        front = new JLabel();
        front.setBounds(12, 10, 310, 208);
        panel.add(front);
        
        side = new JLabel();
        side.setBounds(435, 10, 310, 208);
        panel.add(side);
        
        back = new JLabel();
        back.setBounds(848, 10, 310, 208);
        panel.add(back);
        
        ListSelectionModel selectionModel = carTable.getSelectionModel();
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = carTable.getSelectedRow();


                    if (selectedRow != -1) {

                        Object value = carTable.getValueAt(selectedRow, 0);


                        String selectedValue = String.valueOf(value);
                        addImages("./images/"+selectedValue +"_front.jpg", "./images/"+selectedValue +"_side.jpg",
                                "./images/"+selectedValue +"_back.jpg");


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

    public void addImages(String f, String s, String b) {
        ImageIcon frontImage = new ImageIcon(f);
        ImageIcon sideImage = new ImageIcon(s);
        ImageIcon backImage = new ImageIcon(b);
        front.setIcon(frontImage);
        side.setIcon(sideImage);
        back.setIcon(backImage);
    }
}
