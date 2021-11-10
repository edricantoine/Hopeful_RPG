package test;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AttackSkillTest {
    private PlayerCharacter p1;

    private AttackSkill atkS;
    private AttackSkill atkB;
    private AttackSkill atkF;
    private AttackSkill atkP;
    private AttackSkill atkA;
    private AttackSkill atkAmod;
    private AttackSkill atkDmod;

    private SupportSkill supS;
    private List<Skill> skills;

    @BeforeEach
    public void setUp() {
        skills = new ArrayList<>();
        atkS = new AttackSkill("Attack!", "...attacks the enemy.", 10, "one", 10,
                StatusEffect.NONE, 1.0, 1.0, 0);
        atkB = new AttackSkill("Attack!", "...attacks the enemy.", 10, "one", 40,
                StatusEffect.BURNED, 1.0, 1.0, 1);
        atkF = new AttackSkill("Attack!", "...attacks the enemy.", 10, "one", 2,
                StatusEffect.FROZEN, 1.0, 1.0, 1);
        atkP = new AttackSkill("Attack!", "...attacks the enemy.", 10, "one", 13,
                StatusEffect.POISONED, 1.0, 1.0, 1);
        atkA = new AttackSkill("Attack!", "...attacks the enemy.", 10, "one", 44,
                StatusEffect.AFRAID, 1.0, 1.0, 1);
        atkAmod = new AttackSkill("Attack!", "...attacks the enemy.", 10, "one", 23,
                StatusEffect.NONE, 0.50, 1.0, 1);
        atkDmod = new AttackSkill("Attack!", "...attacks the enemy.", 10, "one", 9,
                StatusEffect.NONE, 1.0, 1.50, 1);
        skills.add(atkS);
        skills.add(atkB);
        skills.add(atkF);
        skills.add(atkP);
        skills.add(atkA);
        skills.add(atkAmod);
        skills.add(atkDmod);

        p1 = new PlayerCharacter("John", 100, 100, skills, 5,
                "Test", new ArrayList<>(), new ArrayList<>());

    }

    @Test
    public void testAtkS() {
        atkS.takeEffect(p1);
        assertEquals(p1.getHp(), p1.getMaxhp() - atkS.getDamage());
        assertEquals(p1.getAtkMod(), 1.0);
        assertEquals(p1.getDefMod(), 1.0);
        assertEquals(p1.getCurrentStatus(), StatusEffect.NONE);
    }

    @Test
    public void testAtkB() {
        atkB.takeEffect(p1);
        assertEquals(p1.getHp(), p1.getMaxhp() - atkB.getDamage());
        assertEquals(p1.getAtkMod(), 1.0);
        assertEquals(p1.getDefMod(), 1.0);
        assertEquals(p1.getCurrentStatus(), StatusEffect.BURNED);
    }

    @Test
    public void testAtkF() {
        atkF.takeEffect(p1);
        assertEquals(p1.getHp(), p1.getMaxhp() - atkF.getDamage());
        assertEquals(p1.getAtkMod(), 1.0);
        assertEquals(p1.getDefMod(), 1.0);
        assertEquals(p1.getCurrentStatus(), StatusEffect.FROZEN);
    }

    @Test
    public void testAtkP() {
        atkP.takeEffect(p1);
        assertEquals(p1.getHp(), p1.getMaxhp() - atkP.getDamage());
        assertEquals(p1.getAtkMod(), 1.0);
        assertEquals(p1.getDefMod(), 1.0);
        assertEquals(p1.getCurrentStatus(), StatusEffect.POISONED);
    }

    @Test
    public void testAtkA() {
        atkA.takeEffect(p1);
        assertEquals(p1.getHp(), p1.getMaxhp() - atkA.getDamage());
        assertEquals(p1.getAtkMod(), 0.75);
        assertEquals(p1.getDefMod(), 1.25);
        assertEquals(p1.getCurrentStatus(), StatusEffect.AFRAID);
    }

    @Test
    public void testAtkAmod() {
        atkAmod.takeEffect(p1);
        assertEquals(p1.getHp(), p1.getMaxhp() - atkAmod.getDamage());
        assertEquals(p1.getAtkMod(), atkAmod.getAtkEffect());
        assertEquals(p1.getDefMod(), 1.0);
        assertEquals(p1.getCurrentStatus(), StatusEffect.NONE);
    }

    @Test
    public void testAtkDmod() {
        atkDmod.takeEffect(p1);
        assertEquals(p1.getHp(), p1.getMaxhp() - atkDmod.getDamage());
        assertEquals(p1.getAtkMod(), 1.0);
        assertEquals(p1.getDefMod(), atkDmod.getDefEffect());
        assertEquals(p1.getCurrentStatus(), StatusEffect.NONE);
    }

}
