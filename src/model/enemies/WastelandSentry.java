package model.enemies;

import model.AttackSkill;
import model.StatusEffect;
import model.SupportSkill;

import java.util.ArrayList;
import java.util.Arrays;

public class WastelandSentry extends Enemy{
    public WastelandSentry() {
        super("SEN-3", 500, 100, new ArrayList<>(Arrays.asList(
                        new AttackSkill("Gun Rush", "fired a machine gun!", 0, "all",
                                30, StatusEffect.NONE, 1.0, 1.0, 1),
                        new AttackSkill("Bayonet Stab", "stabbed with a sharp edge, hitting", 0, "one", 40,
                                StatusEffect.NONE, 1.0, 1.0, 1),
                        new SupportSkill("Shields Up", "held up a metal shield, protecting", 0, "one",
                                0, 0, 1.0, 2.00, false),
                        new SupportSkill("Robotic Immunity", "ran an antivirus program, somehow curing",
                                0, "one",
                                0, 0, 1.0, 1.00, true)

                )), 8,
                "This surveillance robot has gone rogue and now attacks everything in sight.",
                " booted up!",
                " crashed and burned.");
    }
}
