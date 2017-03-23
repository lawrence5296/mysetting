package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String args[]) {

        // Sleep time to update. (default = 60)
        int SLEEPTIME_IN_MIN = 60;

        // Set sleep time from args[0]
        if (args.length == 1) {
            SLEEPTIME_IN_MIN = Integer.parseInt(args[0]);
        }

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
                outputHtml.output(personData, expCalculator);
                // TODO: backup data
                // Sleep to update each period
                Thread.sleep(SLEEPTIME_IN_MIN * 1000 * 60);
            }
        } catch (InterruptedException e) {
            System.err.println("Interrupted Exception");
        }
    }

    private static void backupData() {
       // TODO: implement backup
    }

}