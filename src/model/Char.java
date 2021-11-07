package model;

import java.util.List;

public abstract class Char {
    protected String name;
    protected String flavor;
    protected int maxhp;
    protected int maxap;
    protected int hp;
    protected int ap;
    protected List<Skill> skills;
    protected List<Skill> activeSkills;
    protected StatusEffect currentStatus;
    protected double atkMod;
    protected double defMod;
    protected int speed;
    protected Boolean isDead;

    //constructor

    public Char(String name, int maxhp, int maxap, List<Skill> skills, int speed, String flavor) {
        this.name = name;
        this.maxhp = maxhp;
        this.maxap = maxap;
        this.skills = skills;
        this.activeSkills = skills;
        this.speed = speed;
        this.hp = maxhp;
        this.ap = maxap;
        this.currentStatus = StatusEffect.NONE;
        this.atkMod = 1.0;
        this.defMod = 1.0;
        this.flavor = flavor;
        this.isDead = false;
    }

    //getters and setters


    public Boolean getDead() {
        return isDead;
    }

    public List<Skill> getActiveSkills() {
        return activeSkills;
    }

    public String getFlavor() {
        return flavor;
    }

    public String getName() {
        return name;
    }

    public int getMaxhp() {
        return maxhp;
    }

    public int getMaxap() {
        return maxap;
    }

    public double getAtkMod() {
        return atkMod;
    }

    public void setAtkMod(double atkMod) {
        this.atkMod = atkMod;
    }

    public double getDefMod() {
        return defMod;
    }

    public void setDefMod(double defMod) {
        this.defMod = defMod;
    }

    public int getHp() {
        return hp;
    }

    public int getAp() {
        return ap;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public StatusEffect getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(StatusEffect currentStatus) {
        this.currentStatus = currentStatus;
    }

    public int getSpeed() {
        return speed;
    }

    public void addToActiveSkills(Skill s) {
        if(skills.contains(s) && !activeSkills.contains(s)) {
            activeSkills.add(s);
        }
    }

    public abstract void useSkill(Skill s);
}
