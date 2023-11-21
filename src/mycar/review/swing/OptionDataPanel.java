package mycar.review.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import mycar.Option;
import mycar.swing.tools.JLabelFont;

public class OptionDataPanel extends JPanel {

    GridBagConstraints gridBagConstraints = new GridBagConstraints();
    GridBagLayout gridBagLayout = new GridBagLayout();

    class OptionName extends JPanel {

        public OptionName(String optionName) {
            JLabel optionNameLabel = new JLabel(optionName);
            JLabelFont.setFont(optionNameLabel, 30);
            add(optionNameLabel);
        }
    }

    class OptionInformation extends JPanel {

        public OptionInformation(String optionInformation) {
            setLayout(new BorderLayout());
            setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            JLabel optionNameLabel = new JLabel(optionInformation);
            JLabelFont.setFont(optionNameLabel, 20);
            optionNameLabel.setOpaque(true);
            optionNameLabel.setBackground(new Color(192, 171, 71));
            add(optionNameLabel);
        }
    }

    private void settingPanel() {
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setBackground(new Color(22, 22, 131));
        setLayout(gridBagLayout);

        gridBagConstraints.fill = GridBagConstraints.BOTH;

        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;

    }

    private void makeGridBag(JComponent c, int x, int y, int w, int h) {
        gridBagConstraints.gridx = x;
        gridBagConstraints.gridy = y;
        gridBagConstraints.gridwidth = w;
        gridBagConstraints.gridheight = h;

        gridBagLayout.setConstraints(c, gridBagConstraints);

    }

    public OptionDataPanel(Option option) {
        settingPanel();

        JPanel optionName = new OptionName(option.getName());
        // TODO: 정보를 추가하게된다면 아래 부분 실제 옵션의 정보를 받아오도록 수정
        JPanel optionInformation = new OptionInformation("임시 데이터 정보");

        makeGridBag(optionName, 0, 0, 1, 1);
        add(optionName, gridBagConstraints);

        makeGridBag(optionInformation, 0, 1, 1, 1);
        add(optionInformation, gridBagConstraints);
    }
}
