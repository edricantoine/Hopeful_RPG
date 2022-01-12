package model.enemies.Facility;

import model.AttackSkill;
import model.Item;
import model.StatusEffect;
import model.enemies.Enemy;

import java.util.ArrayList;
import java.util.Arrays;

//A class for the "Watcher Rocketeer" enemy.

public class FacilityBomber extends Enemy {
    public FacilityBomber() {
        super("Watcher Rocketeer", 80, 100, new ArrayList<>(Arrays.asList(
                        new AttackSkill("Sidearm", "fired a pistol at", 0, "one",
                                30, StatusEffect.NONE, 1.0, 1.0, 1,
                                0, 0, 1.0, 1.0, 0, 0, StatusEffect.NONE),
                        new AttackSkill("Rocket Barrage", "launched missiles!", 0, "all", 20,
                                StatusEffect.NONE, 1.0, 1.0, 1,
                                0, 0, 1.0, 1.0, 0, 0, StatusEffect.NONE),
                        new AttackSkill("Flashbang", "threw a flashbang!", 0, "all", 10,
                                StatusEffect.NONE, -0.20, 0.20, 1,
                                0, 0, 1.0, 1.0, 0, 0, StatusEffect.NONE)
                )), 5, "Watch out for this enemy's AOE attacks! Make sure you have healing items ready.",
                " are locked and loaded.", " was defeated!");

        loot = new Item("Flashbang Grenade", "Target's attack and defense are lowered, with chance to numb target", 10.0,
                0.0, 0, -0.10, 1.20, false, StatusEffect.NUMB, 2, "one");
    }
}
