package model.enemies.Facility;

import model.Item;
import model.StatusEffect;
import model.SupportSkill;
import model.enemies.Enemy;

import java.util.ArrayList;
import java.util.Arrays;

public class FacilityMedic extends Enemy {
    public FacilityMedic() {
        super("Watcher Medic", 80, 100, new ArrayList<>(Arrays.asList(
                        new SupportSkill("Biofield", "emitted a healing pulse!", 0, "all", 30,
                                0, 1.0, 1.0, false),
                        new SupportSkill("The Cure", "emitted a curing pulse!", 0, "all", 0,
                                0, 1.0, 1.0, true),
                        new SupportSkill("Medical Attention", "fully healed", 0, "one", 200,
                                0, 1.0, 1.0, false)

                )), 5, "Take him out first, or he'll just keep on healing his allies!",
                " are prepared to fight", " crumpled to his knees!");
        loot = new Item("Biofield", "Heals all allies by 50.", 0.0,
                0.0, 0, 1.0, 1.0, false, StatusEffect.NONE, 1, "one");
    }
}
