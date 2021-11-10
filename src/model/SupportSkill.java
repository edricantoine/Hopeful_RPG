package model;

public class SupportSkill extends Skill {

    private double hpEffect;
    private int apEffect;
    private double atkEffect;
    private double defEffect;
    private Boolean cures;

    public SupportSkill(String name, String flavor, int apCost, String target, double hpEffect,
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
        if(defEffect != 1.0 && c.getCurrentStatus() != StatusEffect.AFRAID) {
            c.setDefMod((c.getDefMod() + defEffect) / 2.0);

        }

        if(atkEffect != 1.0 && c.getCurrentStatus() != StatusEffect.AFRAID) {
            c.setAtkMod((c.getAtkMod() + atkEffect) / 2.0);

        }


        if(cures) {
            c.setCurrentStatus(StatusEffect.NONE);
        }

    }

    @Override
    public void setAtkMod(double atkMod) {
        return;
    }

    @Override
    public double getDamage() {
        return 0;
    }
}
