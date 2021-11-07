package model.enemies;

import model.Char;
import model.Skill;

import java.util.List;

public abstract class Enemy extends Char {

    public Enemy(String name, int maxhp, int maxap, List<Skill> skills, int speed, String flavor) {
        super(name, maxhp, maxap, skills, speed, flavor);
    }
}
