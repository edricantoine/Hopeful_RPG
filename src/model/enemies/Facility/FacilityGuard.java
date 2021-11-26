package model.enemies.Facility;

import model.AttackSkill;
import model.StatusEffect;
import model.SupportSkill;
import model.enemies.Enemy;

import java.util.ArrayList;
import java.util.Arrays;

public class FacilityGuard extends Enemy {
    public FacilityGuard() {
        super("Agent Ace, Elite Guard", 400, 100, new ArrayList<>(Arrays.asList(
                        new AttackSkill("Shock Batons", "struck with electrified batons, hitting", 0, "one",
                                40, StatusEffect.NUMB, 1.0, 1.0, 1),
                        new AttackSkill("Group Counter", "commanded the enemies to counter!", 0, "all", 0,
                                StatusEffect.NONE, 1.0, 1.0, 2),
                        new SupportSkill("Group Defense", "commanded the enemies to defend!", 0, "all", 0,
                                0, 1.0, 0.5, false),
                        new SupportSkill("Group Attack Up", "commanded the enemies to attack!", 0, "all", 0,
                                0, 2.0, 1.0, false)

                )), 5, "This enemy relies on her guards to help her in battle. Taking them out will make this easier!",
                " are prepared.", " was defeated.");
    }

}
