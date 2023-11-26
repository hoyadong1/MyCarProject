package mycar.purchasecar.swing;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import mycar.Car;
import mycar.MyCarProgram;
import mycar.User;
import mycar.purchasecar.swing.comparepanel.PurchaseCarComparePanel;

public class MainApplication {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Main Application");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(1200, 800);

                MyCarProgram myCarProgram = new MyCarProgram();
                myCarProgram.run();

                Car tempCar = MyCarProgram.findCar("모닝");
                User.getInstance().addBasket(tempCar);

                PurchaseCarComparePanel comparisonPanel = new PurchaseCarComparePanel(tempCar,
                    null);
                comparisonPanel.getObject(tempCar, null);
                frame.add(comparisonPanel);

                CarSelectPanel test = new CarSelectPanel();
                //frame.add(test);

                frame.getContentPane().setBackground(Color.BLUE);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
