package mycar.swing.tools;

import java.awt.Font;
import javax.swing.JLabel;

public class JLabelFont {

    public static void setFont(JLabel jLabel, int fontSize) {
        jLabel.setFont(new Font("Constantia", Font.PLAIN, fontSize));
    }

    public static void setFont(JLabel jLabel, int fontStyle, int fontSize) {
        jLabel.setFont(new Font("Constantia", fontStyle, fontSize));
    }

    private JLabelFont() {
    }
}
