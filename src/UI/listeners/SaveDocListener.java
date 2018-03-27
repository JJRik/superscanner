package UI.listeners;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class SaveDocListener implements DocumentListener{

    @Override
    public void insertUpdate(DocumentEvent e) {
        Document doc = e.getDocument();
        if (doc.getLength() == 1){

        }
    }

    @Override
    public void removeUpdate(DocumentEvent e) {

    }

    @Override
    public void changedUpdate(DocumentEvent e) {

    }
}
