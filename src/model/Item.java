package model;

import java.util.Random;

public class Item {
    private String name;
    private String flavor;
    private int damage;
    private int healing;
    private int apHeal;
    private double atkMod;
    private double defMod;
    private Boolean cures;
    private StatusEffect effectInflict;
    private int statusChance;
    private String target;

    public Item(String nm ,String flv,
                int dmg, int hl, int aph, double atk, double def, Boolean cur, StatusEffect ef, int chc, String tgt) {
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


    public int getDamage() {
        return damage;
    }

    public int getHealing() {
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

    public void takeEffect(Char c) {
        c.healDamage(healing);
        c.takeDamage(damage);
        c.healAp(apHeal);
        if(cures) {
            c.setCurrentStatus(StatusEffect.NONE);
        }
        c.setAtkMod(atkMod);
        c.setDefMod(defMod);

        if(effectInflict != StatusEffect.NONE) {

            Random rand = new Random();
            int statusApply = rand.nextInt(statusChance);
            if(statusApply == 0) {
                c.setCurrentStatus(effectInflict);
            }

        }

    }
}
