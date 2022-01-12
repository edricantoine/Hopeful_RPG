package model.enemies.Facility;

import model.AttackSkill;
import model.Item;
import model.StatusEffect;
import model.SupportSkill;
import model.enemies.Enemy;

import java.util.ArrayList;
import java.util.Arrays;

//A class for the "Watcher Striker" enemy.

public class FacilityMelee extends Enemy {

    public FacilityMelee() {
        super("Watcher Striker", 100, 100, new ArrayList<>(Arrays.asList(
                        new AttackSkill("Baton Strike", "swung a baton at", 0, "one",
                                40, StatusEffect.NONE, 1.0, 1.0, 1, 0, 0,
                                1.0, 1.0, 0, 0, StatusEffect.NONE),
                        new SupportSkill("Battlecry", "riled up the enemies!", 0, "all", 0,
                                0, 0.25, 1.0, false, 0, 0, 0, StatusEffect.NONE,
                                0, 0, 1.0, 1.0, StatusEffect.NONE),
                        new SupportSkill("Defensive Stance", "is ready to counter!", 0, "all",
                                0, 0, 1.0, 1.0, false, 0, 0, 0, StatusEffect.NONE,
                                0, 0, 1.0, 1.0, StatusEffect.RIPOSTE)

                )), 5, "Don't attack him when he's countering, or you'll feel the pain too!",
                " enter the fray!", " crumpled to his knees!");

        loot = new Item("Food Rations", "Heals by 50 HP.",
                0.0, 50.0, 0, 1.0, 1.0, false, StatusEffect.NONE, 0, "one");
    }
}
