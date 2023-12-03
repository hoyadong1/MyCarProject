package mycar.selectoption.swing;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import manager.OptionManager;
import mycar.Car;
import mycar.MyCarProgram;
import mycar.Option;
import mycar.review.swing.ReviewMainPanel;
import mycar.ui.Palette;

public class AllOptionListPanel extends JPanel {

    JList<String> makeList;
    OptionSelectBtnPanel btnPanel;
    OptionManager optionList;
    Palette pal = new Palette();
    ListSelectionEvent e;
    public void valueChanged(ListSelectionEvent e) {
    	
    }
    private JList<String> makeJList(Car car) {
        JList<String> optionJList;
        optionJList = new JList<>();
        optionJList.setBackground(pal.listNotSelect);
        optionJList.setSelectionBackground(pal.listSelect);
        DefaultListModel<String> carOptionList = new DefaultListModel<>();
        optionList = OptionManager.getInstance();
        optionJList.addMouseListener(new MyMouseListener());
        if (car != null) {
            for (Option listTest : optionList.mList) {
                carOptionList.addElement(listTest.getName());
            }
        } else {
            carOptionList.addElement("없음");
        }
        optionJList.setModel(carOptionList);
        return optionJList;
    }

    //리스트 2번 클릭시 이벤트
    class MyMouseListener extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2) {
                String optionName = makeList.getSelectedValue();

                Option option = MyCarProgram.findOption(optionName);
                System.out.println(optionName + " <- 옵션명 " + option);
                JDialog customDialog = new JDialog((Frame) null, "Option Review", true);
                ReviewMainPanel panel = new ReviewMainPanel(option);
                customDialog.add(panel);
                customDialog.setSize(900, 500);
                customDialog.setVisible(true);
            }
        }
    }
    public AllOptionListPanel(Car car) {
    	
    	setBackground(pal.background);
        makeList = makeJList(car);
        makeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrolled = new JScrollPane(makeList);
        //makeList
        scrolled.setPreferredSize(new Dimension(300, 600));
        add(scrolled);
        setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
        btnPanel = new OptionSelectBtnPanel(car);
        
        add(btnPanel);
    }
}
