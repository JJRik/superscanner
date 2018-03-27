package UI.listeners;

import domain.GenerateAHK;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.KeyEvent;

public class RegNrListener implements DocumentListener {
    GenerateAHK ahk;

    public RegNrListener(GenerateAHK ahk) {
        this.ahk = ahk;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        Document document = e.getDocument();

        try {
            Robot robot = new Robot();
            try {
                if (document.getLength() == 7) {
                    String regNr = document.getText(0, 7);
                    ahk.addRegNr(regNr);
                    robot.keyPress(KeyEvent.VK_TAB);
                }
            } catch (Exception a) {
            }
        } catch (Exception b){
        }
    }

    @Override
    public void removeUpdate(DocumentEvent e) {

    }

    @Override
    public void changedUpdate(DocumentEvent e) {

    }

}
