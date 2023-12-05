package mycar.selectoption.swing;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.border.Border;

public class CustomListCellRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        // Set the font size to 14 (change it to your desired size)
        Font font = renderer.getFont().deriveFont(15.0f);
        renderer.setFont(font);
        Border lineBorder = BorderFactory.createLineBorder(Color.BLACK);
        Border emptyBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(lineBorder, emptyBorder));
        return renderer;
    }
}
