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

    // Construct level table.
    public ExpCalculator() {
        List<LevelTable> tables = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < maxLevel; i++) {
            int term = i/expWeight + firstTerm;
            sum = sum + term;
            tables.add(i, new LevelTable(i, term,  sum));
        }
        this.levelTable = tables;
    }

    // Get next Exp from exp sum.
    public int getNextExp(int exp) {
        List<Integer> tmp = levelTable.stream()
                .filter( levelTable1 -> levelTable1.getExpSum() > exp )
                .map( table -> table.getExp())
                .collect(Collectors.toList());
        return tmp.get(0).intValue();
    }

    // Get current level from exp sum.
    public int getLevel(int exp) {
        List<Integer> tmp = levelTable.stream()
                .filter( levelTable1 -> levelTable1.getExpSum() > exp)
                .map( table -> table.getLevel())
                .collect(Collectors.toList());
        return tmp.get(0).intValue();
    }

    public void printLevelTable() {
        levelTable.forEach((table) -> {
            System.out.println("level:"+table.getLevel());
            System.out.println("exp:"+table.getExp());
            System.out.println("expSum  :"+table.getExpSum());
        });
    }
}


