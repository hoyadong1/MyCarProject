package mycar.selectoption.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import mycar.Car;

public class AllOptionListPanel extends JPanel{
	JList<String> makeList;
	OptionSelectBtnPanel btnPanel;
	private JList<String> makeJList (Car car){
		JList<String> optionJList;
        optionJList = new JList<>();
        
        DefaultListModel<String> carOptionList = new DefaultListModel<>();
        if (car != null) {
            for (String optionName : car.getOptionListName()) {
            	carOptionList.addElement(optionName);
            }
        } else {
        	carOptionList.addElement("없음");
        }
        optionJList.setModel(carOptionList);
        return optionJList;
	}

	
	public AllOptionListPanel(Car car){
		makeList = makeJList(car);
		makeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrolled=new JScrollPane(makeList);
		scrolled.setPreferredSize(new Dimension(300, 350));
		add(scrolled);
		setBorder(BorderFactory.createEmptyBorder(0,0,0,5));
		btnPanel = new OptionSelectBtnPanel(car);
		add(btnPanel);
	}
}
