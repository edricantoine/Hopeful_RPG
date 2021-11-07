package model;

import java.util.Objects;

public abstract class Skill {
    protected String name;
    protected String flavor;
    protected int apCost;
    protected int maxCooldown;
    protected int currCooldown;
    protected String target;

    //Target can be either "one" or "all".

    public Skill(String name, String flavor, int apCost, int cooldown, String target) {
        this.name = name;
        this.flavor = flavor;
        this.apCost = apCost;
        this.maxCooldown = cooldown;
        this.currCooldown = 0;
        this.target = target;
    }

    public String getName() {
        return name;
    }

    public String getFlavor() {
        return flavor;
    }

    public int getApCost() {
        return apCost;
    }

    public int getMaxCooldown() {
        return maxCooldown;
    }

    public int getCurrCooldown() {
        return currCooldown;
    }

    public String getTarget() {
        return target;
    }

    public abstract void takeEffect(Char c);

    public Boolean isOnCooldown() {
        return this.currCooldown != 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Skill)) return false;
        Skill skill = (Skill) o;
        return name.equals(skill.name) && flavor.equals(skill.flavor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, flavor);
    }
}
