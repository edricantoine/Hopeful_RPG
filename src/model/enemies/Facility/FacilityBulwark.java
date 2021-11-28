package model.enemies.Facility;

import model.AttackSkill;
import model.Item;
import model.StatusEffect;
import model.SupportSkill;
import model.enemies.Enemy;

import java.util.ArrayList;
import java.util.Arrays;

public class FacilityBulwark extends Enemy {

    public FacilityBulwark() {
        super("Watcher Defender", 200, 100, new ArrayList<>(Arrays.asList(
                        new AttackSkill("Bash", "bashed with a riot shield, hitting", 0, "one",
                                30, StatusEffect.NONE, 1.0, 1.0, 1),
                        new SupportSkill("Shield Stance", "and cohorts assumed a defensive stance!", 0, "all", 0,
                                0, 1.0, 0.5, false),
                        new AttackSkill("Intimidate", "roared fiercely, intimidating", 0, "one",
                                0, StatusEffect.AFRAID, 1.0, 1.0, 1)

                )), 5, "This enemy will increase all his allies' defense, so take him out quickly.",
                " stand strong!", " crumpled to his knees!");

        loot = new Item("Riot Shield", "Increases defense and activates Riposte.", 0.0,
                0.0, 0, 1.0, 0.80, false, StatusEffect.RIPOSTE, 1, "one");
    }

}
