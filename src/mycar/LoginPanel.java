package mycar;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import mycar.ui.Palette;

public class LoginPanel extends JPanel {
	JTextField idField;
	JPasswordField passwordField;

	private static final long serialVersionUID = 1L;

	public LoginPanel() {
		ImagePanel loginImage = new ImagePanel(new ImageIcon("./images/Login.jpg").getImage());
		loginImage.setBorder(new LineBorder(Color.DARK_GRAY, 5));

		this.setBackground(Palette.firstPanel);
		this.setBounds(0, 0, 1143, 714);
		this.setLayout(null);
		loginImage.setBounds(592, 152, 551, 443);
		this.add(loginImage);

		JLabel madeBy = new JLabel("Made by A조");
		madeBy.setFont(new Font("굴림", Font.ITALIC, 14));
		madeBy.setBounds(12, 10, 95, 15);
		add(madeBy);

		JLabel lblNewLabel = new JLabel("당신에게 딱 맞는 차추천! 구매 견적 측정 후 실매물 정보까지");
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setFont(new Font("휴먼편지체", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(12, 625, 636, 89);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("구매 이후 차량 유지를 위한 부품 수리 견적과 수리점 정보도!");
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setFont(new Font("휴먼편지체", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_1.setBounds(12, 589, 636, 89);
		add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("이 모든걸 내손에 My Car Program");
		lblNewLabel_1_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_1.setForeground(Color.GRAY);
		lblNewLabel_1_1.setFont(new Font("휴먼편지체", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_1_1.setBounds(659, 589, 447, 115);
		add(lblNewLabel_1_1);

		JPanel panel = new JPanel();
		panel.setBackground(Palette.firstPanel);
		panel.setBounds(29, 150, 551, 280);
		panel.setBorder(new LineBorder(Color.DARK_GRAY, 5));
		add(panel);
		panel.setLayout(null);

		JLabel lblPw = new JLabel("Pw : ");
		lblPw.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		lblPw.setBounds(12, 138, 73, 45);
		panel.add(lblPw);
		lblPw.setFont(new Font("Constantia", Font.PLAIN, 30));

		JLabel idLable = new JLabel("ID : ");
		idLable.setBackground(Color.WHITE);
		idLable.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		idLable.setBounds(12, 43, 73, 45);
		panel.add(idLable);
		idLable.setFont(new Font("Constantia", Font.PLAIN, 35));

		idField = new JTextField();
		idField.setBounds(97, 134, 349, 54);
		panel.add(idField);
		idField.setText("1234");
		idField.setFont(new Font("Constantia", Font.BOLD, 25));
		idField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(97, 40, 349, 54);
		panel.add(passwordField);
		passwordField.setFont(new Font("Constantia", Font.BOLD, 25));

		JLabel pageName = new JLabel("My Car Program");
		pageName.setBounds(423, 10, 298, 132);
		add(pageName);
		pageName.setBackground(new Color(255, 255, 255));
		pageName.setForeground(new Color(0, 0, 0));
		pageName.setFont(new Font("Constantia", Font.PLAIN, 40));
	}
}