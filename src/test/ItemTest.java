package test;

import model.Char;
import model.Item;
import model.PlayerCharacter;
import model.StatusEffect;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ItemTest {

    private PlayerCharacter p1;

    private Item itemDmg;
    private Item itemHl;
    private Item itemAphl;
    private Item itemAtkDefMod;
    private Item itemCure;
    private Item itemStatus;
    private Item itemAfraid;


    @BeforeEach
    public void setUp() {

        p1 = new PlayerCharacter("John", 100, 100, new ArrayList<>(), 5,
                "Test", new ArrayList<>(), new ArrayList<>());

        itemDmg = new Item("Bomb", "A bomb.", 50.0, 0.0, 0, 1.0, 1.0, false,
                StatusEffect.NONE, 0, "all");

        itemHl = new Item("Potion", "A healing potion.",
                0.0, 10.0, 0, 1.0, 1.0, false, StatusEffect.NONE, 0, "one");

        itemAphl = new Item("AP Juice", "An AP potion.",
                0.0, 0.0, 10, 1.0, 1.0, false, StatusEffect.NONE, 0, "one");

        itemAtkDefMod = new Item("Slorp Juice", "???",
                0.0, 0.0, 0, 1.50, 0.50, false, StatusEffect.NONE, 0, "one");

        itemCure = new Item("Remedy", "Heals status effects and resets attack + defense",
                0.0, 0.0, 0, 1.0, 1.0, true, StatusEffect.NONE, 0, "one");

        itemStatus = new Item("Hot Coals", "Burns the target",
                1.0, 0.0, 0, 1.0, 1.0, false, StatusEffect.BURNED, 1, "one");

        itemAfraid = new Item("Bad Memory", "Makes the target afraid",
                0.0, 0.0, 0, 1.0, 1.0, false, StatusEffect.AFRAID, 1, "one");

    }

    @Test
    public void testItemDmg() {
        itemDmg.takeEffect(p1);
        assertEquals(p1.getHp(), p1.getMaxhp() - 50);
        itemDmg.takeEffect(p1);
        assertEquals(p1.getHp(), 0);
        assertTrue(p1.getDead());
    }

    @Test
    public void testItemHl() {
        itemHl.takeEffect(p1);
        assertEquals(p1.getHp(), p1.getMaxhp());
        p1.takeDamage(10);
        assertEquals(p1.getHp(), 90);
        itemHl.takeEffect(p1);
        assertEquals(p1.getHp(), 100);
        p1.takeDamage(100);
        assertTrue(p1.getDead());
        itemHl.takeEffect(p1);
        assertEquals(p1.getHp(), 10);
        assertFalse(p1.getDead());
    }

    @Test
    public void testItemAphl() {
        itemAphl.takeEffect(p1);
        assertEquals(p1.getAp(), p1.getMaxap());
        p1.useAp(100);
        itemAphl.takeEffect(p1);
        assertEquals(p1.getAp(), 10);
    }

    @Test
    public void testItemAtkDefMod() {
        itemAtkDefMod.takeEffect(p1);
        assertEquals(p1.getAtkMod(), (1.0 + 1.50) / 2);
        assertEquals(p1.getDefMod(), (1.0 + 0.50) / 2);
        p1.takeDamage(10);
        assertEquals(p1.getHp(), p1.getMaxhp() - (10 * ((1.0 + 0.50) / 2)));
    }

    @Test
    public void testItemCure() {
        p1.setAtkMod(2.00);
        p1.setDefMod(2.00);
        p1.setCurrentStatus(StatusEffect.NUMB);
        assertEquals(p1.getCurrentStatus(), StatusEffect.NUMB);
        itemCure.takeEffect(p1);
        assertEquals(p1.getCurrentStatus(), StatusEffect.NONE);
        assertEquals(p1.getAtkMod(), 1.0);
        assertEquals(p1.getDefMod(), 1.0);
    }

    @Test
    public void testItemStatus() {
        p1.setAtkMod(2.00);
        p1.setDefMod(2.00);
        assertEquals(p1.getCurrentStatus(), StatusEffect.NONE);
        itemStatus.takeEffect(p1);
        assertEquals(p1.getCurrentStatus(), StatusEffect.BURNED);
        assertEquals(p1.getTimeSinceStatusApplied(), Char.W_BURNED);
        assertEquals(p1.getAtkMod(), 2.0);
        assertEquals(p1.getDefMod(), 2.0);
        p1.takeDamage(90);
        itemStatus.takeEffect(p1);
        assertTrue(p1.getDead());
        assertEquals(p1.getCurrentStatus(), StatusEffect.NONE);
    }

    @Test
    public void testItemAfraid() {
        p1.setAtkMod(2.00);
        p1.setDefMod(2.00);
        itemAfraid.takeEffect(p1);
        assertEquals(p1.getCurrentStatus(), StatusEffect.AFRAID);
        assertEquals(p1.getAtkMod(), 0.75);
        assertEquals(p1.getDefMod(), 1.25);
    }
}
