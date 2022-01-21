package model.enemies.City;

//Class for the "Corrupt Cop" enemy

import model.AttackSkill;
import model.Item;
import model.StatusEffect;
import model.SupportSkill;
import model.enemies.Enemy;

import java.util.ArrayList;
import java.util.Arrays;

public class CityCop extends Enemy {
    public CityCop() {
        super("Corrupt Cop", 200, 100, new ArrayList<>(Arrays.asList(
                        new AttackSkill("Gun Down", "shot with a pistol at", 0, "one",
                                50, StatusEffect.NONE, 1.0, 1.0, 1,
                                0, 0, 1.0, 1.0, 0, -1, StatusEffect.NONE ),
                        new AttackSkill("Gun Down", "shot with a pistol at", 0, "one",
                                50, StatusEffect.NONE, 1.0, 1.0, 1,
                                0, 0, 1.0, 1.0, 0, -1, StatusEffect.NONE ),
                        new SupportSkill("Defensive Formation", "and cohorts got into a slow but defensive position!", 0, "all", 0,
                                0, 1.0, -0.15, false, 0, -2, 0, StatusEffect.NONE,
                                0, 0, 1.0, 1.0, StatusEffect.NONE),
                        new SupportSkill("Defensive Formation", "and cohorts got into a slow but defensive position!", 0, "all", 0,
                                0, 1.0, -0.15, false, 0, -2, 0, StatusEffect.NONE,
                                0, 0, 1.0, 1.0, StatusEffect.NONE),
                        new AttackSkill("Skeet Shoot", "fired wildly!", 0, "all",
                                20, StatusEffect.NONE, 1.0, 1.0, 1,
                                0, 0, 1.0, 1.0, 0, 0, StatusEffect.NONE),
                        new AttackSkill("Skeet Shoot", "fired wildly!", 0, "all",
                                50, StatusEffect.NONE, 1.0, 1.0, 1,
                                0, 10, 1.0, 1.0, 0, 0, StatusEffect.NONE),
                        new AttackSkill("Skeet Shoot", "fired wildly!", 0, "all",
                                70, StatusEffect.NONE, 1.0, 1.0, 1,
                                0, 30, 1.0, 1.0, 0, 0, StatusEffect.NONE)


                )), 3, "This corrupt cop has been working with the gangs! Show him some real justice!",
                " are alert!", " crumpled to his knees!");

        loot = new Item("Riot Shield", "Activates Riposte on one character.", 0.0,
                0.0, 0, 1.0, 1.0, 0, false, StatusEffect.RIPOSTE, 1, "one");
    }
}
