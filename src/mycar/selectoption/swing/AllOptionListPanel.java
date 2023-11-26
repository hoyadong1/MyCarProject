package mycar.selectoption.swing;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import manager.OptionManager;
import mycar.Car;
import mycar.MyCarProgram;
import mycar.Option;
import mycar.review.swing.ReviewMainPanel;

public class AllOptionListPanel extends JPanel {

    JList<String> makeList;
    OptionSelectBtnPanel btnPanel;
    OptionManager optionList;

    private JList<String> makeJList(Car car) {
        JList<String> optionJList;
        optionJList = new JList<>();

        DefaultListModel<String> carOptionList = new DefaultListModel<>();
        optionList = OptionManager.getInstance();
        optionJList.addMouseListener(new MyMouseListener());
        if (car != null) {
            for (Option listTest : optionList.mList) {
                carOptionList.addElement(listTest.getName() + listTest.getPrice());
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
            }
        }
    }

    public AllOptionListPanel(Car car) {
        makeList = makeJList(car);
        makeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrolled = new JScrollPane(makeList);
        scrolled.setPreferredSize(new Dimension(300, 600));
        add(scrolled);
        setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
        btnPanel = new OptionSelectBtnPanel(car);
        add(btnPanel);
    }
}
