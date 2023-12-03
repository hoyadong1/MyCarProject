package mycar;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import mycar.purchasecar.swing.MainPanel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import mycar.ui.Palette;

public class Start1 {

    static Object[][] data;
    MyCarProgram mcp;
    
    public static JFrame myCarProgram;

    public static void main(String[] args) {
        MyCarProgram mcp = new MyCarProgram();
        mcp.run();
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Start1 window = new Start1();
                    window.mcp = mcp;
                    window.myCarProgram.setVisible(true);
                    window.myCarProgram.setLocationRelativeTo(null);
                    window.myCarProgram.setResizable(false);
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
        myCarProgram = new JFrame();
        myCarProgram.setBounds(500, 250, 1200, 800);
        //MyCarProgram.setBounds(500, 250, 903, 384);
        myCarProgram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CardLayout cardLayout = new CardLayout();
        myCarProgram.getContentPane().setLayout(null);

        // ====================================================================================================================================

        CarListPanel CarList = new CarListPanel();
        myCarProgram.getContentPane().add(CarList);
        
        JButton returntoMain = new JButton("Return to Main menu");
        returntoMain.setFont(new Font("굴림", Font.PLAIN, 20));
        returntoMain.setBounds(723, 10, 229, 36);
        CarList.add(returntoMain);
        // ===================================================================================================================================


        RecommendPanel recommendPanel = new RecommendPanel();
        
        JButton recommendSubmit = new JButton("");
        recommendSubmit.setIcon(new ImageIcon("./images/submit.jpg"));
        recommendSubmit.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 20));
        recommendSubmit.setBounds(851, 666, 176, 53);
        recommendPanel.add(recommendSubmit);
        myCarProgram.getContentPane().add(recommendPanel);


        // =========================================================================================================================


        LoginPanel login = new LoginPanel();
        login.setBackground(Palette.background);
        login.setBounds(0, 0, 1194, 761);
        myCarProgram.getContentPane().add(login);

        JButton loginBt = new JButton("");
        loginBt.setIcon(new ImageIcon("./images/loginbt.jpg"));
        loginBt.setFont(new Font("Constantia", Font.BOLD, 15));
        loginBt.setBounds(404, 456, 176, 53);
        login.add(loginBt);
        
        //==================================================================================================================================
        
        MainPanel purchase = MainPanel.getInstance();
        myCarProgram.getContentPane().add(purchase,"purchase");
        
        
        // //================================================================================================================================

        MainPagePanel mainPage = new MainPagePanel();
        myCarProgram.getContentPane().add(mainPage);
        
        //===================================================================================================================================
        
        
        CarStoreListPanel carStoreListPanel = new CarStoreListPanel(mcp, CarList, mainPage);
        myCarProgram.getContentPane().add(carStoreListPanel);

        SearchPanel searchCarPanel = new SearchPanel(mcp, carStoreListPanel);
        myCarProgram.getContentPane().add(searchCarPanel);

        //===================================================================================================================================
        
        JButton carRecommend = new JButton("carRecommend");
        carRecommend.setIcon(new ImageIcon("./images/carRecommend.jpg"));
        carRecommend.setBounds(70, 130, 383, 218);
        mainPage.add(carRecommend);

        JButton purchaseEstimate = new JButton("purchaseEstimate");
        purchaseEstimate.setIcon(new ImageIcon("./images/carPurchase.jpg"));
        purchaseEstimate.setBounds(70, 450, 383, 218);
        mainPage.add(purchaseEstimate);

        JButton carSearch = new JButton("carSearch");
        carSearch.setBounds(710, 130, 383, 218);
        mainPage.add(carSearch);

        JButton repairEstimate = new JButton("repairEstimate");
        repairEstimate.setBounds(710, 450, 383, 218);
        mainPage.add(repairEstimate);

        // =====================================================================================================================================

        loginBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = "1234";
                String pw = "1234";
                if (id.equals(login.idField.getText()) && pw.equals(login.passwordField.getText())) {
                    JOptionPane.showMessageDialog(null, "로그인에 성공했습니다.");
                    myCarProgram.setSize(1200, 800);
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
                recommendPanel.setVisible(true);
            }

        });
        
        carSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPage.setVisible(false);
                searchCarPanel.setVisible(true);
            }
        });
        
        purchaseEstimate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPage.setVisible(false);
                myCarProgram.getContentPane().setLayout(cardLayout);
                cardLayout.show(myCarProgram.getContentPane(),"purchase");
                purchase.setVisible(true);
            }

        });

        recommendSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CarRange CR = new CarRange();
                CR.read(Integer.parseInt(recommendPanel.startPrice.getText()),
                        Integer.parseInt(recommendPanel.endPrice.getText()),
                        Integer.parseInt(recommendPanel.startYear.getText()),
                        Integer.parseInt(recommendPanel.endYear.getText()),
                        Integer.parseInt(recommendPanel.startFuelEffi.getText()),
                        Integer.parseInt(recommendPanel.endFuelEffi.getText()),
                        Integer.parseInt(recommendPanel.startPower.getText()),
                        Integer.parseInt(recommendPanel.endPower.getText()),
                        recommendPanel.list.getSelectedIndices());
                mcp.makeRecommendList(CR);
                CarList.model.setDataVector(data, CarList.columnNames);
                recommendPanel.setVisible(false);
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
}

