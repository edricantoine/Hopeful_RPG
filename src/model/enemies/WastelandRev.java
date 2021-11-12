package model.enemies;

import model.AttackSkill;
import model.StatusEffect;
import model.SupportSkill;

import java.util.ArrayList;
import java.util.Arrays;

public class WastelandRev extends Enemy{
    public WastelandRev() {
        super("Reverend Pastel", 600, 100, new ArrayList<>(Arrays.asList(
                        new AttackSkill("Stab for the Light", " stabbed with a cross!", 0, "one",
                                50, StatusEffect.NONE, 1.0, 1.0, 1),
                        new AttackSkill("Smite", " called down burning rays!", 0, "all", 25,
                                StatusEffect.BURNED, 1.0, 1.0, 2),
                        new SupportSkill("Spiritual Healing", " said a prayer...", 0, "one",
                                50, 0, 1.0, 1.0, true),
                        new SupportSkill("Blessing", " said a blessing!",
                                0, "one",
                                0, 0, 1.25, 0.75, false)

                )), 8,
                "Who knew wasteland bandits could be religious? You'll burn if you aren't careful.",
                " stands strongly!",
                " fell to his knees...");
    }
}
