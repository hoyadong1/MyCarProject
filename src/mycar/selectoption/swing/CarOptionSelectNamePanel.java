package mycar.selectoption.swing;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import mycar.ui.Palette;

public class CarOptionSelectNamePanel extends JPanel{
	
	public CarOptionSelectNamePanel() {
    	Palette pal = new Palette();
    	setBackground(pal.background);
		JLabel optionSelect = new JLabel("선택한 옵션", JLabel.LEFT);
		optionSelect.setBorder(BorderFactory.createEmptyBorder(10,10,5,5));
		optionSelect.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 20));
		//JLabelFont.setFont(optionSelect, 14);
		//optionSelect.setBounds(10,10,100,30);
		JLabel optionName = new JLabel("옵션 종류", JLabel.RIGHT);
		optionName.setBorder(BorderFactory.createEmptyBorder(10,10,0,250));
		optionName.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 20));
		//optionName.setBounds(250, 10, 110, 30);
		
		this.setLayout(new GridLayout(1,2));
		this.add(optionSelect);
		this.add(optionName);
	}	
}
