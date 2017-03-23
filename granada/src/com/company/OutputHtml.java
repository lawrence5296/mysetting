package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.io.IOException;
import java.math.RoundingMode;
import com.company.LevelTable;
import com.company.PersonExpData;
import com.company.ExpCalculator;

public class OutputHtml {

    public void output(List<PersonExpData> personData, ExpCalculator expCalculator) {
        try {
            File file = new File("redmine.html");

            if (checkBeforeWritefile(file)) {
                PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"Shift-JIS")));

                // Start outputting HTML.
                pw.println("<html>");
                pw.println("<html xmlns=\"http://www.w3.org/1999/xhtml\" lang=\"ja\">");
                pw.println(" <head>");
                pw.println("<title>REDMINE EXPERIENCE LIST</title>");
                pw.println("<link rel=\"stylesheet\" href=\"./redmine.css\" type=\"text/css\" />");
                pw.println("<link rel=\"stylesheet\" href=\"chart.css\">");
                pw.println("<script src=\"https://code.createjs.com/createjs-2015.11.26.min.js\"></script>");
                pw.println("<script src=\"https://cdn.rawgit.com/ics-creative/ParticleJS/release/0.1.2/libs/particlejs.min.js\"></script>");
                pw.println("<script src=\"effect.js\"></script>");
                pw.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=Shift_JIS\">");
                pw.println("</head>");
                pw.println(" <body>");
                pw.println("<h1>REDMINE EXPERIENCE LIST</h1>");
                pw.println("<table class=\"type12\">");
                pw.println("<thead>");
                pw.println("<tr>");
                pw.println("<th scope=\"cols\" class=\"col01\">Workers</th>");
                pw.println("<th scope=\"cols\" class=\"col02\">Level</th>");
                pw.println("<th scope=\"cols\" class=\"col03\">Next Level</th>");
                pw.println("</tr>");
                pw.println("</thead>");
                pw.println("<tbody>");

                // Output workers personal data.
                personData.forEach( p -> {
                    pw.println("<tr>");
                    pw.println("<td class=\"col01\">" + p.getName() + "</th>");
                    if (p.isLevelUp()){
                        pw.println("<td class=\"col04\">Lv." + expCalculator.getLevel(p.getExp()) + "</th>");
                    }else {
                        pw.println("<td class=\"col02\">Lv." + expCalculator.getLevel(p.getExp()) + "</th>");
                    }
                    pw.println("<td class=\"col03\">");
                    pw.println("<div class=\"charts\">");
                    pw.println("<div class=\"charts__chart chart--p100 chart--xl chart--default\">");
                    pw.println("	<div class=\"charts__chart chart--p"
                            + Math.round((double)expCalculator.getCurrentExp(p.getExp())/(double)expCalculator.getNextExp(p.getExp())*100.0)
                            + " chart--xl chart--green\" data-percent></div>");
                    pw.println("</div>");
                    pw.println("</div>");
                    pw.println("</th>");
                    pw.println("</tr>");
                    if (p.isLevelUp()){
                        pw.println("<canvas class=\"effect\" width=\"1400\" height=\"1040\" id=\"myCanvas\"></canvas>");
                    }
                    System.out.println(p.toString());
                    System.out.println("level=" + expCalculator.getLevel(p.getExp()));
                    System.out.println("current=" + expCalculator.getCurrentExp(p.getExp()));
                    System.out.println("next=" + expCalculator.getNextExp(p.getExp()));
                    System.out.println("rate=" + Math.round((double)expCalculator.getCurrentExp(p.getExp())/(double)expCalculator.getNextExp(p.getExp())*100.0));
                });


                pw.println("</tbody>");
                pw.println("</table>");

                pw.println("<hr />");
                pw.println("<footer>");
                pw.println("</footer>");
                pw.println("</body>");
                pw.println("</html>");

                // Outputting HTML finished.
                pw.close();

                System.out.println("Output finished.");
            } else {
                System.out.println("Can not write file.");
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    // Check whether exists redmine.html. If it does not exists, create it.
    private static boolean checkBeforeWritefile(File file) {
        if (file.exists()) {
            System.out.println("redmine.html exists.");
            if (file.isFile() && file.canWrite()) {
                System.out.println("redmine.html can Write");
                return true;
            }
        } else {
            System.out.println("file not exists.");
            try {
                System.out.println("create redmine.html.");
                file.createNewFile();
                return true;
            } catch (IOException e) {
                System.err.println(e);
                System.err.println("can not create redmine.html");
                return false;
            }
        }
        return false;
    }


}
