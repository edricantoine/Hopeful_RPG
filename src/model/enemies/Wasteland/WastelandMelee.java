package model.enemies.Wasteland;

import model.AttackSkill;
import model.Item;
import model.StatusEffect;
import model.enemies.Enemy;

import java.util.ArrayList;
import java.util.Arrays;

public class WastelandMelee extends Enemy {
    public WastelandMelee() {
        super("Desert Bandit", 150, 100, new ArrayList<>(Arrays.asList(
                        new AttackSkill("Sandblast", "launched sand everywhere!", 0, "all",
                                15, StatusEffect.NONE, -0.05, 1.0, 1),
                        new AttackSkill("Kick", "kicked at", 0, "one", 35,
                                StatusEffect.NONE, 1.0, 1.0, 1)
                )), 5,
                "Your typical desert wasteland bandit.", " enter the fray!",
                " was defeated.");

        loot = new Item("Bomb", "A bomb. Deals 100 damage.", 100, 0.0, 0, 1.0, 1.0, false,
                StatusEffect.NONE, 0, "all");
    }
}
