package model.enemies.City;

//A class for the "Knife Knut" enemy

import model.AttackSkill;
import model.Item;
import model.StatusEffect;
import model.enemies.Enemy;

import java.util.ArrayList;
import java.util.Arrays;

public class CityKnifer extends Enemy {
    public CityKnifer() {
        super("Knife Knut", 100, 100, new ArrayList<>(Arrays.asList(
                        new AttackSkill("Critical Stab!", "stabbed with a dagger, multiple times, hitting", 0, "one",
                                100, StatusEffect.NONE, 1.0, 1.0, 1,
                                0, 0, 1.0, 1.0, 0, 0, StatusEffect.NONE ),

                        new AttackSkill("Psych Up", "screamed loudly at", 0, "one",
                                0, StatusEffect.AFRAID, 1.0, 1.0, 1,
                                0, 0, 1.0, 1.0, 1, -1, StatusEffect.NONE)

                )), 7, "This mentally-unstable guy really knows how to cripple someone with his knife. Watch out!",
                " brandished their weapons!", " crumpled to his knees!");

        loot = new Item("Frail Knife", "Use this to strike at the very soul of one enemy! But then it breaks.", 100.0,
                0.0, 0, 0.5, 1.0, 0, false, StatusEffect.NONE, 1, "one");
    }
}
