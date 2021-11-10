package model;

import java.util.Random;

public class AttackSkill extends Skill {

    private double damage;
    private double atkMod;
    private double atkEffect;
    private double defEffect;
    private int statusApplyChance; // picks number from 0 to statusApplyChance to determine whether status is applied
    private StatusEffect statusToApply;


    public AttackSkill(String name, String flavor, int apCost, String target, double damage,
                       StatusEffect statusToApply, double atkEffect, double defEffect, int statusApplyChance) {
        super(name, flavor, apCost, target);
        this.damage = damage;
        this.statusToApply = statusToApply;
        this.statusApplyChance = statusApplyChance;
        this.atkEffect = atkEffect;
        this.defEffect = defEffect;
        this.atkMod = 1.0;
    }


    public double getAtkMod() {
        return atkMod;
    }

    public void setAtkMod(double atkMod) {
        this.atkMod = atkMod;
    }



    public double getDamage() {
        return damage;
    }


    public double getAtkEffect() {
        return atkEffect;
    }

    public double getDefEffect() {
        return defEffect;
    }

    public int getStatusApplyChance() {
        return statusApplyChance;
    }

    public StatusEffect getStatusToApply() {
        return statusToApply;
    }

    @Override
    public void takeEffect(Char c) {



        c.takeDamage(damage * atkMod);

        if(defEffect != 1.0 && c.getCurrentStatus() != StatusEffect.AFRAID) {
            c.setDefMod((defEffect + c.getDefMod()) / 2.0);

        }

        if(atkEffect != 1.0 && c.getCurrentStatus() != StatusEffect.AFRAID) {
            c.setAtkMod((atkEffect + c.getAtkMod()) / 2.0);

        }

        if(statusToApply != StatusEffect.NONE && !c.getDead()) {

            Random rand = new Random();
            int statusApply = rand.nextInt(statusApplyChance);
            if(statusApply == 0) {
                c.setCurrentStatus(statusToApply);
            }

        }


    }

}
