package UI.listeners;

import domain.Doc;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.KeyEvent;

public class MonthListener implements DocumentListener {
    Doc doc;

    public MonthListener(Doc doc) {
        this.doc = doc;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        Document document = e.getDocument();

        try {
            Robot robot = new Robot();
            try{
                String month = document.getText(0, 2).toString();
                if (document.getLength() == 2) {
                    if (!month.matches("(0[1-9]|1[0-2])")) {
                        robot.keyPress(KeyEvent.VK_BACK_SPACE);
                        robot.keyPress(KeyEvent.VK_BACK_SPACE);
                        return;
                    }
                    this.doc.setMonths(month);
                    robot.keyPress(KeyEvent.VK_TAB);
                }
            }catch (Exception a){
                }


                try {
                   // System.out.println(doc.getText(0, 2));
                } catch (Exception es) {
                }


        } catch (AWTException e1) {
        }
    }

    @Override
    public void removeUpdate(DocumentEvent e) {

    }

    @Override
    public void changedUpdate(DocumentEvent e) {

    }
}
