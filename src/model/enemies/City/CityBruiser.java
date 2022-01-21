package model.enemies.City;

//A class for the "Punk Bruiser" enemy.

import model.AttackSkill;
import model.Item;
import model.StatusEffect;
import model.enemies.Enemy;

import java.util.ArrayList;
import java.util.Arrays;

public class CityBruiser extends Enemy {
    public CityBruiser() {
        super("Punk Bruiser", 150, 100, new ArrayList<>(Arrays.asList(
                        new AttackSkill("Warm-Up Punch", "threw a fierce punch, increasing his attack and hitting", 0, "one",
                                10, StatusEffect.NONE, 1.0, 1.0, 1,
                                0, 0,  0.5, 1.0, 0, 0, StatusEffect.NONE),
                        new AttackSkill("Nitro Kick", "did a fierce roundhouse kick, hitting", 0, "one", 75,
                                StatusEffect.NONE, 1.0, 1.0, 1,
                                0, 0, 1.0, 1.0, 0, 0, StatusEffect.NONE),
                        new AttackSkill("Warm-Up Punch", "threw a fierce punch, increasing his attack and hitting", 0, "one",
                                10, StatusEffect.NONE, 1.0, 1.0, 1,
                                0, 0,  0.5, 1.0, 0, 0, StatusEffect.NONE)
                )), 6, "This punk can increase his attack damage every time he attacks, then unleashes a powerful kick. Freeze him to stop it!",
                " are raring to fight", " was defeated!");

        loot = new Item("Protein Shake", "Increases one character's attack and defense!", 10.0,
                0.0, 0, 0.50, -0.10, 0, false, StatusEffect.NONE, 2, "one");
    }
}
