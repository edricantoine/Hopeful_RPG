package model.enemies.City;

import model.AttackSkill;
import model.Item;
import model.StatusEffect;
import model.SupportSkill;
import model.enemies.Enemy;

import java.util.ArrayList;
import java.util.Arrays;

//A class for the "Isaac Volkov" boss.
public class CityBiker extends Enemy {
    public CityBiker() {
        super("Isaac Volkov", 400, 100, new ArrayList<>(Arrays.asList(
                        new AttackSkill("Hit N' Run", "charged on his motorcycle, hitting", 0, "one",
                                70, StatusEffect.NONE, 1.0, 1.0, 1,
                                0, 0, 1.0, 1.0, 0, 0, StatusEffect.NONE ),
                        new AttackSkill("Donuts", "spun in circles!", 0, "all",
                        35, StatusEffect.NONE, 1.0, 1.0, 1,
                        0, 0, 1.0, 1.0, 0, 0, StatusEffect.NONE),
                        new AttackSkill("Donuts", "spun in circles!", 0, "all",
                                35, StatusEffect.NONE, 1.0, 1.0, 1,
                                0, 0, 1.0, 1.0, 0, 0, StatusEffect.NONE),
                        new SupportSkill("Fighting Words", "hyped up his allies!", 0, "all", 0,
                                0, 0.20, 1.0, false, 0, 1, 0, StatusEffect.NONE,
                                0, 0, 1.0, 1.0, StatusEffect.NONE),
                        new AttackSkill("Engine Rev", "revved his bike loudly and fiercely!", 0, "all",
                                20, StatusEffect.NUMB, -0.25, 0.20, 3,
                                0, 0, 1.0, 1.0, 1, 0, StatusEffect.NONE)

                )), 5, "Don't let him run you flat with his bike!",
                " are ready to rock.", " crumpled to his knees!");

        loot = new Item("Can o' Fuel", "Damages and burns all selected targets", 90,
                0.0, 0, 1.0, 1.0, 0, false, StatusEffect.BURNED, 1, "all");
    }
}
