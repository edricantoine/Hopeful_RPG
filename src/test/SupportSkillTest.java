package test;

import model.PlayerCharacter;
import model.StatusEffect;
import model.SupportSkill;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class SupportSkillTest {

    private PlayerCharacter p1;

    private SupportSkill supS;
    private SupportSkill supA;
    private SupportSkill supAtk;
    private SupportSkill supDef;
    private SupportSkill supCure;
    private SupportSkill supUser;


    @BeforeEach
    public void setUp() {
        supS = new SupportSkill("Basic Heal", "Heals for 10 HP", 0, "one", 10.0,
                0, 1.0, 1.0, false, 0, 0, 0, StatusEffect.NONE, 0, 0,
                1.0, 1.0, StatusEffect.NONE);

        supA = new SupportSkill("AP Heal", "Heals for 10 AP", 0, "one", 0.0,
                10, 1.0, 1.0, false, 0, 0, 0, StatusEffect.NONE, 0, 0,
                1.0, 1.0, StatusEffect.NONE);

        supAtk = new SupportSkill("Attack Up", "Increases attack", 0, "one",
                0.0, 0, 0.1, 1.0, false, 0, 0, 0, StatusEffect.NONE,
                0, 0, 1.0, 1.0, StatusEffect.NONE);

        supDef = new SupportSkill("Defense Up", "Increases defense", 0, "one",
                0.0, 0, 1.0, -0.1, false, 0, 0, 0, StatusEffect.NONE,
                0, 0, 1.0, 1.0, StatusEffect.NONE);

        supCure = new SupportSkill("Cure", "Cures a status ailment, but resets attack and defense.",
                0, "one", 0.0, 0, 1.0, 1.0, true, 0, 0, 0, StatusEffect.NONE,
                0, 0, 1.0, 1.0, StatusEffect.NONE);

        supUser = new SupportSkill("BuffNHeal", "Heals target and user for 10 HP, increases user's atk, def, and speed, " +
                "increases target speed, gives user riposte", 0, "one", 10.0, 0, 1.0, 1.0, false, 0, 1, 1,
                StatusEffect.NONE, 10, 0, 0.1, -0.1, StatusEffect.RIPOSTE);


        p1 = new PlayerCharacter("John", 100, 100, new ArrayList<>(), 5,
                "Test", new ArrayList<>(), new ArrayList<>());

    }

    @Test
    public void testsupUser() {
        p1.takeDamage(10);
        assertEquals(p1.getHp(), p1.getMaxhp() - 10);
        supUser.takeUserEffect(p1);
        assertEquals(p1.getHp(), p1.getMaxhp());
        assertEquals(p1.getAtkMod(), 1.1);
        assertEquals(p1.getDefMod(), 0.9);
        assertEquals(p1.getSpeed(), 6);
        assertEquals(p1.getCurrentStatus(), StatusEffect.RIPOSTE);
    }

    @Test
    public void testAffectSpeed() {
        assertEquals(p1.getSpeed(), 5);
        supUser.takeEffect(p1);
        assertEquals(p1.getSpeed(), 6);
    }

    @Test
    public void testHealSkill() {
        p1.setAtkMod(2.00);
        p1.setDefMod(2.00);
        p1.takeDamage(25);
        assertEquals(p1.getHp(), 50);
        supS.takeEffect(p1);
        assertEquals(p1.getHp(), 60);
        assertEquals(p1.getDefMod(), 2.00);
        assertEquals(p1.getAtkMod(), 2.00);

        p1.takeDamage(30);
        assertTrue(p1.getDead());
        assertEquals(p1.getDefMod(), 1.0);
        assertEquals(p1.getAtkMod(), 1.0);

        supS.takeEffect(p1);
        assertEquals(p1.getHp(), 10);
        assertFalse(p1.getDead());

    }

    @Test
    public void testAPHeal() {
        p1.setAtkMod(2.00);
        p1.setDefMod(2.00);

        p1.useAp(50);
        supA.takeEffect(p1);
        assertEquals(p1.getAp(), 60);
        p1.healAp(39);
        supA.takeEffect(p1);
        assertEquals(p1.getAp(), p1.getMaxap());
        assertEquals(p1.getDefMod(), 2.0);
        assertEquals(p1.getAtkMod(), 2.0);

    }

    @Test
    public void testAtkModSkill() {
        supAtk.takeEffect(p1);
        assertEquals(p1.getAtkMod(), 1.0 + 0.1);
        assertEquals(p1.getDefMod(), 1.0);

        supAtk.takeEffect(p1);
        assertEquals(p1.getAtkMod(), 1.0 + 0.1 + 0.1);
        assertEquals(p1.getDefMod(), 1.0);
    }

    @Test
    public void testDefModSkill() {
        supDef.takeEffect(p1);
        assertEquals(p1.getDefMod(), 1.0 - 0.1);
        assertEquals(p1.getAtkMod(), 1.0);

        supDef.takeEffect(p1);
        assertEquals(p1.getDefMod(), 1.0 - 0.1 - 0.1);
        assertEquals(p1.getAtkMod(), 1.0);
    }

    @Test
    public void testCureSkill() {
        p1.setAtkMod(2.00);
        p1.setDefMod(2.00);
        p1.setCurrentStatus(StatusEffect.BURNED);
        supCure.takeEffect(p1);
        assertEquals(p1.getDefMod(), 2.0);
        assertEquals(p1.getAtkMod(), 2.0);
        assertEquals(p1.getCurrentStatus(), StatusEffect.NONE);

    }


}
