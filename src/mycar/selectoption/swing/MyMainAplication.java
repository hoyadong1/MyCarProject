package mycar.selectoption.swing;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MyMainAplication {

    public static void main(String[] args) {
	    SwingUtilities.invokeLater(new Runnable() {
	        @Override
	        public void run() {
	            JFrame frame = new JFrame("test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(1200, 800);
                CarOptionSelect panel = new CarOptionSelect(null);
                frame.add(panel);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
	        }
	    });
    }
}
