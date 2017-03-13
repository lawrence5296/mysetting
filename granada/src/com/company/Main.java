package com.company;

import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.StringTokenizer;
import java.io.IOException;

import com.company.PersonExpData;
import com.company.ExpCalculator;

public class Main {
    public static void main(String args[]) {
        // Initialize current data
        List<PersonExpData> personData = initialize();
        ExpCalculator expCalculator = new ExpCalculator();

        System.out.println(personData);

        // Infinity loop to get redmine data each 30 min.
        try {
            while (true) {
                // TODO: Update personData by reading csv file.


                // TODO: Output html.
                // TODO: Backup data.
                // Thread.sleep(60000 * 30);
                Thread.sleep(10);
                // System.out.println("1:" + ExpCalculator.getNextExp(0));
                // System.out.println("2:" +ExpCalculator.getNextExp(6));
                // System.out.println("3:" +ExpCalculator.getLevel(1));
                // System.out.println("4:" +ExpCalculator.getLevel(2));
                expCalculator.printLevelTable();
                personData.forEach( s -> {
                    System.out.println(s.getName());
                    System.out.println(expCalculator.getLevel(s.getExp()));
                    System.out.println(expCalculator.getNextExp(s.getExp()));
                });
                break;
            }
        } catch(InterruptedException e) {
        }
    }

    private static List<PersonExpData> initialize() {
        List<PersonExpData> personData = new ArrayList<>();
        String tmp[] = new String[2];
        String line;
        StringTokenizer token;
        try {
            FileReader fr = new FileReader("./inputData.csv");
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) { // read csv line to EOF
                token = new StringTokenizer(line, ",");
                int count = 0;
                while (token.hasMoreTokens()) {
                    tmp[count] = token.nextToken();
                    count++;
                }
                personData.add(new PersonExpData(tmp[0], Integer.parseInt(tmp[1])));
            }
            br.close();
            fr.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return personData;
    }

}