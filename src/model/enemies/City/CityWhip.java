package model.enemies.City;

import model.AttackSkill;
import model.Item;
import model.StatusEffect;
import model.SupportSkill;
import model.enemies.Enemy;

import java.util.ArrayList;
import java.util.Arrays;
//Class representing the "Ari the Vile" boss.
public class CityWhip extends Enemy {
    public CityWhip() {
        super("Ari the Vile", 450, 100, new ArrayList<>(Arrays.asList(
                        new AttackSkill("Scalewhip", "swung a toxic scale whip around!", 0, "all",
                                50, StatusEffect.POISONED, 1.0, 1.0, 2,
                                0, 0,  0.5, 1.0, 0, 0, StatusEffect.NONE),
                        new AttackSkill("Scaleshot", "fired piercing scales at", 0, "one", 75,
                                StatusEffect.NONE, 1.0, 1.0, 1,
                                0, 10, 1.0, 1.0, 0, 0, StatusEffect.NONE),
                        new AttackSkill("Nimble Reflexes", "swooped behind the party and struck", 0, "one",
                                50, StatusEffect.NONE, 1.0, 1.0, 1,
                                0, 0,  0.5, 1.0, 1, 0, StatusEffect.NONE),
                        new SupportSkill("Swig", "drank from a flask", 0, "one", 100,
                                0, 0.2, 1.0, true, 0, 0, 0, StatusEffect.NUMB,
                                0, 0, 1.0, 1.0, StatusEffect.NONE)

                )), 6, "Ari attacks with deadly scale whips that pack a serious punch - and can poison, too! Time to put Trip to work!",
                " stares coldly...", " was defeated!");

        loot = new Item("Ari's Scales", "Damages and poisons its targets.", 50,
                0.0, 0, 1.00, 1.00, 0, false, StatusEffect.POISONED, 1, "all");
    }
}
