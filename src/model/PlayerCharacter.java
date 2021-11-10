package model;

import model.enemies.Enemy;

import java.util.ArrayList;
import java.util.List;

public class PlayerCharacter extends Char {

    private List<Enemy> enemiesFighting;
    private List<PlayerCharacter> partyWith;

    public PlayerCharacter(String name, int maxhp, int maxap, List<Skill> skills, int speed, String flavor,
                           List<Enemy> enemiesFighting, List<PlayerCharacter> partyWith) {
        super(name, maxhp, maxap, skills, speed, flavor);
        this.enemiesFighting = new ArrayList<>();
        this.partyWith = new ArrayList<>();
    }

    public List<Enemy> getEnemiesFighting() {
        return enemiesFighting;
    }

    public void setEnemiesFighting(List<Enemy> enemiesFighting) {
        this.enemiesFighting = enemiesFighting;
    }

    public List<PlayerCharacter> getPartyWith() {
        return partyWith;
    }

    public void setPartyWith(List<PlayerCharacter> partyWith) {
        this.partyWith = partyWith;
    }

    @Override
    public Boolean useSkill(Skill s, Char c) {
        if(canUseSkill(s)) {
            useAp(s.getApCost());
            s.setAtkMod(atkMod);
            s.takeEffect(c);
            s.setAtkMod(1.00);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void useItem(Item i, Char c) {
        i.takeEffect(c);
    }


}
