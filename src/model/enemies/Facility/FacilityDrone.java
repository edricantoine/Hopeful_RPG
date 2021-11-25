package model.enemies.Facility;

import model.AttackSkill;
import model.StatusEffect;
import model.SupportSkill;
import model.enemies.Enemy;

import java.util.ArrayList;
import java.util.Arrays;

public class FacilityDrone extends Enemy {
    public FacilityDrone() {
        super("COBRA Drone", 500, 100, new ArrayList<>(Arrays.asList(
                        new AttackSkill("Discharge", "discharged electricity!", 0, "all",
                                20, StatusEffect.NUMB, 1.0, 1.0, 2),
                        new AttackSkill("Flamethrower", "shot flames out!", 0, "all", 30,
                                StatusEffect.BURNED, 1.0, 1.0, 2),
                        new AttackSkill("Laser Shot", "shot a beam at", 0, "one", 50,
                                StatusEffect.NONE, 1.0, 1.0, 1),
                        new SupportSkill("Repair Subroutine", "entered repair mode, healing", 0, "one", 50,
                                0, 1.0, 1.0, true)

                )), 8, "You can't take out the commander until you take out the drone!",
                " block the way!", " was destroyed.");
    }
}
