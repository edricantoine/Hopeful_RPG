package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Abstract class for Skills.

public abstract class Skill {
    protected String name; //name
    protected String flavor; //flavor text
    protected int apCost; //ap cost of skill
    protected String target; //can be "one" or "all"
    protected List<Char> setTargets; //skill's set targets

    //Target can be either "one" or "all".

    public Skill(String name, String flavor, int apCost, String target) {
        this.name = name;
        this.flavor = flavor;
        this.apCost = apCost;
        setTargets = new ArrayList<>();
        this.target = target;
    }

    //getters, setters

    public List<Char> getSetTargets() {
        return setTargets;
    }

    public void setSetTargets(List<Char> setTargets) {
        this.setTargets = setTargets;
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

    public abstract void setAtkMod(double atkMod);

    public abstract double getDamage();

    //adds c to set targets

    public void addToSetTargets(Char c) {
        if(!setTargets.contains(c)) {
            setTargets.add(c);
        }
    }

    public abstract void takeEffect(Char c);

    //equals function is based on name and flavor text.
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
