package com.company;

import com.company.PersonExpData;
import com.company.ExpCalculator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CsvUpdater {
    private List<PersonExpData> personData;
    private ExpCalculator expCalculator;

    public CsvUpdater(ExpCalculator expCalculator) {
        this.personData = readFile("inputData");
        this.expCalculator = expCalculator;
        //expCalculator.printLevelTable();
    }

    public List<PersonExpData> update() {
        personData.forEach( p -> p.setLevelUp(false));
        readFile("updateData")
                .forEach( updateData -> {
                    personData.stream()
                            .filter( p -> p.getName().equals(updateData.getName()))
                            .forEach( s -> {
                                int prev = expCalculator.getLevel(s.getExp());
                                s.addExp(updateData.getExp());
                                int current = expCalculator.getLevel(s.getExp());
                                if(prev != current) {
                                    s.setLevelUp(true);
                                }
                            });
                    // TODO: implement add personData when can not find name.
                });
        return personData;
    }

    private List<PersonExpData> readFile(String fileName) {
        List<PersonExpData> personData = new ArrayList<>();
        String tmp[] = new String[2];
        String line;
        StringTokenizer token;
        try {
            FileReader fr = new FileReader("./" + fileName + ".csv");
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
        } catch (FileNotFoundException ex) {
            System.out.println("File:" + fileName + ".csv is not founded.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return personData;
    }
}
