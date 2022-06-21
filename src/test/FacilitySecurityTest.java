package test;

import model.AttackSkill;
import model.StatusEffect;
import model.enemies.Facility.FacilitySecurity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class FacilitySecurityTest {
    private FacilitySecurity gordon;
    private AttackSkill atkS;
    private AttackSkill atkB;
    private AttackSkill atkF;
    private AttackSkill atkP;
    private AttackSkill atkA;

    @BeforeEach
    public void setUp() {
        gordon = new FacilitySecurity();
        atkS = new AttackSkill("Attack!", "...attacks the enemy.", 10, "one", 10,
                StatusEffect.NONE, 1.0, 1.0, 0, 0, 0, 1.0, 1.0, 0, 0, StatusEffect.NONE);
        atkB = new AttackSkill("Attack!", "...attacks the enemy.", 10, "one", 40,
                StatusEffect.BURNED, 1.0, 1.0, 1, 0, 0, 1.0, 1.0, 0, 0, StatusEffect.NONE);
        atkF = new AttackSkill("Attack!", "...attacks the enemy.", 10, "one", 2,
                StatusEffect.NUMB, 1.0, 1.0, 1, 0, 0, 1.0, 1.0, 0, 0, StatusEffect.NONE);
        atkP = new AttackSkill("Attack!", "...attacks the enemy.", 10, "one", 0,
                StatusEffect.POISONED, 1.0, 1.0, 1, 0, 0, 1.0, 1.0, 0, 0, StatusEffect.NONE);
        atkA = new AttackSkill("Attack!", "...attacks the enemy.", 10, "one", 44,
                StatusEffect.AFRAID, 1.0, 1.0, 1, 0, 0, 1.0, 1.0, 0, 0, StatusEffect.NONE);
    }

    @Test
    public void testSetCurrentStatus() {
        assertEquals(gordon.getCurrentStatus(), StatusEffect.NONE);
        gordon.setCurrentStatus(StatusEffect.AFRAID);
        assertEquals(gordon.getCurrentStatus(), StatusEffect.NONE);

        gordon.turnDroneDead();

        gordon.setCurrentStatus(StatusEffect.AFRAID);
        assertEquals(gordon.getCurrentStatus(), StatusEffect.AFRAID);

        gordon.setCurrentStatus(StatusEffect.BURNED);
        assertEquals(gordon.getCurrentStatus(), StatusEffect.BURNED);

        gordon.setCurrentStatus(StatusEffect.NUMB);
        assertEquals(gordon.getCurrentStatus(), StatusEffect.NUMB);

        gordon.setCurrentStatus(StatusEffect.POISONED);
        assertEquals(gordon.getCurrentStatus(), StatusEffect.POISONED);

        gordon.setCurrentStatus(StatusEffect.NONE);
        assertEquals(gordon.getCurrentStatus(), StatusEffect.NONE);

    }

    @Test
    public void testSwitchMoveset() {
        assertEquals(gordon.getSkills().size(), 3);
        gordon.switchMoveset();
        assertEquals(gordon.getSkills().size(), 2);
    }
}
