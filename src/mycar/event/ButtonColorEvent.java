package mycar.event;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import mycar.ui.Palette;

public class ButtonColorEvent extends MouseAdapter {
    private final JButton button;
    @Override
    public void mousePressed(MouseEvent e) {
        // 클릭할 때 랜덤한 버튼 색상을 생성하여 설정
        button.setBackground(Palette.listSelect);
    }

    public ButtonColorEvent(JButton button){
        this.button = button;
    }
}
