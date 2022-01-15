package test;

import model.levelStuff.NewLevel;
import model.levelStuff.NewRoom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class NewLevelTest {
    private NewLevel l1;

    @BeforeEach
    public void setUp() {
        l1 = new NewLevel("Level 1", new NewRoom[2][2], Color.ORANGE);
    }

    @Test
    public void testSetText() {
        l1.setIntroLabelText("kek");
        assertEquals(l1.getIntroLabelText(),"kek");
        l1.setEndLabelText("ses");
        assertEquals(l1.getEndLabelText(), "ses");
    }

    @Test
    public void testKillBosses() {
        assertFalse(l1.getBoss1dead());
        assertFalse(l1.getBoss2dead());
        assertFalse(l1.getBoss3dead());
        assertFalse(l1.getComplete());
        l1.kill1Boss();
        assertTrue(l1.getBoss1dead());
        l1.kill2Boss();
        assertTrue(l1.getBoss2dead());
        l1.kill3Boss();
        assertTrue(l1.getBoss3dead());
        assertTrue(l1.getComplete());

    }
}
