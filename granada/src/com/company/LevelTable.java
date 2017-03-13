package com.company;

public class LevelTable {
    private int level;
    private int exp;
    private int expSum;

    public LevelTable(int level, int exp, int expSum) {
        this.level = level;
        this.exp = exp;
        this.expSum = expSum;
    }

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

    public int getExpSum() {
        return expSum;
    }

    public void setExpSum(int expSum) {
        this.expSum = expSum;
    }

    @Override
    public String toString() {
        return "LevelTable{" +
                "level=" + level +
                "exp=" + exp +
                ", expSum=" + expSum +
                '}';
    }
}
