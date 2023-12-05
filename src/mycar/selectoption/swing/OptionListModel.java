package mycar.selectoption.swing;

import java.util.Collections;
import javax.swing.DefaultListModel;

public class OptionListModel extends DefaultListModel<String> {
    @Override
    public boolean contains(Object element) {
        String elementWithoutBrackets = ((String) element).replaceAll("\\(.*?\\)", "").trim();
        for (String currentElement : Collections.list(elements())) {
            String currentElementWithoutBrackets = currentElement.replaceAll("\\(.*?\\)", "").trim();
            if (currentElementWithoutBrackets.equals(elementWithoutBrackets)) {
                return true;
            }
        }
        return false;
    }
}
