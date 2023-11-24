package mycar.selectoption.swing;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CarOptionSelectNamePanel extends JPanel{
	
	public CarOptionSelectNamePanel() {
		JLabel optionSelect = new JLabel("선택한 옵션", JLabel.LEFT);
		optionSelect.setBorder(BorderFactory.createEmptyBorder(10,10,5,5));
		//JLabelFont.setFont(optionSelect, 14);
		//optionSelect.setBounds(10,10,100,30);
		JLabel optionName = new JLabel("옵션 종류", JLabel.RIGHT);
		optionName.setBorder(BorderFactory.createEmptyBorder(10,10,0,280));
		//optionName.setBounds(250, 10, 110, 30);
		
		this.setLayout(new GridLayout(1,2));
		this.add(optionSelect);
		this.add(optionName);
	}	
}
