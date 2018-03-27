package UI;

import UI.listeners.*;

import domain.Doc;
import domain.GenerateAHK;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class UserInterface implements Runnable {
    private JFrame frame;
    GenerateAHK ahk = new GenerateAHK();

    public UserInterface() {
    }


    @Override
    public void run() {
        frame = new JFrame("Title");
        frame.setPreferredSize(new Dimension(500, 600));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        JTextField regNr = new JTextField("1309");
        //JPanel regPaner = new JPanel();
        regNr.getDocument().addDocumentListener(new RegNrListener(ahk));
        container.add(regNr, BorderLayout.NORTH);
        container.add(createPanel(regNr));
       // container.addKeyListener(new SendToBrowserListener(ahk));
    }

    private JPanel createPanel(JTextField regNr) {


        int rows = 8;
        int cols = 6;

        JPanel skeleton = new JPanel(new GridLayout(rows, cols, 0, 0));

        JPanel[][] panels = new JPanel[rows][cols];

        int page = 0;
        for (int i = 0; i < rows; i++){

            Doc doc = new Doc("","","","","","");


            for (int j = 0; j < cols; j++){
                panels[i][j] = new JPanel();
                JTextField input = new JTextField();
                Border border = BorderFactory.createLineBorder(Color.BLACK);
                input.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(5, 5, 5, 5)));

                if (j == 0) {
                    input.setColumns(2);
                    input.getDocument().addDocumentListener(new DayListener(doc));
                    input.addKeyListener(new SendToBrowserListener(ahk, frame));
                }
                if (j == 1) {
                    input.setColumns(2);
                    input.getDocument().addDocumentListener(new MonthListener(doc));
                }
                if (j == 2){
                    input.setColumns(4);
                    input.getDocument().addDocumentListener(new YearListener(doc));
                }
                if (j == 3){
                    input.setColumns(2);
                    input.setText(String.valueOf(page+1));
                    page += 1;
                    doc.setStartPage(String.valueOf(page));
                    input.addFocusListener(new PageListeners());

                }
                if (j == 4){
                    input.setColumns(2);
                    input.setText(String.valueOf(page +1));
                    page += 1;
                    doc.setLastPage(String.valueOf(page));
                    input.addFocusListener(new PageListeners());

                }
                if (j == 5){
                    input.setColumns(4);
                    input.getDocument().addDocumentListener(new TypeListener(ahk, doc));


                }
                panels[i][j].add(input);
                skeleton.add(panels[i][j]);
            }
        }
        //System.out.println(ahk);
        return skeleton;
    }



}
