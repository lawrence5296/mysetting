package com.company;

public class PersonExpData {
    private String name;
    private int exp;
    private boolean levelUp;

    public PersonExpData(String name, int exp) {
        this.name = name;
        this.exp = exp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExp() { return exp; }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public boolean isLevelUp() {
        return levelUp;
    }

    public void addExp(int exp) { this.exp += exp;}

    public void setLevelUp(boolean levelUp) {
        this.levelUp = levelUp;
    }

    @Override
    public String toString() {
        return "PersonExpData{" +
                "name='" + name + '\'' +
                ", exp=" + exp +
                ", levelUp=" + levelUp +
                "}\n";
    }
}
