package model.enemies;

import model.Char;
import model.PlayerCharacter;
import model.Skill;

import java.util.ArrayList;
import java.util.List;

public class Enemy extends Char {

    private List<Enemy> enemiesWith;
    private List<PlayerCharacter> pcAgainst;

    public Enemy(String name, int maxhp, int maxap, List<Skill> skills, int speed, String flavor) {
        super(name, maxhp, maxap, skills, speed, flavor);
        this.enemiesWith = new ArrayList<>();
        this.pcAgainst = new ArrayList<>();
    }

    public List<Enemy> getEnemiesWith() {
        return enemiesWith;
    }

    public void setEnemiesWith(List<Enemy> enemiesWith) {
        this.enemiesWith = enemiesWith;
    }

    public List<PlayerCharacter> getPcAgainst() {
        return pcAgainst;
    }

    public void setPcAgainst(List<PlayerCharacter> pcAgainst) {
        this.pcAgainst = pcAgainst;
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
}
