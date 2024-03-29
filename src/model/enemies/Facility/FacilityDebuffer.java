package model.enemies.Facility;

import model.AttackSkill;
import model.Item;
import model.StatusEffect;
import model.enemies.Enemy;

import java.util.ArrayList;
import java.util.Arrays;

//A class for the "Watcher Scientist" enemy.
public class FacilityDebuffer extends Enemy {

    public FacilityDebuffer() {
        super("Watcher Scientist", 110, 100, new ArrayList<>(Arrays.asList(
                new AttackSkill("Acid Bomb", "threw a beaker of acid at", 0, "one",
                        40, StatusEffect.BURNED, 1.0, 1.0, 1, 0, 0,
                        1.0, 1.0, 0, 0, StatusEffect.NONE),
                new AttackSkill("Stun Gun", "wielded a taser at", 0, "one", 50,
                        StatusEffect.NUMB, 1.0, 1.0, 1,
                        0, 0, 1.0, 1.0, 0, 0, StatusEffect.NONE),
                new AttackSkill("Toxic Gas", "opened a vial of gas!", 0, "all", 20,
                        StatusEffect.POISONED, 1.0, 1.0, 1,
                        0, 0, 1.0, 1.0, 0, 0, StatusEffect.NONE),
                new AttackSkill("Hallucinogen", "induced hallucinations on the party!", 0, "all", 0,
                        StatusEffect.AFRAID, 1.0, 1.0, 1,
                        0, 0, 1.0, 1.0, 0, 0, StatusEffect.NONE)
        )), 5, "This enemy will inflict status effects on the party, generally making life really annoying.",
                " ready their equipment.", " ran away!");

        loot = new Item("Pot of Coffee", "Permanently increases Speed this battle.", 0.0,
                0.0, 0, 1.0, 1.0, 1, false, StatusEffect.NONE, 1, "one");
    }
}
