package mycar;

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
import javax.swing.border.LineBorder;
import mycar.ui.Palette;

public class CarListPanel extends JPanel {
    private JTable carTable;
    String[] columnNames;
    DefaultTableModel model;
    JLabel front;
    JLabel side;
    JLabel back;
    
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
        setBackground(Palette.background);
        this.setBounds(0, 0, 1194, 761);
        this.setLayout(null);
        this.setVisible(false);

        JLabel lblNewLabel = new JLabel("입력한 스펙에 맞는 차량 리스트");
        lblNewLabel.setBorder(new LineBorder(Color.DARK_GRAY, 1));
        lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 30));
        lblNewLabel.setBounds(12, 10, 437, 36);
        lblNewLabel.setBackground(Palette.firstPanel);
        this.add(lblNewLabel);

        columnNames = new String[] {"Car code", "Car name", "Car price", "Car year",
                "Car fuel", "Fuel efficiency", "Car power"};
        model = new DefaultTableModel(Start1.data, columnNames);
        carTable = new JTable(model);
        carTable.setBackground(Palette.listNotSelect);
        JPanel panel = new JPanel();
        panel.setBackground(Palette.firstPanel);
        panel.setBounds(12, 523, 1170, 228);
        add(panel);
        panel.setLayout(null);
        
        front = new JLabel();
        front.setBorder(new LineBorder(Color.DARK_GRAY, 1));
        front.setBounds(12, 10, 310, 208);
        panel.add(front);
        
        side = new JLabel();
        side.setBorder(new LineBorder(Color.DARK_GRAY, 1));
        side.setBounds(435, 10, 310, 208);
        panel.add(side);
        
        back = new JLabel();
        back.setBorder(new LineBorder(Color.DARK_GRAY, 1));
        back.setBounds(848, 10, 310, 208);
        panel.add(back);
        
        JLabel lblNewLabel_1 = new JLabel("전면사진");
        lblNewLabel_1.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 12));
        lblNewLabel_1.setBounds(334, 110, 57, 15);
        panel.add(lblNewLabel_1);
        
        JLabel lblNewLabel_1_1 = new JLabel("측면사진");
        lblNewLabel_1_1.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 12));
        lblNewLabel_1_1.setBounds(757, 10, 57, 15);
        panel.add(lblNewLabel_1_1);
        
        JLabel lblNewLabel_1_2 = new JLabel("후면사진");
        lblNewLabel_1_2.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 12));
        lblNewLabel_1_2.setBounds(779, 203, 57, 15);
        panel.add(lblNewLabel_1_2);
        
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
        carTable.setFont(new Font("굴림", Font.BOLD, 15));
        carTable.setPreferredScrollableViewportSize(new Dimension(700, 600));
        carTable.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(carTable);
        scrollPane.setFont(new Font("굴림", Font.BOLD, 10));
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
