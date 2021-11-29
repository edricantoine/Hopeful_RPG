package model.enemies.Wasteland;

import model.AttackSkill;
import model.Item;
import model.StatusEffect;
import model.enemies.Enemy;

import java.util.ArrayList;
import java.util.Arrays;

public class WastelandTank extends Enemy {
    public WastelandTank() {
        super("Armored Bandit", 250, 100, new ArrayList<>(Arrays.asList(
                        new AttackSkill("Armor Bash", "strikes with his armor, hitting", 0, "one",
                                20, StatusEffect.NONE, 1.0, 1.0, 1),
                        new AttackSkill("Armor Break", "broke the guard of", 0, "one", 0,
                                StatusEffect.NONE, 1.0, 0.25, 1)
                )), 2,
                "This bandit's scrap armor makes him tough to take down.", " are ready to fight!",
                "'s armor crumbled...");

        loot = new Item("Food Rations", "Heals by 50 HP.",
                0.0, 50.0, 0, 1.0, 1.0, false, StatusEffect.NONE, 0, "one");

    }
}
