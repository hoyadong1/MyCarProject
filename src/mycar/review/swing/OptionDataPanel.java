package mycar.review.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import mycar.Option;
import mycar.swing.tools.JLabelFont;
import mycar.ui.Palette;

public class OptionDataPanel extends JPanel {

    private void settingPanel() {
        setBackground(Palette.firstPanel);
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
    }

    class OptionName extends JPanel {

        public OptionName(String optionName) {
            setLayout(new BorderLayout());
            setBorder(BorderFactory.createEmptyBorder(10, 5, 0, 5));

            JLabel optionNameLabel = new JLabel(optionName);
            JLabelFont.setFont(optionNameLabel, 30);
            optionNameLabel.setOpaque(true);
            optionNameLabel.setBorder(BorderFactory.createEmptyBorder(10, 5, 5, 5));
            optionNameLabel.setBackground(Palette.firstPanel);
            add(optionNameLabel);
        }
    }


    class OptionInformation extends JPanel {

        public OptionInformation(String optionInformation) {
            setLayout(new BorderLayout());
            setBorder(BorderFactory.createEmptyBorder(0, 5, 10, 5));

            JLabel optionInformationLabel = new JLabel(optionInformation);
            JLabelFont.setFont(optionInformationLabel, 20);
            optionInformationLabel.setOpaque(true);
            optionInformationLabel.setBorder(BorderFactory.createEmptyBorder(10, 5, 5, 5));
            optionInformationLabel.setBackground(Palette.firstPanel);
            add(optionInformationLabel);
        }
    }


    public OptionDataPanel(Option option) {
        settingPanel();

        JPanel optionName = new OptionName(option.getName());
        optionName.setPreferredSize(new Dimension(400, 60));
        // TODO: 정보를 추가하게된다면 아래 부분 실제 옵션의 정보를 받아오도록 수정
        JPanel optionInformation = new OptionInformation("");
        optionInformation.setPreferredSize(new Dimension(400, 90));

        add(optionName);
        add(optionInformation);
    }
}
