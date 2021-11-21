package model;

import java.util.List;

public abstract class Char {
    protected String name;
    protected String flavor;
    protected double maxhp;
    protected int maxap;
    protected double hp;
    protected int ap;
    protected List<Skill> skills;
    protected StatusEffect currentStatus;
    protected double atkMod;
    protected double defMod;
    protected int speed;
    protected Boolean isDead;
    protected int timeSinceStatusApplied;
    protected Skill selectedSkill;
    protected Item selectedItem;

    public final static int DMG_BURNED = 5;
    public final static int W_BURNED = 3;
    public final static int W_POISONED = 3;
    public final static int W_FROZEN = 1;
    public final static int W_AFRAID = 3;
    public final static int DMG_POISONED = 10;

    //constructor

    public Char(String name, double maxhp, int maxap, List<Skill> skills, int speed, String flavor) {
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
        this.flavor = flavor;
        this.isDead = false;
        this.timeSinceStatusApplied = 0;
        this.selectedSkill = null;
        this.selectedItem = null;
    }

    //getters and setters


    public Skill getSelectedSkill() {
        return selectedSkill;
    }


    public void setSelectedSkill(Skill selectedSkill) {
        this.selectedSkill = selectedSkill;
    }

    public Item getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(Item selectedItem) {
        this.selectedItem = selectedItem;
    }

    public Boolean getDead() {
        return isDead;
    }

    public int getTimeSinceStatusApplied() {
        return timeSinceStatusApplied;
    }

    public String getFlavor() {
        return flavor;
    }

    public String getName() {
        return name;
    }

    public double getMaxhp() {
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

    public double getHp() {
        return hp;
    }

    public double getAp() {
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
        if(currentStatus.equals(StatusEffect.BURNED)) {
            timeSinceStatusApplied = W_BURNED;
        } else if(currentStatus.equals(StatusEffect.POISONED)) {
            timeSinceStatusApplied = W_POISONED;
        } else if(currentStatus.equals(StatusEffect.NUMB)) {
            timeSinceStatusApplied = W_FROZEN;
        } else if(currentStatus.equals(StatusEffect.AFRAID)) {
            timeSinceStatusApplied = W_AFRAID;
            atkMod = 0.75;
            defMod = 1.25;
        } else if (currentStatus.equals(StatusEffect.NONE)) {

            atkMod = 1.0;
            defMod = 1.0;

            timeSinceStatusApplied = 0;
        }
    }

    public int getSpeed() {
        return speed;
    }


    public abstract Boolean useSkill(Skill s, Char c);
    public abstract void useItem(Item i, Char c);

    public Boolean canUseSkill(Skill s) {
        return ((this.ap >= s.getApCost() && (currentStatus != StatusEffect.NUMB)) && !this.getDead());
    }

    public void takeDamage(double d) {

        if((hp - (d * defMod)) <= 0) {
            hp -= (d * defMod);
            kill();
        } else {
            hp -= (d * defMod);
        }
    }

    public void healDamage(double d) {
        if((hp + d) > 0) {
            revive();
        }
        if((hp + d) >= maxhp) {
            hp = maxhp;
        } else {
            hp += d;
        }

    }

    public void useAp(int d) {
        if(ap - d <= 0) {
            ap = 0;
        } else {
            ap -= d;
        }
    }

    public void healAp(int d) {
        if((ap + d) >= maxap) {
            ap = maxap;
        } else {
            ap += d;
        }
    }

    public void kill() {
        isDead = true;
        setCurrentStatus(StatusEffect.NONE);
    }

    public void revive() {
        isDead = false;
    }

    public void turnBeginRoutine() {
        if (currentStatus.equals(StatusEffect.AFRAID)) {
            atkMod = 0.75;
            defMod = 1.25;
        }
    }

    public void turnEndRoutine() {
        if(currentStatus.equals(StatusEffect.BURNED)) {
            takeDamage(DMG_BURNED);
            timeSinceStatusApplied--;
            if(timeSinceStatusApplied == 0) {
                setCurrentStatus(StatusEffect.NONE);
            }
        }

        if(currentStatus.equals(StatusEffect.POISONED)) {
            takeDamage(DMG_POISONED);
            timeSinceStatusApplied--;
            if(timeSinceStatusApplied == 0) {
                setCurrentStatus(StatusEffect.NONE);
            }
        }

        if(currentStatus.equals(StatusEffect.NUMB)) {
            timeSinceStatusApplied--;
            if(timeSinceStatusApplied == 0) {
                setCurrentStatus(StatusEffect.NONE);
            }
        }

        if(currentStatus.equals(StatusEffect.AFRAID)) {
            timeSinceStatusApplied--;
            if(timeSinceStatusApplied == 0) {
                setCurrentStatus(StatusEffect.NONE);
                atkMod = 1;
                defMod = 1;
            }
        }


        healAp(10);
        setSelectedSkill(null);
        setSelectedItem(null);
    }


}
