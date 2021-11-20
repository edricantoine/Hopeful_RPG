package model.enemies;

import model.AttackSkill;
import model.StatusEffect;
import model.SupportSkill;

import java.util.ArrayList;
import java.util.Arrays;

public class WastelandFrankie extends Enemy{
    public WastelandFrankie() {
        super("Frankie", 350, 100, new ArrayList<>(Arrays.asList(
                        new AttackSkill("You Know The Drill", "rushed forward, drills pointed at", 0, "one",
                                60, StatusEffect.NONE, 1.0, 1.0, 1),
                        new AttackSkill("Hack Up A Lung", "coughed up toxic fumes at", 0, "one", 10,
                                StatusEffect.POISONED, 1.0, 1.0, 2),
                        new SupportSkill("Get Mad", "flew into a rage!", 0, "one",
                                0, 0, 2.00, 1.0, false),
                        new AttackSkill("Burnout", "spewed flames from her exhaust pipes!", 0, "all", 10,
                                StatusEffect.BURNED, 1.0, 1.0, 2)

                )), 10,
                "Is she a machine? A mole? How about both?! Watch out for her high-damage, high-velocity attacks.",
                " are revved up!",
                " sputtered to a stop...");
    }
}
