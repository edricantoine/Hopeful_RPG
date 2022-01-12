package model.enemies.Facility;

import model.AttackSkill;
import model.Item;
import model.StatusEffect;
import model.SupportSkill;
import model.enemies.Enemy;

import java.util.ArrayList;
import java.util.Arrays;
// A class for the "COBRA Drone" boss.
public class FacilityDrone extends Enemy {
    public FacilityDrone() {
        super("COBRA Drone", 350, 100, new ArrayList<>(Arrays.asList(
                        new AttackSkill("Discharge", "discharged electricity!", 0, "all",
                                50, StatusEffect.NUMB, 1.0, 1.0, 2, 0, 0,
                                1.0, 1.0, 0, 0, StatusEffect.NONE),
                        new AttackSkill("Flamethrower", "shot flames out!", 0, "all", 50,
                                StatusEffect.BURNED, 1.0, 1.0, 2,
                                0, 0, 1.0, 1.0, 0, 0, StatusEffect.NONE),
                        new SupportSkill("Repair Subroutine", "entered repair mode, healing", 0, "one", 50,
                                0, 1.0, 1.0, true, 0, 0, 0, StatusEffect.NONE,
                                0, 0, 1.0, 1.0 ,StatusEffect.NONE)

                )), 8, "You can't take out the commander until you take out the drone!",
                " block the way!", " was destroyed.");

        loot = new Item("COBRA Battery", "Zaps all enemies with lightning and Numbs them.", 0.0,
                0.0, 0, 1.0, 1.0, false, StatusEffect.NONE, 1, "one");
    }
}
