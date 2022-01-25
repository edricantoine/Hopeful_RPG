package model.enemies.City;

import model.AttackSkill;
import model.Item;
import model.StatusEffect;
import model.enemies.Enemy;

import java.util.ArrayList;
import java.util.Arrays;

//Class representing the Alt Punk Doppel enemy.

public class CityDoppel2 extends Enemy {
    public CityDoppel2() {
        super("Alt Punk Doppel", 175, 100, new ArrayList<>(Arrays.asList(
                        new AttackSkill("Transform", "transformed into", 0, "one",
                                0, StatusEffect.NONE, 1.0, 1.0, 1,
                                0, 0, 1.0, 1.0, 0, 0, StatusEffect.NONE )

                )), 5, "This punk can somehow transform into your party members and use their attacks!",
                " are ready to brawl!", " crumpled to his knees!");

        loot = new Item("AP Potion", "Heals 50 AP",
                0.0, 0.0, 50, 1.0, 1.0, 0, false, StatusEffect.NONE, 0, "one");
    }
}
