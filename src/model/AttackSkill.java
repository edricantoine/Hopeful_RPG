package model;

import java.util.Random;

public class AttackSkill extends Skill {

    private int damage;
    private double atkEffect;
    private double defEffect;
    private int statusApplyChance; // picks number from 0 to statusApplyChance to determine whether status is applied
    private StatusEffect statusToApply;


    public AttackSkill(String name, String flavor, int apCost, String target, int damage,
                       StatusEffect statusToApply, double atkEffect, double defEffect, int statusApplyChance) {
        super(name, flavor, apCost, target);
        this.damage = damage;
        this.statusToApply = statusToApply;
        this.statusApplyChance = statusApplyChance;
        this.atkEffect = atkEffect;
        this.defEffect = defEffect;
    }

    public int getDamage() {
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

        c.takeDamage(damage);
        c.setDefMod(defEffect);
        c.setAtkMod(atkEffect);

        if(statusToApply != StatusEffect.NONE) {

            Random rand = new Random();
            int statusApply = rand.nextInt(statusApplyChance);
            if(statusApply == 0) {
                c.setCurrentStatus(statusToApply);
            }

        }

    }
}
