package model;

// Class for SUPPORT skills: affect allies

public class SupportSkill extends Skill {

    private double hpEffect; //how much target is healed
    private int apEffect; //how much ap target receives
    private double atkEffect; //attack effect on target
    private double defEffect; //defense effect on target
    private Boolean cures; //whether skill cures target
    private double dmgEffect; //how much target is damaged
    private int spdEffect; //speed effect on target
    private int spdUser; //speed effect on user
    private StatusEffect statusEffect; //status effect on target
    private double hpUser; //heal effect on user
    private double dmgUser; //damage effect on user
    private double atkUser; //attack effect on user
    private double defUser; //defense effect on user
    private StatusEffect statUser; //status inflicted on user


    public SupportSkill(String name, String flavor, int apCost, String target, double hpEffect,
                        int apEffect, double atkEffect, double defEffect, Boolean cures, double dmg, int spd,
                        int spdU, StatusEffect stat, double hpU, double dmgU, double atkU, double defU, StatusEffect stU) {
        super(name, flavor, apCost, target);
        this.hpEffect = hpEffect;
        this.apEffect = apEffect;
        this.atkEffect = atkEffect;
        this.defEffect = defEffect;
        this.cures = cures;
        this.dmgEffect = dmg;
        this.spdEffect = spd;
        this.spdUser = spdU;
        this.statusEffect = stat;
        this.hpUser = hpU;
        this.dmgUser = dmgU;
        this.atkUser = atkU;
        this.defUser = defU;
        this.statUser = stU;

    }

    //getters, setters, need no testing

    @Override
    public void setAtkMod(double atkMod) {
        return;
    }

    @Override
    public double getDamage() {
        return 0;
    }

    //applies relevant effects onto user of skill

    public void takeUserEffect(Char p) {
        //modify user's hp
        p.healDamage(hpUser);
        p.takeDamage(dmgUser);
        //modify user's atk, def
        if(atkUser!= 1.0) {
            if(p.getAtkMod() + atkUser <= 0.25) {
                p.setAtkMod(0.25);
            } else if (p.getAtkMod() + atkUser>= 4.00) {
                p.setAtkMod(4.00);
            } else {
                p.setAtkMod((p.getAtkMod() + atkUser));
            }

        }

        if(defUser!= 1.0) {
            if(p.getDefMod() + defUser <= 0.25) {
                p.setDefMod(0.25);
            } else if (p.getDefMod() + defUser>= 4.00) {
                p.setDefMod(4.00);
            } else {
                p.setDefMod((p.getDefMod() + defUser));
            }

        }

        //modify user's speed

        p.setSpeed(p.getSpeed() + spdUser);

        //set user's status effect
        if(statUser != StatusEffect.NONE) {
            p.setCurrentStatus(statUser);
        }
    }

    //applies relevant effects onto target of skill
    @Override
    public void takeEffect(Char c) {

        c.healDamage(hpEffect);
        c.takeDamage(dmgEffect);
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

        c.setSpeed(c.getSpeed() + spdEffect);


        if(cures) {
            c.setCurrentStatus(StatusEffect.NONE);
        }

        if(statusEffect != StatusEffect.NONE) {
            c.setCurrentStatus(statusEffect);
        }

    }


}
