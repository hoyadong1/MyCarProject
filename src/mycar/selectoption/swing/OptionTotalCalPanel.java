package mycar.selectoption.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class OptionTotalCalPanel extends JPanel{
	JButton deleteBtn;
	int a=0;
	JLabel totalCal;
	public OptionTotalCalPanel() {
		
		totalCal = new JLabel("합계 : " + a);
		setPreferredSize(new Dimension(530, 40));
		totalCal.setPreferredSize(new Dimension(400, 20));
		deleteBtn = new JButton("삭제");
		deleteBtn.setPreferredSize(new Dimension(70, 30));
        setBackground(Color.white);
		add(totalCal);
		add(deleteBtn);
	}

}
