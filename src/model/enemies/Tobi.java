package model.enemies;

import model.Char;
import model.Skill;

import java.util.List;

public class Tobi extends Enemy {

    private Boolean needsToReload;

    public Tobi(String name, int maxhp, int maxap, List<Skill> skills, int speed, String flavor) {
        super(name, maxhp, maxap, skills, speed, flavor);
        needsToReload = false;
    }

    @Override
    public Boolean useSkill(Skill s, Char c) {
        if(canUseSkill(s)) {
            useAp(s.getApCost());
            s.takeEffect(c);
            return true;
        } else {
            return false;
        }
    }

    public Boolean getNeedsToReload() {
        return needsToReload;
    }

    public void setNeedsToReload(Boolean needsToReload) {
        this.needsToReload = needsToReload;
    }
}
