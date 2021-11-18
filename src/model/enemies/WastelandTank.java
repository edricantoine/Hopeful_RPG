package model.enemies;

import model.AttackSkill;
import model.StatusEffect;

import java.util.ArrayList;
import java.util.Arrays;

public class WastelandTank extends Enemy{
    public WastelandTank() {
        super("Armored Bandit", 200, 100, new ArrayList<>(Arrays.asList(
                        new AttackSkill("Armor Bash", " strikes with his armor!", 0, "one",
                                20, StatusEffect.NONE, 1.0, 1.0, 1),
                        new AttackSkill("Armor Break", " broke your guard and lowered Defense!", 0, "one", 0,
                                StatusEffect.NONE, 1.0, 1.25, 1)
                )), 2,
                "This bandit's scrap armor makes him tough to take down.", " are ready to fight!",
                "'s armor crumbled...");
    }
}
