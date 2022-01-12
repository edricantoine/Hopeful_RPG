package model.enemies.Wasteland;

import model.AttackSkill;
import model.Item;
import model.StatusEffect;
import model.enemies.Enemy;

import java.util.ArrayList;
import java.util.Arrays;

//Class for the "Blade Bandit" enemy.

public class WastelandAssassin extends Enemy {
    public WastelandAssassin() {
        super("Blade Bandit", 100, 100, new ArrayList<>(Arrays.asList(
                        new AttackSkill("Shiv", "slashed with rusty scrap metal, hitting", 0, "one",
                                30, StatusEffect.POISONED, 1.0, 1.0, 2, 0, 0, 1.0, 1.0, 0, 0,StatusEffect.NONE),
                        new AttackSkill("Critical Strike", "stabbed at an artery, hitting", 0, "one", 60,
                                StatusEffect.NONE, 1.0, 1.0, 1, 0, 0, 1.0, 1.0, 0, 0,StatusEffect.NONE)
                )), 7,
                "Watch out for this fragile enemy's rusty metal blade! Try not to get poisoned.", " ready their blades.",
                " fell to the ground.");
        loot = new Item("Hot Coals", "Burns the target",
                10.0, 0.0, 0, 1.0, 1.0, false, StatusEffect.BURNED, 1, "one");
    }
}
