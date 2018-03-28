package UI.listeners;

import domain.GenerateAHK;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.lang.Thread.sleep;

public class SendToBrowserListener implements KeyListener{
    GenerateAHK ahk;
    JFrame frame;

    public SendToBrowserListener(GenerateAHK ahk, JFrame frame) {
        this.ahk = ahk;
        this.frame = frame;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER){
            Container container = frame.getContentPane();
            JPanel panel = (JPanel)container.getComponent(1);
            for (Component c: panel.getComponents()){
                JPanel temp = (JPanel)c;
                JTextField tempText = (JTextField)temp.getComponent(0);
                tempText.setText("");
            }
           // System.out.println(panel.getComponents().length);




            JTextField regNR = (JTextField) container.getComponent(0);
            regNR.requestFocus();
            regNR.setText("1309");


            ahk.generateScript();
            try {
                sleep(200);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            ahk.reset();


        }
            //ahk.send();
           // System.out.println("Keystroke " + e.getKeyCode() +  " pressed.");



    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
