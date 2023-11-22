package mycar;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPanel extends JPanel {
    JTextField idField;
    JPasswordField passwordField;

   
    private static final long serialVersionUID = 1L;

    
    public LoginPanel() {
        ImagePanel loginImage = new ImagePanel(new ImageIcon("./images/Login.jpg").getImage());

        this.setBackground(new Color(255, 255, 255));
        this.setBounds(0, 0, 964, 523);
        this.setLayout(null);
        loginImage.setBounds(344, 0, 636, 552);
        this.add(loginImage);

        JLabel pageName = new JLabel("My Car Program");
        pageName.setBackground(new Color(255, 255, 255));
        pageName.setForeground(new Color(0, 0, 0));
        pageName.setFont(new Font("Constantia", Font.PLAIN, 40));
        pageName.setBounds(12, 10, 320, 148);
        this.add(pageName);

        JLabel idLable = new JLabel("ID : ");
        idLable.setFont(new Font("Constantia", Font.PLAIN, 35));
        idLable.setBounds(12, 200, 73, 45);
        this.add(idLable);

        JLabel lblPw = new JLabel("Pw : ");
        lblPw.setFont(new Font("Constantia", Font.PLAIN, 30));
        lblPw.setBounds(12, 260, 63, 45);
        this.add(lblPw);

        idField = new JTextField();
        idField.setText("1234");
        idField.setFont(new Font("Constantia", Font.BOLD, 25));
        idField.setBounds(82, 203, 258, 32);
        this.add(idField);
        idField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Constantia", Font.BOLD, 25));
        passwordField.setBounds(82, 261, 258, 32);
        this.add(passwordField);
        
        JLabel madeBy = new JLabel("Made by A조");
        madeBy.setFont(new Font("굴림", Font.ITALIC, 14));
        madeBy.setBounds(12, 10, 95, 15);
        add(madeBy);
    }

}
