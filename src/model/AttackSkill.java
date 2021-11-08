package model;

import java.util.Random;

public class AttackSkill extends Skill {

    private int damage;
    private int atkEffect;
    private int defEffect;
    private int statusApplyChance; // picks number from 0 to statusApplyChance to determine whether status is applied
    private StatusEffect statusToApply;


    public AttackSkill(String name, String flavor, int apCost, int cooldown, String target, int damage,
                       StatusEffect statusToApply, int atkEffect, int defEffect, int statusApplyChance) {
        super(name, flavor, apCost, cooldown, target);
        this.damage = damage;
        this.statusToApply = statusToApply;
        this.statusApplyChance = statusApplyChance;
        this.atkEffect = atkEffect;
        this.defEffect = defEffect;
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
