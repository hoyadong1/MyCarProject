package mycar.carrecommend;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class LoginPanel extends JPanel {
    public JTextField idField;
    public JPasswordField passwordField;

   
    private static final long serialVersionUID = 1L;

    
    public LoginPanel() {
        ImagePanel loginImage = new ImagePanel(new ImageIcon("./images/Login.jpg").getImage());
        loginImage.setBorder(new LineBorder(Color.DARK_GRAY, 5));

        this.setBackground(Color.LIGHT_GRAY);
        this.setBounds(0, 0, 1143, 714);
        this.setLayout(null);
        loginImage.setBounds(521, 152, 551, 443);
        this.add(loginImage);

        JLabel pageName = new JLabel("My Car Program");
        pageName.setBackground(new Color(255, 255, 255));
        pageName.setForeground(new Color(0, 0, 0));
        pageName.setFont(new Font("Constantia", Font.PLAIN, 40));
        pageName.setBounds(12, 10, 551, 132);
        this.add(pageName);

        JLabel idLable = new JLabel("ID : ");
        idLable.setFont(new Font("Constantia", Font.PLAIN, 35));
        idLable.setBounds(12, 235, 73, 45);
        this.add(idLable);

        JLabel lblPw = new JLabel("Pw : ");
        lblPw.setFont(new Font("Constantia", Font.PLAIN, 30));
        lblPw.setBounds(12, 356, 63, 45);
        this.add(lblPw);

        idField = new JTextField();
        idField.setText("1234");
        idField.setFont(new Font("Constantia", Font.BOLD, 25));
        idField.setBounds(82, 221, 349, 54);
        this.add(idField);
        idField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Constantia", Font.BOLD, 25));
        passwordField.setBounds(82, 352, 349, 54);
        this.add(passwordField);
        
        JLabel madeBy = new JLabel("Made by A조");
        madeBy.setFont(new Font("굴림", Font.ITALIC, 14));
        madeBy.setBounds(12, 10, 95, 15);
        add(madeBy);
        
        JLabel lblNewLabel = new JLabel("당신에게 딱 맞는 차추천! 구매 견적 측정 후 실매물 정보까지");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setFont(new Font("휴먼편지체", Font.BOLD | Font.ITALIC, 25));
        lblNewLabel.setBounds(470, 31, 636, 89);
        add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("구매 이후 차량 유지를 위한 부품 수리 견적과 수리점 정보도!");
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setFont(new Font("휴먼편지체", Font.BOLD | Font.ITALIC, 25));
        lblNewLabel_1.setBounds(12, 589, 636, 89);
        add(lblNewLabel_1);
        
        JLabel lblNewLabel_1_1 = new JLabel("이 모든걸 내손에 My Car Program");
        lblNewLabel_1_1.setBackground(Color.LIGHT_GRAY);
        lblNewLabel_1_1.setForeground(Color.GRAY);
        lblNewLabel_1_1.setFont(new Font("휴먼편지체", Font.BOLD | Font.ITALIC, 30));
        lblNewLabel_1_1.setBounds(659, 589, 447, 115);
        add(lblNewLabel_1_1);
    }
}
