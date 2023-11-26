package mycar.selectoption.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import mycar.purchasecar.swing.MainPanel;

public class OptionTotalCalPanel extends JPanel{
	JButton deleteBtn;
	int a=0;
	JLabel totalCal;
	public OptionTotalCalPanel() {
		JPanel test = new JPanel();
		totalCal = new JLabel("합계 : " + a);
		setPreferredSize(new Dimension(800, 100));
		setLayout(new GridLayout(2,1, 10, 10));
		totalCal.setPreferredSize(new Dimension(600, 20));
		deleteBtn = new JButton("삭제");
		deleteBtn.setPreferredSize(new Dimension(70, 30));
        test.setBackground(Color.white);
		
		JButton backButton = new JButton("back");
        backButton.setPreferredSize(new Dimension(70, 50));
        backButton.addActionListener(e -> back());
        test.add(totalCal);
        test.add(deleteBtn);
        add(test);
		add(backButton);
	}
    private void back() {
        MainPanel.getInstance().showPanel("panel1");
    }
}
