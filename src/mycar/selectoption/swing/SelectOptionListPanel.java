package mycar.selectoption.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import mycar.Car;

public class SelectOptionListPanel extends JPanel{
	DefaultListModel<String> selectCarOptionModel = new DefaultListModel<>();
	JScrollPane scrolled;
    JList<String> tempJList;
	//OptionSelectBtnPanel plusElement = new OptionSelectBtnPanel(car);
	
    private JList<String> makeList(Car car) {

        tempJList = new JList<>(selectCarOptionModel);
        return tempJList;
    }

	public SelectOptionListPanel(Car car) {
		setPreferredSize(new Dimension(800, 600));
		CarSelectLabelPanel carSelectLabel = new CarSelectLabelPanel(car);
		carSelectLabel.setPreferredSize(new Dimension(800, 50));
		add(carSelectLabel);
		
		JList<String> selectOptionJList = makeList(car);
		
		scrolled=new JScrollPane(selectOptionJList);
		scrolled.setPreferredSize(new Dimension(800, 500)); 
		
		selectOptionJList.setBackground(Color.green);
		
		setBackground(Color.blue);
		add(scrolled);
		setBorder(BorderFactory.createEmptyBorder(0,5,0,5));
	}
	
}
