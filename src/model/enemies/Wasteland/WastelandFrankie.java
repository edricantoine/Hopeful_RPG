package model.enemies.Wasteland;

import model.AttackSkill;
import model.Item;
import model.StatusEffect;
import model.SupportSkill;
import model.enemies.Enemy;

import java.util.ArrayList;
import java.util.Arrays;

//Class for the "Frankie" boss.

public class WastelandFrankie extends Enemy {
    public WastelandFrankie() {
        super("Frankie", 350, 100, new ArrayList<>(Arrays.asList(
                        new AttackSkill("You Know The Drill", "rushed forward, drills pointed at", 0, "one",
                                60, StatusEffect.NONE, 1.0, 1.0, 1, 0, 0, 0.5, 1.0, 0, 1, StatusEffect.NONE),
                        new AttackSkill("Hack Up A Lung", "coughed up toxic fumes at", 0, "one", 10,
                                StatusEffect.POISONED, 1.0, 1.0, 1, 0, 0, 1.0, 1.0, 0, 0,StatusEffect.NONE),
                        new SupportSkill("Get Mad", "flew into a rage!", 0, "one",
                                0, 0, 0.50, 1.0, false, 0, 0, 0, StatusEffect.NONE, 0, 0,
                                1.0, 1.0, StatusEffect.NONE),
                        new AttackSkill("Burnout", "spewed flames from her exhaust pipes!", 0, "all", 10,
                                StatusEffect.BURNED, 1.0, 1.0, 1, 0, 0, 1.0, 1.0, 0, 0, StatusEffect.NONE)

                )), 10,
                "Is she a machine? A mole? How about both?! Watch out for her high-damage, high-velocity attacks.",
                " are revved up!",
                " sputtered to a stop...");

        loot = new Item("Frankie's Engine", "Increases attack drastically but burns the user",
                0.0, 0.0, 0, 1.50, 1.0, 0, false, StatusEffect.BURNED, 1, "one");
    }
}
