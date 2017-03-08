package com.company;

import java.util.ArrayList;
import java.util.List;

public class ExpCalculator {
    final static int firstTerm = 6;
    final static int term = 1;
    final static List<levelTable> levelTable = new ArrayList<>();

    public ExpCalculator() {
        for (int i = 0; i < 1000; i++) {
            levelTable.get(i).setLevel(i);
            levelTable.get(i).setExp(i/2 * (2*firstTerm - (i-1)*term));
        }
    }

    public static int getCurrentExp(int level) {
        System.out.println("getCurrentExp input:" + level);
        return level/2 * (2*firstTerm - (level-1)*term);
    }

    public static int getNextExp(int level) {
        System.out.println("getNextExp input:" + level);
        level++;
        return level/2 * (2*firstTerm - (level+1)*term);
    }

    public static int getLevel(int exp) {
        System.out.println("getLevel:" + exp);
        for(int i=0; ; i++) {
           if(getNextExp(i) >= exp ) {
               return i-1;
           }
        }
    }

    public static void printLevelTable() {
        levelTable.forEach((table) -> {
            System.out.println("level:"+table.getLevel());
            System.out.println("exp  :"+table.getExp());
        });
    }
}

class levelTable {
    private int level;
    private int exp;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
}
