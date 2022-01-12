package model;

import model.enemies.Enemy;

import java.util.ArrayList;
import java.util.List;

public class PlayerCharacter extends Char {

    private List<Enemy> enemiesFighting; //enemies this character is fighting
    private List<PlayerCharacter> partyWith; //party this character is with

    public PlayerCharacter(String name, int maxhp, int maxap, List<Skill> skills, int speed, String flavor,
                           List<Enemy> enemiesFighting, List<PlayerCharacter> partyWith) {
        super(name, maxhp, maxap, skills, speed, flavor);
        this.enemiesFighting = new ArrayList<>();
        this.partyWith = new ArrayList<>();
    }

    //getters, setters

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








}
