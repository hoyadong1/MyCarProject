package mycar;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mycar.ui.Palette;

public class BookMarkPanel extends JPanel {
    private JList<String> favoriteListUI;
    private DefaultListModel<String> listModel;
    private JButton removeButton;

    public BookMarkPanel() {
        setLayout(new BorderLayout());
        listModel = new DefaultListModel<>();
        favoriteListUI = new JList<>(listModel);
        favoriteListUI.setBackground(Palette.listSelect);
        favoriteListUI.setFont(new Font("굴림", Font.PLAIN, 16));
        add(new JScrollPane(favoriteListUI), BorderLayout.CENTER);

        removeButton = new JButton("해제");
        removeButton.setBounds(950, 56, 240, 36); 
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = favoriteListUI.getSelectedIndex();
                if (row != -1) {
                    String storeLocation = favoriteListUI.getModel().getElementAt(row);
                    removeFavorite(storeLocation);
                    JOptionPane.showMessageDialog(null, "즐겨찾기에서 해제되었습니다.");
                }
            }
        });
        add(removeButton, BorderLayout.SOUTH);
    }
    public void addFavorite(String location) {
        if (isFavorite(location)) {
            JOptionPane.showMessageDialog(null, "이미 즐겨찾기된 지점입니다.");
        } else {
            listModel.addElement(location);
        }
    }

    public boolean isFavorite(String location) {
        return listModel.contains(location);
    }

    public void removeFavorite(String location) {
        listModel.removeElement(location);
    }
    public JList<String> getBookmarkTable() {
        return favoriteListUI;
    }
}