package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Item {
    private String name;
    private String flavor;
    private double damage;
    private double healing;
    private int apHeal;
    private double atkMod;
    private double defMod;
    private Boolean cures;
    private StatusEffect effectInflict;
    private int statusChance;
    private String target;
    private List<Char> setTargets;

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

    public List<Char> getSetTargets() {
        return setTargets;
    }

    public void addToSetTargets(Char c) {
        if(!setTargets.contains(c)) {
            setTargets.add(c);
        }
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

    public void takeEffect(Char c) {
        c.healDamage(healing);
        c.healAp(apHeal);
        c.takeDamage(damage);

        if(defMod != 1.0 && c.getCurrentStatus() != StatusEffect.AFRAID) {
            c.setDefMod((defMod + c.getDefMod()) / 2.0);

        }

        if(atkMod != 1.0 && c.getCurrentStatus() != StatusEffect.AFRAID) {
            c.setAtkMod((atkMod + c.getAtkMod()) / 2.0);

        }

        if(effectInflict != StatusEffect.NONE && !c.getDead()) {

            Random rand = new Random();
            int statusApply = rand.nextInt(statusChance);
            if(statusApply == 0) {
                c.setCurrentStatus(effectInflict);
            }

        }

        if(cures) {
            c.setCurrentStatus(StatusEffect.NONE);
        }

    }
}
