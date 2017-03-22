package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.company.LevelTable;

public class ExpCalculator {
    final static int firstTerm = 5;
    final static int maxLevel = 1000;
    final static int expWeight = 5;
    private List<LevelTable> levelTable;

    // Create level table.
    public ExpCalculator() {
        List<LevelTable> tables = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < maxLevel; i++) {
            int term = i / expWeight + firstTerm;
            sum = sum + term;
            tables.add(i, new LevelTable(i, term, sum));
        }
        this.levelTable = tables;
    }
    
    // Get current Exp from exp sum.
    public int getCurrentExp(int exp) {
        if (exp < firstTerm) { return 0;}
       return exp - levelTable.stream()
               .filter(lt -> lt.getLevel() == getLevel(exp)-1 )
               .map(table -> table.getExpSum())
               .collect(Collectors.toList())
               .get(0);
    }
    
    // Get next Exp from exp sum.
    public int getNextExp(int exp) {
        return levelTable.stream()
                .filter(lt -> lt.getExpSum() > exp)
                .map(table -> table.getExp())
                .collect(Collectors.toList())
                .get(0);
    }

    // Get current level from exp sum.
    public int getLevel(int exp) {
        return  levelTable.stream()
                .filter(lt -> lt.getExpSum() > exp)
                .map(table -> table.getLevel())
                .collect(Collectors.toList())
                .get(0);
    }

    public void printLevelTable() {
        levelTable.forEach((table) -> {
            System.out.println("level:" + table.getLevel());
            System.out.println("exp:" + table.getExp());
            System.out.println("expSum  :" + table.getExpSum());
        });
    }
}


