package com.company;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String args[]) {
        List<PersonExpData> personData;
        ExpCalculator expCalculator = new ExpCalculator();
        CsvUpdater csvUpdater = new CsvUpdater(expCalculator);
        OutputHtml outputHtml = new OutputHtml();

        try {
            // Infinity loop
            while (true) {
                // Update data
                personData = csvUpdater.update();
                // Output data
                outputHtml.outputHtml(personData, expCalculator);
                // TODO: backup data
                Thread.sleep(10);
                break;
            }
        } catch (InterruptedException e) {
            System.err.println("Interrupted Exception");
        }
    }

    private static void backupData() {
       // TODO: implement backup
    }
}