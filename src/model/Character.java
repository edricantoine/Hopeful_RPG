package model;

import java.util.List;

public abstract class Character {
    protected String name;
    protected int maxhp;
    protected int maxap;
    protected int hp;
    protected int ap;
    protected List<Skill> skills;
    protected StatusEffect currentStatus;
    protected double atkMod;
    protected double defMod;
    protected int speed;

    public Character(String name, int maxhp, int maxap, List<Skill> skills, int speed) {
        this.name = name;
        this.maxhp = maxhp;
        this.maxap = maxap;
        this.skills = skills;
        this.speed = speed;
        this.hp = maxhp;
        this.ap = maxap;
        this.currentStatus = StatusEffect.NONE;
        this.atkMod = 1.0;
        this.defMod = 1.0;
    }
}
