package UI;

import UI.listeners.*;

import domain.Doc;
import domain.GenerateAHK;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class UserInterface implements Runnable {
    private JFrame frame;
    GenerateAHK ahk;

    public UserInterface() {
        this.ahk = new GenerateAHK();
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
        int cols = 4;

        JPanel skeleton = new JPanel(new GridLayout(rows, cols, 0, 0));

        JPanel[][] panels = new JPanel[rows][cols];

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
                    input.setColumns(4);
                    TypeListener typeToDoc = new TypeListener(ahk, doc, i);

                    input.getDocument().addDocumentListener(typeToDoc);


                }
                panels[i][j].add(input);
                skeleton.add(panels[i][j]);
            }
        }
        //System.out.println(ahk);
        return skeleton;
    }



}
