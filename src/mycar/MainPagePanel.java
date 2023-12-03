package mycar;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import mycar.ui.Palette;

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
        this.setBackground(Palette.background);
        this.setBounds(0, 0, 1184, 761);
        this.setLayout(null);
        this.setVisible(false);

        JLabel manu = new JLabel("Menu");
        manu.setFont(new Font("Constantia", Font.BOLD, 50));
        manu.setBounds(502, 10, 205, 114);
        this.add(manu);

        JLabel lblNewLabel11 = new JLabel("          차량 추천");
        lblNewLabel11.setFont(new Font("HY헤드라인M", Font.BOLD, 15));
        lblNewLabel11.setBounds(179, 358, 195, 30);
        this.add(lblNewLabel11);

        JLabel lblSearchRealCars = new JLabel(" 차량 매물 검색");
        lblSearchRealCars.setFont(new Font("HY헤드라인M", Font.BOLD, 15));
        lblSearchRealCars.setBounds(840, 358, 188, 30);
        this.add(lblSearchRealCars);

        JLabel lblCarPurchaseEstimate = new JLabel("     차량 구매 견적");
        lblCarPurchaseEstimate.setFont(new Font("HY헤드라인M", Font.BOLD, 15));
        lblCarPurchaseEstimate.setBounds(179, 680, 139, 30);
        this.add(lblCarPurchaseEstimate);

        JLabel lblCarRepairEstimate = new JLabel("차량 부품 수리 견적");
        lblCarRepairEstimate.setFont(new Font("HY헤드라인M", Font.BOLD, 15));
        lblCarRepairEstimate.setBounds(840, 680, 145, 30);
        this.add(lblCarRepairEstimate);
    }
}