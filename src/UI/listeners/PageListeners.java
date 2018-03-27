package UI.listeners;

import domain.Doc;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;

public class PageListeners implements FocusListener{

    @Override
    public void focusGained(FocusEvent e) {
        try {

            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_TAB);
        } catch (Exception e1) {

        }
    }

    @Override
    public void focusLost(FocusEvent e) {

    }
}
