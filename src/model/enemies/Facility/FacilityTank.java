package model.enemies.Facility;

import model.AttackSkill;
import model.StatusEffect;
import model.SupportSkill;
import model.enemies.Enemy;

import java.util.ArrayList;
import java.util.Arrays;

public class FacilityTank extends Enemy {
    private Boolean hasRevived;
    public FacilityTank() {
        super("Agent Jackpot", 500, 100, new ArrayList<>(Arrays.asList(
                        new AttackSkill("Shield Gauntlets", "struck with a massive shield, hitting", 0, "one",
                                15, StatusEffect.NONE, 1.0, 1.10, 1),
                        new SupportSkill("Shrug It Off", "held up a shield!", 0, "one", 0,
                                0, 1.0, 0.0, false)

                )), 2, "Just when you think you've beaten him...",
                " make their last stand.", " was defeated for good.");
    }

    public void checkandRevive() {
        if(getHp() <= 1 && !hasRevived) {
            ascend();
            hasRevived = true;
        }
    }

    public void ascend() {
        setName("Agent Jackpot, the Ascended");
        healDamage(10000.0);
        setSkills(new ArrayList<>(Arrays.asList(
                new AttackSkill("Radiant Beam", "fired a beam of burning light from his face, at", 0, "one",
                        50, StatusEffect.BURNED, 1.0, 1.0, 2),
                new AttackSkill("Glory", "emitted a dazzling light!", 0, "all", 20,
                        StatusEffect.NONE, 1.0, 1.0, 2),
                new AttackSkill("Be Not Afraid", "focused many eyes on the party...", 0, "all", 0,
                        StatusEffect.AFRAID, 1.0, 1.0, 1))));

    }
}
