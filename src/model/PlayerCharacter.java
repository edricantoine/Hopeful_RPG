package model;

import java.util.List;

public class PlayerCharacter extends Char {

    public PlayerCharacter(String name, int maxhp, int maxap, List<Skill> skills, int speed, String flavor) {
        super(name, maxhp, maxap, skills, speed, flavor);
    }

    @Override
    public void useSkill(Skill s) {

    }



}
