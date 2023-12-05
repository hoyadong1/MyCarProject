package mycar.purchasecar.swing;

import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import mycar.purchasecar.swing.carselect.CarSelectPanel;

public class MainPanel extends JPanel {

    private static MainPanel instance = null;
    public CardLayout cardLayout;

    private void setting() {
        cardLayout = new CardLayout();
        setLayout(cardLayout);
        setPreferredSize(new Dimension(1200, 800));
        CarSelectPanel panel1 = new CarSelectPanel();

        add(panel1, "panel1");
    }

    public static MainPanel getInstance() {
        if (instance == null) {
            instance = new MainPanel();
        }
        return instance;
    }

    private MainPanel() {
        setting();
    }

    public void showPanel(String panelName) {
        cardLayout.show(this, panelName);
    }
}
