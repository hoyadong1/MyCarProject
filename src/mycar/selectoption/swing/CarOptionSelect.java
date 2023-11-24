package mycar.selectoption.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import mycar.Car;
import mycar.MyCarProgram;
import mycar.Option;

public class CarOptionSelect extends JPanel{
	JFrame frame;
	JTextField totalCal;
	int calNum = 0;
	Option option;
	public CarOptionSelect(Car car) {
		//프레임 크기(실행용)
		frame = new JFrame("test");
		
        frame.setSize(964, 530);
		frame.setLocation(700, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = frame.getContentPane();
		
		//메인 페널 생성
		setLayout(new BorderLayout());
		
		//라벨(맨 위 리스트 이름)
		CarOptionSelectNamePanel namePanel = new CarOptionSelectNamePanel();
		add(namePanel, BorderLayout.NORTH);
		
		//텍스트 필드
		//선택한 옵션들 표기
		SelectOptionListPanel selectOptionList = new SelectOptionListPanel(car);
		
		//현제 선택한 옵션들 가격 합
		OptionTotalCalPanel totalCalP = new OptionTotalCalPanel();
		selectOptionList.add(totalCalP);

		add(selectOptionList, BorderLayout.WEST);
		//전체 옵션 표기	(버튼 포함)(버튼 기능 구현)
		//============================================================
		//추가 버튼================================================
        AllOptionListPanel optionJList = new AllOptionListPanel(car);
        ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				option = new Option();
				String data = optionJList.makeList.getSelectedValue();
				selectOptionList.selectCarOptionModel.addElement(data);
				optionJList.makeList.clearSelection();
				/*
				for(String optionName : ) {
					if(option.matches(data))
						calNum += option.getPrice();
				}
				*/
			}
		};
		optionJList.btnPanel.plusBtn.addActionListener(listener);
		//삭제 버튼================================================
		ActionListener deleteListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectOptionList.selectCarOptionModel.removeElement(selectOptionList.tempJList.getSelectedValue());
				optionJList.makeList.clearSelection();
				/*
				for(String optionName : car.getOptionListName()) {
					if(option.matches(selectOptionList.selectCarOptionModel))
						calNum += option.getPrice();
				}
				*/
			}
		};
		totalCalP.deleteBtn.addActionListener(deleteListener);
		//계산 버튼 ===============================================
		/*
		ActionListener calListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for(DefaultListModel j : selectOptionList.selectCarOptionModel) {
					
				}
				totalCalP.totalCal.setText("합계 : "+ calNum);
			}
		};
		
		optionJList.btnPanel.calBtn.addActionListener(calListener);
		*/
		add(optionJList);
		//============================================================
		contentPane.add(this);
		
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		new CarOptionSelect(null);
		
	}
	
	
}