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
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

public class Start {

	private JFrame MyCarProgram;
	private JTextField idField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start window = new Start();
					window.MyCarProgram.setVisible(true);
					window.MyCarProgram.setLocationRelativeTo(null);
					window.MyCarProgram.setResizable(false);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Start() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		MyCarProgram = new JFrame();
		MyCarProgram.setBounds(500, 250, 980, 562);
		MyCarProgram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyCarProgram.getContentPane().setLayout(null);
		
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
		
	//================================================================================================================================
		
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
		
		JLabel lblNewLabel = new JLabel("Car Recommendation");
		lblNewLabel.setFont(new Font("Constantia", Font.BOLD, 12));
		lblNewLabel.setBounds(33, 219, 167, 15);
		mainPage.add(lblNewLabel);
		
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
		
		
		loginBt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = "1234";
				String pw = "1234";
				
				if(id.equals(idField.getText()) && pw.equals(passwordField.getText())) {
					JOptionPane.showMessageDialog(null, "로그인에 성공했습니다.");
					MyCarProgram.setBounds(500, 250, 980, 562);
					login.setVisible(false);
					mainPage.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "로그인에 실패했습니다.");
				}
				
			}
			
		});
	}
	
	
	
	class ImagePanel extends JPanel{
		private Image img;
		
		public ImagePanel(Image img) {
			this.img = img;
			setSize(new Dimension(img.getWidth(null),img.getHeight(null)));
			setPreferredSize(new Dimension(img.getWidth(null),img.getHeight(null)));
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
