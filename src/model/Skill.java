package model;

import java.util.Objects;

public abstract class Skill {
    protected String name;
    protected String flavor;
    protected int apCost;
    protected String target;

    //Target can be either "one" or "all".

    public Skill(String name, String flavor, int apCost, String target) {
        this.name = name;
        this.flavor = flavor;
        this.apCost = apCost;

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


    public String getTarget() {
        return target;
    }

    public abstract void takeEffect(Char c);

    public abstract void setAtkMod(double atkMod);

    public abstract double getDamage();


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
