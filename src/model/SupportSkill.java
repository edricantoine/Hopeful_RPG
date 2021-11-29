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
        if(defEffect != 1.0) {
            if(c.getDefMod() + defEffect <= 0.25) {
                c.setDefMod(0.25);
            } else if (c.getDefMod() + defEffect >= 4.00) {
                c.setDefMod(4.00);
            } else {
                    c.setDefMod((c.getDefMod() + defEffect));
            }

        }

        if(atkEffect != 1.0) {
            if(c.getAtkMod() + atkEffect <= 0.25) {
                c.setAtkMod(0.25);
            } else if (c.getAtkMod() + atkEffect >= 4.00) {
                c.setAtkMod(4.00);
            } else {
                c.setAtkMod((c.getAtkMod() + atkEffect));
            }

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
