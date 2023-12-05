package mycar.review.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import mycar.Option;
import mycar.Review;
import mycar.ui.Palette;

public class ReviewListPanel extends JPanel {

    private void setting() {
        setLayout(new BorderLayout());
        //setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    }
    

    private JList<String> makeList(Option option) {

        DefaultListModel<String> listModel = new DefaultListModel<>();

        ArrayList<Review> reviews = (ArrayList<Review>) option.getReviews();
        for (Review review : reviews) {
            String reviewText =
                String.format("<html>%s \t", "☆".repeat(Math.max(0, review.getRating())))
                    + String.format("<br>%s</html>", review.getReviewComment());
            listModel.addElement(reviewText);
        }

        JList<String> tempJList;
        tempJList = new JList<>(listModel);
        tempJList.setPreferredSize(new Dimension(400, 240));
        tempJList.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));
        tempJList.setBackground(Palette.secondPanel);
        tempJList.setCellRenderer(new CustomListCellRenderer());
        tempJList.addMouseListener(new MyMouseListener(tempJList));
        tempJList.setLayoutOrientation(JList.HORIZONTAL_WRAP);

        return tempJList;
    }

    private static class CustomListCellRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index,
            boolean isSelected, boolean cellHasFocus) {
            // 부모 클래스의 기본 렌더러 호출
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            Border lineBorder = BorderFactory.createLineBorder(Color.BLACK);
            Border emptyBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
            setBorder(BorderFactory.createCompoundBorder(lineBorder, emptyBorder));
            setPreferredSize(new Dimension(getPreferredSize().width, 60));
            if (isSelected) {
                setBackground(Palette.listSelect); // 선택할 때의 배경색
                setForeground(Color.WHITE); // 선택할 때의 전경색
            } else {
                setBackground(Palette.listNotSelect);
            }
            return this;
        }
    }

    class MyMouseListener extends MouseAdapter {

        private JList<String> jList;

        public MyMouseListener(JList<String> jList) {
            this.jList = jList;
        }

        @Override
        public void mouseClicked(MouseEvent e) {

            if (SwingUtilities.isLeftMouseButton(e)) {
                int index = jList.locationToIndex(e.getPoint());
                if (index != -1 && !jList.getCellBounds(index, index).contains(e.getPoint())) {
                    jList.clearSelection();
                }
            }

        }

    }


    public ReviewListPanel(Option option) {
        setting();
        setBackground(Palette.secondPanel);
        JList<String> reviewList = makeList(option);
        JScrollPane reviewScrollList = new JScrollPane(reviewList);
        reviewScrollList.setPreferredSize(new Dimension(400, 240));
        reviewScrollList.getHorizontalScrollBar().setVisible(false);
        add(reviewScrollList);
    }

}
