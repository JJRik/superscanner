package UI.listeners;

import domain.Doc;
import domain.GenerateAHK;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.KeyEvent;

public class TypeListener implements DocumentListener{
    private GenerateAHK ahk;
    private Doc doc;
    private int level;



    public TypeListener(GenerateAHK ahk, Doc doc, int level) {
        this.ahk = ahk;
        this.doc = doc;
        this.level = level + 1;

    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        Document document = e.getDocument();
        int pageModifier = ahk.getPageModifier();
        System.out.println(pageModifier);
        int firstPage = (level* 2 - 1) - pageModifier;
        doc.setStartPage(String.valueOf(firstPage));
        try {
            Robot robot = new Robot();
            try {
                String type = document.getText(0,document.getLength());
                if (document.getLength() == 1 && type.equals("7")) {
                    doc.setType(type);

                    doc.setLastPage(String.valueOf((firstPage + 1)));
                    ahk.add(doc);
                    robot.keyPress(KeyEvent.VK_TAB);
                }
                else if (document.getLength() == 1 && type.equals("6")){
                    ahk.onePager();
                    doc.setType(type);
                    doc.setLastPage(String.valueOf(firstPage));

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
