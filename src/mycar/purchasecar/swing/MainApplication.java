package mycar.purchasecar.swing;

import java.awt.Color;
import java.util.Scanner;
import javax.swing.*;
import mycar.Car;
import mycar.MyCarProgram;

public class MainApplication {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Main Application");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(964, 523);

                MyCarProgram myCarProgram = new MyCarProgram();
                myCarProgram.run();

                Car tempCar = MyCarProgram.findCar("모닝");
                PurchaseCarResult comparisonPanel = new PurchaseCarResult(tempCar, null);

                frame.add(comparisonPanel);

                frame.getContentPane().setBackground(Color.BLUE);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
