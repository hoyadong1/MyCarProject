package mycar.selectoption.swing;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import mycar.Car;
import mycar.MyCarProgram;
import mycar.purchasecar.swing.MainPanel;

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
                OptionSelectBtnPanel test = new OptionSelectBtnPanel();
                frame.add(test);

                frame.getContentPane().setBackground(Color.BLUE);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
