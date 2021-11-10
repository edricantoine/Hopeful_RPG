package model.enemies;

import model.Char;
import model.Skill;
import model.StatusEffect;

import java.util.List;

public class Tobi extends Enemy {

    private Boolean needsToReload;
    private int timeTillAttack;

    public Tobi(String name, int maxhp, int maxap, List<Skill> skills, int speed, String flavor) {
        super(name, maxhp, maxap, skills, speed, flavor, " enters guns blazing!", " falls to the ground.");
        needsToReload = false;
        timeTillAttack = 5;
    }


    public Boolean getNeedsToReload() {
        return needsToReload;
    }

    public void setNeedsToReload(Boolean needsToReload) {
        this.needsToReload = needsToReload;
    }

    @Override
    public Boolean useSkill(Skill s, Char c) {
        if(canUseSkill(s) && !needsToReload) {
            useAp(s.getApCost());
            s.takeEffect(c);
            return true;
        } else {
            return false;
        }
    }

    public int getTimeTillAttack() {
        return timeTillAttack;
    }

    public void setTimeTillAttack(int timeTillAttack) {
        this.timeTillAttack = timeTillAttack;
    }

    public Boolean lawAndOrder(Char c) {
        if(!needsToReload && timeTillAttack == 0) {
            c.takeDamage(c.getMaxhp());
            needsToReload = true;
            timeTillAttack = 5;
            return true;
        } else {
            return false;
        }
    }

    public void reload() {
        if(needsToReload) {
            setNeedsToReload(false);
        }
    }

    @Override
    public void turnEndRoutine() {
        if(currentStatus.equals(StatusEffect.BURNED)) {
            takeDamage(DMG_BURNED);
            timeSinceStatusApplied--;
            if(timeSinceStatusApplied == 0) {
                setCurrentStatus(StatusEffect.NONE);
            }
        }

        if(currentStatus.equals(StatusEffect.POISONED)) {
            takeDamage(DMG_POISONED);
            timeSinceStatusApplied--;
            if(timeSinceStatusApplied == 0) {
                setCurrentStatus(StatusEffect.NONE);
            }
        }

        if(currentStatus.equals(StatusEffect.FROZEN)) {
            timeSinceStatusApplied--;
            if(timeSinceStatusApplied == 0) {
                setCurrentStatus(StatusEffect.NONE);
            }
        }

        if(currentStatus.equals(StatusEffect.AFRAID)) {
            timeSinceStatusApplied--;
            if(timeSinceStatusApplied == 0) {
                setCurrentStatus(StatusEffect.NONE);
                atkMod = 1;
                defMod = 1;
            }
        }

        if(timeTillAttack > 0) {
            timeTillAttack--;
        }


        healAp(5);
    }

}
