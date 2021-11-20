package model.enemies;

import model.SupportSkill;

import java.util.ArrayList;
import java.util.Arrays;

public class WastelandSupport extends Enemy{
    public WastelandSupport() {
        super("Bandit Doctor", 80, 100, new ArrayList<>(Arrays.asList(
                        new SupportSkill("Unlicensed Medicine", "force-fed a pill to", 0, "one",
                                30, 0, 1.0, 1.0, false),
                        new SupportSkill("Roids!", "stabbed a syringe into", 0, "one",
                                0, 0, 1.50, 1.0, false)
                )), 5,
                "WARNING: Not a licensed doctor.", " are ready to help.",
                " fell over in pain.");
    }
}
