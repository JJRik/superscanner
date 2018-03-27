package UI.listeners;

import domain.Doc;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.*;

public class YearListener implements DocumentListener {
    Doc doc;

    public YearListener(Doc doc) {
        this.doc = doc;
    }

    @Override
    public void insertUpdate(DocumentEvent e){
        Document document = e.getDocument();

        try {
            Robot robot = new Robot();
            try{
                String year = document.getText(0, 2).toString();
                if (document.getLength() == 2) {
                    if (!year.matches("(0[1-9]|1[0-8]|9[0-9])")) {
                        robot.keyPress(KeyEvent.VK_BACK_SPACE);
                        robot.keyPress(KeyEvent.VK_BACK_SPACE);
                        return;
                    }

                    this.doc.setYears(year);
                    robot.keyPress(KeyEvent.VK_TAB);
                }
            }catch (Exception a){
            }
        } catch (AWTException e1) {
        }
    }

    @Override
    public void removeUpdate(DocumentEvent e){
    }

    @Override
    public void changedUpdate(DocumentEvent e){
    }
}



