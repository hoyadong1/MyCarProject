package mycar.selectoption.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import mycar.Car;
import mycar.ui.Palette;

public class CarSelectLabelPanel extends JPanel{
	public CarSelectLabelPanel(Car car) {
    	Palette pal = new Palette();
    	setBackground(pal.background);
		setLayout(new GridLayout(3, 1));
		JLabel carKind = new JLabel("선택한 차량");
		carKind.setHorizontalAlignment(SwingConstants.LEFT);
		carKind.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        carKind.setBorder(new LineBorder(Color.DARK_GRAY, 3));
		carKind.setFont(new Font("굴림", Font.BOLD, 20));
		JLabel carName = new JLabel();
		carName.setFont(new Font("굴림", Font.BOLD, 20));
		if(car!=null) {
			carName.setText(car.getCarName()+car.getCarPrice()+"만원");
		}
		else {
			carName.setText("없음");
		}
		carName.setHorizontalAlignment(SwingConstants.LEFT);
		carName.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		

		JLabel carOption = new JLabel("선택한 옵션");
		carOption.setFont(new Font("굴림", Font.BOLD, 20));
		carOption.setHorizontalAlignment(SwingConstants.LEFT);
		carOption.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		carOption.setBorder(new LineBorder(Color.DARK_GRAY, 3));
        
		carOption.setFont(new Font("굴림", Font.BOLD, 20));
		add(carKind);
		add(carName);
		add(carOption);
	}
}
