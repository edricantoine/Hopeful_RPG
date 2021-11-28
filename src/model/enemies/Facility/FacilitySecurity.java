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
                                0, StatusEffect.NONE, 1.0, 1.0, 1),
                        new AttackSkill("Laugh", "laughed... annoyingly.", 0, "all", 0,
                                StatusEffect.NONE, 1.0, 1.0, 2),
                        new AttackSkill("Gloat", "bragged about his drone!", 0, "all", 0,
                                StatusEffect.NONE, 1.0, 1.0, 1)


                )), 11, "You can't take out the commander until you take out the drone!",
                " block the way!", " was destroyed.");
        isDroneDead = false;
        loot = new Item("Dealer's Shield Cell", "Maximizes defense until the target is Cured or made Afraid.", 0.0,
                0.0, 0, 1.0, 0.0, false, StatusEffect.NONE, 1, "one");
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
                atkMod = 0.75;
                defMod = 1.25;
            } else if (currentStatus.equals(StatusEffect.NONE)) {

                atkMod = 1.0;
                defMod = 1.0;

                timeSinceStatusApplied = 0;
            }
        }
    }
}
