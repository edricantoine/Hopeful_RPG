package model.enemies.Facility;

import model.AttackSkill;
import model.Item;
import model.StatusEffect;
import model.enemies.Enemy;

import java.util.ArrayList;
import java.util.Arrays;

public class FacilitySecurity extends Enemy {
    private boolean isDroneDead;
    public FacilitySecurity() {
        super("Agent Dealer, Head of Security", 10, 100, new ArrayList<>(Arrays.asList(
                        new AttackSkill("Taunt", "said something nasty!", 0, "all",
                                0, StatusEffect.NONE, 1.0, 1.0, 1, 0, 0,
                                1.0, 1.0, 0, 0, StatusEffect.NONE),
                        new AttackSkill("Laugh", "laughed... annoyingly.", 0, "all", 0,
                                StatusEffect.NONE, 1.0, 1.0, 2, 0, 0, 1.0, 1.0,
                                0, 0, StatusEffect.NONE),
                        new AttackSkill("Gloat", "bragged about his drone!", 0, "all", 0,
                                StatusEffect.NONE, 1.0, 1.0, 1, 0,0, 1.0,
                                1.0, 0,0, StatusEffect.NONE)


                )), 11, "You can't take out the commander until you take out the drone!",
                " block the way!", " was destroyed.");
        isDroneDead = false;
        loot = new Item("Dealer's Shield Cell", "Heavily increases defense of one character.", 0.0,
                0.0, 0, 1.0, -0.38, false, StatusEffect.NONE, 1, "one");
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
                        0, StatusEffect.NONE, 1.0, 1.0, 1, 0, 0, 1.0,
                        1.0, 0, 0, StatusEffect.NONE),
                new AttackSkill("Beg", "begged for mercy!", 0, "all", 0,
                        StatusEffect.NONE, 1.0, 1.0, 2, 0, 0, 1.0, 1.0, 0, 0, StatusEffect.NONE))));
    }

    @Override
    public void setCurrentStatus(StatusEffect currentStatus) {
        if(!this.getDead() && !this.isDroneDead) {
            this.currentStatus = currentStatus;
            if (currentStatus.equals(StatusEffect.BURNED)) {
                timeSinceStatusApplied = W_BURNED;
            } else if (currentStatus.equals(StatusEffect.POISONED)) {
                timeSinceStatusApplied = W_POISONED;
            } else if (currentStatus.equals(StatusEffect.NUMB)) {
                timeSinceStatusApplied = W_FROZEN;
            } else if (currentStatus.equals(StatusEffect.AFRAID)) {
                timeSinceStatusApplied = W_AFRAID;

            } else if (currentStatus.equals(StatusEffect.NONE)) {

                timeSinceStatusApplied = 0;
            }
        }
    }
}
