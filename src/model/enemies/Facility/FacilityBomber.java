package model.enemies.Facility;

import model.AttackSkill;
import model.StatusEffect;
import model.enemies.Enemy;

import java.util.ArrayList;
import java.util.Arrays;

public class FacilityBomber extends Enemy {
    public FacilityBomber() {
        super("Watcher Rocketeer", 80, 100, new ArrayList<>(Arrays.asList(
                        new AttackSkill("Sidearm", "fired a pistol at", 0, "one",
                                30, StatusEffect.NONE, 1.0, 1.0, 1),
                        new AttackSkill("Rocket Barrage", "launched missiles!", 0, "all", 20,
                                StatusEffect.NONE, 1.0, 1.0, 1),
                        new AttackSkill("Flashbang", "threw a flashbang!", 0, "all", 10,
                                StatusEffect.NONE, 0.80, 1.20, 1)
                )), 5, "Watch out for this enemy's AOE attacks! Make sure you have healing items ready.",
                " are locked and loaded.", " was defeated!");
    }
}
