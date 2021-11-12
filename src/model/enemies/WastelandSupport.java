package model.enemies;

import model.SupportSkill;

import java.util.ArrayList;
import java.util.Arrays;

public class WastelandSupport extends Enemy{
    public WastelandSupport() {
        super("Bandit Doctor", 80, 100, new ArrayList<>(Arrays.asList(
                        new SupportSkill("Unlicensed Medicine", " stuffed a pill down an ally's throat!", 0, "one",
                                30, 0, 1.0, 1.0, false),
                        new SupportSkill("Roids!", " injected an ally with something strange...", 0, "one",
                                0, 0, 1.50, 1.0, false)
                )), 5,
                "WARNING: Not a licensed doctor.", " is ready to help.",
                " fell over in pain.");
    }
}
