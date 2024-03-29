package model.enemies.Wasteland;

import model.Item;
import model.StatusEffect;
import model.SupportSkill;
import model.enemies.Enemy;

import java.util.ArrayList;
import java.util.Arrays;

//Class for the "Bandit Doctor" enemy.

public class WastelandSupport extends Enemy {
    public WastelandSupport() {
        super("Bandit Doctor", 80, 100, new ArrayList<>(Arrays.asList(
                        new SupportSkill("Unlicensed Medicine", "force-fed a pill to", 0, "one",
                                30, 0, 1.0, 1.0, false, 0, 0, 0, StatusEffect.NONE,
                                0, 0, 1.0, 1.0, StatusEffect.NONE),
                        new SupportSkill("Roids!", "stabbed a syringe into", 0, "one",
                                0, 0, 0.50, 1.0, false, 0, 0, 0, StatusEffect.NONE,
                                0, 0, 1.0, 1.0, StatusEffect.NONE)
                )), 5,
                "WARNING: Not a licensed doctor.", " are ready to help.",
                " fell over in pain.");

        loot = new Item("AP Potion", "Heals 50 AP",
                0.0, 0.0, 50, 1.0, 1.0, 0, false, StatusEffect.NONE, 0, "one");
    }
}
