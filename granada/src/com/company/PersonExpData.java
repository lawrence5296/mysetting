package com.company;

public class PersonExpData {
    private String name;
    private int exp;
    private int level;

    public PersonExpData(String name, int exp, int level) {
        this.name = name;
        this.exp = exp;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonExpData)) return false;

        PersonExpData that = (PersonExpData) o;

        if (getExp() != that.getExp()) return false;
        if (getLevel() != that.getLevel()) return false;
        return getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getExp();
        result = 31 * result + getLevel();
        return result;
    }
}
