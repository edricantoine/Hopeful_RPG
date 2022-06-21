package model.enemies;

import model.Char;
import model.Item;
import model.PlayerCharacter;
import model.Skill;

import java.util.ArrayList;
import java.util.List;

// A class representing an Enemy. Extends from Char class, so unit tests for that class mostly cover this one.

public class Enemy extends Char {


    protected List<Enemy> enemiesWith; // enemies currently with this enemy
    protected List<PlayerCharacter> pcAgainst; // the party this enemy is facing
    protected String enterText; //Intro flavor text
    protected String defeatText; //Death flavor text
    protected Item loot; //Loot this enemy can drop

    public Enemy(String name, int maxhp, int maxap, List<Skill> skills, int speed, String flavor,
                 String enter, String defeat) {
        super(name, maxhp, maxap, skills, speed, flavor);
        this.enemiesWith = new ArrayList<>();
        this.pcAgainst = new ArrayList<>();
        this.enterText = enter;
        this.defeatText = defeat;
    }

    //getters, setters

    public Item getLoot() {
        return loot;
    }

    public void setLoot(Item loot) {
        this.loot = loot;
    }

    public String getEnterText() {
        return enterText;
    }

    public String getDefeatText() {
        return defeatText;
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





}
