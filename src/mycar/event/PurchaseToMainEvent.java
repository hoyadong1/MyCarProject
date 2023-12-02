package mycar.event;

import facade.EventHandler;
import java.awt.CardLayout;
import java.awt.Container;

public class PurchaseToMainEvent implements EventHandler {

    CardLayout cardLayout;
    Container getContentPane;

    @Override
    public void handleEvent() {
        System.out.println("Button clicked! Handling the event in MyEventHandler.");
        cardLayout.show(getContentPane, "main");
    }

    public PurchaseToMainEvent(CardLayout cardLayout, Container getContentPane) {
        this.cardLayout = cardLayout;
        this.getContentPane = getContentPane;
    }
}
