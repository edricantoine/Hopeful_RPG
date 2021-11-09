package model;

public class SupportSkill extends Skill {

    private int hpEffect;
    private int apEffect;
    private double atkEffect;
    private double defEffect;
    private Boolean cures;

    public SupportSkill(String name, String flavor, int apCost, int cooldown, String target, int hpEffect,
                        int apEffect, double atkEffect, double defEffect, Boolean cures) {
        super(name, flavor, apCost, target);
        this.hpEffect = hpEffect;
        this.apEffect = apEffect;
        this.atkEffect = atkEffect;
        this.defEffect = defEffect;
        this.cures = cures;
    }

    @Override
    public void takeEffect(Char c) {

        c.healDamage(hpEffect);
        c.healAp(apEffect);
        c.setAtkMod(atkEffect);
        c.setDefMod(defEffect);

        if(cures) {
            c.setCurrentStatus(StatusEffect.NONE);
        }

    }
}
