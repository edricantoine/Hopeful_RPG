package model;

import java.util.List;

public abstract class Char {
    protected String name; //character name
    protected String flavor; //flavor text
    protected double maxhp; //max.hp
    protected int maxap; //max.ap
    protected double hp; //current hp
    protected int ap; //current ap
    protected List<Skill> skills; //skills list
    protected StatusEffect currentStatus; //current status effect
    protected double atkMod; //attack modifier
    protected double defMod; //DAMAGE TAKEN modifier
    protected int speed; //speed
    protected Boolean isDead; //is this character dead?
    protected int timeSinceStatusApplied; //time since last status was applied
    protected Skill selectedSkill; //readied skill
    protected Item selectedItem; //readied item

    public final static int DMG_BURNED = 10; //damage taken per turn while burned
    public final static int W_BURNED = 3; //duration of burn
    public final static int DMG_POISONED = 7; //base damage per turn while poisoned
    public final static int W_POISONED = 3; //duration of poison
    public final static int W_FROZEN = 2; //duration of numb
    public final static int W_AFRAID = 3;//duration of afraid


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


    public void setName(String name) {
        this.name = name;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public Skill getSelectedSkill() {
        return selectedSkill;
    }


    public void setSpeed(int speed) {
        this.speed = speed;
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

    public int getSpeed() {
        return speed;
    }

    //sets current status, but cannot change to anything other than NONE if character is dead

    public void setCurrentStatus(StatusEffect currentStatus) {
        if(currentStatus != StatusEffect.NONE) {
            if (!this.getDead()) {
                this.currentStatus = currentStatus;
                if (currentStatus.equals(StatusEffect.BURNED)) {
                    timeSinceStatusApplied = W_BURNED;
                } else if (currentStatus.equals(StatusEffect.POISONED)) {
                    timeSinceStatusApplied = W_POISONED;
                } else if (currentStatus.equals(StatusEffect.NUMB)) {
                    timeSinceStatusApplied = W_FROZEN;
                } else if (currentStatus.equals(StatusEffect.AFRAID)) {
                    timeSinceStatusApplied = W_AFRAID;

                }
            }
        } else {
            this.currentStatus = StatusEffect.NONE;
            timeSinceStatusApplied = 0;
        }
    }




    //returns skills in string format

    public String getSkillsAsString() {
        StringBuilder temp = new StringBuilder();
        for(int i = 0; i < skills.size(); i++) {
            temp.append("Skill ").append(i + 1).append(": ").append(skills.get(i).getName()).append(" ");
        }
        return temp.toString();
    }

    //if this can use skill, uses skill s on character c like in a battle. Utility function for tests
    public Boolean useSkill(Skill s, Char c) {
        if(canUseSkill(s)) {
            useAp(s.getApCost());
            s.setAtkMod(atkMod);
            s.takeEffect(c);
            s.setAtkMod(1.00);
            return true;
        } else {
            return false;
        }
    }

    //uses item i on character c, like in a battle. Utility function for tests
    public void useItem(Item i, Char c) {
        i.takeEffect(c);
    }

    //if this character can use skill s, returns true. Returns false otherwise.
    public Boolean canUseSkill(Skill s) {
        return ((this.ap >= s.getApCost() && !this.getDead()));
    }

    //takes d damage. If this reduces hp below 0, kills this character.

    public void takeDamage(double d) {

        if((hp - (d * defMod)) <= 0) {
            hp -= (d * defMod);
            kill();
        } else {
            hp -= (d * defMod);
        }
    }

    //heals d damage. If this brings hp above 0, revives this character. Cannot increase hp above maxHp.

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

    //uses d ap. Cannot decrease ap below 0.

    public void useAp(int d) {
        if(ap - d <= 0) {
            ap = 0;
        } else {
            ap -= d;
        }
    }

    //heals d ap. Cannot increase ap past maxAp.
    public void healAp(int d) {
        if((ap + d) >= maxap) {
            ap = maxap;
        } else {
            ap += d;
        }
    }

    //sets character to be dead, and resets attack, defense, and status effect.
    public void kill() {
        isDead = true;
        setAtkMod(1.0);
        setDefMod(1.0);
        setCurrentStatus(StatusEffect.NONE);
    }
    //sets character to not be dead.
    public void revive() {
        isDead = false;
    }

    //applies "AFRAID" attack and defense modifiers. They cannot go above 4.00 or below 0.25.
    //Also, heals 10 AP.
    public void turnBeginRoutine() {
        if (currentStatus.equals(StatusEffect.AFRAID)) {
            if(this.getAtkMod() -0.15 <= 0.25) {
                this.setAtkMod(0.25);
            } else if (this.getAtkMod() - 0.15 >= 4.00) {
                this.setAtkMod(4.00);
            } else {
                this.setAtkMod((this.getAtkMod() - 0.15));
            }
            if(this.getDefMod() + 0.25 <= 0.25) {
                this.setDefMod(0.25);
            } else if (this.getDefMod() + 0.25 >= 4.00) {
                this.setDefMod(4.00);
            } else {
                this.setDefMod((this.getDefMod() + 0.25));
            }
        }
        healAp(10);
    }

    //Applies Burned and Poisoned damage, and decreases time since status applied. Removes effects if
    //their duration is up. Also, sets selected skill and item to null.

    public void turnEndRoutine() {
        if(currentStatus.equals(StatusEffect.BURNED)) {
            takeDamage(DMG_BURNED);
            timeSinceStatusApplied--;
            if(timeSinceStatusApplied == 0) {
                setCurrentStatus(StatusEffect.NONE);
            }
        }

        if(currentStatus.equals(StatusEffect.POISONED)) {
            takeDamage(DMG_POISONED * timeSinceStatusApplied);
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
            }
        }



        setSelectedSkill(null);
        setSelectedItem(null);
    }





}
