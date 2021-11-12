package model.enemies;

import model.AttackSkill;
import model.StatusEffect;

import java.util.ArrayList;
import java.util.Arrays;

public class WastelandMelee extends Enemy{
    public WastelandMelee() {
        super("Desert Bandit", 100, 100, new ArrayList<>(Arrays.asList(
                        new AttackSkill("Sandblast", " launched sand everywhere!", 0, "all",
                                30, StatusEffect.NONE, 0.80, 1.0, 1),
                        new AttackSkill("Kick", " kicked at you.", 0, "one", 35,
                                StatusEffect.NONE, 1.0, 1.0, 1)
                )), 5,
                "Your typical desert wasteland bandit.", " enters the fray!",
                " was defeated.");
    }
}
