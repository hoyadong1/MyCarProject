package mycar.selectoption.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

import javax.swing.JTextField;
import mycar.Car;
import mycar.ui.Palette;

public class OptionSelectBtnPanel extends JPanel{
	
	JButton plusBtn;
	JButton saveBtn;
	JButton calBtn;
	JButton compareBtn;
	JButton searchButton;
	JTextField searchField;
	Palette pal = new Palette();
	private JButton makeJButton (String btnName) {
		JButton btn = new JButton(btnName);
		//버튼 위치, 크기
		Dimension buttonSize = new Dimension(70,50);
		btn.setBackground(pal.button);
		btn.setPreferredSize(buttonSize);

		return btn;
	}
	private void make(JComponent component, int x, int y, int w, int h) {
		component.setSize(w, h);
		component.setLocation(x, y);
		add(component);
	}
	public OptionSelectBtnPanel() {
		setLayout(null);
    	setBackground(Palette.background);

		plusBtn = makeJButton("추가");
		make(plusBtn,0,0,65,50);

		saveBtn = makeJButton("저장");
		make(saveBtn,75,0,65,50);

		calBtn = makeJButton("계산");
		make(calBtn,150,0,65,50);

		compareBtn = makeJButton("견적");
		make(compareBtn,225,0,65,50);

		searchField = new JTextField(15);
		make(searchField,0,60,215,50);

		searchButton = new JButton("Search");
		make(searchButton,225,60,65,50);

		
	}

}
