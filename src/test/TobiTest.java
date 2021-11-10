package test;

import model.enemies.Enemy;
import model.enemies.Tobi;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TobiTest {

    private Tobi tob;
    private Enemy e1;

    @BeforeEach
    public void setUp() {
        tob = new Tobi("Tobi", 100, 100, new ArrayList<>(), 5, "Tobi");
        e1 = new Enemy("Joe", 100, 100, new ArrayList<>(), 5, "It's Joe.", " enters.",
                " dies.");
    }

    @Test
    public void testLawOrderReload() {
        tob.setTimeTillAttack(0);
        assertFalse(tob.getNeedsToReload());
        tob.lawAndOrder(e1);
        assertTrue(e1.getDead());
        assertTrue(tob.getNeedsToReload());
        assertEquals(tob.getTimeTillAttack(), 5);

    }

    @Test
    public void testTurnEndRoutineDecreaseTime() {
        tob.turnEndRoutine();
        assertEquals(tob.getTimeTillAttack(), 4);
        assertFalse(tob.lawAndOrder(e1));
    }
}
