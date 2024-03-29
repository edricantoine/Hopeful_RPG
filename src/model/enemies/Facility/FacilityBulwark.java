package model.enemies.Facility;

import model.AttackSkill;
import model.Item;
import model.StatusEffect;
import model.SupportSkill;
import model.enemies.Enemy;

import java.util.ArrayList;
import java.util.Arrays;

//A class for the "Watcher Defender" enemy.

public class FacilityBulwark extends Enemy {

    public FacilityBulwark() {
        super("Watcher Defender", 200, 100, new ArrayList<>(Arrays.asList(
                        new AttackSkill("Bash", "bashed with a riot shield, hitting", 0, "one",
                                30, StatusEffect.NONE, 1.0, 1.0, 1,
                                0, 0, 1.0, 1.0, 0, 0, StatusEffect.NONE ),
                        new SupportSkill("Shield Stance", "and cohorts assumed a defensive stance!", 0, "all", 0,
                                0, 1.0, -0.10, false, 0, 0, 0, StatusEffect.NONE,
                                0, 0, 1.0, 1.0,StatusEffect.NONE),
                        new AttackSkill("Intimidate", "roared fiercely, intimidating", 0, "one",
                                0, StatusEffect.AFRAID, 1.0, 1.0, 1,
                                0, 0, 1.0, 1.0, 0, 0, StatusEffect.NONE)

                )), 5, "This enemy will increase all his allies' defense, so take him out quickly.",
                " stand strong!", " crumpled to his knees!");

        loot = new Item("Riot Shield", "Activates Riposte on one character.", 0.0,
                0.0, 0, 1.0, 1.0, 0, false, StatusEffect.RIPOSTE, 1, "one");
    }

}
