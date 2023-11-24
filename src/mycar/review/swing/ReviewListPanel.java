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
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import mycar.Option;
import mycar.Review;

public class ReviewListPanel extends JPanel {

    private void setting() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    }

    private JList<String> makeList(Option option) {

        DefaultListModel<String> listModel = new DefaultListModel<>();

        ArrayList<Review> reviews = (ArrayList<Review>) option.getReviews();
        for (Review review : reviews) {
            String reviewText =
                String.format("%s \t", "☆".repeat(Math.max(0, review.getRating())))
                    + String.format(" review : %s", review.getReviewComment());
            listModel.addElement(reviewText);
        }

        JList<String> tempJList;
        tempJList = new JList<>(listModel);
        tempJList.setPreferredSize(new Dimension(400, 240));
        tempJList.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));
        tempJList.setBackground(new Color(0x597081));
        tempJList.setCellRenderer(new CustomListCellRenderer());
        tempJList.addMouseListener(new MyMouseListener(tempJList));
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
            setPreferredSize(new Dimension(getPreferredSize().width, 30));
            if (isSelected) {
                setBackground(new Color(0xa9cef4)); // 선택할 때의 배경색
                setForeground(Color.WHITE); // 선택할 때의 전경색
            } else {
                setBackground(new Color(0x7ea0b7));
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
            System.out.println("Mouse Clicked: " + e);
            if (SwingUtilities.isLeftMouseButton(e)) {
                int index = jList.locationToIndex(e.getPoint());
                if (index != -1 && !jList.getCellBounds(index, index).contains(e.getPoint())) {
                    // Clicked outside of any item, clear selection
                    jList.clearSelection();
                }
            }
        }
    }


    public ReviewListPanel(Option option) {
        setting();
        setBackground(new Color(227, 191, 191));
        JList<String> reviewList = makeList(option);
        add(reviewList);

        JButton confirmButton = new JButton("confirm");
        add(confirmButton, BorderLayout.SOUTH);
    }

}
