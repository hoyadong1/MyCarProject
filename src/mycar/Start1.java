package mycar;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Start1 {

    static Object[][] data;
    MyCarProgram mcp;
    
    public static JFrame MyCarProgram;

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
        MyCarProgram.setBounds(500, 250, 1200, 800);
        //MyCarProgram.setBounds(500, 250, 903, 384);
        MyCarProgram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyCarProgram.getContentPane().setLayout(null);

        // ====================================================================================================================================

        CarListPanel CarList = new CarListPanel();
        MyCarProgram.getContentPane().add(CarList);
        
        JButton returntoMain = new JButton("Return to Main menu");
        returntoMain.setFont(new Font("굴림", Font.PLAIN, 20));
        returntoMain.setBounds(723, 10, 229, 36);
        CarList.add(returntoMain);
        // ===================================================================================================================================


        RecommendPanel recommendPanel = new RecommendPanel();
        
        JButton recommendSubmit = new JButton("Submit");
        recommendSubmit.setBounds(736, 444, 97, 23);
        recommendPanel.add(recommendSubmit);
        MyCarProgram.getContentPane().add(recommendPanel);


        // =========================================================================================================================


        LoginPanel login = new LoginPanel();
        MyCarProgram.getContentPane().add(login);

        JButton loginBt = new JButton("Login");
        loginBt.setFont(new Font("Constantia", Font.BOLD, 15));
        loginBt.setBounds(249, 317, 91, 21);
        login.add(loginBt);

        // //================================================================================================================================

        MainPagePanel mainPage = new MainPagePanel();
        MyCarProgram.getContentPane().add(mainPage);

        JButton carRecommend = new JButton("carRecommend");
        carRecommend.setBounds(33, 0, 383, 218);
        mainPage.add(carRecommend);

        JButton purchaseEstimate = new JButton("purchaseEstimate");
        purchaseEstimate.setBounds(33, 257, 383, 229);
        mainPage.add(purchaseEstimate);

        JButton carSearch = new JButton("carSearch");
        carSearch.setBounds(555, 0, 383, 218);
        mainPage.add(carSearch);

        JButton repairEstimate = new JButton("repairEstimate");
        repairEstimate.setBounds(555, 262, 383, 218);
        mainPage.add(repairEstimate);

        // =====================================================================================================================================

        loginBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = "1234";
                String pw = "1234";
                if (id.equals(login.idField.getText()) && pw.equals(login.passwordField.getText())) {
                    JOptionPane.showMessageDialog(null, "로그인에 성공했습니다.");
                    MyCarProgram.setSize(1200, 800);
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
