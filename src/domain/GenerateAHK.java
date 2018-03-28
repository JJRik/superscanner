package domain;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GenerateAHK {
    List<Doc> docs;
    String regNr;
    int pageModifier;

    public String getRegNr() {
        return regNr;
    }

    public GenerateAHK() {
        this.docs = new ArrayList<>();
        this.pageModifier = 0;
    }

    public int getPageModifier() {
        return pageModifier;
    }

    public void onePager(){
        System.out.println("siin");
        pageModifier = pageModifier + 1;
        System.out.println(pageModifier);
    }

    public void add(Doc doc) {
        docs.add(doc);
    }

    public void addRegNr(String regNr) {
        this.regNr = regNr;
    }

    @Override
    public String toString() {
        String result = regNr + "\n";
        for (Doc doc : docs) {
            result += doc.toString() + "\n";
        }
        return result;
    }

    public void reset() {
        docs.clear();
    }

    public void generateScript() {

        try {
            FileWriter writer = new FileWriter("script.ahk");
            //sisesta reg kood ja liigu skännima
            writer.write("^r::\n" + "Reload" + "\n"); // reload the script
            writer.write("^a::" + "\n" +
                    "CoordMode, Mouse, Screen" + "\n" +
                    "MouseMove, 1233, 13" + "\n" +
                    "Click" + "\n" +
                    "Send ^f" + "\n" +
                    "Send i registrikood" + "\n" +
                    "Send {TAB}" + "\n" +
                    "Send {TAB}" + "\n" +
                    "Send" + " " + regNr + "\n" +
                    "Sleep, 1000" + "\n" +
                    "Send " + "{DOWN}" + "\n" +
                    "Send " + "{ENTER}" + "\n" +
                    "Send " + "{ENTER}" + "\n" +
                    "Sleep, 2000" + "\n"
            );
            for (Doc doc : docs) {
                writer.write(
                            "CoordMode, Mouse, Screen" + "\n" +
                                "MouseMove, 990, 440" + "\n" +
                                "Click" + "\n" +
                                "Send " + doc.getDate() + "\n" +
                                "Send " + "{TAB}" + "\n" +
                                "Send " + doc.getStartPage() + "\n" +
                                "Send " + "{TAB}" + "\n" +
                                "Send " + doc.getLastPage() + "\n" +
                                "Send " + "{TAB}" + "\n" +
                                "Send " + doc.getType() + "\n" +
                                "Send " + "{ENTER}" + "\n" +
                                "Sleep, 500" + "\n");
            }
            writer.write("MouseMove, 836, 210" + "\n" +
                    "Sleep, 1000" + "\n" +
                    "Click" + "\n" +
                    "return" + "\n");


            /*String sleeper = String.valueOf(docs.size()) + "000";


            writer.write("^q::" + "\n" +
                    "CoordMode, Mouse, Screen" + "\n" +
                    "MouseMove, 888, 244" + "\n" +
                    "Click" + "\n" +
                    "Sleep, " + sleeper + "\n" +
                    "MouseMove, 1744, 147" + "\n" +
                    "Click" + "\n"

            );*/


            writer.close(); // the call closes the file and makes sure the written text goes to the file
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
