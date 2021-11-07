package model;

public class AttackSkill extends Skill {

    private int damage;
    private int atkEffect;
    private int defEffect;
    private Boolean appliesStatus;
    private StatusEffect statusToApply;


    public AttackSkill(String name, String flavor, int apCost, int cooldown, String target, int damage,
                       StatusEffect statusToApply, int atkEffect, int defEffect) {
        super(name, flavor, apCost, cooldown, target);
        this.damage = damage;
        this.statusToApply = statusToApply;
        this.appliesStatus = statusToApply != StatusEffect.NONE;
        this.atkEffect = atkEffect;
        this.defEffect = defEffect;
    }

    @Override
    public void takeEffect(Char c) {

    }
}
