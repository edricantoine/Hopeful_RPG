package model.enemies;

import model.AttackSkill;
import model.StatusEffect;

import java.util.ArrayList;
import java.util.Arrays;

public class WastelandAssassin extends Enemy{
    public WastelandAssassin() {
        super("Blade Bandit", 50, 100, new ArrayList<>(Arrays.asList(
                        new AttackSkill("Shiv", " slashed with rusty scrap metal.", 0, "one",
                                30, StatusEffect.POISONED, 1.0, 1.0, 4),
                        new AttackSkill("Critical Strike", " stabbed at an artery!", 0, "one", 60,
                                StatusEffect.NONE, 1.0, 1.0, 1)
                )), 7,
                "Watch out for this fragile enemy's rusty metal blade! Try not to get poisoned.", " ready their blades.",
                " fell to the ground.");
    }
}
