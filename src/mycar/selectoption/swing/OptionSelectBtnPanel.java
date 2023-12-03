package mycar.selectoption.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import mycar.Car;
import mycar.ui.Palette;

public class OptionSelectBtnPanel extends JPanel{
	
	JButton plusBtn ,saveBtn,calBtn,compareBtn;
	Palette pal = new Palette();
	private JButton makeJButton (String btnName) {
		JButton btn = new JButton(btnName);
		//버튼 위치, 크기
		Dimension buttonSize = new Dimension(70,50);
		btn.setBackground(pal.button);
		btn.setPreferredSize(buttonSize);

		return btn;
	}
	
	public OptionSelectBtnPanel(Car car) {
    	
    	setBackground(pal.background);
		plusBtn = makeJButton("추가");
		saveBtn = makeJButton("저장");
		calBtn = makeJButton("계산");
		compareBtn = makeJButton("견적");
		
		setLayout(new GridLayout(1,3, 10, 10));
		add(plusBtn);
		add(calBtn);
		add(saveBtn);
		add(compareBtn);
		
	}

}
