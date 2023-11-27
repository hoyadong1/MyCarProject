package mycar.selectoption.swing;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import mycar.Car;

public class CarSelectLabelPanel extends JPanel{
	public CarSelectLabelPanel(Car car) {
		
		setLayout(new GridLayout(3, 1));
		
		JLabel carKind = new JLabel("Selected Car");
		carKind.setHorizontalAlignment(SwingConstants.LEFT);
		carKind.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
		carKind.setFont(new Font("굴림", Font.PLAIN, 17));
		JLabel carName = new JLabel();
		if(car!=null) {
			carName.setText(car.getCarName()+car.getCarPrice()+"만원");
		}
		else {
			carName.setText("없음");
		}
		carName.setHorizontalAlignment(SwingConstants.LEFT);
		carName.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		

		JLabel carOption = new JLabel("Selected Option");
		carOption.setHorizontalAlignment(SwingConstants.LEFT);
		carOption.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
		carOption.setFont(new Font("굴림", Font.PLAIN, 17));
		add(carKind);
		add(carName);
		add(carOption);
	}
}
