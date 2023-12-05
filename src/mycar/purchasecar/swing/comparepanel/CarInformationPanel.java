package mycar.purchasecar.swing.comparepanel;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import mycar.Car;
import mycar.swing.tools.LoadImage;
import mycar.ui.Palette;

public class CarInformationPanel extends JPanel {

    LoadImage carImagePanel;
    CarTextPanel carTextPanel;

    private void setting() {
        setLayout(null);
        setPreferredSize(new Dimension(516, 258));
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setBorder(new LineBorder(Color.black, 2));
        setBackground(Palette.firstPanel);
    }

    private void makeLayout(JComponent component, int x, int y, int w, int h) {
        component.setSize(w, h);
        component.setLocation(x, y);
        add(component);
    }

    public void updateCar(Car car) {
        carTextPanel.updateLabel(car);
        String imagePath;
        if (car == null) {
            imagePath = "../../../images/none.png";
        } else {
            imagePath = "../../../images/" + car.getCarCode() + "_front.jpg";
        }
        carImagePanel.updateImage(imagePath,200,200);
    }

    public CarInformationPanel(Car car) {
        setting();
        if(car == null){
            carImagePanel = new LoadImage("../../../images/none.png", 200, 200);
        }else{
            carImagePanel = new LoadImage("../../../images/"+car.getCarCode()+"_front.jpg", 200, 200);

        }
        makeLayout(carImagePanel, 24, 29, 200, 200);
        carTextPanel = new CarTextPanel(car);
        makeLayout(carTextPanel, 244, 29, 248, 200);

    }
}
