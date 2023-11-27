package mycar;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPagePanel extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * Create the panel.
     */
    public MainPagePanel() {
        this.setForeground(new Color(0, 0, 0));
        this.setBackground(new Color(255, 255, 255));
        this.setBounds(0, 0, 964, 523);
        this.setLayout(null);
        this.setVisible(false);

        JLabel manu = new JLabel("Menu");
        manu.setFont(new Font("Constantia", Font.BOLD, 40));
        manu.setBounds(428, 10, 155, 66);
        this.add(manu);

        JLabel lblNewLabel11 = new JLabel("Car Recommendation");
        lblNewLabel11.setFont(new Font("Constantia", Font.BOLD, 12));
        lblNewLabel11.setBounds(33, 219, 167, 15);
        this.add(lblNewLabel11);

        JLabel lblSearchRealCars = new JLabel("Search real cars for sale");
        lblSearchRealCars.setFont(new Font("Constantia", Font.BOLD, 12));
        lblSearchRealCars.setBounds(555, 217, 167, 15);
        this.add(lblSearchRealCars);

        JLabel lblCarPurchaseEstimate = new JLabel("Car purchase estimate");
        lblCarPurchaseEstimate.setFont(new Font("Constantia", Font.BOLD, 12));
        lblCarPurchaseEstimate.setBounds(33, 487, 167, 15);
        this.add(lblCarPurchaseEstimate);

        JLabel lblCarRepairEstimate = new JLabel("Car repair estimate");
        lblCarRepairEstimate.setFont(new Font("Constantia", Font.BOLD, 12));
        lblCarRepairEstimate.setBounds(555, 485, 167, 15);
        this.add(lblCarRepairEstimate);
    }

}
