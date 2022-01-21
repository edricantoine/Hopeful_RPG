package model.enemies.City;

//Class for the "Mars" boss

import model.AttackSkill;
import model.Item;
import model.StatusEffect;
import model.SupportSkill;
import model.enemies.Enemy;

import java.util.ArrayList;
import java.util.Arrays;

public class CityBoxer extends Enemy {
    public CityBoxer() {
        super("Mars the Champion", 500, 100, new ArrayList<>(Arrays.asList(
                        new AttackSkill("Tailwind", "summoned a gale of wind, blowing against you!", 0, "all",
                                40, StatusEffect.NONE, 1.0, 1.0, 1,
                                0, 0, 1.0, 1.0, 1, 0, StatusEffect.NONE ),
                        new SupportSkill("Counter Stance", "got ready to counterattack!", 0, "all", 0,
                                0, 1.0, 1.0, false, 0, 0, 0, StatusEffect.RIPOSTE,
                                0, 0, 0.2, 1.0, StatusEffect.NONE),
                        new AttackSkill("Throat Punch", "punched the throat of, and immobilized", 0, "one",
                                30, StatusEffect.NUMB, 1.0, 0.1, 1,
                                0, 0, 1.0, 1.0, 0, 0, StatusEffect.NONE),
                        new AttackSkill("Ora", "rapidly punched", 0, "one",
                                75, StatusEffect.NONE, 1.0, 1.0, 1,
                                0, 0, 1.0, 1.0, 0, -1, StatusEffect.NONE)


                )), 6, "Mars can summon vicious wind storms to attack your party and increase the enemies' speed.",
                " enter the ring!", " crumpled to her knees!");

        loot = new Item("Mars' Feather", "Summons a mighty gust of wind to heal and increase speed dramatically!", 0.0,
                50.0, 0, 1.0, 1.0, 3, false, StatusEffect.RIPOSTE, 1, "all");
    }
}
