package model.enemies;

import model.Char;
import model.Skill;

import java.util.List;

public class Tobi extends Enemy {

    private Boolean needsToReload;

    public Tobi(String name, int maxhp, int maxap, List<Skill> skills, int speed, String flavor) {
        super(name, maxhp, maxap, skills, speed, flavor, " enters guns blazing!", " falls to the ground.");
        needsToReload = false;
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

    public Boolean lawAndOrder(Char c) {
        if(!needsToReload) {
            c.takeDamage(c.getMaxhp());
            needsToReload = true;
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

}
