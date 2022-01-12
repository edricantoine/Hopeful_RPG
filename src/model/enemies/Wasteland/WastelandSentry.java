package model.enemies.Wasteland;

import model.AttackSkill;
import model.Item;
import model.StatusEffect;
import model.SupportSkill;
import model.enemies.Enemy;

import java.util.ArrayList;
import java.util.Arrays;

//Class for the "SEN-3" boss.

public class WastelandSentry extends Enemy {
    public WastelandSentry() {
        super("SEN-3", 500, 100, new ArrayList<>(Arrays.asList(
                        new AttackSkill("Gun Rush", "fired a machine gun!", 0, "all",
                                30, StatusEffect.NONE, 1.0, 1.0, 1, 0, 0, 1.0, 1.0, 0, 0, StatusEffect.NONE),
                        new AttackSkill("Bayonet Stab", "stabbed with a sharp edge, hitting", 0, "one", 40,
                                StatusEffect.NONE, 1.0, 1.0, 1, 0, 0, 1.0, 1.0, 0, 0, StatusEffect.NONE),
                        new SupportSkill("Shields Up", "held up a metal shield, protecting", 0, "one",
                                0, 0, 1.0, -0.15, false, 0, 0, 0, StatusEffect.NONE, 0, 0,
                                1.0, 1.0, StatusEffect.NONE),
                        new SupportSkill("Robotic Immunity", "ran an antivirus program, somehow curing",
                                0, "one",
                                0, 0, 1.0, 1.00, true, 0, 0, 0, StatusEffect.NONE, 0, 0,
                                1.0, 1.0, StatusEffect.NONE)

                )), 8,
                "This surveillance robot has gone rogue and now attacks everything in sight.",
                " booted up!",
                " crashed and burned.");

        loot = new Item("SEN-3's Shield", "Massive increase to defense but decreases attack",
                0.0, 0.0, 0, -1.00, -0.50, 0, false, StatusEffect.NONE, 0, "one");
    }
}
