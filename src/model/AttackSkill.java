package model;

import model.enemies.Facility.FacilitySecurity;

import java.util.Random;

public class AttackSkill extends Skill {

    private double damage; // damage done to target
    private double atkMod; // attack modifier for the damage
    private double atkEffect; // how it affects target's attack stat
    private double defEffect; // how it affects target's defense stat
    private double atkUser; // how it affects user's attack stat
    private double defUser; // how it affects user's defense stat
    private double hpUser; // health gained by user
    private double dmgUser; //damage taken by user
    private int spdUser; // how it affects user's speed
    private int spdTarget; //how it affects target's speed
    private StatusEffect statUser; // status effect applied to user
    private int statusApplyChance; // picks number from 0 to statusApplyChance to determine whether status is applied
    private StatusEffect statusToApply; //status effect applied to target


    public AttackSkill(String name, String flavor, int apCost, String target, double damage,
                       StatusEffect statusToApply, double atkEffect, double defEffect, int statusApplyChance, double hpUser,
                       double dmgUser, double atkUser, double defUser, int spdUser, int spdTarget, StatusEffect statUser) {
        super(name, flavor, apCost, target);
        this.damage = damage;
        this.statusToApply = statusToApply;
        this.statusApplyChance = statusApplyChance;
        this.atkEffect = atkEffect;
        this.defEffect = defEffect;
        this.atkMod = 1.0;
        this.hpUser = hpUser;
        this.dmgUser = dmgUser;
        this.atkUser = atkUser;
        this.defUser = defUser;
        this.spdUser = spdUser;
        this.spdTarget = spdTarget;
        this.statUser = statUser;
    }


    public double getAtkUser() {
        return atkUser;
    }

    public double getDefUser() {
        return defUser;
    }

    public double getHpUser() {
        return hpUser;
    }

    public int getSpdUser() {
        return spdUser;
    }

    public int getSpdTarget() {
        return spdTarget;
    }

    public StatusEffect getStatUser() {
        return statUser;
    }

    public double getDmgUser() {
        return dmgUser;
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

    //all effects that take place ON TARGET.

    public void takeUserEffect(Char p) {
        //modify user's HP
        p.healDamage(hpUser);
        p.takeDamage(dmgUser);
        //modify user's atk + def
        if(atkUser!= 1.0) {
            if(p.getAtkMod() + atkUser <= 0.25) {
                p.setAtkMod(0.25);
            } else if (p.getDefMod() + atkUser>= 4.00) {
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

    @Override
    public void takeEffect(Char c) {

        //special case to account for FacilitySecurity enemy due to its drone mechanic
        //otherwise, just deals damage * atkmod to target

        if(c instanceof FacilitySecurity) {
            if(!((FacilitySecurity) c).isDroneDead()) {
                c.takeDamage(0);
            } else {
                c.takeDamage(damage * atkMod);
            }
        } else {
            c.takeDamage(damage * atkMod);
        }

        //setting target's def mod

        if(defEffect != 1.0) {
            if(c.getDefMod() + defEffect <= 0.25) {
                c.setDefMod(0.25);
            } else if (c.getDefMod() + defEffect >= 4.00) {
                c.setDefMod(4.00);
            } else {
                c.setDefMod((c.getDefMod() + defEffect));
            }

        }

        //setting target's atk mod

        if(atkEffect != 1.0) {
            if(c.getAtkMod() + atkEffect <= 0.25) {
                c.setAtkMod(0.25);
            } else if (c.getAtkMod() + atkEffect >= 4.00) {
                c.setAtkMod(4.00);
            } else {
                c.setAtkMod((c.getAtkMod() + atkEffect));
            }

        }

        //setting target's speed
        c.setSpeed(c.getSpeed() + spdTarget);

        //applying status to target based on chance

        if(statusToApply != StatusEffect.NONE && !c.getDead()) {

            if(c instanceof FacilitySecurity && !((FacilitySecurity) c).isDroneDead()) {
                c.setCurrentStatus(StatusEffect.NONE);
            } else {

                Random rand = new Random();
                int statusApply = rand.nextInt(statusApplyChance);
                if (statusApply == 0) {
                    c.setCurrentStatus(statusToApply);
                }
            }

        }


    }

}
