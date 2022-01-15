package test;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AttackSkillTest {
    private PlayerCharacter p1;

    private AttackSkill atkS;
    private AttackSkill atkB;
    private AttackSkill atkF;
    private AttackSkill atkP;
    private AttackSkill atkA;
    private AttackSkill atkAmod;
    private AttackSkill atkDmod;

    private AttackSkill affectUser;

    private SupportSkill supS;
    private List<Skill> skills;

    @BeforeEach
    public void setUp() {
        skills = new ArrayList<>();
        atkS = new AttackSkill("Attack!", "...attacks the enemy.", 10, "one", 10,
                StatusEffect.NONE, 1.0, 1.0, 0, 0, 0, 1.0, 1.0, 0, 0, StatusEffect.NONE);
        atkB = new AttackSkill("Attack!", "...attacks the enemy.", 10, "one", 40,
                StatusEffect.BURNED, 1.0, 1.0, 1, 0, 0, 1.0, 1.0, 0, 0, StatusEffect.NONE);
        atkF = new AttackSkill("Attack!", "...attacks the enemy.", 10, "one", 2,
                StatusEffect.NUMB, 1.0, 1.0, 1, 0, 0, 1.0, 1.0, 0, 0, StatusEffect.NONE);
        atkP = new AttackSkill("Attack!", "...attacks the enemy.", 10, "one", 13,
                StatusEffect.POISONED, 1.0, 1.0, 1, 0, 0, 1.0, 1.0, 0, 0, StatusEffect.NONE);
        atkA = new AttackSkill("Attack!", "...attacks the enemy.", 10, "one", 44,
                StatusEffect.AFRAID, 1.0, 1.0, 1, 0, 0, 1.0, 1.0, 0, 0, StatusEffect.NONE);
        atkAmod = new AttackSkill("Attack!", "...attacks the enemy.", 10, "one", 23,
                StatusEffect.NONE, 0.50, 1.0, 1, 0, 0, 1.0, 1.0, 0, 0, StatusEffect.NONE);
        atkDmod = new AttackSkill("Attack!", "...attacks the enemy.", 10, "one", 9,
                StatusEffect.NONE, 1.0, 1.50, 1, 0, 0,1.0, 1.0, 0, 0, StatusEffect.NONE);
        affectUser = new AttackSkill("Recoil", "...attacks the enemy but u bump ur head and hurt urself :(",
                10, "one", 10, StatusEffect.NONE, 1.0, 1.0, 0, 0,
                10, -0.1, 0.1, -1, -1, StatusEffect.NONE);
        skills.add(atkS);
        skills.add(atkB);
        skills.add(atkF);
        skills.add(atkP);
        skills.add(atkA);
        skills.add(atkAmod);
        skills.add(atkDmod);
        skills.add(affectUser);

        p1 = new PlayerCharacter("John", 100, 100, skills, 5,
                "Test", new ArrayList<>(), new ArrayList<>());

    }

    @Test
    public void testAtkUser() {
        affectUser.takeUserEffect(p1);
        assertEquals(p1.getHp(), 100 - 10);
        assertEquals(p1.getAtkMod(), 0.9);
        assertEquals(p1.getDefMod(), 1.1);
        assertEquals(p1.getSpeed(), 4);

    }

    @Test
    public void testAtkSpd() {
        affectUser.takeEffect(p1);
        assertEquals(p1.getSpeed(), 4);
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
    public void testAtkSAtkMod() {
        atkS.setAtkMod(1.50);
        atkS.takeEffect(p1);
        assertEquals(p1.getHp(), p1.getMaxhp() - atkS.getDamage() * 1.50);
        assertEquals(p1.getAtkMod(), 1.0);
        assertEquals(p1.getDefMod(), 1.0);
        assertEquals(p1.getCurrentStatus(), StatusEffect.NONE);
    }

    @Test
    public void testAtkSAtkMod2() {
        atkS.setAtkMod(0.50);
        atkS.takeEffect(p1);
        assertEquals(p1.getHp(), p1.getMaxhp() - atkS.getDamage() * 0.50);
        assertEquals(p1.getAtkMod(), 1.0);
        assertEquals(p1.getDefMod(), 1.0);
        assertEquals(p1.getCurrentStatus(), StatusEffect.NONE);
    }

    @Test
    public void testAtkSDefMod() {
        p1.setDefMod(1.50);
        atkS.takeEffect(p1);
        assertEquals(p1.getHp(), p1.getMaxhp() - atkS.getDamage() * 1.50);
        assertEquals(p1.getAtkMod(), 1.0);
        assertEquals(p1.getDefMod(), 1.50);
        assertEquals(p1.getCurrentStatus(), StatusEffect.NONE);
    }

    @Test
    public void testAtkSDefMod2() {
        p1.setDefMod(0.50);
        atkS.takeEffect(p1);
        assertEquals(p1.getHp(), p1.getMaxhp() - atkS.getDamage() * 0.50);
        assertEquals(p1.getAtkMod(), 1.0);
        assertEquals(p1.getDefMod(), 0.50);
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
        assertEquals(p1.getCurrentStatus(), StatusEffect.NUMB);
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
        assertEquals(p1.getCurrentStatus(), StatusEffect.AFRAID);
    }

    @Test
    public void testAtkAmod() {
        atkAmod.takeEffect(p1);
        assertEquals(p1.getHp(), p1.getMaxhp() - atkAmod.getDamage());
        assertEquals(p1.getAtkMod(), (atkAmod.getAtkEffect() + 1.0));
        assertEquals(p1.getDefMod(), 1.0);
        p1.setAtkMod(3.50);
        atkAmod.takeEffect(p1);
        assertEquals(p1.getAtkMod(),4.0);
        assertEquals(p1.getCurrentStatus(), StatusEffect.NONE);
    }

    @Test
    public void testAtkDmod() {
        atkDmod.takeEffect(p1);
        assertEquals(p1.getHp(), p1.getMaxhp() - atkDmod.getDamage());
        assertEquals(p1.getAtkMod(), 1.0);
        assertEquals(p1.getDefMod(), 1.0 + atkDmod.getDefEffect());
        p1.setDefMod(3.99);
        atkDmod.takeEffect(p1);
        assertEquals(p1.getDefMod(), 4.0);
        assertEquals(p1.getCurrentStatus(), StatusEffect.NONE);
    }



    @Test
    public void testAtkDieWithStatusEffect() {
        p1.takeDamage(60.0);
        atkB.takeEffect(p1);
        assertEquals(p1.getHp(), 0);
        assertEquals(p1.getAtkMod(), 1.0);
        assertEquals(p1.getDefMod(), 1.0);
        assertEquals(p1.getCurrentStatus(), StatusEffect.NONE);
        assertTrue(p1.getDead());
    }



}
