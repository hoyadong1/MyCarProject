package mycar.review.swing;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import mycar.MyCarProgram;
import mycar.Option;

public class MainApplication {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Main Application");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(1000, 500);

                MyCarProgram myCarProgram = new MyCarProgram();
                myCarProgram.run();

                Option testOption = MyCarProgram.findOption("8인치내비게이션(120)");

                JPanel reviewMainPanel = new ReviewMainPanel(testOption);
                frame.add(reviewMainPanel);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
