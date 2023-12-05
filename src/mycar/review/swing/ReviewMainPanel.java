package mycar.review.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import mycar.Option;
import mycar.swing.tools.LoadImage;
import mycar.ui.Palette;

public class ReviewMainPanel extends JPanel {

    Option option;
    GridBagConstraints gridBagConstraints = new GridBagConstraints();
    GridBagLayout gridBagLayout = new GridBagLayout();

    private void setting() {
        setBackground(Palette.background);
        setLayout(gridBagLayout);
        setBorder(new LineBorder(Color.BLACK, 2));
        gridBagConstraints.fill = GridBagConstraints.BOTH;

    }

    public void processGetOption(Option option) {
        this.option = option;
    }

    private void makeGridBag(JComponent c, int x, int y, int w, int h) {
        gridBagConstraints.gridx = x;
        gridBagConstraints.gridy = y;
        gridBagConstraints.gridwidth = w;
        gridBagConstraints.gridheight = h;

        gridBagLayout.setConstraints(c, gridBagConstraints);

    }
    private static String removeParenthesesContent(String input) {
        // 정규식 패턴: 괄호로 둘러싸인 내용 제거
        Pattern pattern = Pattern.compile("\\([^)]*\\)");
        Matcher matcher = pattern.matcher(input);
        return matcher.replaceAll("").trim();
    }
    public ReviewMainPanel(Option option) {
        //TODO 옵션 받는거 수정;
        setting();
        String optionName = removeParenthesesContent(option.getName());
        JPanel optionImgPanel = new LoadImage("../../../images/"+optionName+".jpg", 400, 400);

        //JPanel optionImgPanel = new OptionImgPanel("none.png", 400, 400);
        optionImgPanel.setPreferredSize(new Dimension(400, 400));
        makeGridBag(optionImgPanel, 0, 0, 40, 40);
        add(optionImgPanel, gridBagConstraints);

        JPanel optionDataPanel = new OptionDataPanel(option);
        optionDataPanel.setPreferredSize(new Dimension(400, 150));
        makeGridBag(optionDataPanel, 40, 0, 4, 15);
        add(optionDataPanel, gridBagConstraints);

        JPanel reviewListPanel = new ReviewListPanel(option);
        reviewListPanel.setPreferredSize(new Dimension(400, 250));
        makeGridBag(reviewListPanel, 40, 15, 40, 15);
        add(reviewListPanel, gridBagConstraints);

    }
}
