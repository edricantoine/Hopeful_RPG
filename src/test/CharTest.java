package test;

import model.*;
import model.enemies.Enemy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CharTest {

    private PlayerCharacter p1;
    private PlayerCharacter p2;
    private Enemy e1;
    private Enemy e2;
    private AttackSkill atkS;
    private SupportSkill supS;
    private List<Skill> skills;
    private List<PlayerCharacter> party;
    private List<Enemy> ens;
    private List<Enemy> ens2;

    @BeforeEach
    public void setUp() {
        ens = new ArrayList<>();
        ens2 = new ArrayList<>();
        skills = new ArrayList<>();
        party = new ArrayList<>();
        atkS = new AttackSkill("Attack!", "...attacks the enemy.", 10, "one", 10,
                StatusEffect.NONE, 1.0, 1.0, 0, 0, 0, 1.0, 1.0, 0, 0, StatusEffect.NONE);
        supS = new SupportSkill("Heal!", "...heals an ally", 10, "one", 10,
                0, 1.0, 1.0, false, 0, 0, 0, StatusEffect.NONE,
                0, 0, 1.0, 1.0, StatusEffect.NONE);
        skills.add(atkS);
        skills.add(supS);
        e1 = new Enemy("Joe", 100, 100, skills, 5, "It's Joe.", " enters.",
        " dies.");
        e2 = new Enemy("Jim", 100, 100, skills, 5, "It's Jim.", " enters.",
                " dies.");

        p1 = new PlayerCharacter("John", 100, 100, skills, 5,
                "Test", new ArrayList<>(), new ArrayList<>());

        p2 = new PlayerCharacter("Sally", 100, 100, skills, 5, "Test",
                new ArrayList<>(), new ArrayList<>());

        party.add(p1);
        party.add(p2);

        p1.setPartyWith(party);
        p2.setPartyWith(party);

        ens.add(e1);
        ens2.add(e2);

    }

    @Test
    public void testGetSkillAsString() {
        String temp = p1.getSkillsAsString();
        assertEquals(temp, "Skill 1: Attack! Skill 2: Heal! ");
    }


    @Test
    public void testSetStatus() {
       p1.setCurrentStatus(StatusEffect.BURNED);
       assertEquals(p1.getTimeSinceStatusApplied(), Char.W_BURNED);
       p1.setCurrentStatus(StatusEffect.NONE);
       assertEquals(p1.getTimeSinceStatusApplied(), 0);
       p1.setCurrentStatus(StatusEffect.POISONED);
       assertEquals(p1.getTimeSinceStatusApplied(), Char.W_POISONED);
       p1.setCurrentStatus(StatusEffect.NUMB);
       assertEquals(p1.getTimeSinceStatusApplied(), Char.W_FROZEN);
       p1.setCurrentStatus(StatusEffect.AFRAID);
       assertEquals(p1.getTimeSinceStatusApplied(), Char.W_AFRAID);
    }

    @Test
    public void testTakeDamageDie() {
        assertEquals(p1.getHp(), 100);
        p1.takeDamage(50);
        assertEquals(p1.getHp(), 50);
        p1.takeDamage(50);
        assertEquals(p1.getHp(), 0);
        assertTrue(p1.getDead());
    }

    @Test
    public void testTakeDamageDefMod() {
        assertEquals(p1.getHp(), 100);
        p1.setDefMod(1.50);
        p1.takeDamage(50);
        assertEquals(p1.getHp(), 25);
    }

    @Test
    public void testTakeDamageDieWhileStatusEffect() {
        p1.setCurrentStatus(StatusEffect.AFRAID);

        assertEquals(p1.getHp(), 100);
        p1.takeDamage(10000);

        assertTrue(p1.getDead());
        assertEquals(p1.getCurrentStatus(), StatusEffect.NONE);
        assertEquals(p1.getAtkMod(), 1.0);
        assertEquals(p1.getDefMod(), 1.0);
    }

    @Test
    public void testTakeDamageDieOverkill() {
        p1.takeDamage(500000);
        assertEquals(p1.getHp(), -499900.0);
        assertTrue(p1.getDead());
    }

    @Test
    public void testHealDamage() {
        p1.takeDamage(50);
        p1.healDamage(20);
        assertEquals(p1.getHp(), 70);
    }

    @Test
    public void testHealDamageOverheal() {
        p1.takeDamage(50);
        p1.healDamage(500000);
        assertEquals(p1.getHp(), p1.getMaxhp());
    }

    @Test
    public void testHealDamageFromDead() {
        p1.takeDamage(150);
        assertTrue(p1.getDead());
        p1.healDamage(50);
        assertTrue(p1.getDead());
        p1.healDamage(1);
        assertEquals(p1.getHp(), 1.0);
        assertFalse(p1.getDead());
    }

    @Test
    public void testUseAp() {
        assertEquals(p1.getAp(), 100);
        p1.useAp(50);
        assertEquals(p1.getAp(), 50);
        p1.useAp(50);
        assertEquals(p1.getAp(), 0);
        p1.useAp(50);
        assertEquals(p1.getAp(), 0);
    }


    @Test
    public void testHealAp() {
        p1.useAp(50);
        p1.healAp(20);
        assertEquals(p1.getAp(), 70);
    }

    @Test
    public void testHealApOverheal() {
        p1.useAp(50);
        p1.healAp(500000);
        assertEquals(p1.getAp(), p1.getMaxap());
    }

    @Test
    public void testHealApFromEmpty() {
        p1.useAp(p1.getMaxap());
        p1.healAp(50);
        assertEquals(p1.getAp(), 50);
    }

    @Test
    public void testTurnBeginRoutine() {
        p1.turnBeginRoutine();
        assertEquals(p1.getAtkMod(), 1.0);
        assertEquals(p1.getDefMod(), 1.0);

        p1.setCurrentStatus(StatusEffect.AFRAID);

        p1.turnBeginRoutine();
        assertEquals(p1.getAtkMod(), 1.0 - 0.15);
        assertEquals(p1.getDefMod(), 1.0 + 0.25);
    }

    @Test
    public void testTurnBeginRoutineAfraidOverLimits() {
        p1.setAtkMod(0.25);
        p1.setDefMod(4.00);

        p1.setCurrentStatus(StatusEffect.AFRAID);
        p1.turnBeginRoutine();

        assertEquals(p1.getAtkMod(), 0.25);
        assertEquals(p1.getDefMod(), 4.0);
    }

    @Test
    public void testTurnBeginRoutineAP() {
        p1.useAp(10);
        assertEquals(p1.getAp(), p1.getMaxap() - 10);
        p1.turnBeginRoutine();
        assertEquals(p1.getAp(), p1.getMaxap());

    }

    @Test
    public void testRevive() {
        p1.takeDamage(p1.getMaxhp() + 24);
        assertTrue(p1.getDead());
        p1.healDamage(25);
        assertFalse(p1.getDead());
    }




    @Test
    public void testTurnEndRoutineBurned() {
        p1.setCurrentStatus(StatusEffect.BURNED);
        assertEquals(p1.getCurrentStatus(), StatusEffect.BURNED);
        assertEquals(p1.getTimeSinceStatusApplied(), Char.W_BURNED);
        p1.useAp(5);
        assertEquals(p1.getAp(), 95);
        p1.turnEndRoutine();
        assertEquals(p1.getHp(), p1.getMaxhp() - Char.DMG_BURNED);



        assertEquals(p1.getTimeSinceStatusApplied(), Char.W_BURNED - 1);

        for(int i = 0; i < Char.W_BURNED - 1; i++) {
            p1.turnEndRoutine();
        }

        assertEquals(p1.getTimeSinceStatusApplied(), 0);
        assertEquals(p1.getCurrentStatus(), StatusEffect.NONE);
    }

    @Test
    public void testTurnEndRoutinePsn() {
        p1.setCurrentStatus(StatusEffect.POISONED);

        assertEquals(p1.getCurrentStatus(), StatusEffect.POISONED);
        assertEquals(p1.getTimeSinceStatusApplied(), Char.W_POISONED);

        p1.turnEndRoutine();

        assertEquals(p1.getHp(), p1.getMaxhp() - (Char.DMG_POISONED * (p1.getTimeSinceStatusApplied() + 1)));
        assertEquals(p1.getTimeSinceStatusApplied(), Char.W_POISONED - 1);

        for(int i = 0; i < Char.W_POISONED - 1; i++) {
            p1.turnEndRoutine();
        }
        assertEquals(p1.getTimeSinceStatusApplied(), 0);
        assertEquals(p1.getCurrentStatus(), StatusEffect.NONE);
    }

    @Test
    public void testTurnEndRoutineFrz() {
        p1.setCurrentStatus(StatusEffect.NUMB);

        assertEquals(p1.getCurrentStatus(), StatusEffect.NUMB);
        assertEquals(p1.getTimeSinceStatusApplied(), Char.W_FROZEN);

        p1.turnEndRoutine();
        p1.turnEndRoutine();

        assertEquals(p1.getTimeSinceStatusApplied(), 0);
        assertEquals(p1.getCurrentStatus(), StatusEffect.NONE);

    }

    @Test
    public void testTurnEndRoutineAfd() {
        p1.setCurrentStatus(StatusEffect.AFRAID);

        assertEquals(p1.getCurrentStatus(), StatusEffect.AFRAID);
        assertEquals(p1.getTimeSinceStatusApplied(), Char.W_AFRAID);


        for(int i = 0; i < Char.W_AFRAID; i++) {
            p1.turnEndRoutine();
        }

        assertEquals(p1.getTimeSinceStatusApplied(), 0);
        assertEquals(p1.getCurrentStatus(), StatusEffect.NONE);
        assertEquals(p1.getAtkMod(), 1.0);
        assertEquals(p1.getDefMod(), 1.0);


    }

    @Test
    public void testTurnEndRoutineBurnedDie() {
        p1.setCurrentStatus(StatusEffect.BURNED);
        p1.takeDamage(p1.getMaxhp() - Char.DMG_BURNED);
        p1.turnEndRoutine();
        assertEquals(p1.getHp(), 0);
        assertTrue(p1.getDead());
    }

    @Test
    public void testTurnEndRoutineStatusWearoff() {
        p1.setCurrentStatus(StatusEffect.BURNED);
        assertEquals(p1.getTimeSinceStatusApplied(), Char.W_BURNED);
        for(int i = 0; i < Char.W_BURNED; i++) {
            p1.turnEndRoutine();
        }
        assertEquals(p1.getTimeSinceStatusApplied(), 0);
        assertEquals(p1.getCurrentStatus(), StatusEffect.NONE);

    }



    @Test
    public void testUseAtkSkill() {
        assertTrue(p1.canUseSkill(atkS));
        assertTrue(p1.useSkill(atkS, e1));
        assertEquals(p1.getAp(), p1.getMaxap() - atkS.getApCost());
        assertEquals(e1.getHp(), e1.getMaxhp() - atkS.getDamage());
    }

    @Test
    public void testUseAtkSkillAtkMod() {
        p1.setAtkMod(1.50);
        assertTrue(p1.canUseSkill(atkS));
        assertTrue(p1.useSkill(atkS, e1));
        assertEquals(p1.getAp(), p1.getMaxap() - atkS.getApCost());
        assertEquals(e1.getHp(), e1.getMaxhp() - (atkS.getDamage() * 1.50));
    }

    @Test
    public void testUseAtkSkillAtkModConsecutive() {
        p1.setAtkMod(1.50);
        assertTrue(p1.canUseSkill(atkS));
        assertTrue(p1.useSkill(atkS, e1));
        assertEquals(p1.getAp(), p1.getMaxap() - atkS.getApCost());
        assertEquals(e1.getHp(), e1.getMaxhp() - (atkS.getDamage() * 1.50));

        assertTrue(p2.canUseSkill(atkS));
        assertTrue(p2.useSkill(atkS, e2));
        assertEquals(p2.getAp(), p2.getMaxap() - atkS.getApCost());
        assertEquals(e2.getHp(), e2.getMaxhp() - (atkS.getDamage()));
    }

    @Test
    public void testNotEnoughAp() {
        p1.useAp(95);
        assertFalse(p1.canUseSkill(atkS));
        assertFalse(p1.useSkill(atkS, e1));
        assertEquals(p1.getAp(), p1.getMaxap() - 95);
        assertEquals(e1.getHp(), e1.getMaxhp());
    }

    @Test
    public void testUseSupportSkill() {
        p2.takeDamage(10);
        assertTrue(p1.useSkill(supS, p2));
        assertEquals(p1.getAp(), p1.getMaxap() - atkS.getApCost());
        assertEquals(p2.getHp(), p2.getMaxhp());
    }


}
