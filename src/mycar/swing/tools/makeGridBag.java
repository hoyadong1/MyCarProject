package mycar.swing.tools;

import java.awt.GridBagConstraints;

public class makeGridBag {

    public void makeGridBag(GridBagConstraints gridBagConstraints, int x, int y,
        int w, int h) {
        gridBagConstraints.gridx = x;
        gridBagConstraints.gridy = y;
        gridBagConstraints.gridwidth = w;
        gridBagConstraints.gridheight = h;

    }
}
