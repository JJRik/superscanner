package UI.listeners;

import domain.Doc;
import domain.GenerateAHK;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.KeyEvent;

public class TypeListener implements DocumentListener{
    GenerateAHK ahk;
    Doc doc;


    public TypeListener(GenerateAHK ahk, Doc doc) {
        this.ahk = ahk;
        this.doc = doc;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        Document document = e.getDocument();
        try {
            Robot robot = new Robot();
            try {
                String type = document.getText(0,1);
                if (document.getLength() == 1) {
                    doc.setType(type);
                    ahk.add(doc);
                    robot.keyPress(KeyEvent.VK_TAB);
                }
            }catch (Exception c) {
            }
        } catch (AWTException e1) {
            //e1.printStackTrace();
        }
    }

    @Override
    public void removeUpdate(DocumentEvent e) {

    }

    @Override
    public void changedUpdate(DocumentEvent e) {

    }
}
