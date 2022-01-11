package model.enemies.Wasteland;

import model.AttackSkill;
import model.Item;
import model.StatusEffect;
import model.SupportSkill;
import model.enemies.Enemy;

import java.util.ArrayList;
import java.util.Arrays;

public class WastelandRev extends Enemy {
    public WastelandRev() {
        super("Reverend Pastel", 600, 100, new ArrayList<>(Arrays.asList(
                        new AttackSkill("Stab for the Light", "stabbed with a cross, hitting", 0, "one",
                                50, StatusEffect.NONE, 1.0, 1.0, 1, 0, 0, 1.0, 1.0,
                                0, 0, StatusEffect.NONE),
                        new AttackSkill("Smite", "called down burning rays!", 0, "all", 25,
                                StatusEffect.BURNED, 1.0, 1.0, 2, 0, 0, 1.0,
                                1.0, 0, 0,StatusEffect.NONE),
                        new SupportSkill("Spiritual Healing", "said a prayer for", 0, "one",
                                50, 0, 1.0, 1.0, true, 0, 0, 0, StatusEffect.NONE,
                                0, 0, 1.0, 1.0 ,StatusEffect.NONE),
                        new SupportSkill("Blessing", "said a blessing for",
                                0, "one",
                                0, 0, 0.25, -0.10, false, 0, 0, 0, StatusEffect.NONE,
                                0, 0, 1.0, 1.0, StatusEffect.NONE)

                )), 8,
                "Who knew wasteland bandits could be religious? You'll burn if you aren't careful.",
                " stand strongly!",
                " fell to his knees...");

        loot = new Item("Reverend's Scripture", "Fully heals HP and AP, and cures status.",
                0.0, 1000, 101, 1.0, 1.0, true, StatusEffect.NONE, 0, "one");
    }
}
