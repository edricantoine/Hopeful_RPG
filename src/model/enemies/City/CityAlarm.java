package model.enemies.City;

//Class representing the Squealing Rat enemy.

import model.AttackSkill;
import model.Item;
import model.StatusEffect;
import model.SupportSkill;
import model.enemies.Enemy;

import java.util.ArrayList;
import java.util.Arrays;

public class CityAlarm extends Enemy {
    public CityAlarm() {
        super("Squealing Rat", 120, 100, new ArrayList<>(Arrays.asList(
                        new AttackSkill("Shin Kick", "kicked at the shins of", 0, "one",
                                30, StatusEffect.NONE, 1.0, 1.0, 1,
                                0, 0, 1.0, 1.0, 0, 0, StatusEffect.NONE ),
                        new SupportSkill("Squeal", "cried for help!", 0, "all", 0,
                                0, 1.0, 1.0, false, 0, 0, 0, StatusEffect.NONE,
                                0, 0, 1.0, 1.0, StatusEffect.NONE)

                )), 11, "Beat this rat before he summons too many enemies to handle!",
                " cower nervously...", " crumpled to his knees!");

        loot = new Item("Tranquilizer", "Heals a character, but Numbs them.", 0.0,
                80, 0, 1.0, 1.0, 0, false, StatusEffect.NUMB, 1, "one");
    }
}
