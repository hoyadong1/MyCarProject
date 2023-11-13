package mycar;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class Start1 {

    CarRange CR = new CarRange();
    static Object[][] data;
    MyCarProgram mcp;


    private JFrame MyCarProgram;
    private JTextField idField;
    private JPasswordField passwordField;
    private JTextField startPrice;
    private JTextField endPrice;
    private JTextField startYear;
    private JTextField endYear;
    private JTextField startPower;
    private JTextField endPower;
    private JTextField startFuelEffi;
    private JTextField endFuelEffi;
    private JLabel lblNewLabel_3;
    private JLabel lblNewLabel_4;
    private JLabel lblNewLabel_5;
    private JLabel lblNewLabel_1_4;
    private JTable carTable;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        MyCarProgram mcp = new MyCarProgram();
        mcp.run();
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Start1 window = new Start1();
                    window.mcp = mcp;
                    window.MyCarProgram.setVisible(true);
                    window.MyCarProgram.setLocationRelativeTo(null);
                    window.MyCarProgram.setResizable(false);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Start1() {
        initialize();
    }

    private void initialize() {
        MyCarProgram = new JFrame();
        // MyCarProgram.setBounds(500, 250, 903, 384);
        MyCarProgram.setBounds(500, 250, 980, 562);
        MyCarProgram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyCarProgram.getContentPane().setLayout(null);

        JPanel CarList = new JPanel();
        CarList.setBounds(0, 0, 964, 523);
        MyCarProgram.getContentPane().add(CarList);
        CarList.setLayout(null);
        CarList.setVisible(false);

        JLabel lblNewLabel = new JLabel("List of cars that match the specs");
        lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 30));
        lblNewLabel.setBounds(12, 10, 498, 36);
        CarList.add(lblNewLabel);

        JButton returntoMain = new JButton("Return to Main menu");
        returntoMain.setFont(new Font("굴림", Font.PLAIN, 20));
        returntoMain.setBounds(723, 10, 229, 36);
        CarList.add(returntoMain);

        String[] columnNames = new String[] {"Car code", "Car name", "Car price", "Car year",
                "Car fuel", "Fuel efficiency", "Car power"};
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
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
        CarList.add(scrollPane);

        // ===================================================================================================================================


        JPanel RecommendPanel = new JPanel();
        RecommendPanel.setBackground(new Color(255, 255, 255));
        RecommendPanel.setBounds(0, 0, 964, 523);
        MyCarProgram.getContentPane().add(RecommendPanel);
        RecommendPanel.setLayout(null);
        RecommendPanel.setVisible(false);

        JLabel lblNewLabel1 = new JLabel("enter car sepcs");
        lblNewLabel1.setFont(new Font("굴림", Font.BOLD, 30));
        lblNewLabel1.setBounds(359, 10, 244, 60);
        RecommendPanel.add(lblNewLabel1);

        startPrice = new JTextField();
        startPrice.setText("0");
        startPrice.setBounds(27, 167, 84, 28);
        RecommendPanel.add(startPrice);
        startPrice.setColumns(10);

        endPrice = new JTextField();
        endPrice.setText("9000");
        endPrice.setColumns(10);
        endPrice.setBounds(175, 167, 84, 28);
        RecommendPanel.add(endPrice);

        startYear = new JTextField();
        startYear.setText("1990");
        startYear.setColumns(10);
        startYear.setBounds(372, 167, 84, 28);
        RecommendPanel.add(startYear);

        endYear = new JTextField();
        endYear.setText("2030");
        endYear.setColumns(10);
        endYear.setBounds(511, 167, 84, 28);
        RecommendPanel.add(endYear);

        startPower = new JTextField();
        startPower.setText("0");
        startPower.setColumns(10);
        startPower.setBounds(372, 377, 84, 28);
        RecommendPanel.add(startPower);

        endPower = new JTextField();
        endPower.setText("800");
        endPower.setColumns(10);
        endPower.setBounds(511, 377, 84, 28);
        RecommendPanel.add(endPower);

        startFuelEffi = new JTextField();
        startFuelEffi.setText("0");
        startFuelEffi.setColumns(10);
        startFuelEffi.setBounds(27, 377, 84, 28);
        RecommendPanel.add(startFuelEffi);

        endFuelEffi = new JTextField();
        endFuelEffi.setText("500");
        endFuelEffi.setColumns(10);
        endFuelEffi.setBounds(175, 377, 84, 28);
        RecommendPanel.add(endFuelEffi);

        JLabel lblNewLabel_1 = new JLabel("Price range");
        lblNewLabel_1.setBounds(110, 121, 89, 36);
        RecommendPanel.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("Car year range");
        lblNewLabel_1_1.setBounds(438, 121, 101, 36);
        RecommendPanel.add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_2 = new JLabel("Fuel efficient range");
        lblNewLabel_1_2.setBounds(86, 331, 117, 36);
        RecommendPanel.add(lblNewLabel_1_2);

        JLabel lblNewLabel_1_3 = new JLabel("Car power range");
        lblNewLabel_1_3.setBounds(438, 331, 101, 36);
        RecommendPanel.add(lblNewLabel_1_3);

        JLabel lblNewLabel_2 = new JLabel("  ~");
        lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 25));
        lblNewLabel_2.setBounds(120, 173, 57, 15);
        RecommendPanel.add(lblNewLabel_2);

        lblNewLabel_3 = new JLabel("  ~");
        lblNewLabel_3.setFont(new Font("Arial Black", Font.BOLD, 25));
        lblNewLabel_3.setBounds(460, 173, 57, 15);
        RecommendPanel.add(lblNewLabel_3);

        lblNewLabel_4 = new JLabel("  ~");
        lblNewLabel_4.setFont(new Font("Arial Black", Font.BOLD, 25));
        lblNewLabel_4.setBounds(120, 383, 57, 15);
        RecommendPanel.add(lblNewLabel_4);

        lblNewLabel_5 = new JLabel("  ~");
        lblNewLabel_5.setFont(new Font("Arial Black", Font.BOLD, 25));
        lblNewLabel_5.setBounds(460, 383, 57, 15);
        RecommendPanel.add(lblNewLabel_5);

        lblNewLabel_1_4 = new JLabel("Choose the fuel");
        lblNewLabel_1_4.setBounds(744, 121, 89, 36);
        RecommendPanel.add(lblNewLabel_1_4);

        JButton recommendSubmit = new JButton("Submit");
        recommendSubmit.setBounds(736, 444, 97, 23);
        RecommendPanel.add(recommendSubmit);

        JList<String> list = new JList<>();
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
        RecommendPanel.add(list);

        // =========================================================================================================================

        ImagePanel loginImage = new ImagePanel(new ImageIcon("./images/Login.jpg").getImage());

        JPanel login = new JPanel();
        login.setBackground(new Color(255, 255, 255));
        login.setBounds(0, 0, 964, 523);
        MyCarProgram.getContentPane().add(login);
        login.setLayout(null);
        loginImage.setBounds(344, 0, 636, 552);
        login.add(loginImage);

        JLabel pageName = new JLabel("My Car Program");
        pageName.setBackground(new Color(255, 255, 255));
        pageName.setForeground(new Color(0, 0, 0));
        pageName.setFont(new Font("Constantia", Font.PLAIN, 40));
        pageName.setBounds(12, 10, 320, 148);
        login.add(pageName);

        JLabel idLable = new JLabel("ID : ");
        idLable.setFont(new Font("Constantia", Font.PLAIN, 35));
        idLable.setBounds(12, 200, 73, 45);
        login.add(idLable);

        JLabel lblPw = new JLabel("Pw : ");
        lblPw.setFont(new Font("Constantia", Font.PLAIN, 30));
        lblPw.setBounds(12, 260, 63, 45);
        login.add(lblPw);

        idField = new JTextField();
        idField.setText("1234");
        idField.setFont(new Font("Constantia", Font.BOLD, 25));
        idField.setBounds(82, 203, 258, 32);
        login.add(idField);
        idField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Constantia", Font.BOLD, 25));
        passwordField.setBounds(82, 261, 258, 32);
        login.add(passwordField);

        JButton loginBt = new JButton("Login");
        loginBt.setFont(new Font("Constantia", Font.BOLD, 15));
        loginBt.setBounds(249, 317, 91, 21);
        login.add(loginBt);

        // //================================================================================================================================

        JPanel mainPage = new JPanel();
        mainPage.setForeground(new Color(0, 0, 0));
        mainPage.setBackground(new Color(255, 255, 255));
        mainPage.setBounds(0, 0, 964, 523);
        MyCarProgram.getContentPane().add(mainPage);
        mainPage.setLayout(null);
        mainPage.setVisible(false);

        JButton carRecommend = new JButton("carRecommend");
        carRecommend.setBounds(33, 0, 383, 218);
        mainPage.add(carRecommend);

        JLabel manu = new JLabel("Menu");
        manu.setFont(new Font("Constantia", Font.BOLD, 40));
        manu.setBounds(428, 10, 155, 66);
        mainPage.add(manu);

        JButton purchaseEstimate = new JButton("purchaseEstimate");
        purchaseEstimate.setBounds(33, 257, 383, 229);
        mainPage.add(purchaseEstimate);

        JButton carSearch = new JButton("carSearch");
        carSearch.setBounds(555, 0, 383, 218);
        mainPage.add(carSearch);

        JButton repairEstimate = new JButton("repairEstimate");
        repairEstimate.setBounds(555, 262, 383, 218);
        mainPage.add(repairEstimate);

        JLabel lblNewLabel11 = new JLabel("Car Recommendation");
        lblNewLabel11.setFont(new Font("Constantia", Font.BOLD, 12));
        lblNewLabel11.setBounds(33, 219, 167, 15);
        mainPage.add(lblNewLabel11);

        JLabel lblSearchRealCars = new JLabel("Search real cars for sale");
        lblSearchRealCars.setFont(new Font("Constantia", Font.BOLD, 12));
        lblSearchRealCars.setBounds(555, 217, 167, 15);
        mainPage.add(lblSearchRealCars);

        JLabel lblCarPurchaseEstimate = new JLabel("Car purchase estimate");
        lblCarPurchaseEstimate.setFont(new Font("Constantia", Font.BOLD, 12));
        lblCarPurchaseEstimate.setBounds(33, 487, 167, 15);
        mainPage.add(lblCarPurchaseEstimate);

        JLabel lblCarRepairEstimate = new JLabel("Car repair estimate");
        lblCarRepairEstimate.setFont(new Font("Constantia", Font.BOLD, 12));
        lblCarRepairEstimate.setBounds(555, 485, 167, 15);
        mainPage.add(lblCarRepairEstimate);



        // =====================================================================================================================================


        loginBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = "1234";
                String pw = "1234";

                if (id.equals(idField.getText()) && pw.equals(passwordField.getText())) {
                    JOptionPane.showMessageDialog(null, "로그인에 성공했습니다.");
                    MyCarProgram.setBounds(500, 250, 980, 562);
                    login.setVisible(false);
                    mainPage.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "로그인에 실패했습니다.");
                }

            }

        });
        carRecommend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPage.setVisible(false);
                RecommendPanel.setVisible(true);
            }

        });

        recommendSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CR.read(Integer.parseInt(startPrice.getText()),
                        Integer.parseInt(endPrice.getText()), Integer.parseInt(startYear.getText()),
                        Integer.parseInt(endYear.getText()),
                        Integer.parseInt(startFuelEffi.getText()),
                        Integer.parseInt(endFuelEffi.getText()),
                        Integer.parseInt(startPower.getText()),
                        Integer.parseInt(endPower.getText()), list.getSelectedIndices());
                mcp.makeRecommendList(CR);
                model.setDataVector(data, columnNames);
                RecommendPanel.setVisible(false);
                CarList.setVisible(true);
            }
        });
        returntoMain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CarList.setVisible(false);
                mainPage.setVisible(true);
            }
        });
    }



    class ImagePanel extends JPanel {
        private Image img;

        public ImagePanel(Image img) {
            this.img = img;
            setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
            setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
            setLayout(null);
        }

        public int getWidth() {
            return img.getWidth(null);
        }

        public int getHeight() {
            return img.getHeight(null);
        }

        public void paintComponent(Graphics g) {
            g.drawImage(img, 0, 0, null);
        }
    }
}
