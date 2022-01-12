package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Item {
    private String name; //item name
    private String flavor; //flavor text
    private double damage; //item damage
    private double healing; //item healing
    private int apHeal; //item AP healing
    private double atkMod; //attack modifier effect
    private double defMod; //DAMAGE TAKEN modifier effect
    private Boolean cures; //if item cures status
    private StatusEffect effectInflict; //status effect that item inflicts
    private int statusChance; //chance to inflict status effect
    private String target; //can be "one" or "all"
    private List<Char> setTargets; //item's set targets

    public Item(String nm ,String flv,
                double dmg, double hl, int aph, double atk, double def, Boolean cur, StatusEffect ef, int chc, String tgt) {
        this.name = nm;
        this.flavor = flv;
        this.damage = dmg;
        this.healing = hl;
        this.atkMod = atk;
        this.defMod = def;
        this.apHeal = aph;
        this.cures = cur;
        this.effectInflict = ef;
        this.statusChance = chc;
        this.target = tgt;
        setTargets = new ArrayList<>();
    }

    //setters, getters

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

    public int getApHeal() {
        return apHeal;
    }

    public double getAtkMod() {
        return atkMod;
    }

    public double getDefMod() {
        return defMod;
    }


    public double getDamage() {
        return damage;
    }

    public double getHealing() {
        return healing;
    }

    public Boolean getCures() {
        return cures;
    }

    public StatusEffect getEffectInflict() {
        return effectInflict;
    }

    public int getStatusChance() {
        return statusChance;
    }

    public String getTarget() {
        return target;
    }

    //adds c to set targets

    public void addToSetTargets(Char c) {
        if(!setTargets.contains(c)) {
            setTargets.add(c);
        }
    }

    //takes effect on the target of the item

    public void takeEffect(Char c) {
        //modifies target's HP and AP
        c.healDamage(healing);
        c.healAp(apHeal);
        c.takeDamage(damage);

        //modifies target's attack and defense. Cannot go over 4.00 or under 0.25
        if(defMod != 1.0) {
            if(c.getDefMod() + defMod <= 0.25) {
                c.setDefMod(0.25);
            } else if (c.getDefMod() + defMod >= 4.00) {
                c.setDefMod(4.00);
            } else {
                c.setDefMod((c.getDefMod() + defMod));
            }

        }

        if(defMod != 1.0) {
            if(c.getAtkMod() + defMod <= 0.25) {
                c.setAtkMod(0.25);
            } else if (c.getAtkMod() + defMod >= 4.00) {
                c.setAtkMod(4.00);
            } else {
                c.setAtkMod((c.getAtkMod() + defMod));
            }

        }

        //applies status effect based on random chance (if target isn't dead)

        if(!c.getDead() && effectInflict != StatusEffect.NONE) {

            Random rand = new Random();
            int statusApply = rand.nextInt(statusChance);
            if(statusApply == 0) {
                c.setCurrentStatus(effectInflict);
            }

        }

        //cures target, if applicable

        if(cures) {
            c.setCurrentStatus(StatusEffect.NONE);
        }

    }
}
