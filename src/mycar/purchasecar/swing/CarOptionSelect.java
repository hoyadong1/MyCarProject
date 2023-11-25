package mycar.purchasecar.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import mycar.Car;
import mycar.MyCarProgram;

public class CarOptionSelect extends JPanel implements ActionListener{
	JFrame frame;
	JPanel mainPanel, namePanel, selectOptionList, optionList, btnPanel;
	JTextArea t1, t2, totalCal;
	JLabel optionName, optionSelect;
	JButton saveBtn, calBtn, compareBtn;
	
	public CarOptionSelect() {
		//프레임 크기(실행용)
		frame = new JFrame("test");
		
		frame.setSize(800,600);
		frame.setLocation(700, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = frame.getContentPane();
		//frame.getContentPane().setLayout(null);
		
		//메인 페널 생성
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		optionList = new JPanel();
		
		//라벨(맨 위 리스트 이름)
		optionSelect = new JLabel("선택한 옵션", JLabel.LEFT);
		optionSelect.setBorder(BorderFactory.createEmptyBorder(10,10,5,5));
		//JLabelFont.setFont(optionSelect, 14);
		//optionSelect.setBounds(10,10,100,30);
		optionName = new JLabel("옵션 종류", JLabel.RIGHT);
		optionName.setBorder(BorderFactory.createEmptyBorder(10,10,0,180));
		//optionName.setBounds(250, 10, 110, 30);
		
		namePanel = new JPanel();
		namePanel.setLayout(new GridLayout(1,2));
		namePanel.add(optionSelect);
		namePanel.add(optionName);
		//optionList.add(optionName, BorderLayout.NORTH); 
		mainPanel.add(namePanel, BorderLayout.NORTH);
		
		//텍스트 필드
		//선택한 옵션들 표기
		JList<String> selectOptionJList;
		selectOptionJList = new JList<>();
		selectOptionJList.setPreferredSize(new Dimension(500, 400));
		
		selectOptionList = new JPanel();
		selectOptionList.setSize(500, 300);
		//selectOptionList.setBackground(Color.green);
		//selectOptionList.setLayout(new GridLayout(2,1, 10, 10));
		
		selectOptionList.add(selectOptionJList);
		selectOptionList.setBorder(BorderFactory.createEmptyBorder(0,5,0,5));
		
		
		//현제 선택한 옵션들 가격 합
		int a=0;
		totalCal = new JTextArea("합계 : " + a);
		totalCal.setEditable(false);
		JScrollPane scrollPane3 = new JScrollPane(totalCal);
		scrollPane3.setBorder(BorderFactory.createEmptyBorder(0,0,135,0));
		//scrollPane3.setSize(20,0);
		//scrollPane3.setBounds(10, 500, 200, 30);
		//selectOptionList.add(scrollPane3);
		
		//전체 옵션 표기		
        JList<String> optionJList;
        optionJList = new JList<>();
        optionJList.setPreferredSize(new Dimension(200, 400));
        
        mainPanel.add(selectOptionList, BorderLayout.WEST);
        
		optionList.add(optionJList, BorderLayout.CENTER);
		optionList.setBorder(BorderFactory.createEmptyBorder(0,0,0,5));
		//JScrollPane scrollPane4 = new JScrollPane(optionJList);
		//scrollPane4.setSize(200,300);
		
		
		//버튼
		saveBtn = new JButton("저장");
		calBtn = new JButton("계산");
		compareBtn = new JButton("계산");
		
		//버튼 위치, 크기
		Dimension buttonSize = new Dimension(80,40);
		saveBtn.setPreferredSize(buttonSize);
		calBtn.setPreferredSize(buttonSize);
		compareBtn.setPreferredSize(buttonSize);
		
		btnPanel = new JPanel();

		btnPanel.setLayout(new GridLayout(2,2, 10, 10));
		
		btnPanel.add(saveBtn);
		btnPanel.add(calBtn);
		btnPanel.add(compareBtn);
		
		optionList.add(btnPanel, BorderLayout.SOUTH);
		
		mainPanel.add(optionList);
		
		contentPane.add(mainPanel);
		
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		new CarOptionSelect();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}