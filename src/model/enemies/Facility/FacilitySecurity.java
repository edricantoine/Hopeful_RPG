package model.enemies.Facility;

import model.AttackSkill;
import model.StatusEffect;
import model.enemies.Enemy;

import java.util.ArrayList;
import java.util.Arrays;

public class FacilitySecurity extends Enemy {
    private boolean isDroneDead;
    public FacilitySecurity() {
        super("Dealer, Head of Security", 10, 100, new ArrayList<>(Arrays.asList(
                        new AttackSkill("Taunt", "said something nasty!", 0, "all",
                                0, StatusEffect.NONE, 1.0, 1.0, 1),
                        new AttackSkill("Laugh", "laughed... annoyingly.", 0, "all", 0,
                                StatusEffect.NONE, 1.0, 1.0, 2),
                        new AttackSkill("Gloat", "bragged about his drone!", 0, "all", 0,
                                StatusEffect.NONE, 1.0, 1.0, 1)


                )), 11, "You can't take out the commander until you take out the drone!",
                " block the way!", " was destroyed.");
        isDroneDead = false;
    }

    public void turnDroneDead() {
        isDroneDead = true;
    }

    public boolean isDroneDead() {
        return isDroneDead;
    }

    public void switchMoveset() {
        setSkills(new ArrayList<>(Arrays.asList(
                new AttackSkill("Cower", "cowered in fear!", 0, "all",
                        0, StatusEffect.NONE, 1.0, 1.0, 1),
                new AttackSkill("Beg", "begged for mercy!", 0, "all", 0,
                        StatusEffect.NONE, 1.0, 1.0, 2),
                new AttackSkill("Weak Slap", "weakly slapped at", 0, "one", 1,
                        StatusEffect.NONE, 1.0, 1.0, 1))));
    }
}
